package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDashboardPage {
    public static WebDriver driver;

    public static By  dashboardText = By.xpath("/html/body/div[1]/aside/div/nav/ul/li[4]/ul/li[1]/a");
    public static By  restaurantText = By.xpath("/html/body/div[1]/aside/div/nav/ul/li[4]");

    public RestaurantDashboardPage(WebDriver newDriver) {
        driver = newDriver;
    }

}
