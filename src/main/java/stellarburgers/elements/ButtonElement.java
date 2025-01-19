package stellarburgers.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class ButtonElement {
    SelenideElement buttonElement;

    public ButtonElement(String locator) {
        buttonElement = $(new By.ByXPath(locator));
    }

    @Step("Button is enabled")
    public boolean isEnabled() {
        return buttonElement.isEnabled();
    }

    @Step("Click button")
    public void click() {
        buttonElement.shouldBe(enabled);
        buttonElement.scrollIntoView(false);
        buttonElement.click();
    }

}
