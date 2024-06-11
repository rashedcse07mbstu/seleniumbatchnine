package seleniumfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandlingRadioButton {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demo.guru99.com/test/radio.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Select Checkbox
        WebElement element = driver.findElement(By.id("vfb-7-1"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("vfb-7-1")));

        driver.findElement(By.id("vfb-7-1")).isDisplayed();

        if (!(element.isSelected())){
            driver.findElement(By.id("vfb-7-1")).click();
        }

        //Select Checkbox
        WebElement element2 = driver.findElement(By.id("vfb-6-0"));
        if (!(element2.isEnabled())){
            element2.click();
        }
        else {
            System.out.println("Checkbox is already selected");
        }

    }
}
