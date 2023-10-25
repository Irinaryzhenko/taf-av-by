package ui.testing.test_suits;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.testing.steps.SearchSteps;

public class SearchTest extends BaseTest {
    @DisplayName("Check searching car Audi")
    @Test
    public void searchCarByPopularParams() {
        SearchSteps.startIteration();
        SearchSteps.selectCarBrand();
        SearchSteps.selectCarModel();
        SearchSteps.selectGeneration();
        SearchSteps.selectCarMadeYears();
        SearchSteps.inputCarPrice();
        SearchSteps.selectEngineCapacity();
        SearchSteps.submitSearch();
        SearchSteps.checkTopResult();
        SearchSteps.checkCarSearchResult();
    }
}
