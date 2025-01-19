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
import static org.junit.Assert.assertTrue;
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
    @DisplayName("Авторизация через кнопку 'Войти в аккаунт' на главной")
    @Description("Авторизация через кнопку 'Войти в аккаунт' на главной странице")
    public void loginIntoAccountButtonLoginTest() {
        mainPage.clickButtonLoginIntoAccount();
        loginPage.setEmail(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickButtonLogin();

        boolean actual = mainPage.isEnabledButtonOrder();
        assertTrue("Ожидаем трансформации кнопки 'Войти в аккаунт' на главной странице в кнопку 'Оформить заказ'",
                actual);

    }

    @Test
    @DisplayName("Авторизация через кнопку 'Личный кабинет'")
    @Description("Авторизация через кнопку 'Личный кабинет'")
    public void accountButtonLoginTest() {
        mainPage.clickButtonPersonalAccount();
        loginPage
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickButtonLogin();

        boolean actual = mainPage.isEnabledButtonOrder();
        assertTrue("Ожидаем трансформации кнопки 'Войти в аккаунт' на главной странице в кнопку 'Оформить заказ'",
                actual);
    }

    @Test
    @DisplayName("Авторизация через ссылку 'Войти' в форме регистрации")
    @Description("Авторизация через ссылку 'Войти' в форме регистрации")
    public void loginIntoButtonLoginRegistrationPageLoginTest() {
        mainPage.clickButtonPersonalAccount();
        loginPage.clickLinkRegister();
        registrationPage.clickButtonLogin();
        loginPage
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickButtonLogin();

        boolean actual = mainPage.isEnabledButtonOrder();
        assertTrue("Ожидаем трансформации кнопки 'Войти в аккаунт' на главной странице в кнопку 'Оформить заказ'",
                actual);
    }

    @Test
    @DisplayName("Авторизация через ссылку 'Войти' на странице восстановления пароля")
    @Description("Авторизация через ссылку 'Войти' на странице восстановления пароля")
    public void loginIntoLinkLoginPasswordRecoveryPageTest() {
        mainPage.clickButtonPersonalAccount();
        loginPage.clickButtonLogin()
                .clickLinkPasswordRecover();
        passwordRecoveryPage.clickLinkPasswordRecover();
        loginPage
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickButtonLogin();

        boolean actual = mainPage.isEnabledButtonOrder();
        assertTrue("Ожидаем трансформации кнопки 'Войти в аккаунт' на главной странице в кнопку 'Оформить заказ'",
                actual);
    }
}
