package ui.testing.steps;

import domain.constant.Constant;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import po.HomePage;
import po.LoginFormPage;
import po.NewOfferPage;

public class NewOfferSteps extends CommonSteps {

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
        loginFormPage.fillLoginPasswordField(Constant.VALID_LOGIN, Constant.VALID_PASSWORD);
        loginFormPage.submitAuthData();
        try {
            NewOfferPage newOfferPage = new NewOfferPage();
            homePage.clickAddNewOfferButton();
            Assertions.assertEquals("Новое объявление", newOfferPage.getNewOfferTitleText());
            logger.info("New offer are ready to be created");
        } catch (Exception e) {
            logger.error("You have been banned. Don't joke with valid credentials!");
        }
    }
}
