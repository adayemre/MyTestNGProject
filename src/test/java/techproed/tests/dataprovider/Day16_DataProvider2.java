package techproed.tests.dataprovider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.EmployeeDefaultPage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigurationReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

/*/
The difference between try catch and throws in exception handling ?
If a method is re-usable (if you will call the method again) and we don't use try catch for exception handle
We will have to handle the exception whenever we call the method.
But if we used try catch and then whenever we call the method it will not throw an exception.
 */

public class Day16_DataProvider2 {
    @DataProvider(name = "employeeInfo")
    public Object[][] getData(){
        Object [][] employeeCredentials = {
                {"gino.wintheiser","%B6B*q1!TH"},
                {"dallas.batz","dOWjuXz8*es6"},
                {"leonel.skiles","x3uvY0f8hw1T"}
        };
        return employeeCredentials;
    }
    LoginPage loginPage;
    EmployeeDefaultPage employeeDefaultPage;
    public void logIn() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_login_url"));
        loginPage=new LoginPage();
        employeeDefaultPage=new EmployeeDefaultPage();
        ReusableMethods.waitFor(1);
        loginPage.loginDropdown.click();
        ReusableMethods.waitFor(1);;
        try{
            loginPage.signOut.click();
            ReusableMethods.waitFor(1);
            loginPage.loginDropdown.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
//            System.out.println("Sign out link is not exist");
        }
        loginPage.signInButton.click();
    }
    @Test(dataProvider = "employeeInfo")
    public void employeeLogin(String userName, String password) throws InterruptedException {
        logIn();
        loginPage.username.sendKeys(userName);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(1);
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
