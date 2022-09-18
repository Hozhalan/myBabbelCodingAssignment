package steps;

import base.BaseTests;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class StepDefinition extends BaseTests {
    private Properties properties;

    @Before
    public void stepUp() {
        startUp();
    }

    @Given("initialize the data fields to process with the flow")
    public void initialize_the_data_fields_to_process_with_the_flow() throws IOException {
        FileReader reader = new FileReader("src/test/resources/users/PropertyDetails");
        properties = new Properties();
        properties.load(reader);
    }

    @Given("user is in the home after successfully logging into the application")
    public void user_is_in_the_home_after_successfully_logging_into_the_application() throws IOException {
        homePage = new HomePage(driver);
        loginPage = homePage.clickOnTheSignInButton();
        loginPage.enterTheEmailAddress(properties.getProperty("email"));
        loginPage.enterThePassword(properties.getProperty("password"));
        homePage = loginPage.clickLoginNowButton();
    }

    @And("user checks if the status of the add to cart is empty or not to clear add to cart")
    public void user_checks_if_the_status_of_the_add_to_cart_is_empty_or_not_to_clear_add_to_cart() {
        String addToCartValue = homePage.checkAddToCartCount();
        if (!addToCartValue.equals("0")) {
            addToCartPage = homePage.clickOnTheAddToCartButton();
            addToCartPage.removeTheAddedItem();
        }

    }

    @And("user proceeds to the check-out page by adding the selected TV from the search list with {string} quantity")
    public void user_proceeds_to_the_checkout_page_by_adding_the_selected_TV(String quantityType) {
        homePage.clickOnTheSearchBoxAndEnterTheSearchValue(properties.getProperty("searchValue"));
        searchResultPage = homePage.clickOnTheSearchButton();
        searchResultPage.selectAnItemFromTheList(properties.getProperty("wantedItem"));
        selectedItemPage = searchResultPage.clickOnTheSelectedItem();
        if (quantityType.equals("multiple")) {
            selectedItemPage.addMultipleQuantity();
        }
        selectedItemPage.clickOnTheAddToCartButton();
        shippingAndPaymentPage = selectedItemPage.clickOnTheProceedToCheckoutButton();
    }

    @Then("verify user have successfully proceeded with the checkout page and redirected to the shipping and payment page")
    public void verify_user_redirected_to_the_shipping_and_payment_page() {
        String shippingAndPaymentPageTitle = shippingAndPaymentPage.checkAddToCartCount();
        Assert.assertEquals("Select a shipping address", shippingAndPaymentPageTitle);
    }

    @After
    public void quitBrowser() {
        teardown();
    }
}
