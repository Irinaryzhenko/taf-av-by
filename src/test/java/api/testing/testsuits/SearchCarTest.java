package api.testing.testsuits;

import domain.search.SearchCarTestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import domain.constant.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class SearchCarTest {
    private final static Logger logger = LoggerFactory.getLogger(SearchCarTest.class);

    @DisplayName("Check searching any car without filters")
    @Test
    public void checkSearchingAnyCar() {
        when().get(Constant.getSearchAnyCarUrl()).then().log().status()
                .assertThat().statusCode(200);
        logger.info("All cars are available for selecting");
    }

    @DisplayName("Check searching by brand - Acura")
    @Test
    public void searchingByCarBrand() {
                given().body(SearchCarTestData.getCarBrandRequestBody())
                .header(Constant.getContentTypeHeader(), Constant.getContentType())
                .when().post(Constant.getSearchCarByFilterUrl())
                .then().statusCode(200)
                .assertThat().body(Constant.getSearchResultResponseKey(), equalTo(Constant.getSearchByBrandAcura()));
                logger.info("Selected car has been found by brand");
    }

    @DisplayName("Check searching by transmission type - automatic transmission")
    @Test
    public void searchingByTransmissionType() {
                given().body(SearchCarTestData.getTransmissionTypeRequestBody())
                .header(Constant.getContentTypeHeader(), Constant.getContentType())
                .when().post(Constant.getSearchCarByFilterUrl())
                .then().statusCode(200)
                .assertThat().body(Constant.getSearchResultResponseKey(),
                                equalTo(Constant.getSearchByTransmissionTypeAutomatic()));
                logger.info("Car has been found by selected transmission type");
    }

    @DisplayName("Check searching by custom client's text in description. Search word - multiroule")
    @Test
    public void checkSearchingByCustomText() {
                given().body(SearchCarTestData.getCustomTextRequestBody())
                .header(Constant.getContentTypeHeader(), Constant.getContentType())
                .when().post(Constant.getSearchCarByFilterUrl())
                .then().statusCode(200)
                .assertThat().body(Constant.getSearchResultResponseKey(),
                                equalTo(Constant.getSearchCustomTextQueryMultiroule()));
        logger.info("Car offer has been found by selected word in custom client text");
    }

    @DisplayName("Check searching by car body type - convertible")
    @Test
    public void checkSearchingByBodyType() {
                given().body(SearchCarTestData.getBodyTypeRequestBody())
                .header(Constant.getContentTypeHeader(), Constant.getContentType())
                .when().post(Constant.getSearchCarByFilterUrl())
                .then().statusCode(200)
                .assertThat().body(Constant.getSearchResultResponseKey(), equalTo(Constant.getSearchBodyTypeConvertible()));
        logger.info("Car has been found by selected body type");
    }
}
