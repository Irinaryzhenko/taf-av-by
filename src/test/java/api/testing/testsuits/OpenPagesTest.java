package api.testing.testsuits;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class OpenPagesTest {
    @DisplayName("Check opening the Home page - status code")
    @Test
    public void checkStatusCodeHomePage() {
        when().get("https://av.by/")
                .then().log().status()
                .assertThat().statusCode(200);
    }

    @DisplayName("Check opening Venicle page - status code")
    @Test
    public void checkStatusCodeCarPage() {
        when().get("https://cars.av.by/")
                .then().log().status()
                .assertThat().statusCode(200);
    }

    @DisplayName("Check opening WheelsParts page - status code")
    @Test
    public void checkStatusCodeWheelsPartsPage() {
        when().get("https://parts.av.by/")
                .then().log().status()
                .assertThat().statusCode(200);
    }

    @DisplayName("Check opening News page - status code")
    @Test
    public void checkStatusCodeNewsPage() {
        when().get("https://av.by/news")
                .then().log().status()
                .assertThat().statusCode(200);
    }

    @DisplayName("Check opening Info page - status code")
    @Test
    public void checkStatusCodeInfoPage() {
        when().get("https://av.by/pages/info")
                .then().log().status()
                .assertThat().statusCode(200);
    }

    @DisplayName("Check opening Finance page - status code")
    @Test
    public void checkStatusCodeFinancePage() {
        when().get("https://av.by/finance")
                .then().log().status()
                .assertThat().statusCode(200);
    }

    @DisplayName("Check opening VinChecker page - status code")
    @Test
    public void checkStatusCodeVinCheckerPage() {
        when().get("https://av.by/vin")
                .then().log().status()
                .assertThat().statusCode(200);
    }

    @DisplayName("Check Content Type of the Home page")
    @Test
    public void checkHomePageContentType() {
        when().get("https://av.by/")
                .then().log().headers()
                .assertThat().headers("Content-Type", equalTo("text/html; charset=utf-8"));
    }
}
