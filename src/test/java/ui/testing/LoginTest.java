package ui.testing;

import org.junit.jupiter.api.Assertions;
import po.LoginFormPage;
import po.PersonalAccountPage;
import domain.login.LoginRequestTestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import po.HomePage;

public class LoginTest extends BaseTest{
    @DisplayName("Check login with invalid credentials")
    @Test
    public void loginWithInvalidCredentials() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        try {
            homePage.submitCookies();
        } catch (Exception e) {
        };
        homePage.openLoginForm();
        LoginFormPage loginFormPage = new LoginFormPage();
        loginFormPage.openLoginFormViaMail();
        loginFormPage.fillLoginPasswordField(LoginRequestTestData.generateLogin(), LoginRequestTestData.generatePassword());
        loginFormPage.submitAuthData();
        String actualErrorMessageText = loginFormPage.getErrorMessageText();
        String expectedErrorMessageText = "Неверный логин или пароль. Если забыли пароль, восстановите его";
        Assertions.assertEquals(expectedErrorMessageText, actualErrorMessageText);
    }
    @DisplayName("Check login with valid login and invalid password")
    @Test
    public void loginWithValidLoginInvalidPassword() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        try {
            homePage.submitCookies();
        } catch (Exception e) {
        };
        homePage.openLoginForm();
        LoginFormPage loginFormPage = new LoginFormPage();
        loginFormPage.openLoginFormViaMail();
        loginFormPage.fillLoginPasswordField(LoginRequestTestData.getValidLogin(), LoginRequestTestData.generatePassword());
        loginFormPage.submitAuthData();
        String actualErrorMessageText = loginFormPage.getErrorMessageText();
        String expectedErrorMessageText = "Неверный логин или пароль. Если забыли пароль, восстановите его";
        Assertions.assertEquals(expectedErrorMessageText, actualErrorMessageText);
    }
    @DisplayName("Check login with invalid login and valid password")
    @Test
    public void loginWithInvalidLoginValidPassword() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        try {
            homePage.submitCookies();
        } catch (Exception e) {
        };
        homePage.openLoginForm();
        LoginFormPage loginFormPage = new LoginFormPage();
        loginFormPage.openLoginFormViaMail();
        loginFormPage.fillLoginPasswordField(LoginRequestTestData.generateLogin(), LoginRequestTestData.getValidPassword());
        loginFormPage.submitAuthData();
        String actualErrorMessageText = loginFormPage.getErrorMessageText();
        String expectedErrorMessageText = "Неверный логин или пароль. Если забыли пароль, восстановите его";
        Assertions.assertEquals(expectedErrorMessageText, actualErrorMessageText);
    }

    @DisplayName("Check login with valid credentials")
    @Test
    public void loginWithValidCredentials() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        try {
            homePage.submitCookies();
        } catch (Exception e) {
        };
        homePage.openLoginForm();
        LoginFormPage loginFormPage = new LoginFormPage();
        loginFormPage.openLoginFormViaMail();
        loginFormPage.fillLoginPasswordField(LoginRequestTestData.getValidLogin(), LoginRequestTestData.getValidPassword());
        loginFormPage.submitAuthData();
        homePage.openPersonalAccountPage();
        PersonalAccountPage accountPage = new PersonalAccountPage();
        accountPage.getMyOffersTabLocatorTabText();
        System.out.println(accountPage.getMyOffersTabLocatorTabText());
        Assertions.assertEquals("Мои объявления", accountPage.getMyOffersTabLocatorTabText());
    }
}
