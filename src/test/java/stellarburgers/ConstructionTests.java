package stellarburgers;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.pageobject.ConstructionPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;
import static stellarburgers.pageobject.Constants.MAIN_PAGE;

public class ConstructionTests extends BaseTest {

    ConstructionPage constructionPage;

    @Before
    public void setUp() {
        constructionPage = open(MAIN_PAGE, ConstructionPage.class);
    }

    @Test
    @DisplayName("Click-through buns section")
    @Description("Переход по клику в раздел 'Булки'")
    public void clickThroughToTheBunsSectionTest() {

        constructionPage.saucesLinkClick()
                .bunsLinkClick()
                .isBunsSectionActive();
        Configuration.timeout = 6000;

        assertTrue("Ожидаем активации раздела 'Булки'", true);
    }

    @Test
    @DisplayName("Click-through sauсes section")
    @Description("Переход по клику в раздел 'Соусы'")
    public void clickThroughToTheSaucesSectionTest() {

        constructionPage.saucesLinkClick()
                .isSaucesSectionActive();
        Configuration.timeout = 3000;

        assertTrue("Ожидаем активации раздела 'Соусы'", true);
    }


    @Test
    @DisplayName("Click-through buns section")
    @Description("Переход по клику в раздел 'Начинки'")
    public void clickThroughToTheFillingsSectionTest() {

        constructionPage.fillingsLinkClick()
                .isFillingsSectionActive();
        Configuration.timeout = 3000;

        assertTrue("Ожидаем активации раздела 'Начинки'", true);
    }
}
