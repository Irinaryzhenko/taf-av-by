package ui.testing.steps;

import com.github.javafaker.Faker;
import domain.constant.Constant;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import po.HomePage;
import po.LoginFormPage;
import po.PersonalAccountPage;

public class LoginSteps extends CommonSteps{

    private final static Logger logger = LoggerFactory.getLogger(LoginSteps.class);
    public static Faker faker = new Faker();
    public static void openLoginFormViaEmail() {
        HomePage homePage = new HomePage();
        homePage.openLoginForm();
        LoginFormPage loginFormPage = new LoginFormPage();
        loginFormPage.openLoginFormViaMail();
    }
    public static void fillAuthDataWithInvalidCredentials() {
        LoginFormPage loginFormPage = new LoginFormPage();
        loginFormPage
                .fillLoginPasswordField(faker.internet().emailAddress(), faker.internet().password())
                .submitAuthData();
        logger.info("Invalid credentials have been generated and filled in login form");
    }
    public static void fillAuthDataWithValidloginInvalidPassword() {
        LoginFormPage loginFormPage = new LoginFormPage();
        loginFormPage
                .fillLoginPasswordField(Constant.VALID_LOGIN, faker.internet().password())
                .submitAuthData();
        logger.info("Invalid password has been generated , valid login has been filled in login form");
    }
    public static void fillAuthDataInvalidLoginValidPasswords() {
        LoginFormPage loginFormPage = new LoginFormPage();
        loginFormPage
                .fillLoginPasswordField(faker.internet().emailAddress(), Constant.VALID_PASSWORD)
                .submitAuthData();
        logger.info("Invalid Login has been generated and filled in the login form with valid password");
    }
    public static void fillAuthDataWithValidCredentials() {
        LoginFormPage loginFormPage = new LoginFormPage();
        loginFormPage
                .fillLoginPasswordField(Constant.VALID_LOGIN, Constant.VALID_PASSWORD)
                .submitAuthData();
        logger.info("Valid credentials have been filled in the login form");
    }
    public static void checkErrorMessageLoginInvalidCredentials() {
        LoginFormPage loginFormPage = new LoginFormPage();
        String actualErrorMessageText = loginFormPage.getErrorMessageText();
        Assertions.assertEquals(Constant.LOGIN_FAILED_INVALID_CREDS_MESSAGE, actualErrorMessageText);
        logger.info("Authorization failed. User sees error message: \"{}\"",
                actualErrorMessageText);
    }
    public static void checkAuthorizationSuccess() {
        HomePage homePage = new HomePage();
        homePage.openPersonalAccountPage();
        PersonalAccountPage accountPage = new PersonalAccountPage();
            accountPage.getMyOffersTabLocatorTabText();
            Assertions.assertEquals(Constant.LOGIN_SUCCESS_TITLE, accountPage.getMyOffersTabLocatorTabText());
            logger.info("Authorization done");
    }
    public static void checkNeedLoginTitle() {
        LoginFormPage loginFormPage = new LoginFormPage();
         Assertions.assertEquals(Constant.LOGIN_NEEDED_TITLE, loginFormPage.getLogInTitleText());
         logger.info("User needs to authorize");
    }
    public static void logOut() {
        PersonalAccountPage personalAccountPage = new PersonalAccountPage();
        personalAccountPage.clickLogOut();
    }
}
