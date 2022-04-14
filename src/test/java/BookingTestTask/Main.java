package BookingTestTask;

import BookingTestTask.article.Attraction;
import BookingTestTask.article.AttractionsPage;
import BookingTestTask.login.Login;
import BookingTestTask.login.LoginPage;
import org.junit.*;
import org.openqa.selenium.support.PageFactory;
import BookingTestTask.WebDriverSettings;
import io.github.cdimascio.dotenv.Dotenv;


public class Main extends WebDriverSettings {

    @Test
    public void login(){

        //load Dotenv
        Dotenv dotenv = Dotenv.load();

        //create LoginPage element via PageFactory
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        //open booking.com
        loginPage.open();
        //wait until Sign in Button will be visible
        loginPage.loaderSignInButton();
        //check is Sign in button is available
        loginPage.checkingSignInIsAvailable();
        // click on Sign in button
        loginPage.clickSignInButton();

        Login login = PageFactory.initElements(driver, Login.class);
        //wait for username input and button
        login.waitingElementsForUsername();
        //fill username input with data form dot env file
        login.fillUsername(dotenv.get("USERNAME"));
        //click submit button
        login.buttonSubmitClick();
        //wait for input password and submit button
        login.waitingElementsForPassword();
        //fill password with data from dot env file
        login.fillPassword(dotenv.get("PASSWORD"));
        //click on submit button
        login.buttonSubmitClick();
        //checking if username is correct
        login.checkingSuccessLogin();

    }
    @Test
    public void loginNegativeMail(){
        Dotenv dotenv = Dotenv.load();


        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
        loginPage.loaderSignInButton();
        loginPage.checkingSignInIsAvailable();
        loginPage.clickSignInButton();

        Login login = PageFactory.initElements(driver, Login.class);
        login.waitingElementsForUsername();
        login.fillUsername(dotenv.get("USERNAMENEGATIVE"));
        login.buttonSubmitClick();
        //checking username fail text message
        login.checkUsernameFailMessage();
    }

    @Test
    public void loginNegativePassword(){
        Dotenv dotenv = Dotenv.load();


        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
        loginPage.loaderSignInButton();
        loginPage.checkingSignInIsAvailable();
        loginPage.clickSignInButton();

        Login login = PageFactory.initElements(driver, Login.class);
        login.waitingElementsForUsername();
        login.fillUsername(dotenv.get("USERNAME"));
        login.buttonSubmitClick();
        login.waitingElementsForPassword();
        login.fillPassword(dotenv.get("PASSWORDNEGATIVE"));
        login.buttonSubmitClick();
        //checking password file text message
        login.checkPasswordFailMessage();
    }

    @Test
    public void article(){
        AttractionsPage attractionsPage = PageFactory.initElements(driver, AttractionsPage.class);

        attractionsPage.open();
        attractionsPage.loader();
        attractionsPage.checkingAttractionsButtonISAvailable();
        attractionsPage.clickAttractionsButton();

        Attraction attraction = PageFactory.initElements(driver, Attraction.class);
        //wait for Search input and button
        attraction.waitingSearchElements();
        //typing travel in search input
        attraction.search("travel");
        //click on search button
        attraction.clickSearchButton();
        //waining fot museums checkbox
        attraction.waitingMuseumsCheckboxElements();
        //click on museums checkbox
        attraction.clickMuseumsCheckboxButton();
        //wait for card
        attraction.waitingCardElement();
        // copy first article title form search page than click on first article than compare to title on article page
        attraction.checkingSuccessArticle();
    }

}
