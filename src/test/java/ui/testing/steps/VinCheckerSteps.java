package ui.testing.steps;

import domain.vincode.Generator;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import po.HomePage;
import po.VinCheckPage;

public class VinCheckerSteps extends CommonSteps {
    private static HomePage homePage = new HomePage();
    private static VinCheckPage vinCheckPage = new VinCheckPage();
    private final static Logger logger = LoggerFactory.getLogger(VinCheckerSteps.class);

    public static void inputValidVinCodeInChecker() {
        homePage.openVinCheckPage();
        vinCheckPage.fillInputVinCodeField(Generator.generateValidFormatVinCode());
        vinCheckPage.clickCheckVinCode();
    }

    public static void checkValidVinCode() {
        String expectedPhrase = "Купить отчёт";
        Assertions.assertEquals(expectedPhrase,
                vinCheckPage.getBuyVinCodeResultButtonText());
        logger.info("VinCode has been checked. User sees: \"{}\",", expectedPhrase);
    }

    public static void inputInvalidNumberVinCodeInChecker() {
        homePage.openVinCheckPage();
        vinCheckPage.fillInputVinCodeField(Generator.generateInvalidNumberCharactersVinCode());
        vinCheckPage.clickCheckVinCode();
    }
    public static void checkInvalidNumberVinCode() {
        String expectedPhrase = "VIN-номер состоит из 17 символов";
        Assertions.assertEquals(expectedPhrase,
                vinCheckPage.getErrorNumberVinMessageText());
        logger.info("Vin Code is invalid, User sees \"{}\"", expectedPhrase);
    }
    public static void inputInvalidFormatVinCode() {
        homePage.openVinCheckPage();
        vinCheckPage.fillInputVinCodeField(Generator.generateInvalidCharactersInVinCode());
        vinCheckPage.clickCheckVinCode();
    }
    public static void checkInvalidFormatVinCode() {
        String expectedPhrase = "Неверно указан VIN-номер";
        Assertions.assertEquals(expectedPhrase,
                vinCheckPage.getErrorVinFormatMessageText());
        logger.info("VinCode is invalid format. User sees \"{}\"", expectedPhrase);
    }
}
