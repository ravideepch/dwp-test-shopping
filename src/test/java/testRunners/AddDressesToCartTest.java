package testRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(  monochrome = true,
		features = {"src/test/features/addItemsToShoppingCart.feature"},
		glue = {"stepDefinitions"})
public class AddDressesToCartTest {
}
