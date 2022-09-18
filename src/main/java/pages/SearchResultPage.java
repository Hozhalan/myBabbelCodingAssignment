package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultPage {
    private final WebDriver driver;
    protected By listSearchItem = By.xpath("//div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span/..");
    private WebElement selectedItem;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public SelectedItemPage clickOnTheSelectedItem() {
        selectedItem.click();
        return new SelectedItemPage(driver);
    }

    public void selectAnItemFromTheList(String searchValue) {
        List<WebElement> searchItems = driver.findElements(listSearchItem);
        for (WebElement wantedItem : searchItems) {
            if (wantedItem.getText().contains(searchValue)) {
                selectedItem = wantedItem;
                break;
            }
        }
    }

}
