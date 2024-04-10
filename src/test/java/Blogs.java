/*
Authors: Ayleen Roque, Katarya Johnson-Williams
Class: Software Testing - CEN 4072 - CRN 10420
Instructor: Dr. Deepa Devasenapathy
Date: Spring 2024
File: Blogs.java
Description: Class to test the Blogs page on Nano Experience website.
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

public class Blogs {
    // Protected variable to store the webdriver
    protected WebDriver driver;

    // Create executor to scroll in browser
    protected JavascriptExecutor execute;

    // Store website URL in a string variable for easy access
    protected String BlogsURL = "https://www.thenanoexperience.com/blog";

    // Set up the webdriver before we start running the class
    @BeforeClass
    public void setUp() throws InterruptedException {
      //  System.setProperty("webdriver.chrome.driver", "WebDrivers/Chromedriver/chromedriver.exe");
        driver = new ChromeDriver();

        // Reassign executor instance
        execute = (JavascriptExecutor) driver;

        // Open and maximize the Nano Experience page
        driver.get(BlogsURL);
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
    void urlAndTitle() throws InterruptedException {
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
    void selectBlogsLinks() throws InterruptedException {
        // Scroll Down to Articles
        execute.executeScript("window.scroll(0,850)", "");
        Thread.sleep(4000);

        // Select "Nano Arthroscopy Offers Minimally Invasive Carpal Tunnel Solution"
        driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[4]/div/div[1]/a/div/h3")).click();
        Thread.sleep(2000);

        // Return to Blogs Page
        driver.get(BlogsURL);
        Thread.sleep(2000);

        // Scroll Down to Articles
        execute.executeScript("window.scroll(0,850)", "");
        Thread.sleep(4000);

        // Select "Leading Surgeon Responds to Nano Experience FAQs"
        driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[4]/div/div[2]/a/div/h3")).click();
        Thread.sleep(2000);

        // Return to Blogs Page
        driver.get(BlogsURL);
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    void findDoctorSearch() throws InterruptedException {
        // Scroll Down to Download Brochure Link
        execute.executeScript("window.scroll(0,1500)", "");
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

        // Return to Blogs Page
        driver.get(BlogsURL);
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    void downloadQuestionList() throws InterruptedException {
        // Scroll Down to Download Brochure Link
        execute.executeScript("window.scroll(0,1500)", "");
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

        // Switch Back to Blogs Site
        driver.switchTo().window(tabs.getFirst());
        Thread.sleep(2000);
    }
}