package stellarburgers;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.client.UserClient;
import stellarburgers.models.User;
import stellarburgers.pageobject.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.Assert.assertEquals;
import static stellarburgers.generators.UserGenerator.randomUser;
import static stellarburgers.pageobject.Constants.*;

public class ClickThroughTests extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    User user;
    RegistrationPage registrationPage;
    PasswordRecoveryPage passwordRecoveryPage;
    AccountPage accountPage;

    @Before
    public void setUp() {
        mainPage = open(MAIN_PAGE, MainPage.class);
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
        passwordRecoveryPage = new PasswordRecoveryPage();
        accountPage = new AccountPage();
    }

    @Test
    @Description("Переход по клику на кнопку 'Личный кабинет' для неавторизованного пользователя")
    @DisplayName("Click-through personal account button without authorization test")
    public void clickThroughPersonalAccountButtonWithoutAuthorizationTest() {
        mainPage.clickButtonPersonalAccount();
        String actualUrl = webdriver().driver().url();

        assertEquals("Ожидаем перехода на страницу входа в аккаунт", LOGIN_PAGE, actualUrl);
    }

    @Test
    @Description("Переход по клику на кнопку 'Личный кабинет' для авторизованного пользователя")
    @DisplayName("Click-through personal account button after authorization test")
    public void clickThroughPersonalAccountButtonAfterAuthorizationTest() {
        user = randomUser();
        UserClient userClient = new UserClient();
        userClient.create(user);
        userClient.login(user);
        mainPage.clickButtonPersonalAccount();
        Configuration.timeout = 5000;

        String actualUrl = webdriver().driver().url();
        assertEquals("Ожидаем перехода в личный кабинет", ACCOUNT_PAGE, actualUrl);
    }


    @Test
    @Description("Переход по клику на 'Конструктор' из личного кабинета")
    @DisplayName("Click-through construction from account page test")
    public void clickThroughСonstructionButtonFromAccountPageTest() {
        user = randomUser();
        UserClient userClient = new UserClient();
        userClient.create(user);
        userClient.login(user);
        mainPage.clickButtonPersonalAccount()
                .clickButtonConstruction();

        String actualUrl = webdriver().driver().url();
        assertEquals("Ожидаем перехода на главную страницу", MAIN_PAGE, actualUrl);
    }

    @Test
    @Description("Переход на лого из личного кабинета")
    @DisplayName("Click-through logo from account page test")
    public void clickThroughLogoFromAccountPageTest() {
        user = randomUser();
        UserClient userClient = new UserClient();
        userClient.create(user);
        userClient.login(user);
        mainPage.clickButtonPersonalAccount()
                .clickLogo();

        String actualUrl = webdriver().driver().url();
        assertEquals("Ожидаем перехода на главную страницу", MAIN_PAGE, actualUrl);
    }

    @Test
    @Description("Выход из аккаунта по клику на 'Выход' из личного кабинета")
    @DisplayName("click through exit button from account page test")
    public void clickThroughExitButtonFromAccountPageTest() {
        user = randomUser();
        UserClient userClient = new UserClient();
        userClient.create(user);
        userClient.login(user);
        mainPage.clickButtonPersonalAccount();
        Configuration.timeout = 4000;
        accountPage.clickButtonExit();

        String actualUrl = webdriver().driver().url();
        assertEquals("Ожидаем перехода на страницу авторизации", LOGIN_PAGE, actualUrl);
    }
}
