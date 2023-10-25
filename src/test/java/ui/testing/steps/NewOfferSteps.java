package ui.testing.steps;

import org.junit.jupiter.api.Assertions;
import po.HomePage;
import po.LoginFormPage;
import po.NewOfferPage;

public class NewOfferSteps extends CommonSteps {
    private static HomePage homePage = new HomePage();;
    private static LoginFormPage loginFormPage = new LoginFormPage();
    public static void addNewOffer() {
        homePage.clickAddNewOfferButton();
    }
    public static void checkPossibilityToAddOfferByAuthorizedUser() {
        NewOfferPage newOfferPage = new NewOfferPage();
        Assertions.assertEquals("Новое объявление", newOfferPage.getNewOfferTitleText());
    }
}
