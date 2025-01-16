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
                System.setProperty("webdriver.chrome.driver", "C://Users//masha//Downloads//Yandex.exe/");
                Configuration.browser = "CHROME";
                break;
            default:
                throw new RuntimeException("Browser undefined");
        }
    }
}
