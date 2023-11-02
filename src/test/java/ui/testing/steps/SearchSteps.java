package ui.testing.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import po.HomePage;
import po.SearchResultPage;

public class SearchSteps extends CommonSteps{
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

    public static void checkTopCarSearchResult() {    // закоментировано в связи с изменение результата поиска - отсуствие топовой машины
        logger.info("Checking top result");
        searchResultPage = new SearchResultPage();
        searchResultPage.checkCarSearchTopResult();
    }

    public static void checkCarSearchResult() {
//        SearchResultPage searchResultPage = new SearchResultPage();
        logger.info("Checking result");
        searchResultPage.getCarTitleSearchResults();
        searchResultPage.getCarPriceSearchResult();
        searchResultPage.checkCarSearchParamsText();
        searchResultPage.checkCarSearchResult();
    }
}
