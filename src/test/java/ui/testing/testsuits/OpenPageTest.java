package ui.testing.testsuits;

import domain.constant.Constant;
import org.slf4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.slf4j.LoggerFactory;
import po.*;
import org.junit.jupiter.api.Test;
import ui.testing.steps.OpenPageSteps;


public class OpenPageTest extends BaseTest {
    private final static Logger logger = LoggerFactory.getLogger(OpenPageTest.class);

    @DisplayName("Check home page opening")
    @Test
    public void openHomePageTest() {
        OpenPageSteps.openHomePageSubmitCookies();
        HomePage homePage = new HomePage();
        Assertions.assertEquals(Constant.HOME_PAGE_COPYRIGHT,
                homePage.getCopyrightText());
        logger.info("Home page opens");
    }

    @DisplayName("Check Finance Page opening")
    @Test
    public void openFinancePageTest() {
        OpenPageSteps.openHomePageSubmitCookies();
        HomePage homePage = new HomePage();
        homePage.openFinancePage();
        FinancePage financePage = new FinancePage();
        Assertions.assertEquals(Constant.FINANCE_TITLE,
                financePage.getFinanceTitleText());
        logger.info("Finance page opens");
    }

    @DisplayName("Check Vehicle Page opening")
    @Test
    public void openVehiclePageTest() {
        OpenPageSteps.openHomePageSubmitCookies();
        HomePage homePage = new HomePage();
        homePage.openTransportPage();
        VehiclePage transportPage = new VehiclePage();
        Assertions.assertEquals(Constant.VEHICLE_TITLE,
                transportPage.getTransportTitleText());
        logger.info("Vehicle page opens");
    }
    @DisplayName("Check Part Page opening")
    @Test
    public void openPartPageTest() {
        OpenPageSteps.openHomePageSubmitCookies();
        HomePage homePage = new HomePage();
        homePage.openPartPage();
        PartPage partPage = new PartPage();
        Assertions.assertEquals(Constant.PART_TITLE,
                partPage.getPartTitlePageText());
        logger.info("Part page opens");
    }
    @DisplayName("Check News Page opening")
    @Test
    public void openNewsPageTest() {
        OpenPageSteps.openHomePageSubmitCookies();
        HomePage homePage = new HomePage();
        homePage.openNewsPage();
        NewsPage newsPage = new NewsPage();
        Assertions.assertEquals(Constant.NEWS_TITLE,
                newsPage.getNewsTitleText());
        logger.info("News page opens");
    }
    @DisplayName("Check Info Page opening")
    @Test
    public void openInfoPageTest() {
        OpenPageSteps.openHomePageSubmitCookies();
        HomePage homePage = new HomePage();
        homePage.openInfoPage();
        InfoPage infoPage = new InfoPage();
        Assertions.assertEquals(Constant.INFO_TITLE, infoPage.getInfoPageTitleText());
        logger.info("Info page opens");
    }
    @DisplayName("Check VinChecker opening")
    @Test
    public void openVinCheckPageTest() {
       OpenPageSteps.openHomePageSubmitCookies();
       HomePage homePage = new HomePage();
        homePage.openVinCheckPage();
        VinCheckPage vinCheckPage = new VinCheckPage();
        Assertions.assertEquals(Constant.VIN_TITLE,
                vinCheckPage.getVinCheckPageTitleText());
        logger.info("VinChecker page opens");
    }

    @DisplayName("Check bus page opens")
    @Test
    public void openBusPageTest() {
            OpenPageSteps.openHomePageSubmitCookies();
            HomePage homePage = new HomePage();
            homePage.openBusSearchPageFromVehicle();
            VehiclePage vehiclePage = new VehiclePage();
            Assertions.assertEquals(Constant.BUS_PAGE_TITLE_TEXT, vehiclePage.getBusPageTitleText());
            logger.info("Bus page is opened");
        }
}
