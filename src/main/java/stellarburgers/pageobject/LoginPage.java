package stellarburgers.pageobject;

import org.openqa.selenium.WebDriver;
import stellarburgers.elements.ButtonElement;
import stellarburgers.elements.InputElement;
import stellarburgers.elements.LinkElement;

public class LoginPage {
    WebDriver driver;

    private String inputEmail = ".//input[@name='name']";
    private String inputPassword = ".//input[@name='Пароль']";
    private String buttonLogin = ".//button[text()='Войти']";
    private String linkRegister = ".//a[text()='Зарегистрироваться']";
    private String linkPasswordRecover = ".//a[text()='Восстановить пароль']";


    public LoginPage() {
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage registerLinkClick() {
        LinkElement link = new LinkElement(linkRegister);
        link.click();
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

    public LoginPage linkPasswordRecoverClick() {
        LinkElement element = new LinkElement(linkPasswordRecover);
        element.click();
        return this;
    }

}
