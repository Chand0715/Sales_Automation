package Action;
import Pages.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;

public class LoginAction {
    private WebDriver driver;
    private Login loginPage;

    public LoginAction(WebDriver driver) {
        this.driver = driver;
        loginPage = new Login(driver);
    }

    public void login(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }
}


