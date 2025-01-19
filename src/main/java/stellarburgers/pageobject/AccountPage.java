package stellarburgers.pageobject;

import stellarburgers.elements.ButtonElement;

public class AccountPage {

    private String emailLocator = ".//input[text()='Логин']";
    private String passwordLocator = ".//input[text()='Пароль']";
    private String nameLocator = ".//input[text()='Имя']";
    private String saveButtonLocator = ".//button[text()='Сохранить']";
    private String exitButton = ".//button[text()='Выход']";

    public AccountPage() {
    }

    public void exitButtonClick() {
        ButtonElement element = new ButtonElement(exitButton);
        element.click();
    }
}
