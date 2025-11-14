package tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void successAuthorization() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.pageTitle());
        assertEquals(productsPage.pageTitleText(), "Products");
    }

    @DataProvider()
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "secret", "Epic sadface: Username and password do not match any user in this service"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "", "Epic sadface: Username is required"},
                {"locked_out_user", "secret", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "loginData")
    public void unsuccessAuthorization(String login, String password, String error) {
        loginPage.open();
        loginPage.login(login, password);
        assertEquals(loginPage.chekErrorMsg(), error);
    }
}
