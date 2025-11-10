package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver browser;

    private static final By USER_NAME = By.xpath("//input[@name='user-name']");
    private static final By PASSWORD = By.xpath("//input[@name='password']");
    private static final By LOGIN = By.xpath("//input[@id='login-button']");
    private static final By PRODUCTS = By.xpath("//span[@class='title']");
    private static final By ERROR = By.cssSelector(".error-message-container");

    public LoginPage(WebDriver browser) {
        this.browser = browser;
    }

    public void open(){
        browser.get("https://www.saucedemo.com/");
    }
    public void login(String log) {
        browser.findElement(USER_NAME).sendKeys(log);
    }

    public void password(String pas){
        browser.findElement(PASSWORD).sendKeys(pas);
        browser.findElement(LOGIN).click();
    }

    public String chekMsg() {
        return browser.findElement(PRODUCTS).getText();
    }

    public String chekErrorMsg() {
        return browser.findElement(ERROR).getText();
    }
}
