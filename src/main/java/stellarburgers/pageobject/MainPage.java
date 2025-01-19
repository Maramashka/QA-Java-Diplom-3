package stellarburgers.pageobject;

import stellarburgers.elements.ButtonElement;

public class MainPage {

    private String personalAccountButton = ".//*[text()='Личный Кабинет']";
    private String loginIntoAccountButton = ".//button[text()='Войти в аккаунт']";
    private String setOrderButton = ".//button[text()='Оформить заказ']";
    private String buttonConstruction = "//p[text()='Конструктор']";

    public MainPage() {
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

    public boolean isOrderButtonEnabled() {
        ButtonElement element = new ButtonElement(setOrderButton);
        return element.isEnabled();
    }

    public MainPage buttonConstructionClick() {
        ButtonElement element = new ButtonElement(buttonConstruction);
        element.click();
        return this;
    }
}
