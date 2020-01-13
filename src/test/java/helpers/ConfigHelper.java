package helpers;

import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ConfigHelper
{
	private static final int MAX_WAIT = 10;

	public static WebDriver setupBrowser()
	{
		WebDriver driver = createWebDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		return driver;
	}

	public static WebDriver createWebDriver() {
        String webdriver = System.getProperty("browser", "chrome");

        if (webdriver.equalsIgnoreCase("firefox"))
        	return new FirefoxDriver();
        else if (webdriver.equalsIgnoreCase("chrome"))
        	return new ChromeDriver();
        else
        	throw new RuntimeException("Unsupported webdriver: " + webdriver);

    }

    public static void waitForLocator(WebElement element, WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, MAX_WAIT);

        try{
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException ex){
			Assert.fail("Element can not be found after " + MAX_WAIT + " seconds");
		}
    }
}
