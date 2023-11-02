package api.testing.testsuits;

import domain.search.FinanceTestData;
import io.basc.framework.http.HttpStatus;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static domain.constant.Constant.CONTENT_TYPE_HEADER;
import static domain.constant.Constant.FINANCE_SEARCH_URL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FinanceTest {
    private final static Logger logger = LoggerFactory.getLogger(FinanceTest.class);

    @DisplayName("Check offer for credits")
    @Test
    public void checkCreditOffers() {
        int generalCreditQuantity = 18;
        given().body(FinanceTestData.getAllCreditOffersRequestBody())
                .header(CONTENT_TYPE_HEADER, ContentType.JSON)
                .when().post(FINANCE_SEARCH_URL)
                .then().statusCode(HttpStatus.OK.value())
                .assertThat().body("total", equalTo(generalCreditQuantity))
                .body("items[0].title", equalTo("Автомобиль с пробегом в лизинг"));
        logger.info("Sending POST request for checking credit quantity. Credit offer have been found, quantity: {}",
                generalCreditQuantity);
    }

    @DisplayName("Check offer for new car credits")
    @Test
    public void checkOffersForNewCarCredit() {
        int newCarCreditQuantity = 2;
        given().body(FinanceTestData.getNewCarCreditOfferRequestBody())
                .header((CONTENT_TYPE_HEADER), ContentType.JSON)
                .when().post(FINANCE_SEARCH_URL)
                .then().statusCode(HttpStatus.OK.value())
                .assertThat().body("total", equalTo(newCarCreditQuantity))
                .body("items[0].title", equalTo("На новый авто и с пробегом"));
        logger.info("Sending POST request for checking credit quantity. Credit offer for new cars have been found, quantity: {} ",
                newCarCreditQuantity);
    }

    @DisplayName("Check offer for truck credits")
    @Test
    public void checkOffersForTruckCredit() {
        int truckCreditQuantity = 7;
        given().body(FinanceTestData.getTruckCreditOfferRequestBody())
                .header(CONTENT_TYPE_HEADER, ContentType.JSON)
                .when().post(FINANCE_SEARCH_URL)
                .then().statusCode(HttpStatus.OK.value())
                .assertThat().body("total", equalTo(truckCreditQuantity))
                .body("items[0].title", equalTo("Кредит на любые цели. Полностью онлайн"));
        logger.info("Sending POST request for checking credit quantity. Credit offer for trucks have been found, quantity: {} ",
                truckCreditQuantity);
    }
}
