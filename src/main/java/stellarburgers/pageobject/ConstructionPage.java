package stellarburgers.pageobject;

import org.openqa.selenium.WebDriver;
import stellarburgers.elements.LinkElement;

public class ConstructionPage {
    WebDriver driver;

    private String bunsLink = "//div[span[text()='Булки']]";
    private String saucesLink = "//div[span[text()='Соусы']]";
    private String fillingsLink = "//div[span[text()='Начинки']]";

    private String currentBunsSection = "//.div[contains(span/text(),'Булки') and contains(@class,'current')]";
    private String currentSaucesSection = "//.div[contains(span/text(),'Соусы') and contains(@class,'current')]";
    private String currentFillingsSection = "//.div[contains(span/text(),'Начинки') and contains(@class,'current')]";

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

    public boolean isBunsSectionActive() {
        LinkElement element = new LinkElement(currentBunsSection);
        bunsLinkClick();
        return element.isDisplayed();
    }

    public boolean isSaucesSectionActive() {
        LinkElement element = new LinkElement(currentSaucesSection);
        saucesLinkClick();
        return element.isDisplayed();
    }

    public boolean isFillingsSectionActive() {
        LinkElement element = new LinkElement(currentFillingsSection);
        fillingsLinkClick();
        return element.isDisplayed();
    }

}
