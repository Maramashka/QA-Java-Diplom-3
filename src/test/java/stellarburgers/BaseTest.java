package stellarburgers;

import com.codeborne.selenide.Configuration;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import stellarburgers.client.UserClient;
import stellarburgers.models.User;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static stellarburgers.browser.Browser.initDriver;

public class BaseTest {
    User user;
    UserClient userClient;
    private String accessToken;

    @Before
    public void setup() throws IOException {
        initDriver();
        Configuration.timeout = 4000;
    }

    @After
    public void tearDown() {
        closeWebDriver();

        if (user != null) {
            ValidatableResponse response = userClient.login(user);
            accessToken = response.extract().path("accessToken");
            userClient.delete(accessToken);
        }
    }
}