package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectedItemPage {
    private final WebDriver driver;
    protected By btnAddToCart = By.xpath("//input[@id='add-to-cart-button']/..");
    protected By btnProceedToCheckout = By.xpath("//*[@id='sc-buy-box-ptc-button']/span/input");
    protected By dropDownForItemQuantity = By.xpath("//*[@id='a-autoid-0']");
    protected By dropDownForItemQuantityValues = By.xpath("//div[@id='a-popover-17']");
    private WebDriverWait wait;

    public SelectedItemPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addMultipleQuantity() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropDownForItemQuantity)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropDownForItemQuantityValues)).click();
    }

    public void clickOnTheAddToCartButton() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnAddToCart)).click();
    }

    public ShippingAndPaymentPage clickOnTheProceedToCheckoutButton() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnProceedToCheckout)).click();
        return new ShippingAndPaymentPage(driver);
    }
}
