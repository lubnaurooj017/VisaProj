## VisaProj
Solved Questionnaire by Visa as part of the 1st round of interview "Chandler Macleod - Role of Quality Assurance Engineer"

## Tools used
- selenium
- eclipse
- TestNG
- maven

## Language code is written
- java

## Frameworks followed
- POM
- DOM

## Things which are implemented/configured in this automation
- [x] Tests are runnable from the command line
- [x] Tests are run against a configurable host, I have used http://www.amazon.com as the default
- [x] Tests are configured to run on a various browser eg Chrome, FireFox, Safari 
- [x] Tests are configurd to run on all OS combinations against a testing service eg: windows, MacOS
- [x] Testing service credentials and all configuration settings are passed as environment variables
- [x] Tests are configured to run in parallel
- [x] The automation runs via the UI within a browser
- [x] Solution produces a detailed and clean report file under **target** and **test-output** folder insie the solution

## How to run this project
1. Clone this repo to your local directory **<LOCAL_WORKING_DIRECTORY>** : 
`git clone https://github.com/lubnaurooj017/VisaProj.git`
2. Change the directory to <LOCAL_DIRECTORY>/VisaChandlerProject/Problem1/com.amazon : `cd <LOCAL_WORKING_DIRECTORY>/VisaChandlerProject/Problem1/com.amazon`
3. Follow the maven commands below to run (test) this project:

## maven command to run the project through command line by passing arguments
> chrome
`mvn clean test -Durl="http://www.amazon.com/" -Dbrowser="chrome" -DxmlFileName=testng.xml`

> Firefox
`mvn clean test -Durl="http://www.amazon.com/" -Dbrowser="firefox" -DxmlFileName=testng.xml`

> Safari
`mvn clean test -Durl="http://www.amazon.com/" -Dbrowser="safari" -DxmlFileName=testng.xml`


> *Some of important maven commands for reference*:
```
mvn clean
mvn clean install
mvn pre-clean
mvn compile   
mvn package
```

## Test Cases reports captured ?
- [x] YES
## Location of test report captured:
- Go to <LOCAL_WORKING_DIRECTORY>/VisaChandlerProject/Problem1/com.amazon/target/surefire-reports/
- Go to <LOCAL_WORKING_DIRECTORY>/VisaChandlerProject/Problem1/com.amazon/test-output/
- Then click index.html present inside folder
- Things you should be able to see:
  - testng-customsuite.xml
  - test
  - groups
  - Times
  - Reporter output
  - Ignored methods
  - Chronological view
  - Results

## Test Cases **SCREENSHOTS** captured ?
- [x] YES

## Location of screenshots captured
> <LOCAL_WORKING_DIRECTORY>/VisaChandlerProject/Problem1/com.amazon/ScreenShots/

## Test Data provided ?
- [x] YES
## Location of Test Data file
> <LOCAL_WORKING_DIRECTORY>/VisaChandlerProject/Problem1/com.amazon/testdata/amazonTestData.json

## firefox gecko driver and chrome driver location
> <LOCAL_WORKING_DIRECTORY>/VisaChandlerProject/Problem1/com.amazon/src/driverfile

## Project structure
### root/Packages/class/:
- src/main/java
  - utility
    - businessClass.java
    - captureScreenshot.java
    - listenerClass.java
    - parseJsonClass.java
  - visaChandler.com.amazon
  	- loginPage.java
  	- ProductPurchasePage.java
- src/test/java
  - amazonTest
    - amazonTestCases.java
- JRE System Library
- Maven Dependencies
- Screenshots
- src
- target
- test-output
- testdata
- pom.xml
- testng.xml

## Test Cases Methods used:
- validateErrorForIncorrectPassword 
- validateErrorForIncorrectUserName 
- validateItemNameAndPriceAndAddtoCart 
- validatePageHeader 
- validateProductAddedtoCart 
- validateProductPresentAfterLogoutAndRelogin 
- validateProductPriceAndNameInCart 
- validateReenterCorrectPassword 
- validateSearchAndAddFirstProduct 
- validateSuccessfulLoginandPageHeader 



