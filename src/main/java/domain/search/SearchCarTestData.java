package domain.search;

public class SearchCarTestData {
    private static String carBrandRequestBody = """
            {
                "page": 1,
                "properties": [
                    {
                        "name": "brands",
                        "property": 6,
                        "value": [
                            [
                                {
                                    "name": "brand",
                                    "value": 1444
                                }
                            ]
                        ]
                    },
                    {
                        "name": "price_currency",
                        "value": 2
                    }
                ],
                "sorting": 1
            }""";
    private static String transmissionTypeRequestBody = """
            {
                "page": 1,
                "properties": [
                    {
                        "name": "brands",
                        "property": 6,
                        "value": [
                            [
                                {
                                    "name": "brand",
                                    "value": 1
                                }
                            ]
                        ]
                    },
                    {
                        "name": "price_currency",
                        "value": 2
                    },
                    {
                        "name": "transmission_type",
                        "value": 1
                    }
                ],
                "sorting": 1
            }""";
    private static String customTextRequestBody = """
            {
                "page": 1,
                "properties": [
                    {
                        "name": "brands",
                        "property": 6,
                        "value": [
                            [
                                {
                                    "name": "brand",
                                    "value": 589
                                }
                            ]
                        ]
                    },
                    {
                        "name": "price_currency",
                        "value": 2
                    },
                    {
                        "name": "description",
                        "value": "мультируль"
                    }
                ],
                "sorting": 1
            }""";
    private static String bodyTypeRequestBody = """
            {
                "page": 1,
                "properties": [
                    {
                        "name": "price_currency",
                        "value": 2
                    },
                    {
                        "name": "body_type",
                        "value": [
                            7
                        ]
                    }
                ],
                "sorting": 1
            }""";

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
