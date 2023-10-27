package ui.testing.testsuits;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.testing.steps.VinCheckerSteps;

public class VinCheckerTest extends BaseTest {
    @DisplayName("Check VinChecker with valid vin code")
    @Test
    public void vinCheckerWithValidVinCode() {
        VinCheckerSteps.startIteration();
        VinCheckerSteps.inputValidVinCodeInChecker();
        VinCheckerSteps.checkValidVinCode();
    }

    @DisplayName("Check VinChecker with invalid number of characters of vin code")
    @Test
    public void vinCheckerWithInvalidNumberOfCharactersOfVinCode() {
        VinCheckerSteps.startIteration();
        VinCheckerSteps.inputInvalidNumberVinCodeInChecker();
        VinCheckerSteps.checkInvalidNumberVinCode();
    }

    @DisplayName("Check VinChecker with invalid format of characters of vin code")
    @Test
    public void vinCheckerWithInvalidFormatOfCharactersOfVinCode() {
        VinCheckerSteps.startIteration();
        VinCheckerSteps.inputInvalidFormatVinCode();
        VinCheckerSteps.checkInvalidFormatVinCode();
    }
}
