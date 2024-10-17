package Test;

import Action.AccountAction;
import Action.LoginAction;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import Enum.LoginConstants;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static Test.Logintest.log;

public class AccountTest {
    private WebDriver driver;
    private LoginAction loginAction;
    @BeforeClass
    public void setUp() {
        FirefoxProfile profile=new FirefoxProfile();
        profile.setPreference("geo.enabled", false);
        profile.setPreference("permissions.default.desktop-notification", 2);// 1: allow, 2: block
        profile.setPreference("permissions.default.geo", 2);
        FirefoxOptions options=new FirefoxOptions();
        options.setProfile(profile);
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
    public void AccountTest() throws InterruptedException {
        loginAction.login(LoginConstants.username, LoginConstants.password);
        AccountAction accountAction=new AccountAction(driver);
        accountAction.AccountPage("Suraj","Bhadwagiri.com","8867462885","hello","chandinikumari@gmail.com","30","Bangalore","california");
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
}
