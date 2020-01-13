package pageObjects;

import helpers.ConfigHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingCartPage
{
    private WebDriver driver;
	private Actions action;

	@FindAll(@FindBy(how = How.CSS, using = "table#cart_summary tr[id^=\"product_\"]"))
	private List<WebElement> allItemsInBasket;

    @FindBy(how = How.CSS, using = "a[title=\"Delete\"]")
	private WebElement deleteButton;

    @FindBy(how = How.CSS, using = "div.shopping_cart a[title=\"View my shopping cart\"]")
	private WebElement shoppingCartElement;

	public ShoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;

		action = new Actions(driver);
	}

	public void goToShoppingCart()
    {
        shoppingCartElement.click();
    }

	public int numberOfItemsInBasket()
    {
        return allItemsInBasket.size();
    }

	public void clearShoppingCart()
    {
        ConfigHelper.waitForLocator(deleteButton, driver);

        deleteButton.click();
    }

    public Boolean isShoppingCartEmpty()
    {
        return (numberOfItemsInBasket() != 0);
    }
}
