package stellarburgers.pageobject;

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

    public LoginPage registerLinkClick() {
        LinkElement element = new LinkElement(linkRegister);
        element.click();
        return this;
    }

    public LoginPage setEmail(String email) {
        InputElement element = new InputElement(inputEmail);
        element.setValue(email);
        return this;
    }

    public LoginPage setPassword(String password) {
        InputElement element = new InputElement(inputPassword);
        element.setValue(password);
        return this;
    }

    public LoginPage buttonLoginClick() {
        ButtonElement element = new ButtonElement(buttonLogin);
        element.click();
        return this;
    }

    public void linkPasswordRecoverClick() {
        LinkElement element = new LinkElement(linkPasswordRecover);
        element.click();
    }

}
