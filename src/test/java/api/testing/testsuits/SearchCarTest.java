package api.testing.testsuits;

import domain.search.SearchCarTestData;
import io.basc.framework.http.HttpStatus;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static domain.constant.Constant.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class SearchCarTest {
    private final static Logger logger = LoggerFactory.getLogger(SearchCarTest.class);

    @DisplayName("Check searching any car without filters")
    @Test
    public void checkSearchingAnyCar() {
        when().get(SEARCH_ANY_CAR_URL).then().log().status()
                .assertThat().statusCode(HttpStatus.OK.value());
        logger.info("All cars are available for selecting");
    }

    @DisplayName("Check searching by brand - Acura")
    @Test
    public void searchingByCarBrand() {
                given().body(SearchCarTestData.getCarBrandRequestBody())
                .header(CONTENT_TYPE_HEADER, ContentType.JSON)
                .when().post(SEARCH_CAR_BY_FILTER_URL)
                .then().statusCode(HttpStatus.OK.value())
                .assertThat().body(SEARCH_RESULT_RESPONSE_KEY, equalTo(SEARCH_BY_BRAND_ACURA));
                logger.info("Selected car has been found by brand");
    }

    @DisplayName("Check searching by transmission type - automatic transmission")
    @Test
    public void searchingByTransmissionType() {
                given().body(SearchCarTestData.getTransmissionTypeRequestBody())
                .header(CONTENT_TYPE_HEADER,ContentType.JSON)
                .when().post(SEARCH_CAR_BY_FILTER_URL)
                .then().statusCode(HttpStatus.OK.value())
                .assertThat().body(SEARCH_RESULT_RESPONSE_KEY,
                                equalTo(SEARCH_BY_TRANSMISSION_TYPE_AUTOMATIC));
                logger.info("Car has been found by selected transmission type");
    }

    @DisplayName("Check searching by custom client's text in description. Search word - multiroule")
    @Test
    public void checkSearchingByCustomText() {
                given().body(SearchCarTestData.getCustomTextRequestBody())
                .header(CONTENT_TYPE_HEADER, ContentType.JSON)
                .when().post(SEARCH_CAR_BY_FILTER_URL)
                .then().statusCode(HttpStatus.OK.value())
                .assertThat().body(SEARCH_RESULT_RESPONSE_KEY,
                                equalTo(SEARCH_CUSTOM_TEXT_QUERY_MULTIROULE));
        logger.info("Car offer has been found by selected word in custom client text");
    }

    @DisplayName("Check searching by car body type - convertible")
    @Test
    public void checkSearchingByBodyType() {
                given().body(SearchCarTestData.getBodyTypeRequestBody())
                .header(CONTENT_TYPE_HEADER, ContentType.JSON)
                .when().post(SEARCH_CAR_BY_FILTER_URL)
                .then().statusCode(HttpStatus.OK.value())
                .assertThat().body(SEARCH_RESULT_RESPONSE_KEY, equalTo(SEARCH_BODY_TYPE_CONVERTIBLE));
        logger.info("Car has been found by selected body type");
    }
}
