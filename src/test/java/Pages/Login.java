package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class Login {
        private WebDriver driver;
        public Login(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }
        @FindBy(id = "username")
        private WebElement Username;
        @FindBy(id = "password")
        private WebElement password;
        @FindBy(id = "Login")
        private  WebElement LogintoSandbox;

            public void enterUsername(String user) {
                Username.sendKeys(user);
            }
            public void enterPassword(String pass) {
                password.sendKeys(pass);
            }
            public void clickLogin() {
                LogintoSandbox.click();
            }
        }



