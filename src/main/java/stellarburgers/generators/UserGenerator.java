package stellarburgers.generators;

import io.qameta.allure.Step;
import stellarburgers.models.User;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class UserGenerator {

    @Step("User-генератор")
    public static User randomUser() {
        String email = "Koza";
        String password = "Koza";
        String name = "Koza";

        String newEmail = email + randomAlphabetic(5) + "@yandex.ru";
        String newPassword = password + randomAlphabetic(5);
        String newName = name + randomAlphabetic(5);

        return new User(newEmail, newPassword, newName);
    }
}