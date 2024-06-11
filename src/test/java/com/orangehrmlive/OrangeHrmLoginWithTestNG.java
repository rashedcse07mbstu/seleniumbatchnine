package com.orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHrmLoginWithTestNG extends BaseClass {
    WebElement userEle;
       /*
        1. Open a browser >= done
        2. Open URL - done
        3. Enter User Name - done
        4. Enter password - done
        5. Click on login button
        6. Check the page title
         */

    @BeforeMethod
    public void setUp() {
        initialization();
    }

    @Test(priority = 0, enabled = true)
    public void loginApplication() {
        userEle = driver.findElement(By.name("username"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("username")));

        // To validate input field
        driver.findElement(By.name("username")).isDisplayed();

        if (userEle.isDisplayed()) {
            userEle.clear();
            //To clear username input field
            userEle.clear();

            //Inout UserName
            inputValueInInputField((By) userEle, userName);
        } else {
            System.out.println("User Name input field not found");
        }

        //To clear password input field
        driver.findElement(By.name("password")).clear();

        //Inout Password
        inputValueInInputField((By) driver.findElement(By.name("password")), password);

        //Clickq`w1 on Login button
        clickBtn((By) driver.findElement(By.xpath("//button[@type='submit']")));
    }

    @Test(priority = 1)
    public void validateHomePageTitle() {
        userEle = driver.findElement(By.name("username"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("password")));

        // To validate input field
        driver.findElement(By.name("password")).isDisplayed();

        if (userEle.isDisplayed()) {
            userEle.clear();
            //To clear username input field
            userEle.clear();

            //Inout UserName
            userEle.sendKeys(userName);
        } else {
            System.out.println("User Name input field not found");
        }

        //To clear password input field
        driver.findElement(By.name("password")).clear();

        //Inout Password
        driver.findElement(By.name("password")).sendKeys(password);

        //Click on Login button
        clickBtn((By) driver.findElement(By.xpath("//button[@type='submit']")));

        String expectedPageTitle = "OrangeHRM";

        Assert.assertEquals(getPageTitle(), expectedPageTitle);

        Assert.assertTrue(Boolean.parseBoolean(driver.getTitle()));

    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }

    @Override
    public String getPageTitle() {
        return getTitle();
    }
}
