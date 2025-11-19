package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

public class ProductsTest extends BaseTest {

    final String goodsName = "Sauce Labs Backpack";

    @Test
    public void chekGoodsAdded(){
        System.out.println("Products tests are running in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.pageTitleText();
        productsPage.addToCart(goodsName);
        assertEquals(productsPage.cart(), "1");
    }

    @Test
    public void goodsInCart(){
        System.out.println("Products tests are running in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.pageTitleText();
        productsPage.addToCart(goodsName);
        productsPage.switchToCart();
        cartPage.pageCartOpen();
        assertTrue(cartPage.getProductNames().contains(goodsName));
        assertEquals(cartPage.getProductNames().size(), 1);
        assertFalse(cartPage.getProductNames().isEmpty());
    }
}

