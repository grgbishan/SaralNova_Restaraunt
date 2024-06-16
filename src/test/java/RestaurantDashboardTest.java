import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import pages.RestaurantDashboardPage;

import java.time.Duration;

import static pages.RestaurantDashboardPage.restaurantText;


public class RestaurantDashboardTest {
    public WebDriver driver;
    public LoginPage loginPage;
    public RestaurantDashboardPage dashboardPage;


    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://uat-app.saralnova.com/login");
        loginPage = new LoginPage(driver);
        loginPage.loginToApplication(LoginPage.correctEmail, LoginPage.correctPassword);
        dashboardPage = new RestaurantDashboardPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void restaurantDashboardPageIsDisplayed(){
        driver.findElement(restaurantText).click();
        String dashboardText = driver.findElement(RestaurantDashboardPage.dashboardText).getText();
        Assertions.assertEquals("Dashboard", dashboardText);
    }


}
