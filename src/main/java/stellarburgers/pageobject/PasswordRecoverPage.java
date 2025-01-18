package stellarburgers.pageobject;

import org.openqa.selenium.WebDriver;
import stellarburgers.elements.LinkElement;

public class PasswordRecoverPage {
    WebDriver driver;

    private String linkLogin = ".//a[text()='Войти']";

    public PasswordRecoverPage() {
    }

    public void linkPasswordRecoverClick() {
        LinkElement element = new LinkElement(linkLogin);
        element.click();
    }
}
