package stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.client.UserClient;
import stellarburgers.models.User;
import stellarburgers.pageobject.LoginPage;
import stellarburgers.pageobject.MainPage;
import stellarburgers.pageobject.PasswordRecoverPage;
import stellarburgers.pageobject.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static stellarburgers.generators.UserGenerator.randomUser;
import static stellarburgers.pageobject.Constants.MAIN_PAGE;

public class LoginTests extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    User user;
    RegistrationPage registrationPage;
    PasswordRecoverPage passwordRecoverPage;

    @Before
    public void setUp() {
        mainPage = open(MAIN_PAGE, MainPage.class);
        loginPage = new LoginPage();
        user = randomUser();
        UserClient userClient = new UserClient();
        userClient.create(user);
        registrationPage = new RegistrationPage();
        passwordRecoverPage = new PasswordRecoverPage();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Description("Вход по кнопке «Войти в аккаунт» на главной странице")
    public void loginIntoAccountButtonLoginTest() {
        mainPage.loginIntoAccountButtonClick();
        loginPage.setEmail(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.buttonLoginClick();

        String actualUrl = webdriver().driver().getCurrentFrameUrl();
        assertThat("Переход на страницу оформления заказа", actualUrl, is(url()));
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Вход в аккаунт через кнопку «Личный кабинет»")
    public void accountButtonLoginTest() {
        mainPage.accountButtonClick();
        loginPage.buttonLoginClick();
        loginPage.setEmail(user.getEmail());
        loginPage.setPassword(user.getPassword());

        String actualUrl = webdriver().driver().getCurrentFrameUrl();

        assertThat("Переход на страницу оформления заказа", actualUrl, is(url()));
    }

    @Test
    @DisplayName("Вход через ссылку «Войти» на странице регистрации")
    @Description("Вход в аккаунт через ссылку «Войти» на странице регистрации")
    public void loginIntoButtonLoginRegistrationPageLoginTest() {
        mainPage.accountButtonClick();
        loginPage.registerLinkClick();
        registrationPage.buttonLoginClick();
        loginPage.setEmail(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.buttonLoginClick();

        String actualUrl = webdriver().driver().getCurrentFrameUrl();

        assertThat("Переход на страницу оформления заказа", actualUrl, is(url()));
    }

    @Test
    @DisplayName("Вход через ссылку «Войти» на странице регистрации")
    @Description("Вход в аккаунт через кнопку в форме восстановления пароля")
    public void LoginTest() {
        mainPage.accountButtonClick();
        loginPage.buttonLoginClick();
        loginPage.linkPasswordRecoverClick();
        passwordRecoverPage.linkPasswordRecoverClick();
        loginPage.setEmail(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.buttonLoginClick();

        String actualUrl = webdriver().driver().getCurrentFrameUrl();

        assertThat("Переход на страницу оформления заказа", actualUrl, is(url()));
    }
}
