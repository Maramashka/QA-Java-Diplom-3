package stellarburgers.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class ButtonElement {
    SelenideElement buttonElement;

    // В элемент в конструкторе передаём локатор и внутри конструктора мы по этому локатору делаем ByXPath
    // в данном случае мы элемент можем искать только по XPath
    public ButtonElement(String locator) {
        buttonElement = $(new By.ByXPath(locator));
    }

    // а можем вместо локатора передать By
    // или Сss, или name, или class - конструктор можно написать для чего угодно
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


    public void click() {
        buttonElement.shouldBe(enabled);
        buttonElement.scrollIntoView(false);
        buttonElement.click();
    }

    public void scrollAndClickButton() {
        buttonElement.shouldBe(enabled);
        buttonElement.scrollIntoView(true);
        buttonElement.click();
    }

    public boolean isEnabledButton() {
        return buttonElement.isEnabled();
    }
}
