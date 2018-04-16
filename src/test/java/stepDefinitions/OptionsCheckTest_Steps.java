package stepDefinitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.DriverInitiation;
import helper.WaitTime;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.MyStorePage;
import pageObjects.SummerDressesPage;
import steps.World;


public class OptionsCheckTest_Steps
{
    WebDriver driver;
    HomePage homePage;
    MyStorePage myStorePage;
    SummerDressesPage summerDressesPage;
    String browser = null;
    private World world;
    public OptionsCheckTest_Steps(World world)
    {
        this.world = world;
    }

    @Given("^The user is on home page$")
    public void the_user_is_on_home_page()
    {
        world.homePage = new HomePage(DriverInitiation.ReturnWebDriver());
    }

    @When("^the user selects Dresses tab$")
    public void the_user_selects_Dresses_tab()
    {
        world.homePage.ClickOnDressesTab();
    }

    @When("^the user selects Summer Dresses$")
    public void the_user_selects_Summer_Dresses()
    {
        world.homePage.SelectSummerDresses();
    }

    @Then("^Summer Dresses page is displayed$")
    public void summer_Dresses_page_is_displayed()
    {
        world.summerDressesPage = new SummerDressesPage(driver);
    }

    @Given("^the user is on Summer Dresses page$")
    public void the_user_is_on_Summer_Dresses_page()
    {
        world.summerDressesPage = new SummerDressesPage(DriverInitiation.ReturnWebDriver()); //Reinitialize SummerDressesPage
        world.homePage = new HomePage(DriverInitiation.ReturnWebDriver());                  //Reinitialize HomePage
        world.homePage.ClickOnDressesTab();
        world.homePage.SelectSummerDresses();
    }

    @When("^the user selects to sort dresses by ascending price$")
    public void the_user_selects_to_sort_dresses_by_ascending_price()
    {
        world.summerDressesPage.ClickOnSelectProduct();

    }

    @Then("^Summer Dresses are sorted in ascending order of price$")
    public void summer_Dresses_are_sorted_in_ascending_order_of_price()
    {
        world.summerDressesPage.SortDressesByAscendingPrice();
        WaitTime.SpecifyWaitTime(3000);
    }

    @When("^the user selects to sort dresses by descending price$")
    public void the_user_selects_to_sort_dresses_by_descending_price()
    {
        world.summerDressesPage.ClickOnSelectProduct();
    }

    @Then("^Summer Dresses are sorted in descending order of price$")
    public void summer_Dresses_are_sorted_in_descending_order_of_price()
    {
        world.summerDressesPage.SortDressesByDescendingPrice();
        WaitTime.SpecifyWaitTime(3000);
        DriverInitiation.CloseAllInstances();
    }


}
