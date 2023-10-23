package domain.search;

public class SearchCarTestData {
    private static String carBrandRequestBody = "{\n" +
            "    \"page\": 1,\n" +
            "    \"properties\": [\n" +
            "        {\n" +
            "            \"name\": \"brands\",\n" +
            "            \"property\": 6,\n" +
            "            \"value\": [\n" +
            "                [\n" +
            "                    {\n" +
            "                        \"name\": \"brand\",\n" +
            "                        \"value\": 1444\n" +
            "                    }\n" +
            "                ]\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"price_currency\",\n" +
            "            \"value\": 2\n" +
            "        }\n" +
            "    ],\n" +
            "    \"sorting\": 1\n" +
            "}";
    private static String transmissionTypeRequestBody = "{\n" +
            "    \"page\": 1,\n" +
            "    \"properties\": [\n" +
            "        {\n" +
            "            \"name\": \"brands\",\n" +
            "            \"property\": 6,\n" +
            "            \"value\": [\n" +
            "                [\n" +
            "                    {\n" +
            "                        \"name\": \"brand\",\n" +
            "                        \"value\": 1\n" +
            "                    }\n" +
            "                ]\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"price_currency\",\n" +
            "            \"value\": 2\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"transmission_type\",\n" +
            "            \"value\": 1\n" +
            "        }\n" +
            "    ],\n" +
            "    \"sorting\": 1\n" +
            "}";
    private static String customTextRequestBody = "{\n" +
            "    \"page\": 1,\n" +
            "    \"properties\": [\n" +
            "        {\n" +
            "            \"name\": \"brands\",\n" +
            "            \"property\": 6,\n" +
            "            \"value\": [\n" +
            "                [\n" +
            "                    {\n" +
            "                        \"name\": \"brand\",\n" +
            "                        \"value\": 589\n" +
            "                    }\n" +
            "                ]\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"price_currency\",\n" +
            "            \"value\": 2\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"description\",\n" +
            "            \"value\": \"мультируль\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"sorting\": 1\n" +
            "}";
    private static String bodyTypeRequestBody = "{\n" +
            "    \"page\": 1,\n" +
            "    \"properties\": [\n" +
            "        {\n" +
            "            \"name\": \"price_currency\",\n" +
            "            \"value\": 2\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"body_type\",\n" +
            "            \"value\": [\n" +
            "                7\n" +
            "            ]\n" +
            "        }\n" +
            "    ],\n" +
            "    \"sorting\": 1\n" +
            "}";

    public static String getTransmissionTypeRequestBody() {
        return transmissionTypeRequestBody;
    }

    public static String getCarBrandRequestBody() {
        return carBrandRequestBody;
    }

    public static String getCustomTextRequestBody() {
        return customTextRequestBody;
    }

    public static String getBodyTypeRequestBody() {
        return bodyTypeRequestBody;
    }
}
