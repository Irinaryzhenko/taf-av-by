package ui.testing.steps;

import po.HomePage;
import po.SearchResultPage;

public class SearchSteps extends CommonSteps {
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
    }
}
