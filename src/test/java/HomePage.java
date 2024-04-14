/*
Authors: Ayleen Roque, Katarya Johnson-Williams
Class: Software Testing - CEN 4072 - CRN 10420
Instructor: Dr. Deepa Devasenapathy
Date: Spring 2024
File: HomePage.java
Description: Class to test the home page on Nano Experience website.
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

public class HomePage {
    // Protected variable to store the webdriver
    protected WebDriver driver;

    // Create executor to scroll in browser
    protected JavascriptExecutor execute;

    // Store website URL in a string variable for easy access
    protected String HomePageURL = "https://www.thenanoexperience.com/";

    // Set up the webdriver before we start running the class
    @BeforeClass
    public void setUp() throws InterruptedException {

        driver = new ChromeDriver();

        // Reassign executor instance
        execute = (JavascriptExecutor) driver;

        // Open and maximize the Nano Experience page
        driver.get(HomePageURL);
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
    void bannerLinks() throws InterruptedException {
        // Select Learn More Button
        driver.findElement(By.xpath("/html/body/div/main/section[1]/div/div/div/div/div/div/div[3]/a[1]")).click();
        Thread.sleep(2000);

        // Return to Home Page
        driver.get(HomePageURL);
        Thread.sleep(2000);

        // Select What Nano Treats Button
        driver.findElement(By.xpath("/html/body/div/main/section[1]/div/div/div/div/div/div/div[3]/a[2]")).click();
        Thread.sleep(6000);

        // Scroll Back to Top of Screen
        execute.executeScript("window.scroll(0,-1000)", "");
        Thread.sleep(6000);

        // Select Reference Link 1,2 (next to "less pain")
        driver.findElement(By.xpath("/html/body/div/main/section[1]/div/div/div/div/div/div/p/a/sup")).click();
        Thread.sleep(2000);

        // Return to Home Page
        driver.get(HomePageURL);
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    void referenceLinks() throws InterruptedException {
        // Scroll to "What Is the Nano Arthroscopy Experience?"
        execute.executeScript("window.scroll(0,700)", "");
        Thread.sleep(3000);

        // Select Reference Link 3 (next to "damage")
        driver.findElement(By.xpath("/html/body/div/main/section[2]/div/div/div/div/div/p/a[1]/sup")).click();
        Thread.sleep(2000);

        // Return to Home Page
        driver.get(HomePageURL);
        Thread.sleep(2000);

        // Scroll to "What Is the Nano Arthroscopy Experience?"
        execute.executeScript("window.scroll(0,700)", "");
        Thread.sleep(3000);

        // Select Reference Link 1 (next to "rates")
        driver.findElement(By.xpath("/html/body/div/main/section[2]/div/div/div/div/div/p/a[2]/sup")).click();
        Thread.sleep(2000);

        // Return to Home Page
        driver.get(HomePageURL);
        Thread.sleep(2000);

        // Scroll to "What Is the Nano Arthroscopy Experience?"
        execute.executeScript("window.scroll(0,700)", "");
        Thread.sleep(3000);

        // Select Reference Link 1 (next to "fast recovery")
        driver.findElement(By.xpath("/html/body/div/main/section[2]/div/div/div/div/div/p/a[3]/sup")).click();
        Thread.sleep(2000);

        // Return to Home Page
        driver.get(HomePageURL);
        Thread.sleep(2000);

        // Scroll to "What Is the Nano Arthroscopy Experience?"
        execute.executeScript("window.scroll(0,700)", "");
        Thread.sleep(3000);

        // Select Reference Link 1 (next to "again")
        driver.findElement(By.xpath("/html/body/div/main/section[2]/div/div/div/div/div/p/a[4]/sup")).click();
        Thread.sleep(2000);

        // Return to Home Page
        driver.get(HomePageURL);
        Thread.sleep(2000);

        // Scroll to "The Nano Arthroscopy Difference"
        execute.executeScript("window.scroll(0,1000)", "");
        Thread.sleep(3000);

        // Select Reference Link 1 (next to "recovery")
        driver.findElement(By.xpath("/html/body/div/main/section[3]/div/div/div/div[1]/div[1]/p/a[1]/sup")).click();
        Thread.sleep(2000);

        // Return to Home Page
        driver.get(HomePageURL);
        Thread.sleep(2000);

        // Scroll to "The Nano Arthroscopy Difference"
        execute.executeScript("window.scroll(0,1000)", "");
        Thread.sleep(3000);

        // Select Reference Link 2 (next to "less pain")
        driver.findElement(By.xpath("/html/body/div/main/section[3]/div/div/div/div[1]/div[1]/p/a[2]/sup")).click();
        Thread.sleep(2000);

        // Return to Home Page
        driver.get(HomePageURL);
        Thread.sleep(2000);

        // Scroll to "The Nano Arthroscopy Difference"
        execute.executeScript("window.scroll(0,1000)", "");
        Thread.sleep(3000);

        // Select Reference Link 4 (next to "narcotics")
        driver.findElement(By.xpath("/html/body/div/main/section[3]/div/div/div/div[1]/div[1]/p/a[3]/sup")).click();
        Thread.sleep(2000);

        // Return to Home Page
        driver.get(HomePageURL);
        Thread.sleep(2000);

        // Scroll to "The Nano Arthroscopy Difference"
        execute.executeScript("window.scroll(0,1000)", "");
        Thread.sleep(3000);

        // Select "Find a Doctor" Button
        driver.findElement(By.xpath("/html/body/div/main/section[3]/div/div/div/div[1]/div[1]/a/div")).click();
        Thread.sleep(2000);

        // Return to Home Page
        driver.get(HomePageURL);
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    void fastRecoveryDropdown() throws InterruptedException {
        // Scroll to "Fast Recovery"
        execute.executeScript("window.scroll(0,1500)", "");
        Thread.sleep(3000);

        // Expand "Less Reliance on Narcotics"
        driver.findElement(By.xpath("//*[@id='w-dropdown-toggle-6']")).click();
        Thread.sleep(2000);

        // Expand "Multiple Anesthesia Options"
        driver.findElement(By.xpath("//*[@id='w-dropdown-toggle-7']")).click();
        Thread.sleep(2000);

        // Expand "Barely-There Scars"
        driver.findElement(By.xpath("//*[@id='w-dropdown-toggle-8']")).click();
        Thread.sleep(2000);

        // Expand "Help Design Your Treatment Experience"
        driver.findElement(By.xpath("//*[@id='w-dropdown-toggle-9']")).click();
        Thread.sleep(2000);

        // Expand "Fast Recovery"
        driver.findElement(By.xpath("//*[@id='w-dropdown-toggle-5']")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    void downloadBrochure() throws InterruptedException {
        // Scroll Down to Download Brochure Link
        execute.executeScript("window.scroll(0,2500)", "");
        Thread.sleep(3000);

        // Select Download Brochure
        driver.findElement(By.xpath("/html/body/div/main/section[4]/div/div/div/div[2]/a/div")).click();
        Thread.sleep(4000);

        // Get List of Window Handles
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // Switch to Brochure Tab and Close
        driver.switchTo().window(tabs.getLast());
        Thread.sleep(2000);
        driver.close();

        // Switch Back to Nano Experience Site
        driver.switchTo().window(tabs.getFirst());
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    void anatomyGraphicLinks() throws InterruptedException {
        // Refresh Home Page
        driver.get(HomePageURL);
        Thread.sleep(2000);

        // Select What Nano Treats Button
        driver.findElement(By.xpath("/html/body/div/main/section[1]/div/div/div/div/div/div/div[3]/a[2]")).click();
        Thread.sleep(2000);

        // Select Learn More
        driver.findElement(By.xpath("//*[@id='arthroman']/div/div[1]/a/div")).click();
        Thread.sleep(2000);

        // Return to Home Page
        driver.get(HomePageURL);
        Thread.sleep(2000);

        // Select What Nano Treats Button
        driver.findElement(By.xpath("/html/body/div/main/section[1]/div/div/div/div/div/div/div[3]/a[2]")).click();
        Thread.sleep(2000);

        // Select Shoulder on Graphic
        driver.findElement(By.xpath("//*[@id=\"arthroman\"]/div/div[1]/div[4]/div/a[1]/div")).click();
        Thread.sleep(2000);

        // Return to Home Page
        driver.get(HomePageURL);
        Thread.sleep(2000);

        // Select What Nano Treats Button
        driver.findElement(By.xpath("/html/body/div/main/section[1]/div/div/div/div/div/div/div[3]/a[2]")).click();
        Thread.sleep(2000);

        // Select Elbow on Graphic
        driver.findElement(By.xpath("//*[@id=\"arthroman\"]/div/div[1]/div[4]/div/a[3]/div")).click();
        Thread.sleep(2000);

        // Return to Home Page
        driver.get(HomePageURL);
        Thread.sleep(2000);

        // Select What Nano Treats Button
        driver.findElement(By.xpath("/html/body/div/main/section[1]/div/div/div/div/div/div/div[3]/a[2]")).click();
        Thread.sleep(2000);

        // Select Hand on Graphic
        driver.findElement(By.xpath("//*[@id=\"arthroman\"]/div/div[1]/div[4]/div/a[8]/div")).click();
        Thread.sleep(2000);

        // Return to Home Page
        driver.get(HomePageURL);
        Thread.sleep(2000);

        // Select What Nano Treats Button
        driver.findElement(By.xpath("/html/body/div/main/section[1]/div/div/div/div/div/div/div[3]/a[2]")).click();
        Thread.sleep(2000);

        // Select Hip on Graphic
        driver.findElement(By.xpath("//*[@id=\"arthroman\"]/div/div[1]/div[4]/div/a[7]/div")).click();
        Thread.sleep(2000);

        // Return to Home Page
        driver.get(HomePageURL);
        Thread.sleep(2000);

        // Select What Nano Treats Button
        driver.findElement(By.xpath("/html/body/div/main/section[1]/div/div/div/div/div/div/div[3]/a[2]")).click();
        Thread.sleep(2000);

        // Select Wrist on Graphic
        driver.findElement(By.xpath("//*[@id=\"arthroman\"]/div/div[1]/div[4]/div/a[2]/div")).click();
        Thread.sleep(2000);

        // Return to Home Page
        driver.get(HomePageURL);
        Thread.sleep(2000);

        // Select What Nano Treats Button
        driver.findElement(By.xpath("/html/body/div/main/section[1]/div/div/div/div/div/div/div[3]/a[2]")).click();
        Thread.sleep(2000);

        // Select Knee on Graphic
        driver.findElement(By.xpath("//*[@id=\"arthroman\"]/div/div[1]/div[4]/div/a[4]/div")).click();
        Thread.sleep(2000);

        // Return to Home Page
        driver.get(HomePageURL);
        Thread.sleep(2000);

        // Select What Nano Treats Button
        driver.findElement(By.xpath("/html/body/div/main/section[1]/div/div/div/div/div/div/div[3]/a[2]")).click();
        Thread.sleep(2000);

        // Select Foot on Graphic
        driver.findElement(By.xpath("//*[@id=\"arthroman\"]/div/div[1]/div[4]/div/a[5]/div")).click();
        Thread.sleep(2000);

        // Return to Home Page
        driver.get(HomePageURL);
        Thread.sleep(2000);

        // Select What Nano Treats Button
        driver.findElement(By.xpath("/html/body/div/main/section[1]/div/div/div/div/div/div/div[3]/a[2]")).click();
        Thread.sleep(2000);

        // Select Ankle on Graphic
        driver.findElement(By.xpath("//*[@id=\"arthroman\"]/div/div[1]/div[4]/div/a[6]/div")).click();
        Thread.sleep(2000);

        // Return to Home Page
        driver.get(HomePageURL);
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    void findDoctorSearch() throws InterruptedException {
        // Scroll Down to Download Brochure Link
        execute.executeScript("window.scroll(0,4500)", "");
        Thread.sleep(8000);

        // Input Search Terms in "Find a Doctor Near You"
        driver.findElement(By.xpath("//*[@id=\"location\"]")).sendKeys("Fort Myers, FL");
        Thread.sleep(2000);

        // Select Search Button
        driver.findElement(By.xpath("//*[@id=\"wf-form-Surgeon-Finder\"]/input[2]")).click();
        Thread.sleep(2000);

        // Scroll Down to Download Brochure Link
        execute.executeScript("window.scroll(0,250)", "");
        Thread.sleep(4000);

        // Return to Home Page
        driver.get(HomePageURL);
        Thread.sleep(2000);
    }

    @Test(priority = 8)
    void downloadQuestionList() throws InterruptedException {
        // Scroll Down to Download Brochure Link
        execute.executeScript("window.scroll(0,4500)", "");
        Thread.sleep(8000);

        // Select Download This List of Questions
        driver.findElement(By.linkText("Download this list of questions")).click();
        Thread.sleep(4000);

        // Get List of Window Handles
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // Switch to Brochure Tab and Close
        driver.switchTo().window(tabs.getLast());
        Thread.sleep(2000);
        driver.close();

        // Switch Back to Nano Experience Site
        driver.switchTo().window(tabs.getFirst());
        Thread.sleep(2000);
    }
}