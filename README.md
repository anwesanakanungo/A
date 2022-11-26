API Automation Framework built using Rest Assured, Java 8 , Maven, Test NG , AssertJ , Lombok ,JAVA faker , Jackson binding .

Frame work support :

Design pattern used : Builder design pattern ( for Post and PUT request ) and it also support the predefined user input data like JSON file and make changes on the same is also taken care in ApiUtilClass .
Each response of the API will be stored in the OUTPUT folder .
Configuration file will be shared both by API and UI classes .
Response of the each Post request will be shared by GET and PUT APIS using DataStore class .
Faker API is used for uniquely creating data for each test . Assumption:
Always run the Create Booking and then GET that booking . (Create bookingid will be input for the GET booking)
How to run the Test :

Install java 8 installed and set JAVA_HOME
Set Maven_home
Check out the code .
Go to the terminal run maven install or mvn clean install test -DsuiteXmlFile="testng.xml"
UI Automation Framework built using Rest Assured, Java 8 , Maven, Test NG , AssertJ , Lombok ,JAVA faker

Frame work support : Design pattern used :

Factory design pattern (Browser support , Currently support CHORME(106) and firefox (104) it can be extended any number of Browsers )
Page objects in fluent style
Configuration file will be shared both by API and UI classes . How to run the Test :
Install java 8 installed and set JAVA_HOME
Set Maven_home
Check out the code .
Go to the terminal run maven install or mvn clean install test -DsuiteXmlFile="testng.xml"
