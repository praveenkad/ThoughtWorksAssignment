Changes Made: 

1. Data Provider: 
Added Scripts to make use of data provider to perform 3 logins from below users 
{"xt2@xt.com", "infy1234"},
{"xt3@xt.com", "infy2234"},
{"xt4@xt.com", "infy3234"}

2. Test Data In Properties: 
Added TestData.properties file under (src\main\resources\TestData\) and made use of test data from it.

3. New Reusable Methods: 
Added waitForPageToLoad(), getConfigProperty(String sKey) methods to serve the below purposes.

waitForPageToLoad() (src\main\java\pages\Login\) - to wait until the browser gets completely loaded to avoid any synchronization issues due to slow internet access.

getConfigProperty(String sKey) (src\main\java\util\DriverManager\) - to return the value of required key from TestData.properties file. 

4. Parameterization: 
Made use of 'browser' parameter in TestNG.xml to specificy the browser of your choice.

5. Generic File Paths (Ready to run without making any file path changes): 
Added generic file paths to the chromedriver.exe, TestData.properties files to avoid hard coding the file paths whilst running on new machine. 

6. Proper Browser Termination:
Added necessary tearDown TestNG annotations in class level to avoid browsers remaining unclosed affecting the peformance. 
