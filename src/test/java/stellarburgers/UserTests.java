package stellarburgers;

import org.junit.Before;
import org.junit.Test;
import stellarburgers.pageobject.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static stellarburgers.pageobject.Constants.MAIN_PAGE;

public class UserTests extends BaseTest {

    MainPage mainPage;

    @Before
    public void setUp() {
        mainPage = open(MAIN_PAGE, MainPage.class);
    }


    @Test
    public void urlTest() {
        String actual = String.valueOf("Соберите бургер");
        assertThat("1231", actual, containsString("Соберите бургер"));
    }

    @Test
    public void profileTest() {
        mainPage.accountButtonClick();


    }
}

