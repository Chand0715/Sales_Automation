package Test;
import Action.LoginAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Enum.LoginConstants;

  public class Logintest {
        private WebDriver driver;
        private LoginAction loginAction;

        @BeforeClass
        public void setUp() {
            driver = new FirefoxDriver();
            loginAction = new LoginAction(driver);
            driver.get(LoginConstants.url);
        }

        @Test
        public void LoginTest() {
            loginAction.login(LoginConstants.username, LoginConstants.password);
        }
        @AfterClass
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }


