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

    public void registerLinkClick() {
        LinkElement link = new LinkElement(linkRegister);
        link.click();
    }

    public void setEmail(String email) {
        InputElement element = new InputElement(inputEmail);
        element.setValue(email);
    }

    public void setPassword(String password) {
        InputElement element = new InputElement(inputPassword);
        element.setValue(password);
    }

    public void buttonLoginClick() {
        ButtonElement element = new ButtonElement(buttonLogin);
        element.click();
    }

    public void linkPasswordRecoverClick() {
        LinkElement element = new LinkElement(linkPasswordRecover);
        element.click();
    }

}
