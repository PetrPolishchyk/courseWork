# courseWork
This course work is about Kanboard

Run tests by the command "mvn clean test -PallRegression -Dbrowser=chrome -Durl=http://localhost:80/jsonrpc.php -DurlUI=http://localhost/login"
where 
-P can be different: allRegression - run all test tests, APIRegression - run only API, UIRegression - run only UI tests.
and 
-Dbrowser can include "chrome" - for test in Chrome browser, "firefox" - for test in Firefox browser, headless - for test in Chrome Headless browser. 

Generate allure report by the command "allure generate target/allure-results"