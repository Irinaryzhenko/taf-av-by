package api.testing.utils.login;

import api.testing.pojo.requests.LoginRequest;

public class LoginRequests {
    public static LoginRequest getLoginRequestBodyValidCreds() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = LoginRequestTestData.getValidLogin();
        loginRequest.password = LoginRequestTestData.getValidPassword();
        return loginRequest;
    }
    public static LoginRequest getLoginRequestBodyInvalidCreds() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = LoginRequestTestData.generateLogin();
        loginRequest.password = LoginRequestTestData.generatePassword();
        return loginRequest;
    }
    public static LoginRequest getLoginRequestBodyEmptyCreds() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = "";
        loginRequest.password = "";
        return loginRequest;
    }
    public static LoginRequest getLoginRequestBodyEmptyloginAnyPassword() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = "";
        loginRequest.password = LoginRequestTestData.generatePassword();
        return loginRequest;
    }
    public static LoginRequest getLoginRequestBodyEmptyPasswordAnylogin() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = LoginRequestTestData.generateLogin();
        loginRequest.password = "";
        return loginRequest;
    }
    public static LoginRequest getLoginRequestBodyValidLoginInvalidPassword() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = LoginRequestTestData.getValidLogin();
        loginRequest.password = LoginRequestTestData.generatePassword();
        return loginRequest;
    }
    public static LoginRequest getLoginRequestBodyInvalidLoginValidPassword() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = LoginRequestTestData.generateLogin();
        loginRequest.password = LoginRequestTestData.getValidPassword();
        return loginRequest;
    }
    public static LoginRequest getLoginRequestBodyValidCredsWithSpacesBeforeLogin() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = "   " + LoginRequestTestData.getValidLogin();
        loginRequest.password = LoginRequestTestData.getValidPassword();
        return loginRequest;
    }
    public static LoginRequest getLoginRequestBodyValidCredsWithSpacesAfterLogin() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.login = LoginRequestTestData.getValidLogin() + "    ";
        loginRequest.password = LoginRequestTestData.getValidPassword();
        return loginRequest;
    }




}
