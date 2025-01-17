package stellarburgers.pageobject;

import org.openqa.selenium.WebDriver;
import stellarburgers.elements.ButtonElement;
import stellarburgers.elements.InputElement;

public class RegistrationPage {
    WebDriver driver;

    private String inputEmailLocator = "//input[@class='text input__textfield text_type_main-default'][1]";
    private String inputPasswordLocator = ".//input[@type='password']";
    private String inputNameLocator = "//input[@class='text input__textfield text_type_main-default'][1]";
    private String buttonRegisterLocator = ".//button[text()='Зарегистрироваться']";

    public RegistrationPage() {
    }

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }


    public void setEmailValue(String email) {
        InputElement element = new InputElement(inputEmailLocator);
        element.setValue(email);
    }

    public void setPasswordValue(String password) {
        InputElement element = new InputElement(inputPasswordLocator);
        element.setValue(password);
    }

    public void setNameValue(String name) {
        InputElement element = new InputElement(inputNameLocator);
        element.setValue(name);
    }

    public void registerButtonClick() {
        ButtonElement element = new ButtonElement(buttonRegisterLocator);
        element.click();
    }





}
