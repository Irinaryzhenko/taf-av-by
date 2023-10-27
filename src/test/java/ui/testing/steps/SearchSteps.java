package ui.testing.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import po.HomePage;
import po.SearchResultPage;
import ui.testing.testsuits.SearchTest;

public class SearchSteps extends CommonSteps {
    private static final Logger logger = LogManager.getLogger(SearchSteps.class);
    private static HomePage homePage;
    private static SearchResultPage searchResultPage;

    public static void selectCarBrand() {
        homePage = new HomePage();
        homePage.openBrandDropDownMenu();
        homePage.selectCarBrand();
    }

    public static void selectCarModel() {
        homePage.openModelDropDownMenu();
        homePage.selectCarModel();
    }

    public static void selectGeneration() {
        homePage.openCarGenerationDropDownMenu();
        homePage.selectCarGeneration();
    }

    public static void selectCarMadeYears() {
        homePage.openYearFromDropDown();
        homePage.selectYearFrom();
        homePage.openYearUntilDropDown();
        homePage.selectYearUntil();
    }

    public static void inputCarPrice() {
        homePage.inputPriceFrom("10000");
        homePage.inputPriceUntil("50000");
    }

    public static void selectEngineCapacity() {
        homePage.openEngineCapacityFromDropDownMenu();
        homePage.selectEngineCapacityFrom();
        homePage.openEngineCapacityUntilDropDownMenu();
        homePage.selectEngineCapacityUntil();
    }

    public static void submitSearch() {
        homePage.submitSearchQuery();
    }

    public static void checkTopCarSearchResult() {
        searchResultPage = new SearchResultPage();
        searchResultPage.checkCarSearchTopResult();
    }

    public static void checkCarSearchResult() {
        searchResultPage.getCarTitleSearchResults();
        searchResultPage.getCarPriceSearchResult();
        searchResultPage.checkCarSearchParamsText();
        searchResultPage.checkCarSearchResult();
        logger.info("Search result has been got");
    }
}
