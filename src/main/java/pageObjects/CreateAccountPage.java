package pageObjects;

import com.sun.tools.javac.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends PageObject
{
    public CreateAccountPage(WebDriver driver)
    {
        super(driver);
        Assert.check(PageHeader.isDisplayed());
    }

    @FindBy(xpath = "//div[@id = \"noSlide\"]/h1[text()='Create an account']")
    private  WebElement PageHeader;
}
