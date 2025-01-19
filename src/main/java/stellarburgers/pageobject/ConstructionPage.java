package stellarburgers.pageobject;

import stellarburgers.elements.LinkElement;


public class ConstructionPage {

    private String bunsLink = ".//span[text()='Булки']";
    private String saucesLink = ".//span[text()='Соусы']";
    private String fillingsLink = ".//span[text()='Начинки']";

    private String currentBunsSection = ".//div[contains(@class, 'current')]/span[text()='Булки']";
    private String currentSaucesSection = ".//div[contains(@class, 'current')]/span[text()='Соусы']";
    private String currentFillingsSection = ".//div[contains(@class, 'current')]/span[text()='Начинки']";

    public ConstructionPage() {
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
