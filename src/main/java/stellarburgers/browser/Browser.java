package stellarburgers.browser;

import com.codeborne.selenide.Configuration;

public class Browser {
    public static void initDriver() {

        final String YANDEX_PATH = "...";

        String browserProperty = System.getProperty("testBrowser", "CHROME");
        System.out.println("browserProperty = " + browserProperty);

        BrowserType browserType = BrowserType.valueOf(browserProperty);

        switch (browserType) {
            case CHROME:
                Configuration.browser = "CHROME";
                break;
            case YANDEX:
                System.setProperty("webdriver.chrome.driver", YANDEX_PATH);
                Configuration.browser = "CHROME";
                break;
            default:
                throw new RuntimeException("Browser undefined");
        }
    }
}
