package stepDefination;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DatatabledemoLogin {

    WebDriver driver;





        @Given("Go to the loginpage")
        public void go_to_the_loginpage() {

            driver = new ChromeDriver();
            driver.manage().window().maximize();


        }

        @When("enter credentials (.*) and (.*)$")
        public void enter_credentials_and(String username, String password) {
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement usernameField = driver.findElement(By.name("username")); // Adjust locator as needed
            WebElement passwordField = driver.findElement(By.name("password")); // Adjust locator as needed

            usernameField.sendKeys(username);
            passwordField.sendKeys(password);
        }

        @And("press the enter")
        public void press_the_enter() {
            WebElement loginButton = driver.findElement(By.tagName("button")); // Adjust locator as needed
            loginButton.click();
        }

        @Then("user navigate to the homepage for valid")
        public void user_navigate_to_the_homepage_for_valid() {

            driver.quit();
        }
    }

