
# Hoge

This is an assignment for Any Mind Group. 
## Purpose : 
The purpose of this project is to complete the front end automation assignment provided by Any Mind Group. 

## System Details: 
While completing the assignment, QA has used Mac OS X and Chrome browser.
Also successfully executed all test script on Safari Browser.
Although script should supports other operating system like Linux and Windows. 
and browsers like Firefox , IE, etc with minimal change in TestSetUP Class > openBrowser Method under utility package.
If someone wants to execute single test script, they can hard code browser name (browserName) line number 71 and 78 in TestSetUp Class openBrowser Method under utility package.
browserName variable is passed as a parameter from testng.xml file.

## Reporting : 
Author has used Extent Report and all the executed reports are available in below path :
/Hoge/results/<separated_by_date_of_execution>

## BrowserDriver
All browser driver are present in below location : 
Hoge/src/main/resources/driver
If someone else wants to execute the test scripts on local, they need to update browser driver as per their browser version. 

## Dependencies
Since author is using maven. All jar files will be automatically gets download under .m2 folder. 
If any new jar files needs to be added, we need to mention the same under pom.xml file.

## Tech-stack Used: 
maven, TestNg, Selenium 4 , Eclipse , JDK 8 

## Page Design : 
Page Factory

## Test Data
Since the data set requirement was very less, currently author is passing all test data from a Constant.java file under utility package. 

## How to execute ? 
- Download the zip file.
- Extract the project or 
- clone project from github and avoid previous two steps.
- Open Eclipse 
- In Eclipse top navigation panel > File > Import > Existing maven project > Open Hoge Bank's pom.xml > 
- Allow project to build so that it can download necessary dependencies from internet into your .m2 folder
- Clean the project  > Eclipse top navigation panel > Project > Clean
- Go to testNg.xml file > right click > Run as TestNg

## Possible Error
- Browser and Browser Driver compatibility issue: Please make sure necessary browser driver is present in Hoge/src/main/resources/driver/ <os name> / location and it is runnable.
- Build error : Make sure all dependencies are properly downloaded . Right click on Project > Build Path > Configure Build Path> Libraries > JRE System Libraries, Maven Dependencies and TestNG should be present there and none of them should be in red cross.

## Test Scripts
Location - Hoge/src/test/java/testCases

# Locators 
Location - Hoge/src/main/java/pages








