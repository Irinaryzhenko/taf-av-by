package domain.search;

public class FinanceTestData {
    private static String allCreditOffersRequestBody = """
            {
                "category": "null"
            }""";
    private static String newCarCreditOfferRequestBody = """
            {
                "category": "new_cars"
            }""";
    private static String truckCreditOfferRequestBody = """
            {
                "category": "truck"
            }""";

    public static String getTruckCreditOfferRequestBody() {
        return truckCreditOfferRequestBody;
    }

    public static String getNewCarCreditOfferRequestBody() {
        return newCarCreditOfferRequestBody;
    }

    public static String getAllCreditOffersRequestBody() {
        return allCreditOffersRequestBody;
    }
}
