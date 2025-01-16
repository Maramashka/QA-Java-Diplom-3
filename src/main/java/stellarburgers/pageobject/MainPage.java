package stellarburgers.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import stellarburgers.elements.ButtonElement;

import static stellarburgers.pageobject.Constants.MAIN_PAGE;

public class MainPage {
    WebDriver driver;

    private String profileButtonLocator = ".//*[text()='Личный Кабинет']";
    private String orderButtonLocator = ".//button[text(), 'Оформить заказ']";

    public MainPage() {
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage openMainPage() {
        driver.get(MAIN_PAGE);
        return this;
    }

    public void accountButtonClick() {
        ButtonElement profileButton = new ButtonElement(profileButtonLocator);
        profileButton.click();
    }

    public void orderButtonClick() {
        MainPage mainPage = new MainPage();
        mainPage.openMainPage();
        ButtonElement orderButton = new ButtonElement(orderButtonLocator);
        orderButton.click();
    }



}
