package pageObjects;

import helpers.ConfigHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DressesPage
{
    private WebDriver driver;
	private Actions action;

	@FindAll(@FindBy(how = How.CSS, using = "div#center_column a.product_img_link img"))
	private List<WebElement> womenDressesByPrice;

    @FindBy(how = How.CSS, using = "div#center_column a[title=\"Add to cart\"]")
	private WebElement addToCartButton;

    @FindBy(how = How.CSS, using = "a[title=\"Proceed to checkout\"] span")
	private WebElement proceedCheckOutButton;

    @FindBy(how = How.CSS, using = "select#selectProductSort")
	private WebElement sortDressElement;

    public DressesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;

		action = new Actions(driver);
	}

    public void sortDress(String sortByCriteria)
    {
        Select sortDress = new Select(sortDressElement);
        sortDress.selectByVisibleText(sortByCriteria);
    }

	public void addGivenItemToShoppingBasket(int itemNumber)
    {
        action.moveToElement(womenDressesByPrice.get(itemNumber)).perform();
        ConfigHelper.waitForLocator(addToCartButton, driver);
        addToCartButton.click();

        ConfigHelper.waitForLocator(proceedCheckOutButton, driver);
        proceedCheckOutButton.click();
    }
}
