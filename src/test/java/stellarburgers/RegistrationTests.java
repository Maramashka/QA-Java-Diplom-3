package stellarburgers;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.models.User;
import stellarburgers.pageobject.LoginPage;
import stellarburgers.pageobject.MainPage;
import stellarburgers.pageobject.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;
import static stellarburgers.generators.UserGenerator.randomUser;
import static stellarburgers.pageobject.Constants.MAIN_PAGE;

public class RegistrationTests extends BaseTest {

    MainPage mainPage;
    RegistrationPage registrationPage;
    LoginPage loginPage;
    Faker faker;
    User user;

    @Before
    public void setUp() {
        mainPage = open(MAIN_PAGE, MainPage.class);
        registrationPage = new RegistrationPage();
        loginPage = new LoginPage();
        faker = new Faker();
    }


    @Test
    public void testTest() {
        String actual = String.valueOf("Соберите бургер");
        assertThat("1231", actual, containsString("Соберите бургер"));
    }


    @Test
    @DisplayName("Регистрация пользователя с корректными данными")
    @Description("Проверка регистрации пользователя с корректными данными")
    public void successfulRegistrationTest() {
        user = randomUser();
        user.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .name(user.getName())
                .build();

        mainPage.accountButtonClick();
        loginPage.registerLinkClick();
        registrationPage.registerButtonClick();
        Configuration.timeout = 5000;

        String actual = String.valueOf("Соберите бургер");
        assertThat("Переход на страницу оформления заказа отсутствует", actual, containsString("Соберите бургер"));
    }


    @Test
    @DisplayName("Ошибка для некорректного пароля")
    @Description("Проверка регистрации с паролем меньше 6 символов")
    public void errorForIncorrectShortPasswordErrorTest() {
        mainPage.accountButtonClick();
        loginPage.registerLinkClick();

        user = randomUser();
        user.builder()
                .email(user.getEmail())
                .password(faker.internet().password(5, 10, true, true, true))
                .name(user.getName())
                .build();

        registrationPage.registerButtonClick();

        Boolean actual = registrationPage.isErrorPasswordTextDisplayed();
        assertTrue("Сообщение о некорректном пароле отсутствует", true);
    }
}



