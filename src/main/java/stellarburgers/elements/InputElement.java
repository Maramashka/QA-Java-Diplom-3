package stellarburgers.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class InputElement {
    SelenideElement inputElement;


    public InputElement(String locator) {
        inputElement = $(new By.ByXPath(locator));
    }

    @Step("Set value input")
    public void setValue(String inputValue) {
        inputElement.shouldBe(enabled)
                .setValue(inputValue);
    }
}