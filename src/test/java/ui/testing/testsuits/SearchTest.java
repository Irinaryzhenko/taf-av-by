package ui.testing.testsuits;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.testing.steps.SearchSteps;

public class SearchTest extends BaseTest {
    @DisplayName("Check searching car Audi")
    @Test
    public void searchCarByPopularParams() {
        SearchSteps.openHomePageSubmitCookies();
        SearchSteps.selectCarBrand();
        SearchSteps.selectCarModel();
        SearchSteps.selectGeneration();
        SearchSteps.selectCarMadeYears();
        SearchSteps.inputCarPrice();
        SearchSteps.selectEngineCapacity();
        SearchSteps.submitSearch();
//        SearchSteps.checkTopCarSearchResult();
        SearchSteps.checkCarSearchResult();
    }
}
