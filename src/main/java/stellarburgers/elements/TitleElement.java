package stellarburgers.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TitleElement {
    SelenideElement titleElement;

    public TitleElement(String locator){
        titleElement = $(new By.ByXPath(locator));
    }

    @Step("Is displayed title")
    public boolean isDisplayed() {
        return titleElement.isDisplayed();
    }

    @Step("Is displayed title")
    public String getText(){
        String text = titleElement.getText();
        return text;
    }
}
