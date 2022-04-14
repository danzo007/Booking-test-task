package BookingTestTask.article;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Attraction {
    private WebDriver driver;
    private WebDriverWait wait;

    public Attraction(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//input[@type='search']")
    private WebElement inputSearchBy;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSearchBy;

    @FindBy(xpath = "//span[text()='Museums']")
    private WebElement checkBoxMuseumsBy;

    @FindBy(xpath = "//a[@data-testid='card']/div[2]/div/div/div/h4")
    private WebElement firsCardElementBy;

    @FindBy(xpath = "//h2")
    private WebElement h2TitleNameBy;



    private By inputSearch = By.xpath("//input[@type='search']");
    private By buttonSearch = By.xpath("//button[@type='submit']");

    private By checkBoxMuseums = By.xpath("//span[text()='Museums']");
    private By cardElement = By.xpath("//a[@data-testid='card']");
    private By h2TitleName = By.xpath("//h2");
    private By aSearchBar = By.xpath("//a[@data-testid='search-bar-result']");




    public void waitingSearchElements(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputSearch));
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonSearch));
    }

    public void search(String search){
        inputSearchBy.sendKeys(search);
    }
    public void clickSearchButton(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(aSearchBar));
        buttonSearchBy.click();
    }
    public void waitingMuseumsCheckboxElements(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxMuseums));
    }
    public void clickMuseumsCheckboxButton(){
        checkBoxMuseumsBy.click();
    }
    public void waitingCardElement(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardElement));
    }
    public void checkingSuccessArticle(){
        String cardTitle = firsCardElementBy.getText();
        firsCardElementBy.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(h2TitleName));
        Assert.assertTrue(h2TitleNameBy.getText().equals(cardTitle));
    }

}
