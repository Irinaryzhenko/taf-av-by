package domain.constant;

public class Constant {
    private final static String LOGIN_URL = "https://api.av.by/auth/login/sign-in";
    private final static String CONTENT_TYPE = "application/json";
    private final static String CONTENT_TYPE_HEADER = "Content-Type";
    private final static String SEARCH_ANY_CAR_URL = "https://cars.av.by/filter";
    private final static String SEARCH_CAR_BY_FILTER_URL = "https://api.av.by/offer-types/cars/filters/main/apply";
    private final static String SEARCH_RESULT_RESPONSE_KEY = "seo.canonicalPage.url";
    private final static String SEARCH_CUSTOM_TEXT_QUERY_MULTIROULE = "https://cars.av.by/filter?brands[0][brand]=589&description=%D0%BC%D1%83%D0%BB%D1%8C%D1%82%D0%B8%D1%80%D1%83%D0%BB%D1%8C";
    private final static String SEARCH_BODY_TYPE_CONVERTIBLE = "https://cars.av.by/filter?body_type[0]=7";
    private final static String SEARCH_BY_BRAND_ACURA = "https://cars.av.by/acura";
    private final static  String SEARCH_BY_TRANSMISSION_TYPE_AUTOMATIC = "https://cars.av.by/filter?brands[0][brand]=1&transmission_type=1";
    private final static String FINANCE_SEARCH_URL = "https://api.av.by/finance/products/search";
    private final static String HOME_URL = "https://av.by/";
    private final static String VEHICLE_URL = "https://cars.av.by/";
    private final static String WHEELS_PARTS_URL = "https://parts.av.by/";
    private final static String NEWS_URL = "https://av.by/news";
    private final static String INFO_URL = "https://av.by/pages/info";
    private final static String FINANCE_URL = "https://av.by/finance";
    private final static String VIN_CHECKER_URL = "https://av.by/vin";

    public static String getVinCheckerUrl() {
        return VIN_CHECKER_URL;
    }

    public static String getFinanceUrl() {
        return FINANCE_URL;
    }

    public static String getInfoUrl() {
        return INFO_URL;
    }

    public static String getNewsUrl() {
        return NEWS_URL;
    }

    public static String getWheelsPartsUrl() {
        return WHEELS_PARTS_URL;
    }

    public static String getVehicleUrl() {
        return VEHICLE_URL;
    }

    public static String getHomeUrl() {
        return HOME_URL;
    }

    public static String getFinanceSearchUrl() {
        return FINANCE_SEARCH_URL;
    }

    public static String getSearchByTransmissionTypeAutomatic() {
        return SEARCH_BY_TRANSMISSION_TYPE_AUTOMATIC;
    }

    public static String getSearchByBrandAcura() {
        return SEARCH_BY_BRAND_ACURA;
    }

    public static String getSearchBodyTypeConvertible() {
        return SEARCH_BODY_TYPE_CONVERTIBLE;
    }

    public static String getSearchResultResponseKey() {
        return SEARCH_RESULT_RESPONSE_KEY;
    }

    public static String getSearchCustomTextQueryMultiroule() {
        return SEARCH_CUSTOM_TEXT_QUERY_MULTIROULE;
    }

    public static String getSearchCarByFilterUrl() {
        return SEARCH_CAR_BY_FILTER_URL;
    }

    public static String getContentTypeHeader() {
        return CONTENT_TYPE_HEADER;
    }

    public static String getLoginUrl() {
        return LOGIN_URL;
    }

    public static String getContentType() {
        return CONTENT_TYPE;
    }

    public static String getSearchAnyCarUrl() {
        return SEARCH_ANY_CAR_URL;
    }
}
