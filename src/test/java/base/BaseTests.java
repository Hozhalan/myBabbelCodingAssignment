package base;

import org.openqa.selenium.WebDriver;
import pages.AddToCartPage;
import pages.LoginPage;
import pages.SearchResultPage;
import pages.HomePage;
import pages.SelectedItemPage;
import pages.ShippingAndPaymentPage;
import utils.WebDriverLibrary;

import java.time.Duration;

public abstract class BaseTests {
    protected static final int GLOBAL_TIMEOUT = 5;
    protected static WebDriver driver;
    protected static String route = "https://www.amazon.com/";
    protected static LoginPage loginPage;
    protected static HomePage homePage;
    protected static SearchResultPage searchResultPage;
    protected static SelectedItemPage selectedItemPage;
    protected static ShippingAndPaymentPage shippingAndPaymentPage;
    protected static AddToCartPage addToCartPage;

    public static void startUp() {
        driver = WebDriverLibrary.getChromeDriver();
        driver.navigate().to(route);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GLOBAL_TIMEOUT));
        driver.navigate().refresh();
    }

    public static void teardown() {
        driver.quit();
    }
}
