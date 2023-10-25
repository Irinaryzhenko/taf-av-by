package ui.testing.test_suits;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.testing.steps.LoginSteps;
import ui.testing.steps.NewOfferSteps;

public class AddNewOfferTest extends BaseTest {
    @DisplayName("Check adding new offer by non-authorized user")
    @Test
    public void addNewOfferByNonAuthUser() {
        LoginSteps.startIteration();
        NewOfferSteps.addNewOffer();
        LoginSteps.checkNeedLoginTitle();
    }

    @DisplayName("Check adding new offer by authorized user")
    @Test
    public void checkUserPossibilityToAddNewOffer() {
        LoginSteps.startIteration();
        LoginSteps.openLoginFormViaEmail();
        LoginSteps.fillAuthDataWithValidCreds();
        NewOfferSteps.addNewOffer();
        NewOfferSteps.checkPossibilityToAddOfferByAuthorizedUser();
    }
}
