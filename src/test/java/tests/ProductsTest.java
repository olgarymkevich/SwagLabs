package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class ProductsTest extends BaseTest {

    @Test
    public void chekGoodsAdded(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.pageTitleText();
        productsPage.addToCart("Sauce Labs Backpack");
        assertEquals(productsPage.cart(), "1");
    }

    @Test
    public void goodsInCart(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.pageTitleText();
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.switchToCart();
        cartPage.pageCartOpen();
        assertTrue(cartPage.getProductNames().contains("Sauce Labs Backpack"));
        assertEquals(cartPage.getProductNames().size(), 1);
        assertFalse(cartPage.getProductNames().isEmpty());
    }
}
