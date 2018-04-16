package helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class DriverInitiation
{
    private static WebDriver driver;
    public static JavascriptExecutor jse;
    private static String browser = null;



    public static WebDriver InitiateFirefoxDriver()
    {
        System.setProperty("webdriver.gecko.driver", "D:\\IntelliJ Projects\\External Jars\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
        driver.get("http://automationpractice.com");
        return driver;
    }

    public static WebDriver InitiateChromeDriver()
    {
        System.setProperty("webdriver.chrome.driver","D:\\IntelliJ Projects\\External Jars\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
        driver.get("http://automationpractice.com");
        return driver;
    }

    public static WebDriver InitiateDriver()
    {
        browser = System.getProperty("browser");
        if(browser== null)
        {
            browser = "chrome";
        }
        if(browser.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "src\\test\\testFiles\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver","src\\test\\testFiles\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        jse = (JavascriptExecutor)driver;
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("http://automationpractice.com");
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver ReturnWebDriver()
    {
        if(driver != null)
        {
            return driver;
        }
        return null;
    }

    public static void CloseAllInstances()
    {
        if(!driver.equals(null)) {
            //driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}
