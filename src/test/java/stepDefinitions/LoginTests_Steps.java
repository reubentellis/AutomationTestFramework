package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import helper.DriverInitiation;
import cucumber.api.java.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.CreateAccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;


public class LoginTests_Steps
{
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    CreateAccountPage createAccountPage;


    @Before
    public void InitialSetup()
    {
        driver = DriverInitiation.InitiateDriver();
    }

    @Given("^the user is on home page$")
    public void the_user_is_on_home_page()
    {

        homePage = new HomePage(driver);
    }

    @When("^the user clicks on Sign In link$")
    public void the_user_clicks_on_Sign_In_link()
    {
        homePage.clickOnSignIn();
    }

    @When("^the user provides the email-ID as \"([^\"]*)\"$")
    public void the_user_provides_the_email_ID_as(String emailID)
    {
        loginPage = new LoginPage(driver);
        LoginPage.SetEmailAddress(emailID);
        LoginPage.ClickOnCreateAnAccount();
    }

    @Then("^the user is directed to create an account$")
    public void the_user_is_directed_to_create_an_account()
    {
        createAccountPage = new CreateAccountPage(driver);

    }

    @Then("^an error message is displayed$")
    public void an_error_message_is_displayed()
    {
        loginPage.VerifyErrorMessageDisplayed();
        DriverInitiation.CloseAllInstances();
    }

    @After
    public void CloseScenario()
    {
        DriverInitiation.CloseAllInstances();
    }

}
