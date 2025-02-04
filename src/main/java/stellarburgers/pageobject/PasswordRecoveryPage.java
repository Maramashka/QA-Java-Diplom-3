package stellarburgers.pageobject;

import io.qameta.allure.Step;
import stellarburgers.elements.LinkElement;

public class PasswordRecoveryPage {

    private String linkLogin = ".//a[text()='Войти']";

    public PasswordRecoveryPage() {
    }

    @Step("Click link Password Recover")
    public void clickLinkPasswordRecover() {
        LinkElement element = new LinkElement(linkLogin);
        element.click();
    }
}
