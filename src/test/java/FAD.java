/*
Authors: Ayleen Roque, Katarya Johnson-Williams
Class: Software Testing - CEN 4072 - CRN 10420
Instructor: Dr. Deepa Devasenapathy
Date: Spring 2024
File:
Description: Class to test the Find a Doctor Page in TheNanoExperience.com
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FAD {
    // Protected variable to store the webdriver
    protected WebDriver driver;

    // Store website URL in a string variable for easy access
    protected String NanoExperienceURL = "https://www.thenanoexperience.com/find-a-doctor";

    // Set up the webdriver before we start running the class
    @BeforeClass
    public void setUp() throws InterruptedException {

        driver = new ChromeDriver();

        // Open and maximize the Nano Experience page
        driver.get(NanoExperienceURL);
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    // Close the webdriver after we are done running the class
    @AfterClass
    public void close() {
        driver.quit();
    }

    // ---------------------- Test Functions ------------------------------------
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
    public void enterLocationAndSelectFirstOption() throws InterruptedException {
        // Switch to the iframe that contains the form
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'doctorfinder')]")));

        // Now that we're in the iframe, locate and interact with the location input
        WebElement locationInput = driver.findElement(By.id("mat-input-1")); // The actual ID of the location input
        locationInput.sendKeys("Miami, FL");

        Thread.sleep(3000); // Wait for the dropdown options to appear

        // click the first dropdown option
        WebElement firstOption = driver.findElement(By.xpath("//mat-option[@role='option']"));
        firstOption.click(); // Click the first option

        // Switch back to the main document
        driver.switchTo().defaultContent();

        Thread.sleep(3000); // Pause to observe the action
    }

    @Test(priority = 3)
    public void selectDistance() throws InterruptedException {
        // Switch to the iframe again
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'doctorfinder')]")));

        // Find the distance dropdown
        WebElement distanceDropdown = driver.findElement(By.id("mat-select-4"));
        distanceDropdown.click(); // Open the dropdown
        Thread.sleep(1000); // Pause to load dropdown

        // Clicking the option for "10 miles"
        WebElement option10Miles = driver.findElement(By.xpath("//mat-option[@role='option']//span[contains(text(),'10 miles')]"));
        option10Miles.click();
        Thread.sleep(1000); // Pause to load the selection

        // Switch back to the main document
        driver.switchTo().defaultContent();
        Thread.sleep(3000); // Pause to load the page with the actions
    }

    @Test(priority = 4)
    public void checkDownloadQuestionsLink() throws InterruptedException {
        // Find the link by text and get the href attribute
        WebElement downloadLink = driver.findElement(By.linkText("Download this list of questions"));
        String href = downloadLink.getAttribute("href");

        // Check if the href is expected
        String expectedUrl = "https://assets.website-files.com/64e8d67c4c23c127a5e3ada4/656f91ec83c5691213580a3e_pFL1-000745-en-US_A%20Nano%20Experience%20Downloadable%20Patient%20Guide.pdf";
        assert href.equals(expectedUrl) : "URL does not match expected.";

        // Check the link
        downloadLink.click();
        Thread.sleep(3000);

        System.out.println("Download link is verified and functional!");
    }



}


