package api.testing.testsuits;

import domain.search.FinanceTestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FinanceTest {
    private String financeSearchUrl = "https://api.av.by/finance/products/search";
    @DisplayName("Check offer for credits")
    @Test
    public void checkCreditOffers(){
                given().body(FinanceTestData.getAllCreditOffersRequestBody())
                        .header("Content-Type", "application/json")
                .when().post(financeSearchUrl)
                .then().statusCode(200)
                .assertThat().body("total", equalTo(19))
                .body("items[0].title", equalTo("Автомобиль с пробегом в лизинг"));
    }
    @DisplayName("Check offer for new car credits")
    @Test
    public void checkOffersForNewCarCredit(){

        given().body(FinanceTestData.getNewCarCreditOfferRequestBody())
                .header("Content-Type", "application/json")
                .when().post(financeSearchUrl)
                .then().statusCode(200)
                .assertThat().body("total", equalTo(2))
                .body("items[0].title", equalTo("На новый авто и с пробегом"));
    }
    @DisplayName("Check offer for truck credits")
    @Test
    public void checkOffersForTruckCredit(){

        given().body(FinanceTestData.getTruckCreditOfferRequestBody())
                .header("Content-Type", "application/json")
                .when().post(financeSearchUrl)
                .then().statusCode(200)
                .assertThat().body("total", equalTo(7))
                .body("items[0].title", equalTo("Кредит «Проще простого»"));
    }
}
