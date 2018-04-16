package pageObjects;

import com.sun.tools.javac.util.Assert;
import helper.DriverInitiation;
import helper.WaitTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends PageObject
{

    public LoginPage(WebDriver driver)
    {
        super(driver);
        Assert.check(EmailAddress.isDisplayed());
    }

    @FindBy(id = "email_create")
    private static WebElement EmailAddress;

    @FindBy(id = "SubmitCreate")
    private static WebElement CreateAccount;

    @FindBy(xpath = "//div[@id='create_account_error']//li[text()='Invalid email address.']")
    private static WebElement InvalidEmailMessage;

    public static void SetEmailAddress(String emailAddress)
    {
        EmailAddress.sendKeys(emailAddress);
    }

    public static void ClickOnCreateAnAccount()
    {
        DriverInitiation.jse.executeScript("window.scrollBy(0,50)");
        WaitTime.SpecifyWaitTime(3000);
        CreateAccount.click();
    }

    public static void VerifyErrorMessageDisplayed()
    {
        Assert.check(InvalidEmailMessage.isDisplayed());
    }
}
