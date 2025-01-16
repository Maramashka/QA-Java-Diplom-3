package client;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import stellarburgers.models.User;

import static io.restassured.RestAssured.given;
import static stellarburgers.pageobject.Constants.BASE_URI;

public class UserClient {

    public static final String USER_CREATE = "/api/auth/register";

    @Step("Создание пользователя")
    public ValidatableResponse create(User user) {
        return given()
                .baseUri(BASE_URI)
                .header("Content-type", "application/json")
                .log().all()
                .body(user)
                .when()
                .post(USER_CREATE)
                .then();
    }
}
