package pageObjects;

import helper.WaitTime;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class SummerDressesPage extends PageObject
{
    public SummerDressesPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id = "selectProductSort")
    private WebElement SelectProduct;

    Select select;

    public void ClickOnSelectProduct()
    {   select = new Select(SelectProduct);
        SelectProduct.click();

    }

    public void SortDressesByAscendingPrice()
    {
        select.selectByValue("price:asc");
        WaitTime.SpecifyWaitTime(5000);
        List<WebElement> OriginalXpaths = driver.findElements(By.xpath
                ("//ul[@class='product_list grid row']//div[@itemprop='offers']/span[@itemprop='price']"));
        ExtractPricesAndVerifySorting(OriginalXpaths, "ascending");
    }

    private void ExtractPricesAndVerifySorting(List<WebElement> originalXpaths, String sortOrder) {
        List<String> pricesList = new ArrayList<>();
        ExtractTextFromXpathListIntoPricesList(originalXpaths, pricesList);
        List<String> PriceListWithoutDuplicates = RemoveDuplicateValuesInList(pricesList);
        SortByAndVerifyOrder(PriceListWithoutDuplicates, sortOrder);
    }

    public void SortDressesByDescendingPrice()
    {
        select.selectByValue("price:desc");
        WaitTime.SpecifyWaitTime(5000);
        List<WebElement> OriginalXpaths = driver.findElements(By.xpath
                ("//ul[@class='product_list grid row']//div[@itemprop='offers']/span[@itemprop='price']"));
        ExtractPricesAndVerifySorting(OriginalXpaths, "descending");
    }

    private void ExtractTextFromXpathListIntoPricesList(List<WebElement> priceList, List<String> prices)
    {
        for (WebElement element : priceList)
        {
            if (element.getText().contains("$"))
            {
                //System.out.println("Original Element is " + element.getText());
                prices.add(element.getText());

            }
        }


    }



    private void SortByAndVerifyOrder(List<String> prices, String sortOrder)
    {
        List<String> sortedPrices = new ArrayList<String>(prices);
        if(sortOrder.equalsIgnoreCase("ascending"))
        {
            Collections.sort(sortedPrices);
        }
        else
        {
            Collections.sort(sortedPrices,Collections.<String>reverseOrder());
        }
        /*System.out.println("size of prices "+prices.size() + " size of sortedprices " + sortedPrices.size() );
        for(int i = 0; i < sortedPrices.size(); i++)
        {
            System.out.println("After sorting" + sortedPrices.get(i));
        }*/
        Assert.assertTrue(prices.equals(sortedPrices));

    }



    public List<String> RemoveDuplicateValuesInList(List<String> price)
    {
        Set<String> hs = new LinkedHashSet<>();
        hs.addAll(price);
        price.clear();
        price.addAll(hs);
        List<String>UpdatedList = new ArrayList<>(price);
       /* for(int i = 0; i < UpdatedList.size(); i++)
        {
            System.out.println("Updated List Value is " + UpdatedList.get(i));
        }*/
        return UpdatedList;
    }
}
