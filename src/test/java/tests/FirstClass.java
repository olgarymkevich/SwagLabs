package tests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FirstClass extends BaseTest{

    @Test
    public void successAuthorization (){
        loginPage.open();
        loginPage.login("standard_user");
        loginPage.password("secret_sauce");
        assertEquals(loginPage.chekMsg(), "Products");
    }

    @Test
    public void failedAuthorization(){
        loginPage.open();
        loginPage.login("standard_user");
        loginPage.password("secret");
        assertEquals(loginPage.chekErrorMsg(), "Epic sadface: Username and password do not match any user in this service");
    }
}
