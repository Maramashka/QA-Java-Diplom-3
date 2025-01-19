package stellarburgers.pageobject;

import org.openqa.selenium.WebDriver;
import stellarburgers.elements.LinkElement;

public class ConstructionPage {
    WebDriver driver;

    private String bunsLink = "div[span[text()='Булки']]";
    private String saucesLink = "div[span[text()='Соусы']]";
    private String fillingsLink = "div[span[text()='Начинки']]";


    public ConstructionPage() {
    }

    public ConstructionPage(WebDriver driver) {
        this.driver = driver;
    }

    public ConstructionPage bunsLinkClick() {
        LinkElement element = new LinkElement(bunsLink);
        element.click();
        return this;
    }

    public ConstructionPage saucesLinkClick() {
        LinkElement element = new LinkElement(saucesLink);
        element.click();
        return this;
    }

    public ConstructionPage fillingsLinkClick() {
        LinkElement element = new LinkElement(fillingsLink);
        element.click();
        return this;
    }


}
