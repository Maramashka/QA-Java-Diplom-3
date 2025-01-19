package stellarburgers.pageobject;

import io.qameta.allure.Step;
import stellarburgers.elements.ButtonElement;

public class AccountPage {

    private String buttonExit = ".//button[text()='Выход']";

    public AccountPage() {
    }

    @Step("Click to button Exit")
    public void clickButtonExit() {
        ButtonElement element = new ButtonElement(buttonExit);
        element.click();
    }
}
