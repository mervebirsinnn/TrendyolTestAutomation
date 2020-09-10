# Project Title

Test Automation for Trendyol

## Before Starting

* Selenium is used for testing and testNG is used for reporting in this project. If you want to create test reports you need click "Use default reports" which is located on Listeners section.

* Test is running on Chrome web browser by default. If you want to change browser (I assume that browser drivers are defined as system variables on your computer) you need to change browser paramater that located in testNG.xml file.

* If any test case fails, system will log these fails on report. You can find report document in the project document with ../test/output extention.

## Test Covarage

1) Navigate trendyol.com
2) Verify page fully loaded
3) Login
4) Write a product, click search button and select randomly product
5) Add basket and compare prices
6) Delete products in basket
 

## How To Run Test

After cloning the project you need to run testNG.xml file.

## Structure

MAVEN - Project Structure. TESTNG - Unit test framework.


