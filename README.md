# Selenium e2e test for app online store(angular)

Rationale: Brief demo e2e test to ensure "admin" role can see "Administration" navbar option while "user" role should not see the option. The tests require the app to be started as per the "Requirement" section.
Major Files:
- EnsureCorrectUiForUserRolesLoginTest.java (tests for role)
- SignInOutActionsExample.java (major support file for "EnsureCorrectUiForUserRolesLoginTest.java")

## Requirement 
- Requires jhipster project created as per Chapter 3 of "Full Stack Development with Jhipster" (2nd Edition). 
- No need Entity generation as per Chapter 4. 
- Jhipster version used: 6.10.3. 
- The created jhipster project would have to be started with:

```
./gradlew -x webpack

npm start
```

## Other notes
- chromedriver.exe in src/test/resources/drivers/active is meant to work with Google Chrome version 88.
- The SeleniumConfig.java "webdriver.chrome.driver" should point to another chromedriver.exe if your computer uses different Chrome version.
- answer by "hal" at (https://stackoverflow.com/questions/41133391/which-chromedriver-version-is-compatible-with-which-chrome-browser-version) if you need to fix error "ChromeDriver is only compatible with Chrome version" when running tests.