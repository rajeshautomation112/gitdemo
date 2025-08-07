package testng_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test_demo {

    WebDriver driver;
     @BeforeClass(groups = "smoke")
     @Parameters ("browser")
     public void setup(String browser){
        if (browser.equalsIgnoreCase("chrome")){
         driver=new ChromeDriver();
         driver.manage().window().maximize();

         driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     }
     else if (browser.equalsIgnoreCase("edge")){

             driver=new EdgeDriver();
             driver.manage().window().maximize();

             driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         }
     }
    @Test(priority =1,groups = "smoke")
     public  void enter_usename_And_password(String username, String password){
         driver.findElement(By.name("username")).sendKeys("admin");
         driver.findElement(By.name("password")).sendKeys("admin123");
     }
    @Test(priority =2,groups="smoke")
     public void click_login_button(){

         driver.findElement(By.tagName("button")).click();
     }
    @Test(priority =3,groups = "regression")
        public void verify_login_success(){
        WebElement img = driver.findElement(By.xpath("//img[@class=\"oxd-userdropdown-img\"]"));
        Assert.assertTrue(img.isDisplayed());
        System.out.println("Login successful, test passed!");
        }
       @Test (priority = 4,groups="regression")
        public void logout(){
         driver.findElement(By.xpath("//img[@class=\"oxd-userdropdown-img\"]")).click();
         driver.findElement(By.xpath("//a[.='Logout']")).click();
            String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
            String actualUrl = driver.getCurrentUrl();
           Assert.assertEquals(expectedUrl,actualUrl);
           System.out.println("Logout successful, test passed!");

        }
    @AfterClass(groups = "regression")
        public void tearDown(){

         driver.quit();
        }
}
