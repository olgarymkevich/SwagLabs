package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private By products = By.xpath("//span[@class='title']");
    private static final String ADD_TO_CART = "//*[text()='%s']//ancestor::div[@class='inventory_item']//child::button[text()='Add to cart']";
    private static final By CART = By.xpath("//span[@class='shopping_cart_badge']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean pageTitle(){
        return driver.findElement(products).isDisplayed();
    }

    public String pageTitleText(){
        return driver.findElement(products).getText();
    }

    public void addToCart(final String goodsName){
        By addToCart = By.xpath(ADD_TO_CART.formatted(goodsName));
        driver.findElement(addToCart).click();
    }

    public String cart(){
        return driver.findElement(CART).getText();
    }
}
