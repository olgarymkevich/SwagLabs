package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;

public class CartPage extends BasePage {

    private final By description = By.xpath("//div[@class='cart_desc_label']");
    private final By items = By.cssSelector(".inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ожидаем отображение перечня товаров")
    public ArrayList<String> getProductNames() {
        List<WebElement> allProducts = driver.findElements(items);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProducts) {
           names.add(product.getText());
        }

        return names;
    }

    @Step("Проверяем переход на страницу")
    public String pageCartOpen(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(description));
        return driver.findElement(description).getText();
    }
}
