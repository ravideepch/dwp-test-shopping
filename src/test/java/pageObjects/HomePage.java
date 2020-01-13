package pageObjects;

import helpers.ConfigHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	private WebDriver driver;
	private Actions action;
	private static final String HOME_PAGE_URL = "http://automationpractice.com/index.php";

	@FindBy(how = How.CSS, using = "#block_top_menu a[title=\"Women\"]")
	private WebElement womenSectionElement;

    @FindBy(how = How.CSS, using = "#block_top_menu a[title=\"Summer Dresses\"]")
	private WebElement summerDressesLink;

    public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;

		driver.get(HOME_PAGE_URL);

		action = new Actions(driver);
	}

	public void hoverOnWomenSection()
    {
        action.moveToElement(womenSectionElement).perform();
    }

	public void goToSummerDress()
    {
        waitForLocator(summerDressesLink);
        action.moveToElement(womenSectionElement).perform();
        summerDressesLink.click();
    }

    public void waitForLocator(WebElement element)
    {
        ConfigHelper.waitForLocator(element, driver);
    }
}
