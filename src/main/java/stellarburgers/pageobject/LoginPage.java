package stellarburgers.pageobject;

import org.openqa.selenium.WebDriver;
import stellarburgers.elements.ButtonElement;
import stellarburgers.elements.InputElement;
import stellarburgers.elements.LinkElement;

public class LoginPage {
    WebDriver driver;

    private String inputEmail = ".//input[type()='text']";
    private String inputPassword = ".//input[type()='password']";
    private String buttonEntrance = ".//button[text()='Войти']";
    private String linkRegister = ".//a[text()='Зарегистрироваться']";


    public LoginPage() {
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registerLinkClick() {
        LinkElement link = new LinkElement(linkRegister);
        link.clickLink();
    }

    public void setEmail(String email) {
        InputElement element = new InputElement(inputEmail);
        element.setValue(email);
    }

    public void setPassword(String password) {
        InputElement element = new InputElement(inputPassword);
        element.setValue(password);
    }

    public void buttonEntranceClick() {
        ButtonElement element = new ButtonElement(buttonEntrance);
        element.click();
    }

}
