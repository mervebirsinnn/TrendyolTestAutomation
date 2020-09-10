package resources.PO;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    //LoginPage includes basepage methods which are commonly used in test scenarios

    BasePage basepage = new BasePage(driver,wait);

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public static String loginPageUrl = "https://www.trendyol.com/";
    public static String firstLoginButtonXpath = "//html[@id='ng-app']//div[@id='accountNavigationRoot']//ul[@class='user-navigation']//i[@class='icon navigation-icon-user']";
    public static String nameBoxXpath = "//html[@id='ng-app']//input[@id='email']";
    public static String passwordBoxXpath = "//html[@id='ng-app']//input[@id='password']";
    public static String loginButtonId = "loginSubmit";
    public static String popupCloseButtonClass = "fancybox-item";
    private static String popupXpath ="//div[@class='homepage-popup']";
    private static String loginPopupXpath ="//*[@id=\"commonPopupRoot\"]/div/div[1]";
    private static String loginId ="accountBtn";


    public void goTo() {
        driver.get(loginPageUrl);
    } //gets loginpage url and opens it

    public void verifyPageLoaded(){ basepage.VerifyFullyLoaded2(driver); } //check page loaded

    public void popupwait(){ waitUntilPageContainElements(popupXpath); } //waits to close gender selection popup

    //public void clickLogin1 (){ click(By.id(firstLoginButtonXpath)); } //clicks giriş yap button
    public void clickLogin1 (){ click(By.id(loginId)); } //clicks giriş yap button

    public void sendKeys(){ //send keys login popup
        basepage.writeText(By.id("email"),"mervebr34@outlook.com");
        basepage.writeText(By.id("password"),"MERVE123.");
    }

    public void clickLogin2(){
        click(By.id(loginButtonId));
    } // clicks giriş yap button located on login popup

    public void closePopup(){
        click(By.className(popupCloseButtonClass));
    }//closes gender selection popup



    public void loginPopupWait(){ waitUntilPageContainElements(loginPopupXpath); }//waits until login popup element occurs on the page

}
