# Testslotegrator Framework (UI and API)
The project is based on a test task for Testslotegrator.

### Tools:
* Maven
* JUnit 5
* Rest-assured
* Lombok
* Cucumber
* WebDriverManager
* Selenium 
* Jackson

### Requirements
In order to utilise this project you need to have the following installed locally:
* Java 11

### Usage
The project is broken into separate modules for API, UI testing. 

### Run
To run UI module, navigate to terminal and run:
'mvn clean test "-Dcucumber.options=src/test/resources/features --tags @CucumberUiTest"'
To run API module, navigate to terminal and run:
'mvn clean test -Dtest=ApiTests'
