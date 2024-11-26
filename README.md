# Calculator-App-Automation
## In this project, I automated the Google Calculator APK with selenium, TestNG, and Appium.

## Automated Scenario
    1. Sum of two numbers
    2. Automate any series for a calculator app.
       example: 100/10*5-10+60
    
       pseudocode for your test function can look like:
    
        public void doSeries(){
        calcuateSeries("100/10*5-10+60");
        }
    3. write another function where the following series will be calculated from csv file. (50)
    
        //data.csv
        50+40-30/2+20 //assert 95 (Marks: 10)
        10*2/2+10-20 // assert 0 (Marks: 10)
        4pi2^3 // assert 100.53 (Marks: 30)

## Technology
- Tool: Selenium, Appium
- IDE: IntelliJ
- Language: Java
- Testing Framework: TestNG
- Build tool: Gradle

## Pre-requisite
- Install jdk 11, gradle, allure
- clone this project and unzip it
- Open Android Studio, go to the debug APK option, and open Google Calculator APK
- Run the emulator
- Open cmd and type `adb devices`
- Type `appium` to run Appium server
- Download and open appium inspector to set the capabilities
- Open the project folder in Intellij
- Click on the terminal and run `gradle clean test`
- To generate an allure report write the following commands on the terminal:
    `allure generate allure-reports --clean --output`
    `allure serve allure-results`

## Allure Report
![appiumAllure01](https://github.com/user-attachments/assets/0e0cc7ac-6d8c-4f9c-ba56-983899485ef6)
![appiumAllure02](https://github.com/user-attachments/assets/38fadbc8-e1f6-4923-b097-0aa6d63734b8)



