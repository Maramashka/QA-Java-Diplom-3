package stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.client.UserClient;
import stellarburgers.pageobject.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.Assert.assertEquals;
import static stellarburgers.generators.UserGenerator.randomUser;
import static stellarburgers.pageobject.Constants.LOGIN_PAGE;
import static stellarburgers.pageobject.Constants.MAIN_PAGE;

public class ConstructionTests extends BaseTest {

    ConstructionPage constructionPage;

    @Before
    public void setUp() {
        constructionPage = open(MAIN_PAGE, ConstructionPage.class);
    }

    @Test
    @DisplayName("Click-Through Personal Account Button Without Authorization Test")
    @Description("Переход по клику в раздел 'Соусы'")
    public void ClickThroughToTheSaucesSectionTest() {

        constructionPage.saucesLinkClick();

        String actualUrl = webdriver().driver().url();

        assertEquals("Ожидаем перехода на страницу входа в аккаунт", LOGIN_PAGE, actualUrl);
    }
}
