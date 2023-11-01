# taf-av-by
### Description:

This repository contains a test automated framework for automating website testing www.av.by . 
Website ia dedicated to selling or buying cars, other vehicles, Wheels or cars parts.

The framework is developed using:
-Java programming language (JDK17);
-Selenium WebDriver;
-JUnit
-REST-ASSURED.

### Project structure:
Pages objects are consist of objects of next pages: home, car, news, info, wheel/part, login form,
newOffer, Vin check. Personal account. PO is in the src/main/java/po.
Domain package is in src/main/java and consists of constant (constants for project, login (login test data) ang search
test data.
Driver is in src/main/java/driver. Settings for WebDriver are saved in Singleton.
Util package contains Waiter for using in tests.
Test part is consists from 2 main package: api & ui
Api is in src/test and consist of pojo classes (for login requests and responses) and test suits.
UI is also in src/test and consist of steps and test suites. test utils are created for making appropriate request and 
response for testing login via api.
Logs is collected by log4j2 and LoggerFactory. Logger configuration is placed in resources packege in src/test/resources.

### Dependencies:

Selenium webDriver, rest-assured, junit, log4j2, gson, jackson.

### Settings:

Install Java and Maven if they are not already installed.

Make sure that the browser drivers (for example, ChromeDriver) are placed in the appropriate folder.

### Running tests:

To run the tests, use the following Maven command: mvn test.

### Framework Extension:

This framework can be expanded and customized according to your needs. You can add new tests, pages, actions, and resources as needed.

* Author:

[IRENA RYZHENKO]

* Connection:

If you have any questions or suggestions, feel free to contact me:

Email: [platinumfoxirina@gmail.com]
[https://github.com/Irinaryzhenko]





