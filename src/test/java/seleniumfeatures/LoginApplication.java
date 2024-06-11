package seleniumfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginApplication {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        /*
        1. Open a browser >= done
        2. Open URL - done
        3. Enter User Name - done
        4. Enter password - done
        5. Click on login button
        6. Check the page title
         */

        WebElement userEle;

        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        driver = new FirefoxDriver(); //Open Browser

        //Open Webpage by get()
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//        Thread.sleep(5000);

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
            userEle.sendKeys("Admin");
        } else {
            System.out.println("User Name input field not found");
        }

        //To clear password input field
        driver.findElement(By.name("password")).clear();

        //Inout Password
        driver.findElement(By.name("password")).sendKeys("admin123");

        //Clickq`w1 on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String actualPateTitle = driver.getTitle();
        System.out.println(actualPateTitle);

        String expectedPageTitle = "OrangeHRM";
        if (expectedPageTitle == actualPateTitle) {
            System.out.println("user Logged in successfully and after login user is in write page");
        }

    }
}
