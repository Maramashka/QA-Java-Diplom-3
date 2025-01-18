package stellarburgers.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class ButtonElement {
    SelenideElement buttonElement;

    public ButtonElement(String locator) {
        buttonElement = $(new By.ByXPath(locator));

    }
    public ButtonElement(By locator) {
        buttonElement = $(locator);
    }

    // а в этом конструкторе передаём готовый SelenideElement
    // у нас помимо buttonElement ещё могут быть ButtonElementCollection
    // т.е. иногда по одному локатору у нас м. находиться несколько кнопок (инпутов)
    // и внутри у нас метод - найди видимую кнопку и по ней кликнуть - тогда используем коллекцию
    public ButtonElement(SelenideElement selenideElement) {
        buttonElement = selenideElement;
    }

    public ButtonElement(WebElement element) {
        buttonElement = (SelenideElement) element;
    }

    public boolean isEnabled() {
        return buttonElement.isEnabled();
    }

    public void click() {
        buttonElement.shouldBe(enabled);
        buttonElement.scrollIntoView(false);
        buttonElement.click();
    }

    public void scrollAndClick() {
        buttonElement.shouldBe(enabled);
        buttonElement.scrollIntoView(true);
        buttonElement.click();
    }


}
