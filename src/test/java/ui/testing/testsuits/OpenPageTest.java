package ui.testing.testsuits;

import org.slf4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.slf4j.LoggerFactory;
import po.*;
import org.junit.jupiter.api.Test;


public class OpenPageTest extends BaseTest {
    private final static Logger logger = LoggerFactory.getLogger(OpenPageTest.class);

    @DisplayName("Check home page opening")
    @Test
    public void openHomePageTest() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        Assertions.assertEquals("© 2001, ООО «Автоклассифайд», УНП 192787977, Минск, ул. Кутузова, 15",
                homePage.getCopyrightText());
        logger.info("Home page opens");
    }

    @DisplayName("Check Finance Page opening")
    @Test
    public void openFinancePageTest() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        homePage.openFinancePage();
        FinancePage financePage = new FinancePage();
        Assertions.assertEquals("Кредиты и лизинг на покупку транспорта и комплектующих",
                financePage.getFinanceTitleText());
        logger.info("Finance page opens");
    }

    @DisplayName("Check Vehicle Page opening")
    @Test
    public void openVehiclePageTest() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        homePage.openTransportPage();
        VehiclePage transportPage = new VehiclePage();
        Assertions.assertEquals("Объявления о продаже автомобилей с пробегом в Беларуси",
                transportPage.getTransportTitleText());
        logger.info("Vehicle page opens");
    }
    @DisplayName("Check Part Page opening")
    @Test
    public void openPartPageTest() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        homePage.openPartPage();
        PartPage partPage = new PartPage();
        Assertions.assertEquals("Продажа запчастей новых и б/у в Беларуси",
                partPage.getPartTitlePageText());
        logger.info("Part page opens");
    }
    @DisplayName("Check News Page opening")
    @Test
    public void openNewsPageTest() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        homePage.openNewsPage();
        NewsPage newsPage = new NewsPage();
        Assertions.assertEquals("Пишем про авторынок в Беларуси, делаем обзоры, интервью и помогаем людям выбирать себе автомобили",
                newsPage.getNewsTitleText());
        logger.info("News page opens");
    }
    @DisplayName("Check Info Page opening")
    @Test
    public void openInfoPageTest() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        homePage.openInfoPage();
        InfoPage infoPage = new InfoPage();
        Assertions.assertEquals("Знания", infoPage.getInfoPageTitleText());
        logger.info("Info page opens");
    }
    @DisplayName("Check VinChecker opening")
    @Test
    public void openVinCheckPageTest() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        homePage.openVinCheckPage();
        VinCheckPage vinCheckPage = new VinCheckPage();
        Assertions.assertEquals("Проверка истории транспорта по VIN",
                vinCheckPage.getVinCheckPageTitleText());
        logger.info("VinChecker page opens");
    }
}
