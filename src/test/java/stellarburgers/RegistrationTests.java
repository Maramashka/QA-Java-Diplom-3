package stellarburgers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.models.User;
import stellarburgers.pageobject.Constants;
import stellarburgers.pageobject.EntrancePage;
import stellarburgers.pageobject.MainPage;
import stellarburgers.pageobject.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stellarburgers.generators.UserGenerator.randomUser;
import static stellarburgers.pageobject.Constants.MAIN_PAGE;

public class RegistrationTests extends BaseTest {

    MainPage mainPage;
    RegistrationPage registrationPage;
    EntrancePage entrancePage;
    Faker faker;

    @Before
    public void setUp() {
        mainPage = open(MAIN_PAGE, MainPage.class);
        registrationPage = new RegistrationPage();
        entrancePage = new EntrancePage();
        faker = new Faker();
    }


    @Test
    public void testTest() {
        String actual = String.valueOf("Соберите бургер");
        assertThat("1231", actual, containsString("Соберите бургер"));
    }

    @Test
    @DisplayName("Регистрация пользователя с валидными данными")
    @Description("Проверка регистрации пользователя с корректными данными")
    public void successfulRegistrationTest() {
        User user = User.builder()
                .email(randomUser().getEmail())
                .password(randomUser().getPassword())
                .name(randomUser().getName())
                .build();

        mainPage.profileButtonClick();
        entrancePage.registerLinkClick();
        registrationPage.setNameValue(user.getName());
        registrationPage.setEmailValue(user.getEmail());
        registrationPage.setPasswordValue(user.getPassword());
        registrationPage.registerButtonClick();

        assertTrue("Отсутствует сообщение об успешной регистрации", actual);

    }

    @Test
    public void incorrectPasswordErrorTest() {
        mainPage.profileButtonClick();
        entrancePage.registerLinkClick();

        User user = User.builder()
                .email(randomUser().getEmail())
                .password(faker.internet().password(5, 10, true, true, true))
                .name(randomUser().getName())
                .build();

        registrationPage.setInputValueName(user.getName());
        registrationPage.setInputValueEmail(user.getEmail());
        registrationPage.setInputValuePassword(user.getPassword());
        registrationPage.registerButtonClick();
        Configuration.timeout = 4000;

        assertEquals("Ошибка",
                Constants.ENTRANCE_PAGE, WebDriverRunner.url());

    }
}

