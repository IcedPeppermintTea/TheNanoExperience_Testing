/*
Authors: Ayleen Roque, Katarya Johnson-Williams
Class: Software Testing - CEN 4072 - CRN 10420
Instructor: Dr. Deepa Devasenapathy
Date: Spring 2024
File: FAQs.java (Frequently Asked Questions)
Description: Class to test the FAQs page on Nano Experience website.
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

public class FAQs {
    // Protected variable to store the webdriver
    protected WebDriver driver;

    // Create executor to scroll in browser
    protected JavascriptExecutor execute;

    // Store website URL in a string variable for easy access
    protected String FAQsURL = "https://www.thenanoexperience.com/faq";

    // Set up the webdriver before we start running the class
    @BeforeClass
    public void setUp() throws InterruptedException {
       // System.setProperty("webdriver.chrome.driver", "WebDrivers/Chromedriver/chromedriver.exe");
        driver = new ChromeDriver();

        // Reassign executor instance
        execute = (JavascriptExecutor) driver;

        // Open and maximize the Nano Experience page
        driver.get(FAQsURL);
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
    void connectWithDoctorButton() throws InterruptedException {
        // Scroll to "Connect With a Doctor" Button
        execute.executeScript("window.scroll(0,500)", "");
        Thread.sleep(2000);

        // Select "Connect With a Doctor" Button
        driver.findElement(By.xpath("/html/body/div/main/div[1]/div/div/div/div/div/div[1]/a")).click();
        Thread.sleep(2000);

        // Return to FAQ Page
        driver.get(FAQsURL);
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    void faqExpansionDropdown() throws InterruptedException {
        // Scroll to "Connect With a Doctor" Button
        execute.executeScript("window.scroll(0,500)", "");
        Thread.sleep(2000);

        // Expand "What is arthroscopic surgery?" Dropdown
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-5\"]/div/img[2]")).click();
        Thread.sleep(2000);

        // Expand "How does a Nano procedure differ from traditional arthroscopic surgery?" Dropdown
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-6\"]/div/img[2]")).click();
        Thread.sleep(2000);

        // Expand "Can anyone undergo Nano arthroscopy?" Dropdown
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-7\"]/div/img[2]")).click();
        Thread.sleep(2000);

        // Expand "What are the benefits of Nano arthroscopy over other types of surgery?" Dropdown
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-8\"]/div/img[2]")).click();
        Thread.sleep(2000);

        // Expand "Will I need a hospital stay?" Dropdown
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-9\"]/div/img[2]")).click();
        Thread.sleep(2000);

        // Expand "What will my recovery look like?" Dropdown
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-10\"]/div/img[2]")).click();
        Thread.sleep(2000);

        // Expand "Will I need anesthesia for my Nano arthroscopy procedure?" Dropdown
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-11\"]/div/img[2]")).click();
        Thread.sleep(2000);

        // Expand "How much pain will I be in?" Dropdown
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-12\"]/div/img[2]")).click();
        Thread.sleep(2000);

        // Expand "How do Nano arthroscopy procedures differ from robotic surgery?" Dropdown
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-13\"]/div/img[2]")).click();
        Thread.sleep(2000);

        // Expand "Are Nano arthroscopy procedures covered by insurance?" Dropdown
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-14\"]/div/img[2]")).click();
        Thread.sleep(2000);

        // Expand "How do I find a doctor who performs arthroscopy?" Dropdown
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-15\"]/div/img[2]")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    void faqReferenceLinks() throws InterruptedException {
        // Scroll to FAQ List
        execute.executeScript("window.scroll(0,1000)", "");
        Thread.sleep(2000);

        // Expand "How does a Nano procedure differ from traditional arthroscopic surgery?" Dropdown
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-6\"]/div/img[2]")).click();
        Thread.sleep(2000);

        // Select Reference Link 1 (next to "weeks")
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-list-6\"]/div/p/a[1]/sup")).click();
        Thread.sleep(2000);

        // Return to FAQs Page
        driver.get(FAQsURL);
        Thread.sleep(2000);

        // Scroll to FAQ List
        execute.executeScript("window.scroll(0,1000)", "");
        Thread.sleep(2000);

        // Expand "How does a Nano procedure differ from traditional arthroscopic surgery?" Dropdown
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-6\"]/div/img[2]")).click();
        Thread.sleep(2000);

        // Select Reference Link 2,3 (next to "such as an MRI")
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-list-6\"]/div/p/a[2]/sup")).click();
        Thread.sleep(2000);

        // Return to FAQs Page
        driver.get(FAQsURL);
        Thread.sleep(2000);

        // Scroll to FAQ List
        execute.executeScript("window.scroll(0,1000)", "");
        Thread.sleep(2000);

        // Expand "How does a Nano procedure differ from traditional arthroscopic surgery?" Dropdown
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-6\"]/div/img[2]")).click();
        Thread.sleep(2000);

        // Select Reference Link "the Nano Experience"
        driver.findElement(By.partialLinkText("Nano Experience")).click();
        Thread.sleep(2000);

        // Return to FAQs Page
        driver.get(FAQsURL);
        Thread.sleep(2000);

        // Scroll to FAQ List
        execute.executeScript("window.scroll(0,1000)", "");
        Thread.sleep(2000);

        // Expand "Can anyone undergo Nano arthroscopy?" Dropdown
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-7\"]/div/img[2]")).click();
        Thread.sleep(2000);

        // Select Reference Link "shoulder and elbow"
        driver.findElement(By.linkText("shoulder and elbow")).click();
        Thread.sleep(2000);

        // Return to FAQs Page
        driver.get(FAQsURL);
        Thread.sleep(2000);

        // Scroll to FAQ List
        execute.executeScript("window.scroll(0,1000)", "");
        Thread.sleep(2000);

        // Expand "Can anyone undergo Nano arthroscopy?" Dropdown
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-7\"]/div/img[2]")).click();
        Thread.sleep(2000);

        // Select Reference Link "knee and hip"
        driver.findElement(By.linkText("knee and hip")).click();
        Thread.sleep(2000);

        // Return to FAQs Page
        driver.get(FAQsURL);
        Thread.sleep(2000);

        // Scroll to FAQ List
        execute.executeScript("window.scroll(0,1000)", "");
        Thread.sleep(2000);

        // Expand "Can anyone undergo Nano arthroscopy?" Dropdown
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-7\"]/div/img[2]")).click();
        Thread.sleep(2000);

        // Select Reference Link "hand and wrist"
        driver.findElement(By.linkText("hand and wrist")).click();
        Thread.sleep(2000);

        // Return to FAQs Page
        driver.get(FAQsURL);
        Thread.sleep(2000);

        // Scroll to FAQ List
        execute.executeScript("window.scroll(0,1000)", "");
        Thread.sleep(2000);

        // Expand "Can anyone undergo Nano arthroscopy?" Dropdown
        driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-7\"]/div/img[2]")).click();
        Thread.sleep(2000);

        // Select Reference Link "foot and ankle"
        driver.findElement(By.linkText("foot and ankle")).click();
        Thread.sleep(2000);

        // Return to FAQs Page
        driver.get(FAQsURL);
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    void findDoctorSearch() throws InterruptedException {
        // Scroll Down to Download Brochure Link
        execute.executeScript("window.scroll(0,2250)", "");
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

        // Return to FAQs Page
        driver.get(FAQsURL);
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    void downloadQuestionList() throws InterruptedException {
        // Scroll Down to Download Brochure Link
        execute.executeScript("window.scroll(0,2250)", "");
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

        // Switch Back to FAQs Page
        driver.switchTo().window(tabs.getFirst());
        Thread.sleep(2000);
    }
}