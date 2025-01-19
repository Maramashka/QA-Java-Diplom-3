package stellarburgers.pageobject;

import io.qameta.allure.Step;
import stellarburgers.elements.ButtonElement;
import stellarburgers.elements.InputElement;
import stellarburgers.elements.LinkElement;

public class LoginPage {

    private String inputEmail = ".//input[@name='name']";
    private String inputPassword = ".//input[@name='Пароль']";
    private String buttonLogin = ".//button[text()='Войти']";
    private String linkRegister = ".//a[text()='Зарегистрироваться']";
    private String linkPasswordRecover = ".//a[text()='Восстановить пароль']";


    public LoginPage() {
    }

    @Step("Click link Register")
    public LoginPage clickLinkRegister() {
        LinkElement element = new LinkElement(linkRegister);
        element.click();
        return this;
    }

    @Step("Set Email")
    public LoginPage setEmail(String email) {
        InputElement element = new InputElement(inputEmail);
        element.setValue(email);
        return this;
    }

    @Step("Set Password")
    public LoginPage setPassword(String password) {
        InputElement element = new InputElement(inputPassword);
        element.setValue(password);
        return this;
    }

    @Step("Click button Login")
    public LoginPage clickButtonLogin() {
        ButtonElement element = new ButtonElement(buttonLogin);
        element.click();
        return this;
    }

    @Step("Click link Password Recover")
    public void clickLinkPasswordRecover() {
        LinkElement element = new LinkElement(linkPasswordRecover);
        element.click();
    }
}
