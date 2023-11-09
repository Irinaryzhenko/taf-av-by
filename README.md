# taf-av-by
### Description:

This repository contains a test automated framework for automating website testing www.av.by . 
Website ia dedicated to selling or buying cars, other vehicles, Wheels or cars parts. Website has account page and part 
of functionality is opened only for authorized users. Users have possibility to log in via login/email or by phone number.
With help of this taf you could test authorization via email/login.
Website has complicated search with great amount of filters. With help of this taf you could test searching car by 
popular parameters - brand, model, year, price, generation, and engine capacity. Search results are given in 2 main
parts - as top car and other appropriate cars. Search test in taf-av-by gives you a possibility to check both 
top results and basic cars, which is matching with search query.
Website give the opportunity to check car vin code. With help of taf-av-by you can test this functionality. 
Functionality to add new offer for selling car is checked by tests in this taf.

The framework is developed using:
-Java programming language (JDK17);
-Selenium WebDriver;
-JUnit
-REST-ASSURED.

### Project structure:
Pages objects are consist of objects of next pages: home, car, news, info, wheel/part, login form,
newOffer, Vin check. Personal account. PO is in the src/main/java/po.
Domain package is in src/main/java and consists of constant, search test data and finance test data and class for 
getting test data for vin code checker testing. For generation of login test data java faker library was used. 
For generation of vin code test data custom generator methods were created.
Driver is in src/main/java/driver. Settings for WebDriver are saved in Driver JavaClass with using Singleton pattern.
Driver class contains also custom method for driver waiting.

Test part is consists from 2 main package: api & ui
Api is in src/test and consist of pojo classes (for login requests and responses) and test suits.
UI is also in src/test and consist of steps and test suites. Test utils are created for making appropriate request and 
response for testing login via api. For ease of assembling tests, tests consist of steps. There are also CommonStep
class which has method for opening home page. Other test step classes are inheritors of the CommonStepClass.

### Dependencies:

Selenium webDriver, rest-assured, junit jupiter, log4j2, gson, jackson, allure-report, java faker library.

### Settings:

Install Java and Maven if they are not already installed.

Make sure that the browser drivers (for example, ChromeDriver) are placed in the appropriate folder and have actual 
version.

### Running tests:

To run the tests, use the following Maven command: mvn test.
if you want to see allure report< you need to run tests by command clean test, then install allure plugin, 
do allure report and allure-serve.

### CI/CD

Ensuring continuous integration and remote running of tests is provided by Jenkins. Tests run twice a day - 
at 8:00 and 20:00 (Minsk time).

### Error logs
Taf has a <logs> folder, which collects archived logs, appLogs (collect info about test execution) and error.log 
(collect only error logs). For logging process we used log4j2 and LoggerFactory library. Logging settings are in
the resources folder in src/test/resources.

### Reporting
Reporting is provided with Allure-report, allure properties are paced in allure.properties file in <resources> directory
in src/test/resources.


### Framework Extension:

This framework can be expanded and customized according to your needs. You can add new tests, pages, actions, and
resources as needed.

* Author:

[IRENA RYZHENKO]

* Connection:

If you have any questions or suggestions, feel free to contact me:

Email: [platinumfoxirina@gmail.com]
[https://github.com/Irinaryzhenko]





