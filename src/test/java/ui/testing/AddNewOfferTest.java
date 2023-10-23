package ui.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import po.HomePage;
import po.LoginFormPage;
import po.NewOfferPage;
import utils.login.LoginRequestTestData;

public class AddNewOfferTest extends BaseTest {
    @DisplayName("Check adding new offer by non-authorized user")
    @Test
    public void addNewOfferByNonAuthUser() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        homePage.clickAddNewOfferButton();
        LoginFormPage loginFormPage = new LoginFormPage();
        Assertions.assertEquals("Вход", loginFormPage.getLogInTitleText());
    }

    @DisplayName("Check adding new offer by authorized user")
    @Test
    public void checkUserPossibilityToAddNewOffer() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        try {
            homePage.submitCookies();
        } catch (Exception e) {
        }
        ;
        homePage.openLoginForm();
        LoginFormPage loginFormPage = new LoginFormPage();
        loginFormPage.openLoginFormViaMail();
        loginFormPage.fillLoginPasswordField(LoginRequestTestData.getValidLogin(), LoginRequestTestData.getValidPassword());
        loginFormPage.submitAuthData();
        homePage.clickAddNewOfferButton();
        NewOfferPage newOfferPage = new NewOfferPage();
        Assertions.assertEquals("Новое объявление", newOfferPage.getNewOfferTitleText());
    }
}
