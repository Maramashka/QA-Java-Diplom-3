package stellarburgers.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class LinkElement {
    SelenideElement linkElement;

    public LinkElement(String locator){
        linkElement = $(new By.ByXPath(locator));
    }

    @Step("Click link")
    public void click(){
        linkElement.scrollIntoView(false);
        linkElement.shouldBe(enabled);
        linkElement.click();
    }

    @Step("Get text link")
    public String getText(){
        linkElement.shouldBe(enabled);
        String linkText = linkElement.getText();
        return linkText;
    }

    @Step("Is displayed link")
    public boolean isDisplayed() {
        return linkElement.isDisplayed();
    }
}
