package api.testing.testsuits;

import io.basc.framework.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static domain.constant.Constant.*;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class OpenPagesTest {
    private final static Logger logger = LoggerFactory.getLogger(OpenPagesTest.class);
    @DisplayName("Check opening the Home page - status code")
    @Test
    public void checkStatusCodeHomePage() {
        when().get(HOME_URL)
                .then().log().status()
                .assertThat().statusCode(HttpStatus.OK.value());
        logger.info("Send GET-request. Home page opens");
    }

    @DisplayName("Check opening Vehicle page - status code")
    @Test
    public void checkStatusCodeCarPage() {
        when().get(VEHICLE_URL)
                .then().log().status()
                .assertThat().statusCode(HttpStatus.OK.value());
        logger.info("Send GET-request. Vehicle page opens");
    }

    @DisplayName("Check opening WheelsParts page - status code")
    @Test
    public void checkStatusCodeWheelsPartsPage() {
        when().get(WHEELS_PARTS_URL)
                .then().log().status()
                .assertThat().statusCode(HttpStatus.OK.value());
        logger.info("Send GET-request. WheelPart page opens");
    }

    @DisplayName("Check opening News page - status code")
    @Test
    public void checkStatusCodeNewsPage() {
        when().get(NEWS_URL)
                .then().log().status()
                .assertThat().statusCode(HttpStatus.OK.value());
        logger.info("Send GET-request. News page opens");
    }

    @DisplayName("Check opening Info page - status code")
    @Test
    public void checkStatusCodeInfoPage() {
        when().get(INFO_URL)
                .then().log().status()
                .assertThat().statusCode(HttpStatus.OK.value());
        logger.info("Send GET-request. Info page opens");
    }

    @DisplayName("Check opening Finance page - status code")
    @Test
    public void checkStatusCodeFinancePage() {
        when().get(FINANCE_URL)
                .then().log().status()
                .assertThat().statusCode(HttpStatus.OK.value());
        logger.info("Send GET-request. Finance page opens");
    }

    @DisplayName("Check opening VinChecker page - status code")
    @Test
    public void checkStatusCodeVinCheckerPage() {
        when().get(VEHICLE_URL)
                .then().log().status()
                .assertThat().statusCode(HttpStatus.OK.value());
        logger.info("Send GET-request.VinChecker page opens");
    }

    @DisplayName("Check Content Type of the Home page")
    @Test
    public void checkHomePageContentType() {
        when().get(HOME_URL)
                .then().log().headers()
                .assertThat().headers(CONTENT_TYPE_HEADER,
                        equalTo("text/html; charset=utf-8"));
        logger.info("Send GET-request. Home page content type is equals to expected");
    }
}
