package Pages;

import Test.Logintest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.manager.SeleniumManagerOutput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage{
    private WebDriver driver;
    static Logger log = LogManager.getLogger(Logintest.class);
    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//    @FindBy(xpath = "//span[@class='slds-truncate'][normalize-space()='Accounts']")
//    private WebElement Account;

//    public void  ClickonAccount(){
//        Account.click();
//    }
    @FindBy(xpath = "//a[@title='New']")
    private  WebElement NewButton;
    public void ClickonNewButton(){
        log.info("Clicked On the NEw Button");
        NewButton.click();
    }
   @FindBy(name = "Name")
    private WebElement AccountName;
    public void EnterAccountName(String text){
        log.info("Enter Name "+text);
        AccountName.sendKeys(text);
    }
   @FindBy(xpath = "//*[@data-value='--None--' and @aria-label='Type']")
    private WebElement Type;
    public void SelectTypeDropDown() throws InterruptedException {

        Type.click();
        Thread.sleep(3000);
//        Select select=new Select(Type);
//        select.selectByValue("Press");
    }

    @FindBy(xpath = "//*[@title='Press']")
    private WebElement PressOption;
    public void SelectPressOption(){
        log.info("Selecting Press from the Type");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(PressOption));
        PressOption.click();
    }
   @FindBy(xpath = "//input[@name='Website' and @class='slds-input']")
    private  WebElement EnterWebsite;
    public void EnterWebsitename(String text){
        EnterWebsite.sendKeys(text);
        log.info("Entered Wesite Link "+text);
    }
    @FindBy(xpath = "//input[@name='Phone']")
    private WebElement PhoneNumber;
    public void EnterPhoneNumber(String phno){
        PhoneNumber.sendKeys(phno);
        log.info("Phone Number Entered Successfully "+phno);
    }
   @FindBy(xpath ="//*[@class='slds-textarea' and @maxlength='32000']")
   private WebElement Description;
    public  void EnterDescription(String des){
        Description.sendKeys(des);
        log.info("Description entered ");
    }
    @FindBy(xpath = "//*[@class='slds-input' and @inputmode='email']")
    private  WebElement Emailtextbox;
    public void EnterEmailtextbox(String email){
        Emailtextbox.sendKeys(email);
        log.info("email entered successfully");
    }
    @FindBy(xpath = "//*[@class='slds-input' and @name='NumberOfEmployees']")
    private  WebElement Employeestextbox;
    public  void EnterEmployee(String Employee){
        Employeestextbox.sendKeys(Employee);
        log.info("Employee name entered Successfully");
    }

    @FindBy(xpath = "//*[@data-value='--None--' and @aria-label='Industry']")
    private WebElement Industry;
    public void SelectIndustryOption(){
        Industry.click();
        log.info("Clicked on Industry");
    }
    @FindBy(xpath = "//*[@data-value='Banking']")
    private  WebElement Banking;
    public void SelectBankingOption() {
        Banking.click();
        log.info("Banking option selected successfully");
    }

    @FindBy(xpath ="//*[text()='Billing Address']/..//*[@placeholder='Search Address']")
    private WebElement BillingAddress;
    public void     SearchBillingAddress(String Bill) throws InterruptedException {
        JavascriptExecutor js =(JavascriptExecutor)(driver);
        js.executeScript("arguments[0].scrollIntoView(true);",BillingAddress);
        js.executeScript("arguments[0].click();",BillingAddress);
        BillingAddress.sendKeys(Bill);
        BillingAddress.sendKeys(Keys.DOWN);
        Thread.sleep(1000);
        BillingAddress.sendKeys(Keys.ENTER);
        log.info(" Search successfull in Billing Address");
        }

    @FindBy(xpath = "//input[@aria-activedescendant='combobox-input-237-2-237']")
    private WebElement SearchBangalore;
    public  void EnterBangalore(){
        log.info("Selecting Bangalore from the Type");
    }

    @FindBy(xpath ="//*[text()='Shipping Address']/..//*[@placeholder='Search Address']")
    private WebElement ShippingAddress;
    public void SearchShippingAddress(String Shipp) throws InterruptedException {
        JavascriptExecutor js =(JavascriptExecutor)(driver);
        js.executeScript("arguments[0].scrollIntoView(true);",ShippingAddress);
        js.executeScript("arguments[0].click();",ShippingAddress);
        ShippingAddress.sendKeys(Shipp);
        ShippingAddress.sendKeys(Keys.DOWN);
        Thread.sleep(1000);
        ShippingAddress.sendKeys(Keys.ENTER);
        log.info(" Search successfull in shipping Address");
    }
    @FindBy(xpath = "//*[@class='slds-button slds-button_brand']")
    private WebElement Savebutton;
    public void ClickonSave(){
        Savebutton.click();
    }

    }

