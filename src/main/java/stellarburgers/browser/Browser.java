package stellarburgers.browser;

import com.codeborne.selenide.Configuration;

public class Browser {
    public static void initDriver() {

        String browserProperty = System.getProperty("testBrowser", "CHROME");
        System.out.println("browserProperty = " + browserProperty);

        BrowserType browserType = BrowserType.valueOf(browserProperty);

        switch (browserType) {
            case CHROME:
                Configuration.browser = "CHROME";
                break;
            case YANDEX:
                System.setProperty("webdriver.chrome.driver", "C://Users//masha//Downloads//yandexdriver-24.12.0.1810-win64//yandexdriver.exe/");
                Configuration.browser = "CHROME";
                break;
            default:
                throw new RuntimeException("Browser undefined");
        }
    }
}
