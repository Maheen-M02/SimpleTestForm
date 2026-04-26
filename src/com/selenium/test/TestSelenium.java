package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TestSelenium {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 👉 Make sure this URL is correct
        driver.get("C:/Users/Maheen/Desktop/SimpleTestForm/index.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {

            // ✅ Wait for first input field instead of heading
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input")
            ));

            // Student Name
            driver.findElement(By.xpath("//label[contains(text(),'Student name')]/following::input[1]"))
                    .sendKeys("Maddy");
            Thread.sleep(1000);

            // Student ID
            driver.findElement(By.xpath("//label[contains(text(),'Student ID')]/following::input[1]"))
                    .sendKeys("STU123");
            Thread.sleep(1000);
            // Email
            driver.findElement(By.xpath("//label[contains(text(),'Email')]/following::input[1]"))
                    .sendKeys("maddy@gmail.com");
            Thread.sleep(1000);
            // Course / Subject
            driver.findElement(By.xpath("//input[@placeholder='e.g., Math 101']"))
                    .sendKeys("Math 101");
            Thread.sleep(1000);
            // Instructor
            driver.findElement(By.xpath("//input[@placeholder='e.g., Ms. Khan']"))
                    .sendKeys("Ms. Khan");
            Thread.sleep(1000);
            // Rating dropdown
            Select rating = new Select(driver.findElement(By.xpath("//select")));
            rating.selectByVisibleText("5 - Excellent");
            Thread.sleep(1000);
            // Comments
            driver.findElement(By.xpath("//textarea"))
                    .sendKeys("Great teaching! Add more practical examples.");
            Thread.sleep(1000);
            // Click Send
            driver.findElement(By.xpath("//button[contains(text(),'Send')]"))
                    .click();
            
            Thread.sleep(3000);

            System.out.println(" FORM SUBMITTED SUCCESSFULLY - TEST PASSED");

        } catch (Exception e) {
            System.out.println(" FORM SUBMISSION FAILED - TEST FAILED");
            e.printStackTrace();
        }

        driver.quit();
    }
}