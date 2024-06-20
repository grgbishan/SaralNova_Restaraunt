package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryPage {
    public WebDriver driver;

    public static By categoryBtn = By.xpath("//button[contains(text(),'Add Category')]");
    public static By addCategoryImage = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/input[1]");
    public static By editCategoryImage = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/input[1]");
    public static By addCategoryText = By.xpath("//p[@id='categoryModalLabel']");
    public static By addCategoryTitle = By.cssSelector("#title");
    public static By addCategorySubmitBtn = By.xpath("//button[contains(text(),'Submit')]");
    public static By updateCategorySubmitBtn = By.xpath("//*[@id=\"categoryEditModal\"]/div/div/div[2]/form/button");
    public static By editCategoryBtn = By.xpath("/html/body/div[1]/div[1]/div/div/section/div/div/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/button[1]/i");
    public static By errorMsgAddCategoryTitle = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/span[1]");
    public static By deleteCategoryTitle = By.xpath("/html/body/div[1]/div[1]/div/div/section/div/div/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/button[2]/i");
    public static By sureDeleteBtnText = By.xpath("//*[@id=\"categoryDeleteModal\"]/div/div/form/div[2]/button[2]");
    public static By updateTitleInput = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/input[1]");
    public static By searchBarInput = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
    public static By categoryBox = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]");
    public static final String addCategoryTitleText = "Burger/Sandwich";
    public static final String editCategoryTitleText = "Sekuwa";
    public static final String categoryImageFile = "C:\\Users\\gurun\\OneDrive\\Pictures\\download.jpg";
    public static final String editCategoryImageFile = "C:\\Users\\gurun\\OneDrive\\Pictures\\Saved Pictures\\download (1).jpg";
    public static final String searchKeyword = "Desserts";


    public CategoryPage(WebDriver newDriver) {
        driver = newDriver;
    }

    public void verifyThatTheCategoriesIsOpen() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/div[1]/aside[1]/div[1]/nav[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]")).click();
    }

    public void updateClear(By element, String data){
        WebElement dataText = driver.findElement(element);
        dataText.clear();
        dataText.sendKeys(data);
    }

}
