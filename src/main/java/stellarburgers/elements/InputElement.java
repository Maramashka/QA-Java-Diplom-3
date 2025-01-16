package stellarburgers.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class InputElement {
    SelenideElement inputElement;


    public InputElement(String locator) {
        inputElement = $(new By.ByXPath(locator));
    }

    public InputElement(SelenideElement selenideElement) {
        inputElement = selenideElement;
    }

    public void clearAndSetValue(String inputValue) {
        inputElement.shouldBe(enabled).clear(); // доступен --> очищаем --> задаём значение
        inputElement.setValue(inputValue);
    }

    public void setValue(String inputValue) { // доступен --> задаём значение, без очищения
        inputElement.shouldBe(enabled)
                .setValue(inputValue);
    }

    public void setValueIfIsEmpty(String value) { // если пустой - задаём значение, если нет - не задаём
        if (inputElement.getValue().isEmpty()) {
            setValue(value);
        }
    }

    public String getValue(String logMessage) {
        String value = inputElement.getValue();
        return value;
    }
}