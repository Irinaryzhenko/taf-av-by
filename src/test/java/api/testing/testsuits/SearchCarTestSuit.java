package api.testing;

import api.testing.utils.search.SearchCarTestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class SearchCarTestSuit {
    private String searchCarWithFilterUrl = "https://api.av.by/offer-types/cars/filters/main/apply";
    private String searchResultResponseKey = "seo.canonicalPage.url";
    @DisplayName("Check searching any car without filtres")
    @Test
    public void checkSearchingAnyCar() {
        when().get("https://cars.av.by/filter").then().log().status()
                .assertThat().statusCode(200);
    }

    @DisplayName("Check searching by brand")
    @Test
    public void searchingByCarBrand() {
        String searchingCar = "https://cars.av.by/acura";
        given().body(SearchCarTestData.getCarBrandRequestBody())
                .header("Content-Type", "application/json")
                .when().post(searchCarWithFilterUrl)
                .then().statusCode(200)
                .assertThat().body(searchResultResponseKey, equalTo(searchingCar));
    }

    @DisplayName("Check searching by transmission type")
    @Test
    public void searchingByTransmissionType() {
        String searchingTransmissionType = "https://cars.av.by/filter?brands[0][brand]=1&transmission_type=1";
        given().body(SearchCarTestData.getTransmissionTypeRequestBody())
                .header("Content-Type", "application/json")
                .when().post(searchCarWithFilterUrl)
                .then().statusCode(200)
                .assertThat().body(searchResultResponseKey, equalTo(searchingTransmissionType));
    }

    @DisplayName("Check searching by custom client's text in discription")
    @Test
    public void checkSearchingByCustomText() {
        String searchingCustomText = "https://cars.av.by/filter?brands[0][brand]=589&description=%D0%BC%D1%83%D0%BB%D1%8C%D1%82%D0%B8%D1%80%D1%83%D0%BB%D1%8C";
        given().body(SearchCarTestData.getCustomTextRequestBody())
                .header("Content-Type", "application/json")
                .when().post(searchCarWithFilterUrl)
                .then().statusCode(200)
                .assertThat().body( searchResultResponseKey, equalTo(searchingCustomText));
    }

    @DisplayName("Check searching by car body type")
    @Test
    public void checkSearchingByBodyType() {
        String serchingBodyType = "https://cars.av.by/filter?body_type[0]=7";
        given().body(SearchCarTestData.getBodyTypeRequestBody()).header("Content-Type", "application/json")
                .when().post(searchCarWithFilterUrl)
                .then().statusCode(200)
                .assertThat().body( searchResultResponseKey, equalTo(serchingBodyType));
    }
}
