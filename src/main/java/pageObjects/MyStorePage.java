package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyStorePage extends PageObject
{
    public MyStorePage(WebDriver driver)
    {
        super(driver);
    }


    @FindBy(xpath = "//*[@id=\"categories_block_left\"]//a[contains(text(),'Summer Dresses')]")
    private WebElement SummerDresses;

    public void ClickOnSummerDresses()
    {
        SummerDresses.click();

    }
}
