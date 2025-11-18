package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage {

    private static final String ADD_TO_CART = "//*[text()='%s']//ancestor::div[@class='inventory_item']//child::button[text()='Add to cart']";
    private By products = By.xpath("//span[@class='title']");
    private By counter_cart = By.xpath("//span[@class='shopping_cart_badge']");
    private By cart_link = By.cssSelector("[data-test='shopping-cart-link']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean pageTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(products));
        return driver.findElement(products).isDisplayed();
    }

    public String pageTitleText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(products));
        return driver.findElement(products).getText();
    }

    public void addToCart(final String goodsName){
        By addToCart = By.xpath(ADD_TO_CART.formatted(goodsName));
        driver.findElement(addToCart).click();
    }

    public String cart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(counter_cart));
        return driver.findElement(counter_cart).getText();
    }

    public void switchToCart(){
        driver.findElement(cart_link).click();
    }
}

//public void addToCart(final int index){
    //By addToCart = By.xpath("//*[text()='Add to cart']");
    //driver.findElements(addToCart).get(index).click();
//}