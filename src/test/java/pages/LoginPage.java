package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private By user_name = By.xpath("//input[@name='user-name']");
    private By password = By.xpath("//input[@name='password']");
    private By login = By.xpath("//input[@id='login-button']");
    private By error = By.cssSelector(".error-message-container");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get(BASE_URL);
    }

    public void login(String log, String pas) {
        fillInLogin(log);
        fillPassword(pas);
        pressLoginBtn();
    }

    public void fillInLogin(String log) {
        driver.findElement(user_name).sendKeys(log);
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
