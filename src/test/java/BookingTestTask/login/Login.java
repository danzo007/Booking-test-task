package BookingTestTask.login;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    private WebDriver driver;
    private WebDriverWait wait;

    public Login(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
    @FindBy (xpath = "//input[@name='username']")
    private WebElement inputUsernameBy;

    @FindBy (xpath = "//input[@name='password']")
    private WebElement inputPasswordBy;

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement buttonSubmitBy;

    @FindBy (xpath = "//span[@id='profile-menu-trigger--title']")
    private WebElement userNameCheckBy;

    @FindBy (xpath = "//div[@id='username-note']")
    private WebElement usernameFailMessageBy;

    @FindBy (xpath = "//div[@id='password-note']")
    private WebElement passwordFailMessageBy;

    private By inputUsername = By.xpath("//input[@name='username']");
    private By inputPassword = By.xpath("//input[@name='password']");
    private By buttonSubmit = By.xpath("//button[@type='submit']");

    private By userNameCheck = By.xpath("//span[@id='profile-menu-trigger--title']");

    private By usernameFailMessage = By.xpath("//div[@id='username-note']");

    private By passwordFailMessage = By.xpath("//div[@id='password-note']");

    public void waitingElementsForUsername(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputUsername));
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonSubmit));
    }

    public void waitingElementsForPassword(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonSubmit));
    }

    public void fillUsername(String username){
        inputUsernameBy.sendKeys(username);
    }

    public void fillPassword(String password){
        inputPasswordBy.sendKeys(password);

    }

    public void buttonSubmitClick(){
        buttonSubmitBy.click();
    }

    public void checkingSuccessLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameCheck));
        Assert.assertTrue(userNameCheckBy.getText().equals("Test West"));
    }

    public void checkUsernameFailMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFailMessage));
        Assert.assertTrue(usernameFailMessageBy.getText().equals("Please check if the email address you've entered is correct."));
    }

    public void checkPasswordFailMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFailMessage));
        Assert.assertTrue(passwordFailMessageBy.getText().equals("The email and password combination you entered doesn't match"));
    }
}