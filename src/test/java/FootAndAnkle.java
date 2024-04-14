
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

/*
Authors: Ayleen Roque, Katarya Johnson-Williams
Class: Software Testing - CEN 4072 - CRN 10420
Instructor: Dr. Deepa Devasenapathy
Date: Spring 2024
File:
Description: This is the testing class for Foot and Ankle
 */
public class FootAndAnkle {
    // Protected variable to store the webdriver
    protected WebDriver driver;

    // Protected variable to store the executor
    protected JavascriptExecutor execute;


    // Store website URL in a variable for easy access
    protected String NanoExperienceURL = "https://www.thenanoexperience.com/foot-and-ankle";

    // Set up the webdriver before we start running the class
    @BeforeClass
    public void setUp() throws InterruptedException {

        driver = new ChromeDriver();
        execute = (JavascriptExecutor) driver;

        // Open and maximize the Nano Experience page
        driver.get(NanoExperienceURL);
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    // Close the webdriver after running the class
    @AfterClass
    public void close() {
        driver.quit();
    }

    // ------------------------- Test Functions ------------------------------------

    @Test(priority = 1)
    public void urlTitle() throws InterruptedException {
        // Get and print URL of webpage
        String pageURL = driver.getCurrentUrl();
        System.out.print("Current Page URL: ");
        System.out.print(pageURL);
        System.out.println();

        // Get and print title of webpage
        String title = driver.getTitle();
        System.out.print("Current Page Title: ");
        System.out.print(title);
        System.out.println();
    }

    @Test(priority = 2)
    public void checkAccordions() throws InterruptedException {
        // List all accordion toggles
        List<WebElement> accordionToggles = driver.findElements(By.cssSelector(".item_toggle.border-all-sides.w-dropdown-toggle"));

        // Loop through each accordion toggle
        for (WebElement toggle : accordionToggles) {
            // Scroll somewhere near the accordion (to make it visible)
            execute.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top + window.pageYOffset - 300);", toggle);
            Thread.sleep(2000); // load scroll

            // Click the accordion
            toggle.click();
            Thread.sleep(2000); // let it load

            // Using aria-controls to manage the visibility of the link
            String contentId = toggle.getAttribute("aria-controls");
            WebElement accordionContent = driver.findElement(By.id(contentId));

            // Verify the accordion content is displayed
            assertTrue(accordionContent.isDisplayed(), "Accordion content for " + contentId + " is not displayed");
        }

    }

    @Test(priority = 3)
    public void checkRecoveryTabs() throws InterruptedException {
        // Array of tab IDs to click (and their content panel IDs)
        String[][] tabsAndContent = new String[][]{
                {"w-tabs-0-data-w-tab-0", "w-tabs-0-data-w-pane-0"}, // "After Your Nano Procedure"
                {"w-tabs-0-data-w-tab-1", "w-tabs-0-data-w-pane-1"}, // "At Home"
                {"w-tabs-0-data-w-tab-2", "w-tabs-0-data-w-pane-2"}, // "During Recovery"
                {"w-tabs-0-data-w-tab-3", "w-tabs-0-data-w-pane-3"}  // "Return to Daily Activity"
        };

        for (String[] tabAndContent : tabsAndContent) {
            // Find the tab
            WebElement tab = driver.findElement(By.id(tabAndContent[0]));

            // Scroll to the tab (I adjusted to avoid sticky nav)
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, " +
                    "arguments[0].getBoundingClientRect().top + window.pageYOffset - 200);", tab);
            Thread.sleep(3000); // wait for scroll to load

            // Click the tab
            tab.click();
            Thread.sleep(2000); // wait for click to load

            // Check if the content panel is visible
            WebElement contentPanel = driver.findElement(By.id(tabAndContent[1]));
            assertTrue(contentPanel.isDisplayed(), "Content panel " + tabAndContent[1] + " is not visible.");
        }

    }

    @Test(priority = 4)
    public void checkFadForm() throws InterruptedException {
        // Navigate to the form section
        WebElement formSection = driver.findElement(By.id("wf-form-Surgeon-Finder"));
        // Adjust the scroll to have element visible
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top " +
                "+ window.pageYOffset + arguments[1]);", formSection, -190);
        Thread.sleep(1000); // Let the scroll complete

        // Input a ZIP code
        WebElement zipInput = driver.findElement(By.id("location"));
        zipInput.clear(); // Clear any values already there (just in case)
        String testZipCode = "90210"; // Example ZIP code
        zipInput.sendKeys(testZipCode);

        // Submit the form
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();

    }
}
