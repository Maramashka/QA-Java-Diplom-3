package stellarburgers.pageobject;

import io.qameta.allure.Step;
import stellarburgers.elements.LinkElement;


public class ConstructionPage {

    private String linkBuns = ".//span[text()='Булки']";
    private String linkSauces = ".//span[text()='Соусы']";
    private String linkFillings = ".//span[text()='Начинки']";

    private String currentSectionBuns = ".//div[contains(@class, 'current')]/span[text()='Булки']";
    private String currentSectionSauces = ".//div[contains(@class, 'current')]/span[text()='Соусы']";
    private String currentSectionFillings = ".//div[contains(@class, 'current')]/span[text()='Начинки']";

    public ConstructionPage() {
    }

    @Step("Click to link Buns")
    public ConstructionPage clickLinkBuns() {
        LinkElement element = new LinkElement(linkBuns);
        element.click();
        return this;
    }

    @Step("Click to link Sauces")
    public ConstructionPage clickLinkSauces() {
        LinkElement element = new LinkElement(linkSauces);
        element.click();
        return this;
    }

    @Step("Click to link Fillings")
    public ConstructionPage clickLinkFillings() {
        LinkElement element = new LinkElement(linkFillings);
        element.click();
        return this;
    }

    @Step("Is Active section Buns")
    public boolean isActiveSectionBuns() {
        LinkElement element = new LinkElement(currentSectionBuns);
        clickLinkBuns();
        return element.isDisplayed();
    }

    @Step("Is Active section Sauces")
    public boolean isActiveSectionSauces() {
        LinkElement element = new LinkElement(currentSectionSauces);
        clickLinkSauces();
        return element.isDisplayed();
    }

    @Step("Is Active section Fillings")
    public boolean isActiveSectionFillings() {
        LinkElement element = new LinkElement(currentSectionFillings);
        clickLinkFillings();
        return element.isDisplayed();
    }
}
