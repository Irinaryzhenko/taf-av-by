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
        logger.info("Invalid creds have been generated and filled in login form");
        loginFormPage.fillLoginPasswordField(faker.internet().emailAddress(),
                faker.internet().password());
        loginFormPage.submitAuthData();
    }
    public static void fillAuthDataWithValidloginInvalidPassword() {
        LoginFormPage loginFormPage = new LoginFormPage();
        logger.info("Invalid password has been generated , valid login has been filled in login form");
        loginFormPage.fillLoginPasswordField(Constant.VALID_LOGIN,
                faker.internet().password());
        loginFormPage.submitAuthData();
    }
    public static void fillAuthDataInvalidLoginValidPasswords() {
        LoginFormPage loginFormPage = new LoginFormPage();
        logger.info("Invalid Login has been generated and filled in the login form with valid password");
        loginFormPage.fillLoginPasswordField(faker.internet().emailAddress(),
                Constant.VALID_PASSWORD);
        loginFormPage.submitAuthData();
    }
    public static void fillAuthDataWithValidCredentials() {
        LoginFormPage loginFormPage = new LoginFormPage();
        logger.info("Valid credentials have been filled in the login form");
        loginFormPage.fillLoginPasswordField(Constant.VALID_LOGIN,
                Constant.VALID_PASSWORD);
        loginFormPage.submitAuthData();
    }
    public static void checkErrorMessageLoginInvalidCredentials() {
        LoginFormPage loginFormPage = new LoginFormPage();
        String actualErrorMessageText = loginFormPage.getErrorMessageText();
        String expectedErrorMessageText = "Неверный логин или пароль. Если забыли пароль, восстановите его";
        Assertions.assertEquals(expectedErrorMessageText, actualErrorMessageText);
        logger.info("Error message:\"{}\" was checked and compare with expected query: \"{}\"",
                actualErrorMessageText, expectedErrorMessageText);
    }
    public static void checkAuthorizationSuccess() {
        HomePage homePage = new HomePage();
        homePage.openPersonalAccountPage();
        PersonalAccountPage accountPage = new PersonalAccountPage();
        accountPage.getMyOffersTabLocatorTabText();
        System.out.println(accountPage.getMyOffersTabLocatorTabText());
        Assertions.assertEquals("Мои объявления", accountPage.getMyOffersTabLocatorTabText());
        logger.info("Authorization done");
    }
    public static void checkNeedLoginTitle() {
        LoginFormPage loginFormPage = new LoginFormPage();
         Assertions.assertEquals("Вход", loginFormPage.getLogInTitleText());
         logger.info("User needs to authorize");
    }
}
