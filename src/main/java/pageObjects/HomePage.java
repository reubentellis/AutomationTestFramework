package pageObjects;



import com.sun.tools.javac.util.Assert;
import helper.WaitTime;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class HomePage extends PageObject
{

    JavascriptExecutor jse;
    //static WebDriver driver = null;
    @FindBy(linkText = "Sign in")
    private WebElement SignIn;


    @FindBy(xpath =  "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    private WebElement DressesTab;

    @FindBy(xpath = "//div[@class='block_content']//ul[@class='tree dynamized']//li[@class='last']//a")
    private WebElement SummerDresses;


    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public void clickOnSignIn()
    {
        SignIn.click();
    }

    public void ClickOnDressesTab()
    {
        DressesTab.click();
    }

    public void VerifyHomePageInitialized()
    {
        Assert.check(SignIn.isDisplayed());
    }

    public boolean IsSummerDressesDisplayed()
    {
        return SummerDresses.isDisplayed();
    }

    public void SelectSummerDresses()
    {
        SummerDresses.click();
    }

}
