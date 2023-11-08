package utils;

import api.testing.pojo.requests.LoginRequest;
import com.github.javafaker.Faker;
import domain.constant.Constant;

public class LoginRequests {
    public static Faker faker = new Faker();
    public static LoginRequest getLoginRequestBodyValidCredentials() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = Constant.VALID_LOGIN;
        loginRequest.password = Constant.VALID_PASSWORD;
        return loginRequest;
    }
    public static LoginRequest getLoginRequestBodyInvalidCredentials() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = faker.internet().emailAddress();
        loginRequest.password = faker.internet().password();
        return loginRequest;
    }
    public static LoginRequest getLoginRequestBodyEmptyCredentials() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = "";
        loginRequest.password = "";
        return loginRequest;
    }
    public static LoginRequest getLoginRequestBodyEmptyloginAnyPassword() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = "";
        loginRequest.password = faker.internet().password();
        return loginRequest;
    }
    public static LoginRequest getLoginRequestBodyEmptyPasswordAnylogin() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = faker.internet().emailAddress();
        loginRequest.password = "";
        return loginRequest;
    }
    public static LoginRequest getLoginRequestBodyValidLoginInvalidPassword() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = Constant.VALID_LOGIN;
        loginRequest.password = faker.internet().password();
        return loginRequest;
    }
    public static LoginRequest getLoginRequestBodyInvalidLoginValidPassword() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = faker.internet().emailAddress();
        loginRequest.password = Constant.VALID_PASSWORD;
        return loginRequest;
    }
    public static LoginRequest getLoginRequestBodyValidCredsWithSpacesBeforeLogin() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = "   " + Constant.VALID_LOGIN;
        loginRequest.password = Constant.VALID_PASSWORD;
        return loginRequest;
    }
    public static LoginRequest getLoginRequestBodyValidCredsWithSpacesAfterLogin() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = Constant.VALID_LOGIN + "    ";
        loginRequest.password = Constant.VALID_PASSWORD;
        return loginRequest;
    }
}
