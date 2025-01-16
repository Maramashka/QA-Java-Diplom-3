package stellarburgers;

import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static stellarburgers.browser.Browser.initDriver;

public class BaseTest {

    @Before
    public void setup() throws IOException {
        initDriver();
        Configuration.timeout = 4000;
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}