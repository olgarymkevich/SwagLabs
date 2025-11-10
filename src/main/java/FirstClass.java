import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FirstClass {

    @Test
    public void successAuthorization (){
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.saucedemo.com/");
        browser.findElement(By.xpath("//input[@name='user-name']")).sendKeys("standard_user");
        browser.findElement(By.xpath("//input[@name='password']")).sendKeys("secret_sauce");
        browser.findElement(By.xpath("//input[@id='login-button']")).click();
        String pageText = browser.findElement(By.xpath("//span[@class='title']")).getText();
        assertEquals(pageText, "Products");
        browser.quit();
    }

    @Test
    public void failedAuthorization(){
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.saucedemo.com/");
        browser.findElement(By.xpath("//input[@name='user-name']")).sendKeys("standard_user");
        browser.findElement(By.xpath("//input[@name='password']")).sendKeys("secret");
        browser.findElement(By.xpath("//input[@id='login-button']")).click();
        String errorText = browser.findElement(By.cssSelector(".error-message-container")).getText();
        assertEquals(errorText, "Epic sadface: Username and password do not match any user in this service");
        browser.quit();
    }
}
