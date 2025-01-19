package stellarburgers.pageobject;

import io.qameta.allure.Step;
import stellarburgers.elements.ButtonElement;
import stellarburgers.elements.LinkElement;

public class MainPage {

    private String logo = ".//div[@class='AppHeader_header__logo__2D0X2']/a[@href='/']";
    private String buttonPersonalAccount = ".//*[text()='Личный Кабинет']";
    private String buttonLoginIntoAccount = ".//button[text()='Войти в аккаунт']";
    private String buttonSetOrder = ".//button[text()='Оформить заказ']";
    private String buttonConstruction = "//p[text()='Конструктор']";

    public MainPage() {
    }

    @Step("Click button Personal Account")
    public MainPage clickButtonPersonalAccount() {
        ButtonElement element = new ButtonElement(buttonPersonalAccount);
        element.click();
        return this;
    }

    @Step("Click button Login Into Account")
    public MainPage clickButtonLoginIntoAccount() {
        ButtonElement element = new ButtonElement(buttonLoginIntoAccount);
        element.click();
        return this;
    }

    @Step("Is enabled button Order")
    public boolean isEnabledButtonOrder() {
        ButtonElement element = new ButtonElement(buttonSetOrder);
        return element.isEnabled();
    }

    @Step("Click button Construction")
    public MainPage clickButtonConstruction() {
        ButtonElement element = new ButtonElement(buttonConstruction);
        element.click();
        return this;
    }

    @Step("Click Logo")
    public MainPage clickLogo() {
        LinkElement element = new LinkElement(logo);
        element.click();
        return this;
    }
}
