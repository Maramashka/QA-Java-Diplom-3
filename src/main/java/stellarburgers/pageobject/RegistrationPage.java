package stellarburgers.pageobject;

import io.qameta.allure.Step;
import stellarburgers.elements.ButtonElement;
import stellarburgers.elements.InputElement;
import stellarburgers.elements.TitleElement;

public class RegistrationPage {

    private String inputEmail = "//div[label[text()='Email']]/input";
    private String inputPassword = "//input[@type='password']";
    private String inputName = "//div[label[text()='Имя']]/input";
    private String buttonRegister = "//button[text()='Зарегистрироваться']";
    private String titleIncorrectPassword = "//p[text()='Некорректный пароль']";
    private String buttonLogin = "//a[text()='Войти']";

    public RegistrationPage() {
    }

    @Step("Set value Email")
    public RegistrationPage setValueEmail(String email) {
        InputElement element = new InputElement(inputEmail);
        element.setValue(email);
        return this;
    }

    @Step("Set value Password")
    public RegistrationPage setValuePassword(String password) {
        InputElement element = new InputElement(inputPassword);
        element.setValue(password);
        return this;
    }

    @Step("Set value Name")
    public RegistrationPage setValueName(String name) {
        InputElement element = new InputElement(inputName);
        element.setValue(name);
        return this;
    }

    @Step("Click button Register")
    public void clickButtonRegister() {
        ButtonElement element = new ButtonElement(buttonRegister);
        element.click();
    }

    @Step("Is displayed title Password Error")
    public boolean isDisplayedTitlePasswordError() {
        TitleElement element = new TitleElement(titleIncorrectPassword);
        element.isDisplayed();
        return true;
    }

    @Step("Click button Login")
    public RegistrationPage clickButtonLogin() {
        ButtonElement element = new ButtonElement(buttonLogin);
        element.click();
        return this;
    }
}
