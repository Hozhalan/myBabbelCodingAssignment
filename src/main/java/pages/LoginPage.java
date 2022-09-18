package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    protected By txtEmailAddress = By.xpath("//input[@id='ap_email']");
    protected By txtPassword = By.xpath("//input[@id='ap_password']");
    protected By btnContinue = By.xpath("//span/input[@id='continue']/..");
    protected By btnSignIn = By.xpath("//input[@id='signInSubmit']/..");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterTheEmailAddress(String emailAddress) {
        driver.findElement(txtEmailAddress).sendKeys(emailAddress);
        driver.findElement(btnContinue).click();
    }

    public void enterThePassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(txtPassword)).sendKeys(password);
    }

    public HomePage clickLoginNowButton() {
        driver.findElement(btnSignIn).click();
        return new HomePage(driver);
    }

}
