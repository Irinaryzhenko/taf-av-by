package ui.testing.steps;

import domain.constant.Constant;
import driver.Driver;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import po.BusPage;
import po.HomePage;
import po.SearchResultPage;

public class SearchSteps extends CommonSteps {
    private final static Logger logger = LoggerFactory.getLogger(SearchSteps.class);
    private static HomePage homePage;


    public static void selectCarBrand() {
        homePage = new HomePage();
        homePage.openBrandDropDownMenu();
        homePage.selectCarBrand();
    }

    public static void selectBusBrand() {
        homePage = new HomePage();
        homePage.openBrandDropDownMenu();
        BusPage busPage = new BusPage();
        busPage.selectBusBrand();
    }

    public static void selectCarModel() {
        homePage.openModelDropDownMenu();
        homePage.selectCarModel();
    }

    public static void selectBusModel() {
        homePage.openModelDropDownMenu();
        BusPage busPage = new BusPage();
        busPage.selectBusModel();

    }

    public static void selectCarGeneration() {
        homePage.openCarGenerationDropDownMenu();
        homePage.selectCarGeneration();
    }

    public static void selectCarMadeYears() {
        homePage.openYearFromDropDown();
        homePage.selectCarYearFrom();
        homePage.openYearUntilDropDown();
        homePage.selectCarYearUntil();
    }

    public static void selectBusMadeYears() {
        homePage.openYearFromDropDown();
        homePage.selectBusYearFrom();
        homePage.openYearUntilDropDown();
        homePage.selectBusYearUntil();
    }

    public static void selectBusQuantityOfSeats() {
        BusPage busPage = new BusPage();
        busPage.openQuantitySetsFromDropDownMenu();
        busPage.selectQuantityOfSeatsFrom();
        busPage.openQuantitySetsUntilDropDownMenu();
        busPage.selectQuantityOfSeatsUntil();
    }

    public static void inputCarPrice() {
        homePage.inputPriceFrom("10000");
        homePage.inputPriceUntil("50000");
    }

    public static void inputBusPrice() {
        homePage.inputPriceFrom("5000");
        homePage.inputPriceUntil("30000");
    }

    public static void selectCarEngineCapacity() {
        homePage.openEngineCapacityFromDropDownMenu();
        homePage.selectEngineCapacityFrom();
        homePage.openEngineCapacityUntilDropDownMenu();
        homePage.selectEngineCapacityUntil();
    }

    public static void selectBusEngineCapacity() {
        BusPage busPage = new BusPage();
        busPage.openBusCapacityDropDownFrom();
        busPage.selectBusEngineCapacityFrom();
        busPage.openBusCapacityDropDownUntil();
        busPage.selectBusEngineCapacityUntil();
    }

    public static void selectTransmissionTypeMechanic() {
        BusPage busPage = new BusPage();
        busPage.selectMechanicTransmissionType();
    }

    public static void selectBusEngineType() {
        BusPage busPage = new BusPage();
        busPage.openEngineTypeDropDown();
        busPage.selectDiselEngine();
    }

    public static void selectBusMileage() {
        BusPage busPage = new BusPage();
        busPage.openMileageDropDown();
        busPage.selectMileage();
    }

    public static void submitSearch() {
        Driver.waitFor(2);
        homePage.submitSearchQuery();
    }

    public static void checkTopCarSearchResult() {
        logger.info("Checking top result");
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.getCarSearchTopResult();
        Assertions.assertTrue((searchResultPage.getActualTopTitle().contains(Constant.CAR_BRAND_SEARCH))
                        && searchResultPage.isTopPriceInRange() && searchResultPage.isTopYearInRange()
                        && searchResultPage.isTopCapacityInRange(),
                "Warning! Top Results do not match with search query!");
        logger.info("Top car is equal to search query");
    }

    public static void checkCarSearchResult() {
        logger.info("Checking result");
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.getCarTitleSearchResults();
        searchResultPage.getCarPriceSearchResult();
        searchResultPage.getCarSearchParamsText();
        Assertions.assertTrue((searchResultPage.getActualCarTitle().contains(Constant.CAR_BRAND_SEARCH))
                        && searchResultPage.isCarCapacityInRange() && searchResultPage.isCarPriceInRange()
                        && searchResultPage.isCarYearInRange(),
                "Warning! Search result don't match with request query!");
        logger.info("Cars are equal to search query. Searching was successfully ended.");
    }

    public static void checkBusSearchResult() {
        SearchResultPage busSearchResultPage = new SearchResultPage();
        Driver.waitFor(5);
        busSearchResultPage.getBusTitleSearchResults();
        busSearchResultPage.getBusPriceSearchResult();
        busSearchResultPage.getBusSearchParamsText();
        Assertions.assertTrue((busSearchResultPage.getActualBusTitle().contains(Constant.BUS_BRAND_SEARCH))
                        && busSearchResultPage.isBusPriceInRange()
                        && busSearchResultPage.isBusCapacityInRange()
                        && busSearchResultPage.isBusYearInRange()
                        && busSearchResultPage.isQuantityOfSeatsInRange()
                        && (busSearchResultPage.getActualBusTransmission().contains("механика"))
                        && (busSearchResultPage.getActualBusEngineType().contains("дизель")),
                "Warning! Search bus result don't match with request query!");
    }
}