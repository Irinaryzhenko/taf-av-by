package api.testing.testsuits;

import api.testing.pojo.requests.LoginRequest;
import api.testing.pojo.responses.LoginFailedEmptyCredsResponse;
import api.testing.pojo.responses.LoginFailedInvalidCredsResponse;
import io.basc.framework.http.HttpStatus;
import io.restassured.http.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import static domain.constant.Constant.LOGIN_URL;
import static io.restassured.RestAssured.given;

public class AuthorizationTest {
    private final static Logger logger = LoggerFactory.getLogger(AuthorizationTest.class);
    @DisplayName("Authorization testing. Positive case: login with valid credentials")
    @Test
    public void checkAuthorizationWithValidCredentials() {
        LoginRequest request = LoginRequests.getLoginRequestBodyValidCredentials();

        given().contentType(ContentType.JSON).log().body()
                .body(request)
                .when().post(LOGIN_URL).then().statusCode(HttpStatus.OK.value());
        logger.info("Sending POST request for authorization. User has been authorized successfully");
    }

    @DisplayName("Authorization testing. Negative case: login with empty credentials")
    @Test
    public void checkAuthorizationWithEmptyCredentials() throws IOException {
        LoginRequest request = LoginRequests.getLoginRequestBodyEmptyCredentials();
        ObjectMapper objectMapperRequest = new ObjectMapper();
        var requestBody = objectMapperRequest.writeValueAsString(request);
        Response responseBody = RestAssured
                .given().contentType(ContentType.JSON).log().body()
                .body(requestBody)
                .when().post(LOGIN_URL);
        if (responseBody.getStatusCode() == HttpStatus.BAD_REQUEST.value()) {

            String response = responseBody.getBody().asString();
            ObjectMapper objectMapper = new ObjectMapper();

            var actualResult = objectMapper.readValue(response, LoginFailedEmptyCredsResponse.class);
            Assertions.assertEquals(LoginResponses.getLoginResponseEmptyCredentials(), actualResult);
            Assertions.assertEquals("exception.validation.failed", actualResult.getMessage());
            logger.info("Sending POST request for authorization. Authorization failed: user sees error: \"{}\" . User need to input credentials",
                    actualResult.getMessage());
        }
    }

    @DisplayName("Authorization testing. Negative case: login with empty email and any password ")
    @Test
    public void checkAuthorizationWithEmptyloginAndAnyPassword() throws JsonProcessingException {
        LoginRequest request = LoginRequests.getLoginRequestBodyEmptyloginAnyPassword();
        ObjectMapper objectMapperRequest = new ObjectMapper();
        var requestBody = objectMapperRequest.writeValueAsString(request);

        Response responseBody = RestAssured
                .given().contentType(ContentType.JSON)
                .body(requestBody).log().body()
                .when().post(LOGIN_URL);
        if (responseBody.getStatusCode() == HttpStatus.BAD_REQUEST.value()) {

            String response = responseBody.getBody().asString();
            ObjectMapper objectMapper = new ObjectMapper();

            var actualResult = objectMapper.readValue(response, LoginFailedEmptyCredsResponse.class);
            Assertions.assertEquals(LoginResponses.getLoginResponseEmptyCredentials(), actualResult);
            logger.info("Sending POST request for authorization. Authorization failed. User sees error: \" {} \"", actualResult);
        }
    }

    @DisplayName("Authorization testing. Negative case: login with password and any email")
    @Test
    public void checkAuthorizationWithEmptyPasswordAndAnyLogin() throws JsonProcessingException {
        LoginRequest request = LoginRequests.getLoginRequestBodyEmptyPasswordAnylogin();
        ObjectMapper objectMapperRequest = new ObjectMapper();
        var requestBody = objectMapperRequest.writeValueAsString(request);
        Response responseBody = RestAssured
                .given().contentType(ContentType.JSON)
                .body(requestBody).log().body()
                .when().post(LOGIN_URL);
        if (responseBody.getStatusCode() == HttpStatus.BAD_REQUEST.value()) {

            String response = responseBody.getBody().asString();
            ObjectMapper objectMapper = new ObjectMapper();

            var actualResult = objectMapper.readValue(response, LoginFailedEmptyCredsResponse.class);
            Assertions.assertEquals(LoginResponses.getLoginResponseEmptyCredentials(), actualResult);
            logger.info("Sending POST request for authorization. Authorization failed. User sees error: \" {} \"", actualResult);
        }
    }

    @DisplayName("Authorization testing. Negative case: login with non-existing user's credentials ")
    @Test
    public void checkAuthorizationWithInvalidCredentials() throws IOException {
        LoginRequest request = LoginRequests.getLoginRequestBodyInvalidCredentials();
        ObjectMapper objectMapperRequest = new ObjectMapper();
        var requestBody = objectMapperRequest.writeValueAsString(request);
        Response responseBody = RestAssured
                .given().contentType(ContentType.JSON)
                .body(requestBody).log().body()
                .when().post(LOGIN_URL);

        if (responseBody.getStatusCode() == HttpStatus.BAD_REQUEST.value()) {

            String response = responseBody.getBody().asString();
            ObjectMapper objectMapper = new ObjectMapper();
            LoginFailedInvalidCredsResponse loginResponse = objectMapper
                    .readValue(response, LoginFailedInvalidCredsResponse.class);
            Assertions.assertEquals(LoginResponses.getLoginResponseInvalidCredentials(), loginResponse);
            logger.info("Sending POST request for authorization. Authorization failed. User sees error: \" {} \"", loginResponse);
        }
    }

    @DisplayName("Authorization testing. Negative case: login with valid user's email and invalid password ")
    @Test
    public void checkAuthorizationWithValidLoginAndInvalidPassword() throws JsonProcessingException {
        LoginRequest request = LoginRequests.getLoginRequestBodyValidLoginInvalidPassword();
        ObjectMapper objectMapperRequest = new ObjectMapper();
        var requestBody = objectMapperRequest.writeValueAsString(request);
        Response responseBody = RestAssured
                .given().contentType(ContentType.JSON)
                .body(requestBody).log().body()
                .when().post(LOGIN_URL);
        if (responseBody.getStatusCode() == HttpStatus.BAD_REQUEST.value()) {

            String response = responseBody.getBody().asString();
            ObjectMapper objectMapper = new ObjectMapper();
            LoginFailedInvalidCredsResponse loginResponse = objectMapper.readValue(response, LoginFailedInvalidCredsResponse.class);
            Assertions.assertEquals(LoginResponses.getLoginResponseInvalidCredentials(), loginResponse);
            logger.info("Sending POST request for authorization.Authorization failed. User sees error: \" {} \"", loginResponse);
        }
    }

    @DisplayName("Authorization testing. Negative case: login with invalid user's email and valid password ")
    @Test
    public void checkAuthorizationWithInvalidloginAndValidPassword() throws JsonProcessingException {
        LoginRequest request = LoginRequests.getLoginRequestBodyInvalidLoginValidPassword();
        ObjectMapper objectMapperRequest = new ObjectMapper();
        var requestBody = objectMapperRequest.writeValueAsString(request);
        Response responseBody = RestAssured
                .given().contentType(ContentType.JSON)
                .body(requestBody).log().body()
                .when().post(LOGIN_URL);
        String response = responseBody.getBody().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        LoginFailedInvalidCredsResponse loginResponse = objectMapper.readValue(response, LoginFailedInvalidCredsResponse.class);
        Assertions.assertEquals(LoginResponses.getLoginResponseInvalidCredentials(), loginResponse);
        logger.info("Sending POST request for authorization. Authorization failed. User sees error: \" {} \"", loginResponse);
    }
}
