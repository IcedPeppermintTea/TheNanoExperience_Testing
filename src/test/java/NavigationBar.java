/*
Authors: Ayleen Roque, Katarya Johnson-Williams
Class: Software Testing - CEN 4072 - CRN 10420
Instructor: Dr. Deepa Devasenapathy
Date: Spring 2024
File: Navbar.java
Description: Class to test the Navigation bar on Nano Experience website.
 */

// Selenium Import Statements
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// TestNG Import Statements
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// Java Import Statements
import java.util.ArrayList;

public class NavigationBar {
    // Protected variable to store the webdriver
    protected WebDriver driver;

    // Store website URL in a string variable for easy access
    protected String NanoExperienceURL = "https://www.thenanoexperience.com/";

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
    void callToActionButtonLinks() throws InterruptedException {
        // Click on Arthrex Nano Experience logo
        driver.findElement(By.cssSelector(".logo-container")).click();
        Thread.sleep(2000);

        // Click on Find a Doctor button
        driver.findElement(By.xpath("/html/body/div/div/div[1]/nav/div[8]/a/div")).click();
        Thread.sleep(2000);

        // Click on Surgeon Site link
        driver.findElement(By.linkText("Surgeon Site")).click();
        Thread.sleep(2000);

        // Get List of Window Handles
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // Switch to Surgeon Site Tab and Close
        driver.switchTo().window(tabs.getLast());
        Thread.sleep(2000);
        driver.close();

        // Switch to Nano Experience Site
        driver.switchTo().window(tabs.getFirst());
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    void treatmentOptionLinks() throws InterruptedException {
        // Click to expand Treatment Options menu
        driver.findElement(By.cssSelector("#w-dropdown-toggle-0 > div.toggle-text")).click();
        Thread.sleep(2000);

        // Click on Home option
        driver.findElement(By.xpath("//*[@id='w-dropdown-list-0']/div/a[1]")).click();
        Thread.sleep(2000);

        // Click to expand Treatment Options menu
        driver.findElement(By.cssSelector("#w-dropdown-toggle-0 > div.toggle-text")).click();
        Thread.sleep(2000);

        // Click on Why Nano? option
        driver.findElement(By.xpath("//*[@id='w-dropdown-list-0']/div/a[2]")).click();
        Thread.sleep(2000);

        // Click to expand Treatment Options menu
        driver.findElement(By.cssSelector("#w-dropdown-toggle-0 > div.toggle-text")).click();
        Thread.sleep(2000);

        // Click on Where Does it Hurt? option
        driver.findElement(By.xpath("//*[@id='w-dropdown-list-0']/div/div[3]")).click();
        Thread.sleep(2000);

        // Click on Blog option
        driver.findElement(By.xpath("//*[@id='w-dropdown-list-0']/div/a[3]")).click();
        Thread.sleep(2000);

        // Click to expand Treatment Options menu
        driver.findElement(By.cssSelector("#w-dropdown-toggle-0 > div.toggle-text")).click();
        Thread.sleep(2000);

        // Click on FAQs option
        driver.findElement(By.xpath("//*[@id='w-dropdown-list-0']/div/a[4]")).click();
        Thread.sleep(2000);
    }

    @Test (priority = 4)
    void whereDoesItHurtLinks() throws InterruptedException {
        // Click to expand Treatment Options menu
        driver.findElement(By.cssSelector("#w-dropdown-toggle-0 > div.toggle-text")).click();
        Thread.sleep(2000);

        // Click on Where Does it Hurt? option
        driver.findElement(By.xpath("//*[@id='w-dropdown-list-0']/div/div[3]")).click();
        Thread.sleep(2000);

        // Click on Shoulder & Elbow option
        driver.findElement(By.xpath("//*[@id='w-dropdown-list-1']/div/a[1]")).click();
        Thread.sleep(2000);

        // Click to expand Treatment Options menu
        driver.findElement(By.cssSelector("#w-dropdown-toggle-0 > div.toggle-text")).click();
        Thread.sleep(2000);

        // Click on Where Does it Hurt? option
        driver.findElement(By.xpath("//*[@id='w-dropdown-list-0']/div/div[3]")).click();
        Thread.sleep(2000);

        // Click on Foot & Ankle option
        driver.findElement(By.xpath("//*[@id='w-dropdown-list-1']/div/a[2]")).click();
        Thread.sleep(2000);

        // Click to expand Treatment Options menu
        driver.findElement(By.cssSelector("#w-dropdown-toggle-0 > div.toggle-text")).click();
        Thread.sleep(2000);

        // Click on Where Does it Hurt? option
        driver.findElement(By.xpath("//*[@id='w-dropdown-list-0']/div/div[3]")).click();
        Thread.sleep(2000);

        // Click on Knee & Hip option
        driver.findElement(By.xpath("//*[@id='w-dropdown-list-1']/div/a[3]")).click();
        Thread.sleep(2000);

        // Click to expand Treatment Options menu
        driver.findElement(By.cssSelector("#w-dropdown-toggle-0 > div.toggle-text")).click();
        Thread.sleep(2000);

        // Click on Where Does it Hurt? option
        driver.findElement(By.xpath("//*[@id='w-dropdown-list-0']/div/div[3]")).click();
        Thread.sleep(2000);

        // Click on Hand & Wrist option
        driver.findElement(By.xpath("//*[@id='w-dropdown-list-1']/div/a[4]")).click();
        Thread.sleep(2000);
    }

    @Test (priority = 5)
    void resourceLinks() throws InterruptedException {
        // Click to expand Resources menu
        driver.findElement(By.cssSelector("#w-dropdown-toggle-2 > div.toggle-text")).click();
        Thread.sleep(2000);

        // Click on About Arthrex option
        driver.findElement(By.xpath("//*[@id='w-dropdown-list-2']/div/a[1]")).click();
        Thread.sleep(2000);

        // Click to expand Resources menu
        driver.findElement(By.cssSelector("#w-dropdown-toggle-2 > div.toggle-text")).click();
        Thread.sleep(2000);

        // Click on Find a Doctor option
        driver.findElement(By.xpath("//*[@id='w-dropdown-list-2']/div/a[2]")).click();
        Thread.sleep(2000);
    }

    @Test (priority = 6)
    void connectWithUsLinks() throws InterruptedException {
        // Click to expand Resources menu
        driver.findElement(By.cssSelector("#w-dropdown-toggle-2 > div.toggle-text")).click();
        Thread.sleep(2000);

        // Click on Facebook option
        driver.findElement(By.xpath("//*[@id='w-dropdown-list-2']/div/a[3]")).click();
        Thread.sleep(6000);

        // Get List of Window Handles
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // Switch to Facebook Tab and Close
        driver.switchTo().window(tabs.getLast());
        Thread.sleep(2000);
        driver.close();

        // Switch to Nano Experience Site
        driver.switchTo().window(tabs.getFirst());
        Thread.sleep(2000);

        // Click on Instagram option
        driver.findElement(By.xpath("//*[@id='w-dropdown-list-2']/div/a[4]")).click();
        Thread.sleep(6000);

        // Refresh List of Window Handles
        tabs = new ArrayList<>(driver.getWindowHandles());

        // Switch to Instagram Tab and Close
        driver.switchTo().window(tabs.getLast());
        Thread.sleep(2000);
        driver.close();

        // Switch to Nano Experience Site
        driver.switchTo().window(tabs.getFirst());
        Thread.sleep(2000);

        // Click on LinkedIn option
        driver.findElement(By.xpath("//*[@id='w-dropdown-list-2']/div/a[5]")).click();
        Thread.sleep(6000);

        // Refresh List of Window Handles
        tabs = new ArrayList<>(driver.getWindowHandles());

        // Switch to LinkedIn Tab and Close
        driver.switchTo().window(tabs.getLast());
        Thread.sleep(2000);
        driver.close();

        // Switch to Nano Experience Site
        driver.switchTo().window(tabs.getFirst());
        Thread.sleep(2000);

        // Click on Twitter option
        driver.findElement(By.xpath("//*[@id='w-dropdown-list-2']/div/a[6]")).click();
        Thread.sleep(6000);

        // Refresh List of Window Handles
        tabs = new ArrayList<>(driver.getWindowHandles());

        // Switch to Twitter Tab and Close
        driver.switchTo().window(tabs.getLast());
        Thread.sleep(2000);
        driver.close();

        // Switch to Nano Experience Site
        driver.switchTo().window(tabs.getFirst());
        Thread.sleep(2000);

        // Click on YouTube option
        driver.findElement(By.xpath("//*[@id='w-dropdown-list-2']/div/a[7]")).click();
        Thread.sleep(6000);

        // Refresh List of Window Handles
        tabs = new ArrayList<>(driver.getWindowHandles());

        // Switch to YouTube Tab and Close
        driver.switchTo().window(tabs.getLast());
        Thread.sleep(2000);
        driver.close();

        // Switch to Nano Experience Site
        driver.switchTo().window(tabs.getFirst());
        Thread.sleep(2000);
    }

}
