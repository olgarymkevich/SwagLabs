package tests;

import enums.DepartmentNaming;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;

import static org.testng.Assert.*;
import static user.UserFactory.*;

public class LoginTest extends BaseTest {

    @Epic("Главная страница интернет-магазина")
    @Feature("Модуль логина")
    @Story("Авторизация")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Рымкевич Ольга, ...@mail.ru")
    @TmsLink("SwagLabs")
    @Issue("Rostelecom")
    @Test(description = "Авторизация с валидными данными")
    public void successAuthorization() {
        System.out.println("CorrectLogin tests are running in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(withAdminPermission());
        assertTrue(productsPage.pageTitle());
        assertEquals(productsPage.pageTitleText(), DepartmentNaming.PRODUCTS.getDisplayName());
    }

    @DataProvider()
    public Object[][] loginData() {
        return new Object[][]{
                {withInvalidPasswordUser(), "Epic sadface: Username and password do not match any user in this service"},
                {withEmptyPasswordUser(), "Epic sadface: Password is required"},
                {withEmptyEmailUser(), "Epic sadface: Username is required"},
                {withLockedUserPermission(), "Epic sadface: Sorry, this user has been locked out."},
                {withEmptyFieldsUser(), "Epic sadface: Username is required"},
                {withInvalidFieldsUser(), "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "loginData", description = "Авторизация с невалидными данными")
    public void unsuccessAuthorization(User user, String error) {
        System.out.println("IncorrectLogin tests are running in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(user);
        assertEquals(loginPage.chekErrorMsg(), error);
    }
}
