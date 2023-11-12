package ui.testing.steps;

import domain.constant.Constant;
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
        try {
            VinCheckPage vinCheckPage = new VinCheckPage();
            Assertions.assertEquals(Constant.VIN_CHECK_SUCCESS_MESSAGE,
                    vinCheckPage.getBuyVinCodeResultButtonText());
            logger.info("VinCode has been checked. User sees: \"{}\",", Constant.VIN_CHECK_SUCCESS_MESSAGE);
        } catch (Exception e) {
            logger.info("You couldn't create a valid vin code. User sees error message: \"{}\"",
                    Constant.VIN_CODE_ERROR_FORMAT_MESSAGE);
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
        VinCheckPage vinCheckPage = new VinCheckPage();
        Assertions.assertEquals(Constant.VIN_CODE_NUMBER_ERROR_MESSAGE,
                vinCheckPage.getErrorNumberVinMessageText());
        logger.info("Vin Code is invalid, User sees \"{}\"", Constant.VIN_CODE_NUMBER_ERROR_MESSAGE);
    }
    public static void inputInvalidFormatVinCode() {
        HomePage homePage = new HomePage();
        homePage.openVinCheckPage();
        VinCheckPage vinCheckPage = new VinCheckPage();
        vinCheckPage.fillInputVinCodeField(Generator.generateInvalidCharactersInVinCode());
        vinCheckPage.clickCheckVinCode();
    }
    public static void checkInvalidFormatVinCode() {
        VinCheckPage vinCheckPage = new VinCheckPage();
        try {
            Assertions.assertEquals(Constant.VIN_CODE_ERROR_FORMAT_MESSAGE,
                    vinCheckPage.getErrorVinInvalidFormatText());
            logger.info("VinCode is invalid format. User sees \"{}\"", Constant.VIN_CODE_ERROR_FORMAT_MESSAGE);
        } catch ( Exception e) {
            Assertions.assertEquals(Constant.VIN_CODE_GLOBAL_ERROR_SCREEN_MESSAGE,
                    vinCheckPage.getErrorSomethingWentWrong());
            logger.error("Error screen opens. User sees \"{}\"", Constant.VIN_CODE_GLOBAL_ERROR_SCREEN_MESSAGE);
        }
    }
}
