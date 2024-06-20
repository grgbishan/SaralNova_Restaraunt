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

public class ExtraFunctionsPage {
    public static WebDriver driver;
    public By popUp = By.xpath("");


    public ExtraFunctionsPage(WebDriver newDriver) {driver = newDriver;}

    public void checkDropDownFunctionality(By element){
        WebElement dropdown = driver.findElement(element);
        Select dropdownSelect = new Select(dropdown);
        List<WebElement> options = dropdownSelect.getOptions();
        List<String> optionsList = new ArrayList<>();
        for(WebElement option : options){
            optionsList.add(option.getText());
        }
        List<String> expectedOptions = getExpectedDropDown(element);
        boolean allOptionsPresent = optionsList.containsAll(expectedOptions);
        if (allOptionsPresent) {
            System.out.println("All expected options are present in the dropdown.");
        } else {
            System.out.println("Some expected options are missing in the dropdown.");
        }
    }

    private static List<String> getExpectedDropDown(By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement expectedOptionsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        List<WebElement> options = expectedOptionsElement.findElements(element);
        List<String> expectedOptions = new ArrayList<>();
        for(WebElement option : options){
            expectedOptions.add(option.getText());
        }
        return expectedOptions;
    }

}
