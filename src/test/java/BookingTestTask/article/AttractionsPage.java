package BookingTestTask.article;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AttractionsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By buttonAttractionsBy = By.xpath("(//a[@class='bui-tab__link'])[3]");
    @FindBy(xpath = "(//a[@class='bui-tab__link'])[3]")
    private WebElement buttonAttractions;

    public AttractionsPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
    public void open(){
        driver.get("https://www.booking.com/");
    }

    public void loader(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonAttractionsBy));
    }
    public void checkingAttractionsButtonISAvailable(){
        Assert.assertTrue(buttonAttractions.isDisplayed());
    }
    public void clickAttractionsButton(){
        buttonAttractions.click();
    }

}
