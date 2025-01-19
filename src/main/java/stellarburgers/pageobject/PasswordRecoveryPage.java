package stellarburgers.pageobject;

import stellarburgers.elements.LinkElement;

public class PasswordRecoveryPage {

    private String linkLogin = ".//a[text()='Войти']";

    public PasswordRecoveryPage() {
    }

    public void linkPasswordRecoverClick() {
        LinkElement element = new LinkElement(linkLogin);
        element.click();
    }
}
