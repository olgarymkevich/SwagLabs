package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import user.User;

public class LoginPage extends BasePage {

    private final By user_name = By.xpath("//input[@name='user-name']");
    private final By password = By.xpath("//input[@name='password']");
    private final By login = By.xpath("//input[@id='login-button']");
    private final By error = By.cssSelector(".error-message-container");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открываем URL страницы")
    public void open(){
        driver.get(BASE_URL);
    }

    @Step("Логинимся под кредами пользователя")
    public void login(User user) {
        fillInLogin(user.getEmail());
        fillPassword(user.getPassword());
        pressLoginBtn();
    }

    @Step("Вводим логин = {user.email}")
    public void fillInLogin(String login) {
        driver.findElement(user_name).sendKeys(login);
    }

    @Step("Вводим пароль = *****")
    public void fillPassword(String pas) {
        driver.findElement(password).sendKeys(pas);
    }

    @Step("Нажимаем кнопку 'Login'")
    public void pressLoginBtn() {
        driver.findElement(login).click();
    }

    @Step("Проверяем текст сообщения об ошибке")
    public String chekErrorMsg() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(error));
        return driver.findElement(error).getText();
    }
}
