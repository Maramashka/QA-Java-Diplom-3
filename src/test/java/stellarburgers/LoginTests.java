package stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.client.UserClient;
import stellarburgers.models.User;
import stellarburgers.pageobject.LoginPage;
import stellarburgers.pageobject.MainPage;
import stellarburgers.pageobject.PasswordRecoveryPage;
import stellarburgers.pageobject.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static stellarburgers.generators.UserGenerator.randomUser;
import static stellarburgers.pageobject.Constants.MAIN_PAGE;

public class LoginTests extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    User user;
    RegistrationPage registrationPage;
    PasswordRecoveryPage passwordRecoveryPage;

    @Before
    public void setUp() {
        mainPage = open(MAIN_PAGE, MainPage.class);
        loginPage = new LoginPage();
        user = randomUser();
        UserClient userClient = new UserClient();
        userClient.create(user);
        registrationPage = new RegistrationPage();
        passwordRecoveryPage = new PasswordRecoveryPage();
    }

    @Test
    @DisplayName("Авторизация через кнопку «Войти в аккаунт» на главной")
    @Description("Авторизация через кнопку «Войти в аккаунт» на главной странице")
    public void loginIntoAccountButtonLoginTest() {
        mainPage.loginIntoAccountButtonClick();
        loginPage.setEmail(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.buttonLoginClick();

        String actualUrl = webdriver().driver().url();

        assertThat("Ожидаем перехода на главную страницу", actualUrl, is(MAIN_PAGE));
    }

    @Test
    @DisplayName("Авторизация через кнопку «Личный кабинет»")
    @Description("Авторизация через кнопку «Личный кабинет»")
    public void accountButtonLoginTest() {
        mainPage.personalAccountButtonClick();
        loginPage
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .buttonLoginClick();

        String actualUrl = webdriver().driver().getCurrentFrameUrl();

        assertThat("Ожидаем перехода на главную страницу", actualUrl, is(MAIN_PAGE));
    }

    @Test
    @DisplayName("Авторизация через ссылку «Войти» в форме регистрации")
    @Description("Авторизация через ссылку «Войти» в форме регистрации")
    public void loginIntoButtonLoginRegistrationPageLoginTest() {
        mainPage.personalAccountButtonClick();
        loginPage.registerLinkClick();
        registrationPage.buttonLoginClick();
        loginPage
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .buttonLoginClick();

        String actualUrl = webdriver().driver().getCurrentFrameUrl();

        assertThat("Ожидаем перехода на главную страницу", actualUrl, is(MAIN_PAGE));
    }

    @Test
    @DisplayName("Авторизация через ссылку «Войти» на странице восстановления пароля")
    @Description("Авторизация через ссылку «Войти» на странице восстановления пароля")
    public void loginIntoLinkLoginPasswordRecoveryPageTest() {
        mainPage.personalAccountButtonClick();
        loginPage.buttonLoginClick()
                .linkPasswordRecoverClick();
        passwordRecoveryPage.linkPasswordRecoverClick();
        loginPage
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .buttonLoginClick();

        String actualUrl = webdriver().driver().getCurrentFrameUrl();

        assertThat("Ожидаем перехода на главную страницу", actualUrl, is(MAIN_PAGE));
    }
}
