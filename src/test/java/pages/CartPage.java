package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    private final By description = By.xpath("//div[@class='cart_desc_label']");
    private final By items = By.cssSelector(".inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public ArrayList<String> getProductNames() {
        List<WebElement> allProducts = driver.findElements(items);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProducts) {
           names.add(product.getText());
        }

        return names;
    }

    public String pageCartOpen(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(description));
        return driver.findElement(description).getText();
    }
}

