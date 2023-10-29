package api.testing.testsuits;

import domain.search.FinanceTestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import domain.constant.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FinanceTest {
    private final static Logger logger = LoggerFactory.getLogger(FinanceTest.class);

    @DisplayName("Check offer for credits")
    @Test
    public void checkCreditOffers(){
        int generalCreditQuantity = 19;
                given().body(FinanceTestData.getAllCreditOffersRequestBody())
                        .header(Constant.getContentTypeHeader(), Constant.getContentType())
                .when().post(Constant.getFinanceSearchUrl())
                .then().statusCode(200)
                .assertThat().body("total", equalTo(generalCreditQuantity))
                .body("items[0].title", equalTo("Автомобиль с пробегом в лизинг"));
                logger.info("Credit offer have been found, quantity: {}", generalCreditQuantity);
    }
    @DisplayName("Check offer for new car credits")
    @Test
    public void checkOffersForNewCarCredit(){
        int newCarCreditQuantity = 2;
        given().body(FinanceTestData.getNewCarCreditOfferRequestBody())
                .header(Constant.getContentTypeHeader(), Constant.getContentType())
                .when().post(Constant.getFinanceSearchUrl())
                .then().statusCode(200)
                .assertThat().body("total", equalTo(newCarCreditQuantity))
                .body("items[0].title", equalTo("На новый авто и с пробегом"));
        logger.info("Credit offer for new cars have been found, quantity: {} ", newCarCreditQuantity);
    }
    @DisplayName("Check offer for truck credits")
    @Test
    public void checkOffersForTruckCredit(){
        int truckCreditQuantity = 7;
        given().body(FinanceTestData.getTruckCreditOfferRequestBody())
                .header(Constant.getContentTypeHeader(), Constant.getContentType())
                .when().post(Constant.getFinanceSearchUrl())
                .then().statusCode(200)
                .assertThat().body("total", equalTo(truckCreditQuantity))
                .body("items[0].title", equalTo("Кредит «Проще простого»"));
        logger.info("Credit offer for trucks have been found, quantity: {} ", truckCreditQuantity);
    }
}
