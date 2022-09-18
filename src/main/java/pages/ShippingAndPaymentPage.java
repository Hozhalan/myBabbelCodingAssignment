package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShippingAndPaymentPage {
    private final WebDriver driver;
    protected By txtTitle = By.xpath("//div[2]/div[1]/h1");

    public ShippingAndPaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public String checkAddToCartCount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(txtTitle)).getText();
    }
}
