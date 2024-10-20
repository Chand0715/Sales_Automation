package Test;
import Action.LoginAction;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.io.FileHandler;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Enum.LoginConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Logintest {
        private WebDriver driver;
        private LoginAction loginAction;
    static Logger log = LogManager.getLogger(Logintest.class); ;
        @BeforeClass
        public void setUp() {
            FirefoxProfile profile=new FirefoxProfile();
            profile.setPreference("geo.enabled", false);
            FirefoxOptions options=new FirefoxOptions();
            options.setProfile(profile);
            driver=new FirefoxDriver(options);
            loginAction = new LoginAction(driver);
            log.info("Starting FirefoxDriver and launching login page");
            try{
                driver.get(LoginConstants.url);
            }catch (Exception e){
                System.out.println(e.getMessage());
                log.error("Exception Occured", new Exception ("Element not found"));
            }
        }
        @Test
        public void LoginTest() {
            loginAction.login(LoginConstants.username, LoginConstants.password);
        }

    @AfterMethod
    public void captureFailureScreenshot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            String projectPath = System.getProperty("user.dir");
            String screenshotPath = projectPath + "/screenshots/" + result.getName() + ".png";
            File destFile = new File(screenshotPath);
            try {
                File screenshotDir = new File(projectPath + "/screenshots/");
                if (!screenshotDir.exists()) {
                    screenshotDir.mkdirs();
                }
                FileHandler.copy(srcFile, destFile);
                log.error("Test failed: " + result.getName());
                log.error("Screenshot saved at: " + screenshotPath);
            } catch (IOException e) {
                log.error("Error while saving screenshot: " + e.getMessage(), e);
            }
        }
    }
        @AfterClass
        public void tearDown() {
              driver.quit();
            }
       }



