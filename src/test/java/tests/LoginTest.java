package tests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{

    @Test
    public void successAuthorization (){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.pageTitle());
        assertEquals(productsPage.pageTitleText(), "Products");
    }

    @Test
    public void incorrectPassword(){
        loginPage.open();
        loginPage.login("standard_user", "secret");
        assertEquals(loginPage.chekErrorMsg(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void incorrectUsername(){
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(loginPage.chekErrorMsg(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void emptyPassword(){
        loginPage.open();
        loginPage.login("locked_out_user", "");
        assertEquals(loginPage.chekErrorMsg(), "Epic sadface: Password is required");
    }

    @Test
    public void emptyUsername(){
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.chekErrorMsg(), "Epic sadface: Username is required");
    }

    @Test
    public void emptyFields(){
        loginPage.open();
        loginPage.login("", "");
        assertEquals(loginPage.chekErrorMsg(), "Epic sadface: Username is required");
    }
}
