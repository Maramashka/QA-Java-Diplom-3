package stellarburgers;

import client.UserClient;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.models.User;
import stellarburgers.pageobject.MainPage;
import stellarburgers.pageobject.ProfilePage;

import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static stellarburgers.generators.UserGenerator.randomUser;
import static stellarburgers.pageobject.Constants.MAIN_PAGE;

public class UserTests extends BaseTest {

    MainPage mainPage;
    private User user;
    private UserClient userClient;

    @Before
    public void setUp() {
        mainPage = open(MAIN_PAGE, MainPage.class);
        user = randomUser();
        userClient = new UserClient();
    }


    @Test
    public void urlTest() {
        String actual = String.valueOf("Соберите бургер");
        assertThat("1231", actual, containsString("Соберите бургер"));
    }

    @Test
    public void profileTest() {
        mainPage.accountButtonClick();
        ProfilePage profilePage = new ProfilePage();
        profilePage.clear


    }
}

