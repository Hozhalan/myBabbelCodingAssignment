package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCartPage {
    private final WebDriver driver;

    protected By btnDelete = By.xpath("//div[4]/div/div[1]/div/div/div[2]/div[1]/span[2]/span");

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void removeTheAddedItem() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnDelete)).click();
    }
}
