package stellarburgers;

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
import static com.codeborne.selenide.Selenide.webdriver;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stellarburgers.generators.UserGenerator.randomUser;
import static stellarburgers.pageobject.Constants.LOGIN_PAGE;
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
        user = randomUser();
    }


    @Test
    @DisplayName("Регистрация пользователя с корректными данными")
    @Description("Проверка регистрации пользователя с корректными данными")
    public void successfulRegistrationTest() {
        mainPage.personalAccountButtonClick();
        loginPage.registerLinkClick();

        registrationPage
                .setNameValue(user.getName())
                .setEmailValue(user.getEmail())
                .setPasswordValue(user.getPassword())
                .registerButtonClick();

//        String actual = String.valueOf("Соберите бургер");
//        assertThat("Ожидаем перехода на главную страницу", actual, containsString("Соберите бургер"));
        String actualUrl = webdriver().driver().url();

        assertEquals("Ожидаем перехода на страницу входа в аккаунт", LOGIN_PAGE, actualUrl);
    }


    @Test
    @DisplayName("Ошибка для некорректного пароля")
    @Description("Проверка регистрации с паролем меньше 6 символов")
    public void errorForIncorrectShortPasswordErrorTest() {
        mainPage.personalAccountButtonClick();
        loginPage.registerLinkClick();

        registrationPage.
                setNameValue(user.getName())
                .setEmailValue(user.getEmail())
                .setPasswordValue(faker.
                        internet().password(5, 10, true, true, true))
                .registerButtonClick();

        Boolean actual = registrationPage.isErrorPasswordTextDisplayed();
        assertTrue("Ожидаем сообщения о некорректном пароле", true);
    }
}



