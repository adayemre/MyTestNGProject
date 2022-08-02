package techproed.tests.smoketest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigurationReader;
import techproed.utilities.Driver;

public class Day13_PositiveLogin {
    /*
Smokes Test:
Testing important, critical functionalities of the application
1. To check if the application up and running
2. To check if critical functionalities are working
In a smoke test:
-login
-log out
-create account
-add to card
-make payment
-....
There are 18 test scripts in my smoke
Smoke test automation script should take about 15-20 minutes on average.
......
Who chooses to include functionalities in the smoke test?
-Test Leads(Senior testers who knows the application very good), chooses what goes to smoke test suite.
-In my company, there is a team who decides the smoke test and regression test automation scripts
.........
Regression Test:
1. Testing ALL major functionalities of the application
-All smokes tests +
-loan creation +
-account creation, edit, delete,...
-search
-...many more
-........
-There are 600 Test scripts
-8-10 hours
.......
When do you do regression testing?
1. Before every release.(minor(every 3 months) or major release(Every 6 months))
2. After each major bug fix. To make sure there is no impact on the existing functionalities
......
Unit test < integration test(testing if components are working good together) < regression test
* */
    LoginPage loginPage;
    @Test
    public void login(){
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_login_url"));
        loginPage = new LoginPage();
        loginPage.loginDropdown.click();
        loginPage.signInButton.click();
        loginPage.username.sendKeys(ConfigurationReader.getProperty("employee_username"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("employee_password"));
        loginPage.loginButton.click();

    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

     //   gino.wintheiser
    //  %B6B*q1!TH

}
