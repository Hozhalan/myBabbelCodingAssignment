package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    protected By btnSignIn = By.xpath("//span[@id='nav-link-accountList-nav-line-1']/../..");
    protected By txtSearchBox = By.xpath("//input[@id='twotabsearchtextbox']");
    protected By btnSearch = By.xpath("//input[@id='nav-search-submit-button']");
    protected By txtAddToCartValue = By.xpath("//span[@id='nav-cart-count']");
    protected By btnAddToCart = By.xpath("//a[@id='nav-cart']");
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickOnTheSignInButton() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSignIn)).click();
        return new LoginPage(driver);
    }

    public void clickOnTheSearchBoxAndEnterTheSearchValue(String searchValue) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtSearchBox)).click();
        driver.findElement(txtSearchBox).sendKeys(searchValue);
    }

    public SearchResultPage clickOnTheSearchButton() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSearch)).click();
        return new SearchResultPage(driver);
    }

    public String checkAddToCartCount() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(txtAddToCartValue)).getText();
    }

    public AddToCartPage clickOnTheAddToCartButton() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnAddToCart)).click();
        return new AddToCartPage(driver);
    }

}