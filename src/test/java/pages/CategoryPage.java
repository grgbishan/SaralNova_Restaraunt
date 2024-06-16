package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryPage {
    public WebDriver driver;

    public static By categoryBtn = By.xpath("//button[contains(text(),'Add Category')]");
    public static By addCategoryImage = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/input[1]");
    public static By addCategoryText = By.xpath("//p[@id='categoryModalLabel']");
    public static By addCategoryTitle = By.cssSelector("#title");
    public static By addCategorySubmitBtn = By.xpath("//button[contains(text(),'Submit')]");
    public static By categoryToast = By.xpath("//body/jam-relay[1]");

    public static final String addCategoryTitleText = "Burger/Sandwich";
    public static final String categoryImageFile = "C:\\Users\\gurun\\OneDrive\\Pictures\\download.jpg";


    public CategoryPage(WebDriver newDriver) {
        driver = newDriver;
    }


}
