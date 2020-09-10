import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.PO.*;

public class MainTest extends BaseTest{

    private LoginPage loginPage;
    private MainPage mainPage;
    private AddBasket addBasket;
    private DeleteBasket deleteBasket;

    @BeforeMethod
    public void initialize(){

        loginPage = new LoginPage(driver,wait);
        mainPage = new MainPage(driver,wait);
        addBasket = new AddBasket(driver,wait);
        deleteBasket = new DeleteBasket(driver,wait);

    }

    @Test(priority = 0)
    public void GoToTrendyol() throws InterruptedException {

    loginPage.goTo();
    loginPage.verifyPageLoaded();
    loginPage.popupwait();

    loginPage.closePopup();
    Thread.sleep(5000);

    }

    @Test(priority = 1)
    public void LoginTrendyol(){

        loginPage.clickLogin1();
        loginPage.loginPopupWait();
        loginPage.sendKeys();
        loginPage.clickLogin2();

    }

    @Test(priority = 2)
    public void ProductControl() throws InterruptedException {
        mainPage.popupbekle();
        mainPage.closePopup();
        mainPage.searchKeyButton();
        mainPage.randomProduct();

    }

    @Test(priority = 3)
    public void AddingBasket() throws InterruptedException {

        addBasket.AddProductBasket();
        //addBasket.GoToBasket();

    }

    @Test(priority = 4)
    public void DeleteBasket() throws InterruptedException {
        deleteBasket.DeletingBasket();
        Thread.sleep(5000);
    }



}
