package stellarburgers.pageobject;

import org.openqa.selenium.WebDriver;
import stellarburgers.elements.ButtonElement;

import static stellarburgers.pageobject.Constants.MAIN_PAGE;

public class MainPage {
    WebDriver driver;
    MainPage mainPage;

    private String accountButton = ".//*[text()='Личный Кабинет']";
    private String loginIntoAccountButton = ".//button[@text()='Войти в аккаунт']";
    private String setOrderButton = ".//button[text()='Оформить заказ']";

    public MainPage() {
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage openMainPage() {
        driver.get(MAIN_PAGE);
        return this;
    }

    public void accountButtonClick() {
        ButtonElement element = new ButtonElement(accountButton);
        element.click();
    }

    public void LoginIntoAccountButtonClick() {
        ButtonElement element = new ButtonElement(loginIntoAccountButton);
        element.click();
    }

    public void setOrderButtonClick() {
        mainPage.openMainPage();
        ButtonElement element = new ButtonElement(setOrderButton);
        element.click();
    }


}
