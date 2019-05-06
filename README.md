Basic Structure for web automation  

  

Framework information: 

This is a basic structure for automation framework where the core tools are selenium webdriver and testNg. Selenium is used for UI interaction and testNg is used to drive the testcases and reporting. 

  

Factory Pattern - In ordered to initialize WebDrivers across multiple platform, factory pattern has been used. 

Data Driven Framework- Test data are retrieved from Excel/CVS and passed to testcase using the data provider. 

POM - Page Object Model is used to locate the web element that are needed for test case. Page elements are defined via its id, class name, css, path. 

Utils package: Utils contains functionality that are used throughout the automation framework like selenium api calls, logging the progress, reading test data 

  

TODO: Extend Report 

Note: Framework is developed in mac os, please use the respective platforms chrome driver. 
