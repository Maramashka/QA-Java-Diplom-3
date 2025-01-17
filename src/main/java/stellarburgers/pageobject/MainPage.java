package stellarburgers.pageobject;

import org.openqa.selenium.WebDriver;
import stellarburgers.elements.ButtonElement;

import static stellarburgers.pageobject.Constants.MAIN_PAGE;

public class MainPage {
    WebDriver driver;
    MainPage mainPage = new MainPage();

    private String profileButtonLocator = ".//*[text()='Личный Кабинет']";
    private String orderButtonLocator = ".//button[text()='Оформить заказ']";
    private String loginIntoAccountButtonLocator = ".//button[@text()='Войти в аккаунт']";

    public MainPage() {
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage openMainPage() {
        driver.get(MAIN_PAGE);
        return this;
    }

    public void profileButtonClick() {
        ButtonElement element = new ButtonElement(profileButtonLocator);
        element.click();
    }

    public void orderButtonClick() {
        mainPage.openMainPage();
        ButtonElement element = new ButtonElement(orderButtonLocator);
        element.click();
    }

    public void LoginIntoAccountButtonClick() {
        ButtonElement element = new ButtonElement(orderButtonLocator);
        element.click();

    }


}
