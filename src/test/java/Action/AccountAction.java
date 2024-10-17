package Action;

import Pages.AccountPage;
import Pages.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v125.fedcm.model.Account;

public class AccountAction {
    private WebDriver driver;
    private AccountPage Account;
   public AccountAction(WebDriver driver){
       this.driver= driver;
       Account =new AccountPage(driver);
   }
    public void AccountPage(String user,String URL,String phno,String des,String email,String employee,String Bill,String Shipp) throws InterruptedException {
        Account.ClickonNewButton();
        Account.EnterAccountName(user);
        Account.SelectTypeDropDown();
        Account.SelectTypeDropDown();
        Account.SelectPressOption();
        Account.EnterWebsitename(URL);
        Account.EnterPhoneNumber(phno);
        Account.EnterDescription(des);
        Account.EnterEmailtextbox(email);
        Account.EnterEmployee(employee);
        Account.SelectIndustryOption();
        Account.SelectBankingOption();
        Account.SearchBillingAddress(Bill);
        Account.SearchShippingAddress(Shipp);
        Account.ClickonSave();
    }



}
