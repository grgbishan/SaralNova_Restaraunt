import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CategoryPage;
import pages.ExtraFunctionsPage;
import pages.LoginPage;

import java.time.Duration;

import static pages.CategoryPage.*;

public class CategoryTest {
    public WebDriver driver;
    public CategoryPage categoryPage;
    public LoginPage loginPage;
    public ExtraFunctionsPage extraFunctionsPage;

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://uat-app.saralnova.com/categories");
        loginPage = new LoginPage(driver);
        loginPage.loginToApplication(LoginPage.correctEmail, LoginPage.correctPassword);
        categoryPage = new CategoryPage(driver);
        extraFunctionsPage = new ExtraFunctionsPage(driver);
    }

    @AfterEach
    public void tearDown() {driver.quit();}

    WebDriverWait wait;

    @Test
    public void verifyThatTheAddCategoryPageIsDisplayed() {
        driver.findElement(categoryBtn).click();
        String addCategoryPopUp = driver.findElement(addCategoryText).getText();
        Assertions.assertEquals("Add Category", addCategoryPopUp);
    }

    @Test
    public void verifyThatTheCategoryIsCreated() {
        extraFunctionsPage.clickTheElement(categoryBtn);
        extraFunctionsPage.selectImage(addCategoryImage, categoryImageFile);
        extraFunctionsPage.sendTheData(addCategoryTitle, addCategoryTitleText);
        extraFunctionsPage.clickTheElement(addCategorySubmitBtn);
//        String categotyAdded = driver.findElement(categoryToast).getText();
//        Assertions.assertEquals("Category Added", categotyAdded);
    }
}
