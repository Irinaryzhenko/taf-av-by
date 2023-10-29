package ui.testing.steps;

import domain.login.LoginTestData;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import po.HomePage;
import po.LoginFormPage;
import po.PersonalAccountPage;

public class LoginSteps {
    private static  HomePage homePage = new HomePage();;
    private static LoginFormPage loginFormPage = new LoginFormPage();
    private final static Logger logger = LoggerFactory.getLogger(LoginSteps.class);
    public static void openLoginFormViaEmail() {
        homePage.openLoginForm();
        loginFormPage.openLoginFormViaMail();
    }
    public static void fillAuthDataWithInvalidCredentials() {
        logger.info("Invalid creds have been generated and filled in login form");
        loginFormPage.fillLoginPasswordField(LoginTestData.generateLogin(),
                LoginTestData.generatePassword());
        loginFormPage.submitAuthData();
    }
    public static void fillAuthDataWithValidloginInvalidPassword() {
        logger.info("Invalid password has been generated , valid login has been filled in login form");
        loginFormPage.fillLoginPasswordField(LoginTestData.getValidLogin(),
                LoginTestData.generatePassword());
        loginFormPage.submitAuthData();
    }
    public static void fillAuthDataInvalidLoginValidPasswords() {
        logger.info("Invalid Login has been generated and filled in the login form with valid password");
        loginFormPage.fillLoginPasswordField(LoginTestData.generateLogin(),
                LoginTestData.getValidPassword());
        loginFormPage.submitAuthData();
    }
    public static void fillAuthDataWithValidCredentials() {
        logger.info("Valid credentials have been filled in the login form");
        loginFormPage.fillLoginPasswordField(LoginTestData.getValidLogin(),
                LoginTestData.getValidPassword());
        loginFormPage.submitAuthData();
    }
    public static void checkErrorMessageLoginInvalidCredentials() {
        String actualErrorMessageText = loginFormPage.getErrorMessageText();
        String expectedErrorMessageText = "Неверный логин или пароль. Если забыли пароль, восстановите его";
        Assertions.assertEquals(expectedErrorMessageText, actualErrorMessageText);
        logger.info("Error message:\"{}\" was checked and compare with expected query: \"{}\"",
                actualErrorMessageText, expectedErrorMessageText);
    }
    public static void checkAuthorizationSuccess() {
        homePage.openPersonalAccountPage();
        PersonalAccountPage accountPage = new PersonalAccountPage();
        accountPage.getMyOffersTabLocatorTabText();
        System.out.println(accountPage.getMyOffersTabLocatorTabText());
        Assertions.assertEquals("Мои объявления", accountPage.getMyOffersTabLocatorTabText());
        logger.info("Authorization done");
    }
    public static void checkNeedLoginTitle() {
         Assertions.assertEquals("Вход", loginFormPage.getLogInTitleText());
         logger.info("User needs to authorize");
    }
}
