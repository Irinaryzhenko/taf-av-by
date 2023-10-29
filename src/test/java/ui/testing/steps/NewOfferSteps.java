package ui.testing.steps;

import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import po.HomePage;
import po.LoginFormPage;
import po.NewOfferPage;

public class NewOfferSteps {
    private static HomePage homePage = new HomePage();;
    private static LoginFormPage loginFormPage = new LoginFormPage();
    private final static Logger logger = LoggerFactory.getLogger(NewOfferSteps.class);
    public static void addNewOffer() {
        homePage.clickAddNewOfferButton();
    }
    public static void checkPossibilityToAddOfferByAuthorizedUser() {
        logger.info("New offer are ready to be created");
        NewOfferPage newOfferPage = new NewOfferPage();
        Assertions.assertEquals("Новое объявление", newOfferPage.getNewOfferTitleText());
    }
}
