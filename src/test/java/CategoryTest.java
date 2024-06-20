import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.CategoryPage;
import pages.ExtraFunctionsPage;
import pages.LoginPage;

import java.time.Duration;
import java.util.List;

import static pages.CategoryPage.*;

public class CategoryTest {
    public WebDriver driver;
    public CategoryPage categoryPage;
    public LoginPage loginPage;
    public ExtraFunctionsPage extraFunctionsPage;


    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://uat-app.saralnova.com/login");
        loginPage = new LoginPage(driver);
        loginPage.loginToApplication(LoginPage.correctEmail, LoginPage.correctPassword);
        categoryPage = new CategoryPage(driver);
        extraFunctionsPage = new ExtraFunctionsPage(driver);
        categoryPage.verifyThatTheCategoriesIsOpen();
    }

    @AfterEach
    public void tearDown() {driver.quit();}

    @Test
    public void verifyThatTheAddCategoryPageIsDisplayed() {
        driver.findElement(categoryBtn).click();
        String addCategoryPopUp = driver.findElement(addCategoryText).getText();
        Assertions.assertEquals("Add Category", addCategoryPopUp);
    }

    @Test
    public void verifyThatThCategoryTitleIsRequired() {
        driver.findElement(categoryBtn).click();
        driver.findElement(addCategorySubmitBtn).click();
        String error_msgTitle = driver.findElement(errorMsgAddCategoryTitle).getText();
        Assertions.assertEquals("The title field is required.", error_msgTitle);
    }

    @Test
    public void verifyThatTheCategoryIsCreated() throws InterruptedException {
        driver.findElement(categoryBtn).click();
        driver.findElement(addCategoryImage).sendKeys(categoryImageFile);
        Thread.sleep(2000);
        driver.findElement(addCategoryTitle).sendKeys(addCategoryTitleText);
        driver.findElement(addCategorySubmitBtn).click();
        Thread.sleep(2000);
        String categoryAdded = driver.findElement(loginPage.Toast).getText();
        Assertions.assertEquals("Category Added.", categoryAdded);
    }

    @Test
    public void verifyThatTheSameCategoryTitleIsNotAccepted() throws InterruptedException {
        driver.findElement(categoryBtn).click();
        driver.findElement(addCategoryImage).sendKeys(categoryImageFile);
        driver.findElement(addCategoryTitle).sendKeys(addCategoryTitleText);
        driver.findElement(addCategorySubmitBtn).click();
        Thread.sleep(2000);
        String error_msgTitle = driver.findElement(errorMsgAddCategoryTitle).getText();
        Assertions.assertEquals("The title has already been taken.", error_msgTitle);
    }

    @Test
    public void verifyThatTheCategoryIsDeleted() throws InterruptedException {
        driver.findElement(deleteCategoryTitle).click();
        driver.findElement(sureDeleteBtnText).click();
        String deleteMsgTitle = driver.findElement(loginPage.Toast).getText();
        Assertions.assertEquals("Category Deleted.", deleteMsgTitle);
    }

    @Test
    public void verifyThatTheCategoryIsUpdated() throws InterruptedException {
        driver.findElement(editCategoryBtn).click();
        Thread.sleep(2000);
        categoryPage.updateClear(editCategoryImage, editCategoryImageFile);
        categoryPage.updateClear(updateTitleInput, editCategoryTitleText);
        driver.findElement(updateCategorySubmitBtn).click();
        String updateMsgTitle = driver.findElement(loginPage.Toast).getText();
        Assertions.assertEquals("Category Updated.", updateMsgTitle);
    }

    @Test
    public void verifyThatTheSearchBarSearchesWithTheSpecifiedKeyword() throws InterruptedException {
        driver.findElement(searchBarInput).sendKeys(searchKeyword);
        Thread.sleep(3000);
        List<WebElement> categoryList = driver.findElements(categoryBox);
        Assertions.assertEquals(searchKeyword, categoryList.get(0).getText());
    }
}
