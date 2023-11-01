package ui.testing.steps;

import domain.vincode.Generator;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import po.HomePage;
import po.VinCheckPage;

public class VinCheckerSteps extends CommonSteps {

     private final static Logger logger = LoggerFactory.getLogger(VinCheckerSteps.class);

    public static void inputValidVinCodeInChecker() {
       HomePage homePage = new HomePage();
        homePage.openVinCheckPage();
        VinCheckPage vinCheckPage = new VinCheckPage();
        vinCheckPage.fillInputVinCodeField(Generator.generateValidFormatVinCode());
        vinCheckPage.clickCheckVinCode();
    }

    public static void checkValidVinCode() {
        String errorMessage = "Неверно указан VIN-номер";
        try {
            String expectedPhrase = "Купить отчёт";
            VinCheckPage vinCheckPage = new VinCheckPage();
            Assertions.assertEquals(expectedPhrase,
                    vinCheckPage.getBuyVinCodeResultButtonText());
            logger.info("VinCode has been checked. User sees: \"{}\",", expectedPhrase);
        } catch (Exception e) {
            logger.info("You couldn't create a valid vin code. User sees error message: \"{}\"", errorMessage);
        }
    }

    public static void inputInvalidNumberVinCodeInChecker() {
        HomePage homePage = new HomePage();
        homePage.openVinCheckPage();
        VinCheckPage vinCheckPage = new VinCheckPage();
        vinCheckPage.fillInputVinCodeField(Generator.generateInvalidNumberCharactersVinCode());
        vinCheckPage.clickCheckVinCode();
    }
    public static void checkInvalidNumberVinCode() {
        String expectedPhrase = "VIN-номер состоит из 17 символов";
        VinCheckPage vinCheckPage = new VinCheckPage();

        Assertions.assertEquals(expectedPhrase,
                vinCheckPage.getErrorNumberVinMessageText());
        logger.info("Vin Code is invalid, User sees \"{}\"", expectedPhrase);
    }
    public static void inputInvalidFormatVinCode() {
        HomePage homePage = new HomePage();
        homePage.openVinCheckPage();
        VinCheckPage vinCheckPage = new VinCheckPage();
        vinCheckPage.fillInputVinCodeField(Generator.generateInvalidCharactersInVinCode());
        vinCheckPage.clickCheckVinCode();
    }
    public static void checkInvalidFormatVinCode() {
        String expectedPhrase1 = "Что-то сломалось";
        String expectedPhrase2 = "Неверно указан VIN-номер";
        VinCheckPage vinCheckPage = new VinCheckPage();
        try {
            Assertions.assertEquals(expectedPhrase2, vinCheckPage.getErrorVinInvalidFormatText());
            logger.info("VinCode is invalid format. User sees \"{}\"", expectedPhrase2);
        } catch ( Exception e) {
            Assertions.assertEquals(expectedPhrase1, vinCheckPage.getErrorSomethingWentWrong());
            logger.error("Error screen opens. User sees \"{}\"", expectedPhrase2);
        }
    }
}
