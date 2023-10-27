package ui.testing.testsuits;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.testing.steps.LoginSteps;

public class LoginTest extends BaseTest {

    @DisplayName("Check login with invalid credentials")
    @Test
    public void loginWithInvalidCredentials() {
        LoginSteps.startWorking();
        LoginSteps.openLoginFormViaEmail();
        LoginSteps.fillAuthDataWithInvalidCreds();
        LoginSteps.checkErrorMessageLoginInvalidCreds();
    }

    @DisplayName("Check login with valid login and invalid password")
    @Test
    public void loginWithValidLoginInvalidPassword() {
        LoginSteps.startWorking();
        LoginSteps.openLoginFormViaEmail();
        LoginSteps.fillAuthDataWithValidloginInvalidPassword();
        LoginSteps.fillAuthDataWithInvalidCreds();
    }

    @DisplayName("Check login with invalid login and valid password")
    @Test
    public void loginWithInvalidLoginValidPassword() {
        LoginSteps.startWorking();
        LoginSteps.openLoginFormViaEmail();
        LoginSteps.fillAuthDataInvalidLoginValidPasswords();
        LoginSteps.checkErrorMessageLoginInvalidCreds();
    }

    @DisplayName("Check login with valid credentials")
    @Test
    public void loginWithValidCredentials() {
        LoginSteps.startWorking();
        LoginSteps.openLoginFormViaEmail();
        LoginSteps.fillAuthDataWithValidCreds();
        LoginSteps.checkAuthorizationSuccess();
    }
}
