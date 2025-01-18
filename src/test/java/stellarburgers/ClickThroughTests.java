package stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.client.UserClient;
import stellarburgers.models.User;
import stellarburgers.pageobject.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
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
    @DisplayName("Click-Through Personal Account Button Without Authorization Test")
    @Description("Переход по клику на кнопку «Личный кабинет» для неавторизованного пользователя")
    public void clickThroughPersonalAccountButtonWithoutAuthorizationTest() {
        mainPage.personalAccountButtonClick();
        String actualUrl = webdriver().driver().url();

        assertEquals("Ожидаем перехода на страницу входа в аккаунт", LOGIN_PAGE, actualUrl);
    }

    @Test
    @DisplayName("Click-Through Personal Account Button After Authorization Test")
    @Description("Переход по клику на кнопку «Личный кабинет» для авторизованного пользователя")
    public void clickThroughPersonalAccountButtonAfterAuthorizationTest() {
        user = randomUser();
        UserClient userClient = new UserClient();
        userClient.create(user);
        userClient.login(user);
        mainPage.personalAccountButtonClick();

        String actualUrl = webdriver().driver().getCurrentFrameUrl();

        assertEquals("Ожидаем перехода в личный кабинет", ACCOUNT_PAGE, actualUrl);
    }


    @Test
    @DisplayName("Click-Through Сonstruction From Account Page Test")
    @Description("Переход по клику на «Конструктор» из личного кабинета")
    public void clickThroughСonstructionButtonFromAccountPageTest() {
        user = randomUser();
        UserClient userClient = new UserClient();
        userClient.create(user);
        userClient.login(user);
        mainPage.personalAccountButtonClick()
                .buttonConstructionClick();

        String actual = String.valueOf("Соберите бургер");

        assertThat("Ожидаем перехода на главную страницу", actual, containsString("Соберите бургер"));
    }

    @Test
    @DisplayName("click Through Exit Button From Account Page Test")
    @Description("Выход из аккаунта по клику на «Выход» из личного кабинета")
    public void clickThroughExitButtonFromAccountPageTest() {
        user = randomUser();
        UserClient userClient = new UserClient();
        userClient.create(user);
        userClient.login(user);
        mainPage.personalAccountButtonClick();
        accountPage.exitButtonClick();

        String actualUrl = webdriver().driver().getCurrentFrameUrl();

        assertThat("Ожидаем перехода на страницу авторизации", actualUrl, is((LOGIN_PAGE)));
    }
}
