package stellarburgers.pageobject;

import org.openqa.selenium.WebDriver;
import stellarburgers.elements.ButtonElement;

import static stellarburgers.pageobject.Constants.MAIN_PAGE;

public class MainPage {
    WebDriver driver;
    MainPage mainPage;

    private String personalAccountButton = ".//*[text()='Личный Кабинет']";
    private String loginIntoAccountButton = ".//button[text()='Войти в аккаунт']";
    private String setOrderButton = ".//button[text()='Оформить заказ']";
    private String buttonConstruction = "//p[text()='Конструктор']";

    public MainPage() {
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage openMainPage() {
        driver.get(MAIN_PAGE);
        return this;
    }

    public MainPage personalAccountButtonClick() {
        ButtonElement element = new ButtonElement(personalAccountButton);
        element.click();
        return this;
    }

    public MainPage loginIntoAccountButtonClick() {
        ButtonElement element = new ButtonElement(loginIntoAccountButton);
        element.click();
        return this;
    }

    public MainPage setOrderButtonClick() {
        mainPage.openMainPage();
        ButtonElement element = new ButtonElement(setOrderButton);
        element.click();
        return this;
    }

    public MainPage buttonConstructionClick() {
        ButtonElement element = new ButtonElement(buttonConstruction);
        element.click();
        return this;
    }
}
