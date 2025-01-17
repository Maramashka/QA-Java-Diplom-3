package stellarburgers.pageobject;

import org.openqa.selenium.WebDriver;
import stellarburgers.elements.LinkElement;

import java.nio.file.Watchable;

public class EntrancePage {
    WebDriver driver;

    private String inputEmail = ".//input[type()='text']";
    private String inputPassword = ".//input[type()='password']";
    private String buttonEntrance = ".//button[text()='Войти']";
    private String linkRegister = ".//a[text()='Зарегистрироваться']";


    public EntrancePage() {
    }

    public EntrancePage(WebDriver driver) {
        this.driver = driver;
    }

    public void registerLinkClick() {
        LinkElement link = new LinkElement(linkRegister);
        link.clickLink();
    }




}
