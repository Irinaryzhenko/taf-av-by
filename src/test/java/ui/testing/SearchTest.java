package ui.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import po.HomePage;

public class SearchTest extends BaseTest {
    @DisplayName("Check searching car Audi")
    @Test
    public void searchCar() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        homePage.submitCookies();
        homePage.openBrandDropDownMenu();
        homePage.selectCarBrand();
        homePage.openModelDropDownMenu();
        homePage.selectCarModel();
        homePage.openCarGenerationDropDownMenu();
        homePage.selectCarGeneration();
        homePage.openYearFromDropDown();
        homePage.selectYearFrom();
        homePage.openYearUntilDropDown();
        homePage.selectYearUntil();
        homePage.inputPriceFrom("10000");
        homePage.inputPriceUntil("50000");
        homePage.openEngineCapacityFromDropDownMenu();
        homePage.selectEngineCapacityFrom();
        homePage.openEngineCapacityUntilDropDownMenu();
        homePage.selectEngineCapacityUntil();
        homePage.submitSearchQuery();
    }


}
