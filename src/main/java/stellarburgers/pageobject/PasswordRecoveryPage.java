package stellarburgers.pageobject;

import org.openqa.selenium.WebDriver;
import stellarburgers.elements.LinkElement;

public class PasswordRecoveryPage {
    WebDriver driver;

    private String linkLogin = ".//a[text()='Войти']";

    public PasswordRecoveryPage() {
    }

    public void linkPasswordRecoverClick() {
        LinkElement element = new LinkElement(linkLogin);
        element.click();
    }
}
