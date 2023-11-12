package ui.testing.steps;

import domain.constant.Constant;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import po.HomePage;
import po.SearchResultPage;

public class SearchSteps extends CommonSteps {
    private final static Logger logger = LoggerFactory.getLogger(SearchSteps.class);
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
        logger.info("Checking top result");
        searchResultPage = new SearchResultPage();
        searchResultPage.getCarSearchTopResult();
        Assertions.assertTrue((searchResultPage.getActualTopTitle().contains(Constant.CAR_BRAND_SEARCH))
                            && searchResultPage.isTopPriceInRange() && searchResultPage.isTopYearInRange()
                        && searchResultPage.isTopCapacityInRange(),
                    "Warning! Top Results do not match with search query!");
        logger.info("Top car is equal to search query");
    }

    public static void checkCarSearchResult() {
        logger.info("Checking result");
        searchResultPage.getCarTitleSearchResults();
        searchResultPage.getCarPriceSearchResult();
        searchResultPage.getCarSearchParamsText();
        Assertions.assertTrue((searchResultPage.getActualTitle().contains(Constant.CAR_BRAND_SEARCH))
                        && searchResultPage.isCapacityInRange() && searchResultPage.isPriceInRange()
                        && searchResultPage.isYearInRange(),
                "Warning! Search result don't match with request query!");
        logger.info("Cars are equal to search query. Searching was successfully ended.");
    }
}