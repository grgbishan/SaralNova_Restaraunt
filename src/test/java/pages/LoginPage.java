package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public static WebDriver driver;
    public By email = By.xpath("//*[@id=\"email\"]");
    public By password = By.xpath("//*[@id=\"password\"]");
    public By loginBtn = By.xpath("/html/body/div[1]/div[2]/form/div[4]/button");
    public static final String correctEmail = "forestway@sns.com";
    public static final String correctPassword = "12345678";

    public LoginPage(WebDriver newDriver){
        driver = newDriver;
    }

    public void loginToApplication(String e_mail, String c_password){
        driver.findElement(email).sendKeys(e_mail);
        driver.findElement(password).sendKeys(c_password);
        driver.findElement(loginBtn).click();
    }






}
