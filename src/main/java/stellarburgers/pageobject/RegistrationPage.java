package stellarburgers.pageobject;

import stellarburgers.elements.ButtonElement;
import stellarburgers.elements.InputElement;
import stellarburgers.elements.MessageElement;

public class RegistrationPage {

    private String inputEmail = "//div[label[text()='Email']]/input";
    private String inputPassword = "//input[@type='password']";
    private String inputName = "//div[label[text()='Имя']]/input";
    private String buttonRegister = "//button[text()='Зарегистрироваться']";
    private String incorrectPassword = "//p[text()='Некорректный пароль']";
    private String buttonLogin = "//a[text()='Войти']";

    public RegistrationPage() {
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

    public void registerButtonClick() {
        ButtonElement element = new ButtonElement(buttonRegister);
        element.click();
    }

    public boolean isErrorPasswordTextDisplayed() {
        MessageElement element = new MessageElement(incorrectPassword);
        element.isDisplayed();
        return true;
    }

    public RegistrationPage buttonLoginClick() {
        ButtonElement element = new ButtonElement(buttonLogin);
        element.click();
        return this;
    }
}
