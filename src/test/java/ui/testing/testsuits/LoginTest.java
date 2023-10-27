package ui.testing.testsuits;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.testing.steps.LoginSteps;

public class LoginTest extends BaseTest {

    @DisplayName("Check login with invalid credentials")
    @Test
    public void loginWithInvalidCredentials() {
        LoginSteps.startIteration();
        LoginSteps.openLoginFormViaEmail();
        LoginSteps.fillAuthDataWithInvalidcreds();
        LoginSteps.checkErrorMessageLoginInvalidCreds();
    }

    @DisplayName("Check login with valid login and invalid password")
    @Test
    public void loginWithValidLoginInvalidPassword() {
        LoginSteps.startIteration();
        LoginSteps.openLoginFormViaEmail();
        LoginSteps.fillAuthDataWithValidloginInvalidPassword();
        LoginSteps.fillAuthDataWithInvalidcreds();
    }

    @DisplayName("Check login with invalid login and valid password")
    @Test
    public void loginWithInvalidLoginValidPassword() {
        LoginSteps.startIteration();
        LoginSteps.openLoginFormViaEmail();
        LoginSteps.fillAuthDataInvalidLoginValidPasswors();
        LoginSteps.checkErrorMessageLoginInvalidCreds();
    }

    @DisplayName("Check login with valid credentials")
    @Test
    public void loginWithValidCredentials() {
        LoginSteps.startIteration();
        LoginSteps.openLoginFormViaEmail();
        LoginSteps.fillAuthDataWithValidCreds();
        LoginSteps.checkAuthorizationSuccess();
    }
}
