package ui.testing.steps;

import domain.login.LoginTestData;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import po.HomePage;
import po.LoginFormPage;
import po.NewOfferPage;

public class NewOfferSteps extends CommonSteps{

    private final static Logger logger = LoggerFactory.getLogger(NewOfferSteps.class);
    public static void addNewOffer() {
        HomePage homePage = new HomePage();
         openHomePageSubmitCookies();
         homePage.clickAddNewOfferButton();
    }
    public static void checkPossibilityToAddOfferByAuthorizedUser() {
        HomePage homePage = new HomePage();
        openHomePageSubmitCookies();
        homePage.openLoginForm();
        LoginFormPage loginFormPage = new LoginFormPage();
        loginFormPage.openLoginFormViaMail();
        loginFormPage.fillLoginPasswordField(LoginTestData.getValidLogin(), LoginTestData.getValidPassword());
        loginFormPage.submitAuthData();
        NewOfferPage newOfferPage = new NewOfferPage();
        homePage.clickAddNewOfferButton();
        Assertions.assertEquals("Новое объявление", newOfferPage.getNewOfferTitleText());
        logger.info("New offer are ready to be created");
    }
}
