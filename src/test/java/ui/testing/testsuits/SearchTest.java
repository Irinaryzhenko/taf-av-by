package ui.testing.testsuits;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import po.HomePage;
import ui.testing.steps.SearchSteps;

public class SearchTest extends BaseTest {
    @DisplayName("Check searching car Audi")
    @Test
    public void searchCarByPopularParams() {
        SearchSteps.openHomePageSubmitCookies();
        SearchSteps.selectCarBrand();
        SearchSteps.selectCarModel();
        SearchSteps.selectCarGeneration();
        SearchSteps.selectCarMadeYears();
        SearchSteps.inputCarPrice();
        SearchSteps.selectCarEngineCapacity();
        SearchSteps.submitSearch();
        SearchSteps.checkTopCarSearchResult();
        SearchSteps.checkCarSearchResult();
    }
    @DisplayName("Check searching Bus")
    @Test
    public void searchBusByParams() {
        SearchSteps.openHomePageSubmitCookies();
        HomePage homePage = new HomePage();
        homePage.openBusSearchPageFromVehicle();
        SearchSteps.selectBusBrand();
        SearchSteps.selectBusModel();
        SearchSteps.selectBusMadeYears();
        SearchSteps.selectBusQuantityOfSeats();
        SearchSteps.inputBusPrice();
        SearchSteps.selectBusEngineCapacity();
        SearchSteps.selectTransmissionTypeMechanic();
        SearchSteps.selectBusEngineType();
        SearchSteps.selectBusMileage();
        SearchSteps.submitSearch();
        SearchSteps.checkBusSearchResult();
    }
}
