package api.testing.testsuits;

import api.testing.pojo.requests.LoginRequest;
import api.testing.pojo.responses.LoginFailedEmptyCredsResponse;
import api.testing.pojo.responses.LoginFailedInvalidCredsResponse;
import utils.LoginRequests;
import utils.LoginResponses;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static io.restassured.RestAssured.given;

public class AuthorizationTest {
    private final static String LOGIN_URL = "https://api.av.by/auth/login/sign-in";
    private final static String CONTENT_TYPE = "application/json";

    @DisplayName("Authorization testing. Positive case: login with valid credentials")
    @Test
    public void checkAuthorizationWithValidCredentials() {
        LoginRequest request = LoginRequests.getLoginRequestBodyValidCreds();

        given().contentType(CONTENT_TYPE).log().body()
                .body(request)
                .when().post(LOGIN_URL).then().statusCode(200);
    }

    @DisplayName("Authorization testing. Negative case: login with empty redentials")
    @Test
    public void checkAuthorizationWithEmptyCredentials() throws IOException {
        LoginRequest request = LoginRequests.getLoginRequestBodyEmptyCreds();
        ObjectMapper objectMapperRequest = new ObjectMapper();
        var requestBody = objectMapperRequest.writeValueAsString(request);
        Response responseBody = RestAssured
                .given().contentType(CONTENT_TYPE).log().body()
                .body(requestBody)
                .when().post(LOGIN_URL);
        if (responseBody.getStatusCode() == 400) {

            String response = responseBody.getBody().asString();
            ObjectMapper objectMapper = new ObjectMapper();

            var actualResult = objectMapper.readValue(response, LoginFailedEmptyCredsResponse.class);
            Assertions.assertEquals(LoginResponses.getLoginResponceEmptyCredentional(), actualResult);
            Assertions.assertEquals("exception.validation.failed", actualResult.getMessage());
        }
    }

    @DisplayName("Authorization testing. Negative case: login with empty email and any password ")
    @Test
    public void checkAuthorizationWithEmptyloginAndAnyPassword() throws JsonProcessingException {
        LoginRequest request = LoginRequests.getLoginRequestBodyEmptyloginAnyPassword();
        ObjectMapper objectMapperRequest = new ObjectMapper();
        var requestBody = objectMapperRequest.writeValueAsString(request);

        Response responseBody = RestAssured
                .given().contentType(CONTENT_TYPE)
                .body(requestBody).log().body()
                .when().post(LOGIN_URL);
        if (responseBody.getStatusCode() == 400) {

            String response = responseBody.getBody().asString();
            ObjectMapper objectMapper = new ObjectMapper();

            var actualResult = objectMapper.readValue(response, LoginFailedEmptyCredsResponse.class);
            Assertions.assertEquals(LoginResponses.getLoginResponceEmptyCredentional(), actualResult);
        }
    }

    @DisplayName("Authorization testing. Negative case: login with password and any email")
    @Test
    public void checkAuthorizationWithEmptyPasswordAndAnyLogin() throws JsonProcessingException {
        LoginRequest request = LoginRequests.getLoginRequestBodyEmptyPasswordAnylogin();
        ObjectMapper objectMapperRequest = new ObjectMapper();
        var requestBody = objectMapperRequest.writeValueAsString(request);
        Response responseBody = RestAssured
                .given().contentType(CONTENT_TYPE)
                .body(requestBody).log().body()
                .when().post(LOGIN_URL);
        if (responseBody.getStatusCode() == 400) {

            String response = responseBody.getBody().asString();
            ObjectMapper objectMapper = new ObjectMapper();

            var actualResult = objectMapper.readValue(response, LoginFailedEmptyCredsResponse.class);
            Assertions.assertEquals(LoginResponses.getLoginResponceEmptyCredentional(), actualResult);
        }
    }

    @DisplayName("Authorization testing. Negative case: login with non-existing user's credentials ")
    @Test
    public void checkAuthorizationWithInvalidCredentials() throws IOException {
        LoginRequest request = LoginRequests.getLoginRequestBodyInvalidCreds();
        ObjectMapper objectMapperRequest = new ObjectMapper();
        var requestBody = objectMapperRequest.writeValueAsString(request);
        Response responseBody = RestAssured
                .given().contentType(CONTENT_TYPE)
                .body(requestBody).log().body()
                .when().post(LOGIN_URL);

        if (responseBody.getStatusCode() == 400) {

            String response = responseBody.getBody().asString();
            ObjectMapper objectMapper = new ObjectMapper();
            LoginFailedInvalidCredsResponse loginResponse = objectMapper
                    .readValue(response, LoginFailedInvalidCredsResponse.class);
            Assertions.assertEquals(LoginResponses.getLoginResponceInvalidCredentials(), loginResponse);
        }
    }

    @DisplayName("Authorization testing. Negative case: login with valid user's email and invalid password ")
    @Test
    public void checkAuthorizationWithValidLoginAndInvalidPassword() throws JsonProcessingException {
        LoginRequest request = LoginRequests.getLoginRequestBodyValidLoginInvalidPassword();
        ObjectMapper objectMapperRequest = new ObjectMapper();
        var requestBody = objectMapperRequest.writeValueAsString(request);
        Response responseBody = RestAssured
                .given().contentType(CONTENT_TYPE)
                .body(requestBody).log().body()
                .when().post(LOGIN_URL);
        if (responseBody.getStatusCode() == 400) {

            String response = responseBody.getBody().asString();
            ObjectMapper objectMapper = new ObjectMapper();
            LoginFailedInvalidCredsResponse loginResponse = objectMapper.readValue(response, LoginFailedInvalidCredsResponse.class);
            Assertions.assertEquals(LoginResponses.getLoginResponceInvalidCredentials(), loginResponse);
        }
    }

    @DisplayName("Authorization testing. Negative case: login with invalid user's email and valid password ")
    @Test
    public void checkAuthorizationWithInalidloginAndValidPassword() throws JsonProcessingException {
        LoginRequest request = LoginRequests.getLoginRequestBodyInvalidLoginValidPassword();
        ObjectMapper objectMapperRequest = new ObjectMapper();
        var requestBody = objectMapperRequest.writeValueAsString(request);
        Response responseBody = RestAssured
                .given().contentType(CONTENT_TYPE)
                .body(requestBody).log().body()
                .when().post(LOGIN_URL);
        String response = responseBody.getBody().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        LoginFailedInvalidCredsResponse loginResponse = objectMapper.readValue(response, LoginFailedInvalidCredsResponse.class);
        Assertions.assertEquals(LoginResponses.getLoginResponceInvalidCredentials(), loginResponse);

    }

    @DisplayName("Authorization testing. Negative case: login with spaces before valid email. Spaces need to be trimmed.")
    @Test
    public void checkAuthorizationWithSpacesBeforeValidLogin() {
        LoginRequest request = LoginRequests.getLoginRequestBodyValidCredsWithSpacesBeforeLogin();

        given().contentType(CONTENT_TYPE).log().body()
                .body(request)
                .when().post(LOGIN_URL).then().statusCode(200);
    }

    @DisplayName("Authorization testing. Negative case: login with spaces before valid email. Spaces need to be trimmed.")
    @Test
    public void checkAuthorizationWithSpacesAfterValidEmail() {
        LoginRequest request = LoginRequests.getLoginRequestBodyValidCredsWithSpacesAfterLogin();
        given().contentType(CONTENT_TYPE).log().body()
                .body(request)
                .when().post(LOGIN_URL).then().statusCode(200);
    }
}
