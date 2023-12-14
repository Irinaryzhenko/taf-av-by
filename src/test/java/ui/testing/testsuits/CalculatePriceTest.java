package ui.testing.testsuits;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import po.HomePage;
import ui.testing.steps.CalculationPriceSteps;

public class CalculatePriceTest extends BaseTest {
    @DisplayName("Check calculation of price")
    @Test
    public void checkCalculationPrice() {
        CalculationPriceSteps.openHomePageSubmitCookies();
        HomePage  homePage = new HomePage();
        homePage.openCalculatePriceFromVehicle();
        CalculationPriceSteps calculationPriceSteps = new CalculationPriceSteps();
        calculationPriceSteps.selectVehicleForCalculation();
        calculationPriceSteps.checkPriceResult();
    }
}
