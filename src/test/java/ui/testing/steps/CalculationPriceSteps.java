package ui.testing.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import po.CalculatePricePage;

public class CalculationPriceSteps extends CommonSteps{
    private final static Logger logger = LoggerFactory.getLogger(CalculationPriceSteps.class);
    public void selectVehicleForCalculation() {
        CalculatePricePage calculatePricePage = new CalculatePricePage();
        calculatePricePage.selectCarBrandForCalculation();
        logger.info("Car brand has been selected");
        calculatePricePage.selectCarModelCalculatorLocator();
        logger.info("Car model has been selected");
        calculatePricePage.selectCarYearCalculatorLocator();
        logger.info("Car year has been selected");
        calculatePricePage.selectCarGenerationCalculatorLocator();
        logger.info("Car generation has been selected");
    }
    public void checkPriceResult() {
        CalculatePricePage calculatePricePage = new CalculatePricePage();
        calculatePricePage.getResultPriceText();
        logger.info("Car price has been get");
        calculatePricePage.checkPriceResult();
        logger.info("Car price has been checked and correct");
    }
}
