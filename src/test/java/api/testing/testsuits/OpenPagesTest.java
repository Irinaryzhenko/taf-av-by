package api.testing.testsuits;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import domain.constant.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class OpenPagesTest {
    private final static Logger logger = LoggerFactory.getLogger(OpenPagesTest.class);
    @DisplayName("Check opening the Home page - status code")
    @Test
    public void checkStatusCodeHomePage() {
        when().get(Constant.getHomeUrl())
                .then().log().status()
                .assertThat().statusCode(200);
        logger.info("Home page opens");
    }

    @DisplayName("Check opening Vehicle page - status code")
    @Test
    public void checkStatusCodeCarPage() {
        when().get(Constant.getVehicleUrl())
                .then().log().status()
                .assertThat().statusCode(200);
        logger.info("Vehicle page opens");
    }

    @DisplayName("Check opening WheelsParts page - status code")
    @Test
    public void checkStatusCodeWheelsPartsPage() {
        when().get(Constant.getWheelsPartsUrl())
                .then().log().status()
                .assertThat().statusCode(200);
        logger.info("WheelPart page opens");
    }

    @DisplayName("Check opening News page - status code")
    @Test
    public void checkStatusCodeNewsPage() {
        when().get(Constant.getNewsUrl())
                .then().log().status()
                .assertThat().statusCode(200);
        logger.info("News page opens");
    }

    @DisplayName("Check opening Info page - status code")
    @Test
    public void checkStatusCodeInfoPage() {
        when().get(Constant.getInfoUrl())
                .then().log().status()
                .assertThat().statusCode(200);
        logger.info("Info page opens");
    }

    @DisplayName("Check opening Finance page - status code")
    @Test
    public void checkStatusCodeFinancePage() {
        when().get(Constant.getFinanceUrl())
                .then().log().status()
                .assertThat().statusCode(200);
        logger.info("Finance page opens");
    }

    @DisplayName("Check opening VinChecker page - status code")
    @Test
    public void checkStatusCodeVinCheckerPage() {
        when().get(Constant.getVinCheckerUrl())
                .then().log().status()
                .assertThat().statusCode(200);
        logger.info("Vinchecker page opens");
    }

    @DisplayName("Check Content Type of the Home page")
    @Test
    public void checkHomePageContentType() {
        when().get(Constant.getHomeUrl())
                .then().log().headers()
                .assertThat().headers(Constant.getContentTypeHeader(),
                        equalTo("text/html; charset=utf-8"));
        logger.info("Home page content type is equals to expected");
    }
}
