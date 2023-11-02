package utils;

import api.testing.pojo.requests.LoginRequest;
import domain.constant.Constant;
import domain.login.LoginTestData;

public class LoginRequests {
    public static LoginRequest getLoginRequestBodyValidCredentials() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = Constant.VALID_LOGIN;
        loginRequest.password = Constant.VALID_PASSWORD;
        return loginRequest;
    }
    public static LoginRequest getLoginRequestBodyInvalidCredentials() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = LoginTestData.generateLogin();
        loginRequest.password = LoginTestData.generatePassword();
        return loginRequest;
    }
    public static LoginRequest getLoginRequestBodyEmptyCredentals() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = "";
        loginRequest.password = "";
        return loginRequest;
    }
    public static LoginRequest getLoginRequestBodyEmptyloginAnyPassword() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = "";
        loginRequest.password = LoginTestData.generatePassword();
        return loginRequest;
    }
    public static LoginRequest getLoginRequestBodyEmptyPasswordAnylogin() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = LoginTestData.generateLogin();
        loginRequest.password = "";
        return loginRequest;
    }
    public static LoginRequest getLoginRequestBodyValidLoginInvalidPassword() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = Constant.VALID_LOGIN;
        loginRequest.password = LoginTestData.generatePassword();
        return loginRequest;
    }
    public static LoginRequest getLoginRequestBodyInvalidLoginValidPassword() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = LoginTestData.generateLogin();
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
