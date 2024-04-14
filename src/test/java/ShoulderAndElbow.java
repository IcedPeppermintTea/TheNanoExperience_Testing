/*
Authors: Ayleen Roque, Katarya Johnson-Williams
Class: Software Testing - CEN 4072 - CRN 10420
Instructor: Dr. Deepa Devasenapathy
Date: Spring 2024
File: ShoulderAndElbow.java
Description: Class to test the Shoulder & Elbow page on Nano Experience website.
 */

// Selenium Import Statements
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// TestNG Import Statements
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ShoulderAndElbow {
    // Protected variable to store the webdriver
    protected WebDriver driver;

    // Create executor to scroll in browser
    protected JavascriptExecutor execute;

    // Store website URL in a string variable for easy access
    protected String ShoulderAndElbowURL = "https://www.thenanoexperience.com/shoulder-and-elbow";

    // Set up the webdriver before we start running the class
    @BeforeClass
    public void setUp() throws InterruptedException {

        driver = new ChromeDriver();

        // Reassign executor instance
        execute = (JavascriptExecutor) driver;

        // Open and maximize the Nano Experience page
        driver.get(ShoulderAndElbowURL);
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
    void urlAndTitle() {
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
    void referenceLinks() throws InterruptedException {
        // Scroll Down to "How Does Nano Work?"
        execute.executeScript("window.scroll(0,850)", "");
        Thread.sleep(4000);

        // Select Reference Link 1 (next to "activity")
        driver.findElement(By.xpath("/html/body/div/main/section[2]/div/div/div/div/div/div[3]/p[1]/a/sup")).click();
        Thread.sleep(2000);

        // Return to Shoulder and Elbow Page
        driver.get(ShoulderAndElbowURL);
        Thread.sleep(2000);

        // Scroll Down to "Recovery Timeline"
        execute.executeScript("window.scroll(0,3150)", "");
        Thread.sleep(4000);

        // Select Reference Link 1 (next to "sports")
        driver.findElement(By.xpath("/html/body/div/main/section[5]/div/div/div/div[1]/p/a[1]/sup")).click();
        Thread.sleep(2000);

        // Return to Shoulder and Elbow Page
        driver.get(ShoulderAndElbowURL);
        Thread.sleep(2000);

        // Scroll Down to "Why Nano Arthroscopy for the Shoulder and Elbow?"
        execute.executeScript("window.scroll(0,4000)", "");
        Thread.sleep(4000);

        // Select Reference Link 4 (next to "complications")
        driver.findElement(By.xpath("/html/body/div/main/section[6]/div/div/div/div[1]/div[2]/div/p/a[1]/sup")).click();
        Thread.sleep(2000);

        // Return to Shoulder and Elbow Page
        driver.get(ShoulderAndElbowURL);
        Thread.sleep(2000);

        // Scroll Down to "Why Nano Arthroscopy for the Shoulder and Elbow?"
        execute.executeScript("window.scroll(0,4000)", "");
        Thread.sleep(4000);

        // Select Reference Link 3 (next to "narcotics use")
        driver.findElement(By.xpath("/html/body/div/main/section[6]/div/div/div/div[1]/div[2]/div/p/a[2]/sup")).click();
        Thread.sleep(2000);

        // Return to Shoulder and Elbow Page
        driver.get(ShoulderAndElbowURL);
        Thread.sleep(2000);

        // Scroll Down to "Why Nano Arthroscopy for the Shoulder and Elbow?"
        execute.executeScript("window.scroll(0,4000)", "");
        Thread.sleep(4000);

        // Select Reference Link 1 (next to "speeding up recovery")
        driver.findElement(By.xpath("/html/body/div/main/section[6]/div/div/div/div[1]/div[2]/div/p/a[3]/sup")).click();
        Thread.sleep(2000);

        // Return to Shoulder and Elbow Page
        driver.get(ShoulderAndElbowURL);
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    void embeddedVideo() throws InterruptedException {
        // Scroll to "The Nano Experience" Embedded Video
        execute.executeScript("window.scroll(0,1650)", "");
        Thread.sleep(4000);

        // Play Embedded Video
        driver.findElement(By.xpath("/html/body/div/main/section[3]/div/div/div/div[2]/div/div[1]")).click();
        Thread.sleep(10000);

        // Pause Embedded Video
        driver.findElement(By.xpath("/html/body/div/main/section[3]/div/div/div/div[2]/div/div[1]")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    void whatCanNanoTreatDropdown() throws InterruptedException {
        // Scroll to "What Can Nano Treat?"
        execute.executeScript("window.scroll(0,2500)", "");
        Thread.sleep(4000);

        // Expand "Chronic Shoulder Issues"
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-5\"]/div/img[2]")).click();
        Thread.sleep(2000);

        // Expand "Biceps Tendon Tears"
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-6\"]/div/img[2]")).click();
        Thread.sleep(2000);

        // Expand "Repair Reassessments"
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-7\"]/div/img[2]")).click();
        Thread.sleep(2000);

        // Expand "Complex Shoulder Repairs"
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-8\"]/div/img[2]")).click();
        Thread.sleep(2000);

        // Collapse "Complex Shoulder Repairs"
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-8\"]/div/img[2]")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    void recoveryTimelineDropdown() throws InterruptedException {
        // Scroll to "Recovery Timeline"
        execute.executeScript("window.scroll(0,3400)", "");
        Thread.sleep(4000);

        // Expand "Return to Regular Activity"
        driver.findElement(By.xpath("//*[@id=\"w-tabs-0-data-w-tab-3\"]/div")).click();
        Thread.sleep(2000);

        // Expand "During Recovery"
        driver.findElement(By.xpath("//*[@id=\"w-tabs-0-data-w-tab-2\"]/div")).click();
        Thread.sleep(2000);

        // Expand "At Home"
        driver.findElement(By.xpath("//*[@id=\"w-tabs-0-data-w-tab-1\"]/div")).click();
        Thread.sleep(2000);

        // Expand "After Your Nano Procedure"
        driver.findElement(By.xpath("//*[@id=\"w-tabs-0-data-w-tab-0\"]/div")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    void findDoctorSearch() throws InterruptedException {
        // Scroll Down to Download Brochure Link
        execute.executeScript("window.scroll(0,4500)", "");
        Thread.sleep(4000);

        // Input Search Terms in "Find a Doctor Near You"
        driver.findElement(By.xpath("//*[@id=\"location\"]")).sendKeys("Fort Myers, FL");
        Thread.sleep(2000);

        // Select Search Button
        driver.findElement(By.xpath("//*[@id=\"wf-form-Surgeon-Finder\"]/input[2]")).click();
        Thread.sleep(2000);

        // Scroll Down to Download Brochure Link
        execute.executeScript("window.scroll(0,250)", "");
        Thread.sleep(4000);

        // Return to Shoulder and Elbow Page
        driver.get(ShoulderAndElbowURL);
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    void downloadQuestionList() throws InterruptedException {
        // Scroll Down to Download Brochure Link
        execute.executeScript("window.scroll(0,4500)", "");
        Thread.sleep(4000);

        // Select Download This List of Questions
        driver.findElement(By.linkText("Download this list of questions")).click();
        Thread.sleep(4000);

        // Get List of Window Handles
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // Switch to Brochure Tab and Close
        driver.switchTo().window(tabs.getLast());
        Thread.sleep(2000);
        driver.close();

        // Switch Back to Shoulder and Elbow Page
        driver.switchTo().window(tabs.getFirst());
        Thread.sleep(2000);
    }
}