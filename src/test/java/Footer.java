/*
Authors: Ayleen Roque, Katarya Johnson-Williams
Class: Software Testing - CEN 4072 - CRN 10420
Instructor: Dr. Deepa Devasenapathy
Date: Spring 2024
File:
Description: Class to test the Footer Component. The Footer Component is called once in all pages,
             therefore, only needs to be tested once.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Footer {
    // Protected variable to store the webdriver
    protected WebDriver driver;

    // Protected variable to store the executor
    protected JavascriptExecutor execute;

    // Store website URL in a variable for easy access
    protected String NanoExperienceURL = "https://www.thenanoexperience.com/";

    // Set up the webdriver before we start running the class
    @BeforeClass
    public void setUp() throws InterruptedException {
       // System.setProperty("webdriver.chrome.driver", "WebDrivers/Chromedriver/chromedriver.exe");
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
    void urlTitle() throws InterruptedException {
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
    void footerHomeLink() throws InterruptedException {
        WebElement footerSection = driver.findElement(By.id("footer"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footerSection);
        Thread.sleep(3000); // Small pause to ensure the script has time to scroll

        driver.findElement(By.linkText("Home")).click(); // click on home link
        Thread.sleep(3000); // wait to load page
    }

    @Test(priority = 3)
    void checkSiteLinks() throws InterruptedException {
        // An array with the links we want to test
        String[] footerLinksText = {
                "Why Nano",
                "Shoulder & Elbow",
                "Foot & Ankle",
                "Knee & Hip",
                "Hand & Wrist",
                "Blog",
                "FAQs",
                "About Arthrex",
                "Find a Doctor"
        };

        // Loop through each link text
        for (String linkText : footerLinksText) {
            try {
                // Scroll to the footer section before clicking each link
                WebElement footerSection = driver.findElement(By.id("footer"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footerSection);
                Thread.sleep(3000); // Small pause to ensure the script has time to scroll

                // Find the link by its text and click it
                WebElement link = driver.findElement(By.linkText(linkText));
                link.click();

                // Wait for the page to load
                Thread.sleep(3000);

                // Go back to the previous page
                driver.navigate().back();

                // Wait for the page to load
                Thread.sleep(3000);
            } catch (Exception e) { // catch errors if link fails
                System.err.println("Error clicking on link with text '" + linkText + "': " + e.getMessage());
            }
        }
    }

    @Test(priority = 6)
    void checkLegalLinks() throws InterruptedException {
        // Save the original tab's handle
        String originalTab = driver.getWindowHandle();

        // Click on "References", wait, and go back
        driver.findElement(By.linkText("References")).click();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);

        // Click on "Privacy", wait, close tab and switch back to first tab
        driver.findElement(By.linkText("Privacy")).click();
        Thread.sleep(3000);

        // Switch to the new tab
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        // Closing new tab
        driver.close();

        // Switch back to original tab
        driver.switchTo().window(originalTab);
        Thread.sleep(3000);

        // click, wait, close tab and switch back to first tab
        driver.findElement(By.linkText("Legal and Ethics Notice")).click();
        Thread.sleep(3000);

        // Switch to the new tab
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        // Closing new tab
        driver.close();

        // Switch back to the original tab
        driver.switchTo().window(originalTab);
        Thread.sleep(3000); // Adjust timing as necessary

        // Handle the "Cookie Settings" button
        driver.findElement(By.id("ot-sdk-btn")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 4)
    void checkExploreLinks() throws InterruptedException {
        String originalTab = driver.getWindowHandle();

        // Click on "OrthoPedia Patient", switch to new tab, wait, close it, and switch back
        driver.findElement(By.linkText("OrthoPedia Patient")).click();
        Thread.sleep(3000); // Wait for the page to load

        // Switch to new tab
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        // Closing the new tab
        driver.close();

        // Switch back to the original tab
        driver.switchTo().window(originalTab);
        Thread.sleep(3000);

        // Click on "Arthrex.com", switch to the new tab, wait, close it, and switch back
        driver.findElement(By.linkText("Arthrex.com")).click();
        Thread.sleep(3000); // Wait for the page to load

        // Switch to the new tab
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        // Closing the new tab
        driver.close();

        // Switch back to the original tab
        driver.switchTo().window(originalTab);
        Thread.sleep(3000);
    }


    @Test(priority = 5)
    void checkSupportLinks() throws InterruptedException {
        // The driver cannot access email app, instead, we can test that the link
        // takes the user to an email address

        // Find the "Contact Us" link and get the href attribute
        String href = driver.findElement(By.linkText("Contact Us")).getAttribute("href");

        // Confirm that the href attribute starts with "mailto:"
        Assert.assertTrue(href.startsWith("mailto:"), "The 'Contact Us' link does not lead to an email.");
    }



}


