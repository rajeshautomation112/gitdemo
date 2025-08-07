package testng_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class DataProvider_with_Login {

    WebDriver driver;

    @Test(dataProvider = "loginData")

    public void setup(String username, String password) {

            driver=new ChromeDriver();
            driver.manage().window().maximize();

            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[.=' Login ']")).click();
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        System.out.println("Logout successful, test passed!");
        }
        @DataProvider (name = "loginData")
        public Object[][] test_data() {
            return new Object[][]{
                    {"admin", "admin123"},
                    {"user1", "password1"},
                    {"user2", "password2"}

            };
        }

@AfterMethod
public void browser_close() {
        if (driver != null) {
            driver.quit();
        }
    }

}


