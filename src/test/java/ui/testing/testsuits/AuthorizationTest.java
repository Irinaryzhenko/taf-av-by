package ui.testing.testsuits;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.testing.steps.LoginSteps;

public class AuthorizationTest extends BaseTest {

    @DisplayName("Check login with invalid credentials")
    @Test
    public void loginWithInvalidCredentials() {
        LoginSteps.openHomePageSubmitCookies();
        LoginSteps.openLoginFormViaEmail();
        LoginSteps.fillAuthDataWithInvalidCredentials();
        LoginSteps.checkErrorMessageLoginInvalidCredentials();
    }

    @DisplayName("Check login with valid login and invalid password")
    @Test
    public void loginWithValidLoginInvalidPassword() {
        LoginSteps.openHomePageSubmitCookies();
        LoginSteps.openLoginFormViaEmail();
        LoginSteps.fillAuthDataWithValidloginInvalidPassword();
        LoginSteps.checkErrorMessageLoginInvalidCredentials();
    }

    @DisplayName("Check login with invalid login and valid password")
    @Test
    public void loginWithInvalidLoginValidPassword() {
        LoginSteps.openHomePageSubmitCookies();
        LoginSteps.openLoginFormViaEmail();
        LoginSteps.fillAuthDataInvalidLoginValidPasswords();
        LoginSteps.checkErrorMessageLoginInvalidCredentials();
    }

    @DisplayName("Check login with valid credentials")
    @Test
    public void loginWithValidCredentials() {
        LoginSteps.openHomePageSubmitCookies();
        LoginSteps.openLoginFormViaEmail();
        LoginSteps.fillAuthDataWithValidCredentials();
        LoginSteps.checkAuthorizationSuccess();
    }
    @DisplayName("Check log out")
    @Test
    public void logOut() {
        LoginSteps.openHomePageSubmitCookies();
        LoginSteps.openLoginFormViaEmail();
        LoginSteps.fillAuthDataWithValidCredentials();
        LoginSteps.logOut();
    }
}
