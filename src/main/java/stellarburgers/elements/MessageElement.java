package stellarburgers.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class MessageElement {
    SelenideElement messageElement;

    public MessageElement(String locator){
        messageElement = $(new By.ByXPath(locator));
    }

    public boolean isDisplayed() {
        return messageElement.isDisplayed();
    }

    public String getText(){
        String messageText = messageElement.getText();
        return messageText;
    }
}
