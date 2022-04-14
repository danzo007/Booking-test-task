package BookingTestTask.login;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;


public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By buttonSignInBy = By.xpath("(//a[@class='bui-button bui-button--secondary js-header-login-link'])[2]");

    @FindBy(xpath = "(//a[@class='bui-button bui-button--secondary js-header-login-link'])[2]")
    private WebElement buttonSignIn;


    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
    public void open(){
        driver.get("https://www.booking.com/");
    }

    public void loaderSignInButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonSignInBy));
    }
    public void checkingSignInIsAvailable(){
        Assert.assertTrue(buttonSignIn.isDisplayed());
    }

    public void clickSignInButton(){
        buttonSignIn.click();
    }




}
