package ui.testing.steps;

import domain.login.LoginRequestTestData;
import org.junit.jupiter.api.Assertions;
import po.HomePage;
import po.LoginFormPage;
import po.PersonalAccountPage;

public class LoginSteps extends CommonSteps {
    private static  HomePage homePage = new HomePage();;
    private static LoginFormPage loginFormPage = new LoginFormPage();
    public static void openLoginFormViaEmail() {
        homePage.openLoginForm();
        LoginFormPage loginFormPage = new LoginFormPage();
        loginFormPage.openLoginFormViaMail();
    }
    public static void fillAuthDataWithInvalidcreds() {

        loginFormPage.fillLoginPasswordField(LoginRequestTestData.generateLogin(),
                LoginRequestTestData.generatePassword());
        loginFormPage.submitAuthData();
    }
    public static void fillAuthDataWithValidloginInvalidPassword() {

        loginFormPage.fillLoginPasswordField(LoginRequestTestData.getValidLogin(),
                LoginRequestTestData.generatePassword());
        loginFormPage.submitAuthData();
    }
    public static void fillAuthDataInvalidLoginValidPasswors() {
        loginFormPage.fillLoginPasswordField(LoginRequestTestData.generateLogin(),
                LoginRequestTestData.getValidPassword());
        loginFormPage.submitAuthData();
    }
    public static void fillAuthDataWithValidCreds() {
        loginFormPage.fillLoginPasswordField(LoginRequestTestData.getValidLogin(),
                LoginRequestTestData.getValidPassword());
        loginFormPage.submitAuthData();
    }
    public static void checkErrorMessageLoginInvalidCreds() {
        String actualErrorMessageText = loginFormPage.getErrorMessageText();
        String expectedErrorMessageText = "Неверный логин или пароль. Если забыли пароль, восстановите его";
        Assertions.assertEquals(expectedErrorMessageText, actualErrorMessageText);
    }
    public static void checkAuthorizationSuccess() {
        homePage.openPersonalAccountPage();
        PersonalAccountPage accountPage = new PersonalAccountPage();
        accountPage.getMyOffersTabLocatorTabText();
        System.out.println(accountPage.getMyOffersTabLocatorTabText());
        Assertions.assertEquals("Мои объявления", accountPage.getMyOffersTabLocatorTabText());
    }
    public static void checkNeedLoginTitle() {
         Assertions.assertEquals("Вход", loginFormPage.getLogInTitleText());
    }
}
