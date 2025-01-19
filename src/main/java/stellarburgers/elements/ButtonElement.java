package stellarburgers.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class ButtonElement {
    SelenideElement buttonElement;

    public ButtonElement(String locator) {
        buttonElement = $(new By.ByXPath(locator));
    }

    public boolean isEnabled() {
        return buttonElement.isEnabled();
    }

    public void click() {
        buttonElement.shouldBe(enabled);
        buttonElement.scrollIntoView(false);
        buttonElement.click();
    }

}
