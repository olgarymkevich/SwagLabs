package pages;

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

    public void open(){
        driver.get(BASE_URL);
    }

    public void login(User user) {
        fillInLogin(user.getEmail());
        fillPassword(user.getPassword());
        pressLoginBtn();
    }

    public void fillInLogin(String login) {
        driver.findElement(user_name).sendKeys(login);
    }

    public void fillPassword(String pas) {
        driver.findElement(password).sendKeys(pas);
    }

    public void pressLoginBtn() {
        driver.findElement(login).click();
    }

    public String chekErrorMsg() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(error));
        return driver.findElement(error).getText();
    }
}

