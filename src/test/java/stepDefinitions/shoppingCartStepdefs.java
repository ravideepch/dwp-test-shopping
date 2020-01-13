package stepDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.ConfigHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.DressesPage;
import pageObjects.HomePage;
import pageObjects.ShoppingCartPage;

public class shoppingCartStepdefs
{
    private WebDriver driver;
    private HomePage homePage;
    private DressesPage dressesPage;
    private ShoppingCartPage cartPage;

    @Before
	public void setup()
	{
		driver = ConfigHelper.setupBrowser();

		//initialise page objects
        homePage = new HomePage(driver);
        dressesPage = new DressesPage(driver);
        cartPage = new ShoppingCartPage(driver);
	}

    @Given("^There is a women summer dress$")
	public void thereIsAWomenSummerDress()
	{
        homePage.hoverOnWomenSection();
        homePage.goToSummerDress();
	}

	@Given("^A user in shopping cart page$")
	public void userInShoppingCartPage()
	{
	    Assert.assertTrue("Expecting shopping cart page here",
                driver.getTitle().contains("Store")
        );
	}

	@And("^Dresses are sorted by price")
    public void dressesSortedByPrice()
    {
        dressesPage.sortDress("Price: Lowest first");
    }

	@When("^Item number \"([^\"]*)\" is added to basket$")
	public void itemNumberIsAddedToBasket(int itemNumber)
	{
        dressesPage.addGivenItemToShoppingBasket(itemNumber);
	}

	@When("^User removed item from shopping cart$")
	public void itemsAreRemovedFromShoppingCart()
	{
        cartPage.clearShoppingCart();
	}

	@Then("^A dress should be in basket$")
	public void givenDressShouldBeInBasket()
	{
        Assert.assertEquals(
                "Expecting one item in basket",
                1,
                cartPage.numberOfItemsInBasket()
        );
	}

	@Then("^There should not be a dress in basket$")
	public void noDressInBasket()
	{
        Assert.assertTrue(
                "No items should in the shopping cart",
                cartPage.isShoppingCartEmpty()
        );
	}
}
