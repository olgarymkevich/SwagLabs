package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    private By description = By.xpath("//div[@class='cart_desc_label']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String pageCartOpen(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(description));
        return driver.findElement(description).getText();
    }

    public ArrayList<String> getProductNames() {
        List<WebElement> allProducts = driver.findElements(By.cssSelector(".inventory_item_name"));
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProducts) {
           names.add(product.getText());
        }
        return names;
    }
}
