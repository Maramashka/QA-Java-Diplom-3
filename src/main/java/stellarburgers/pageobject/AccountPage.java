package stellarburgers.pageobject;

import org.openqa.selenium.WebDriver;
import stellarburgers.elements.ButtonElement;

public class AccountPage {
    WebDriver driver;

    private String emailLocator = ".//input[text()='Логин']";
    private String passwordLocator = ".//input[text()='Пароль']";
    private String nameLocator = ".//input[text()='Имя']";
    private String saveButtonLocator = ".//button[text()='Сохранить']";
    private String exitButton = ".//button[contains(@type,'button') and text()='Выход']";


    public AccountPage() {
    }

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void saveButtonClick() {
        ButtonElement element = new ButtonElement(saveButtonLocator);
        element.click();
    }


    public void exitButtonClick() {
        ButtonElement element = new ButtonElement(exitButton);
        element.click();
    }


}
