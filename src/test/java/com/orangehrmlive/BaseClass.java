package com.orangehrmlive;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public abstract class BaseClass {
    public static WebDriver driver;

    protected String appUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login1323";
    protected String userName = "Admin";
    protected String password = "admin123";

    public void initialization(){
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        driver = new FirefoxDriver(); //Open Browser
        //Open Webpage by get()
        driver.get(appUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void closeBrowser(){
        driver.quit();
    }

    public abstract String getPageTitle();

    public String getTitle() {
        return driver.getTitle();
    }

    public void inputValueInInputField(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    public void clickBtn(By element) {
        driver.findElement(element).click();
    }


}
