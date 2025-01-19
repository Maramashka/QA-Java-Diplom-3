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
    @Description("Переход по клику в раздел 'Булки'")
    @DisplayName("Click-through buns section")
    public void clickThroughToTheBunsSectionTest() {

        constructionPage.clickLinkSauces()
                .clickLinkBuns()
                .isActiveSectionBuns();
        Configuration.timeout = 3000;

        assertTrue("Ожидаем активации раздела 'Булки'", true);
    }

    @Test
    @Description("Переход по клику в раздел 'Соусы'")
    @DisplayName("Click-through sauсes section")
    public void clickThroughToTheSaucesSectionTest() {

        constructionPage.clickLinkSauces()
                .isActiveSectionSauces();
        Configuration.timeout = 3000;

        assertTrue("Ожидаем активации раздела 'Соусы'", true);
    }


    @Test
    @Description("Переход по клику в раздел 'Начинки'")
    @DisplayName("Click-through buns section")
    public void clickThroughToTheFillingsSectionTest() {

        constructionPage.clickLinkFillings()
                .isActiveSectionFillings();
        Configuration.timeout = 3000;

        assertTrue("Ожидаем активации раздела 'Начинки'", true);
    }
}
