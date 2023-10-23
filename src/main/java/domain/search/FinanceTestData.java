package domain.search;

public class FinanceTestData {
    private static String allCreditOffersRequestBody = "{\n" +
            "    \"category\": \"null\"\n" +
            "}";
    private static String newCarCreditOfferRequestBody = "{\n" +
            "    \"category\": \"new_cars\"\n" +
            "}";
    private static String truckCreditOfferRequestBody =  "{\n" +
            "    \"category\": \"truck\"\n" +
            "}";

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
