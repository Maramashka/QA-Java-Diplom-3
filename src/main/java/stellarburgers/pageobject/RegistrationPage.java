package stellarburgers.pageobject;

import org.openqa.selenium.WebDriver;
import stellarburgers.elements.ButtonElement;
import stellarburgers.elements.InputElement;
import stellarburgers.elements.MessageElement;

public class RegistrationPage {
    WebDriver driver;

    private String inputEmail = "//input[@class='text input__textfield text_type_main-default'][1]";
    private String inputPassword = ".//input[@type='password']";
    private String inputName = "//input[@class='text input__textfield text_type_main-default'][1]";
    private String buttonRegister = ".//button[text()='Зарегистрироваться']";
    private String incorrectPassword = "//p[text()='Некорректный пароль']";
    private String buttonLogin = "//a[text()='Войти']";

    public RegistrationPage() {
    }

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }


    public RegistrationPage setEmailValue(String email) {
        InputElement element = new InputElement(inputEmail);
        element.setValue(email);
        return this;
    }

    public RegistrationPage setPasswordValue(String password) {
        InputElement element = new InputElement(inputPassword);
        element.setValue(password);
        return this;
    }

    public RegistrationPage setNameValue(String name) {
        InputElement element = new InputElement(inputName);
        element.setValue(name);
        return this;
    }

    public RegistrationPage registerButtonClick() {
        ButtonElement element = new ButtonElement(buttonRegister);
        element.click();
        return this;
    }

    public boolean isErrorPasswordTextDisplayed() {
        MessageElement element = new MessageElement(incorrectPassword);
        element.isDisplayed();
        return true;
    }

    public String getErrorPasswordText() {
        MessageElement element = new MessageElement(incorrectPassword);
        element.isDisplayed();
        return element.getText();
    }

    public RegistrationPage buttonLoginClick() {
        ButtonElement element = new ButtonElement(buttonLogin);
        element.click();
        return this;
    }
}
