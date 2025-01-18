package stellarburgers.pageobject;

import org.openqa.selenium.WebDriver;
import stellarburgers.elements.ButtonElement;

public class AccountPage {
    WebDriver driver;

    private String emailLocator = ".//input[text()='Логин']";
    private String passwordLocator = ".//input[text()='Пароль']";
    private String nameLocator = ".//input[text()='Имя']";
    private String saveButtonLocator = ".//button[text()='Сохранить']";


    public AccountPage() {
    }

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void saveButtonClick() {
        ButtonElement saveButton = new ButtonElement(saveButtonLocator);
        saveButton.click();
    }

}
