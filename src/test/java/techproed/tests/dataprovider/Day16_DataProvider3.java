package techproed.tests.dataprovider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.EmployeeDefaultPage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigurationReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtil;
import techproed.utilities.ReusableMethods;
public class Day16_DataProvider3 {
    @DataProvider(name = "employeeInfo")
    public Object[][] getData(){
//       The only difference between DataProvider2 and DataProvider3 will be the source of teh data
//        In this method we will get data from Excel
//        path of the excel sheet
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
//        sheet name on the excel sheet
        String sheetName="employee_login_info";
//       Creating Excel Util object
        ExcelUtil excelUtil = new ExcelUtil(path,sheetName);
//       Use getDataArrayWithoutFirstRow() that will return all rows except header
        Object [][] employeeCredentials = excelUtil.getDataArrayWithoutFirstRow();
//        Object [][] employeeCredentials = {
//                {"gino.wintheiser","%B6B*q1!TH"},
//                {"dallas.batz","dOWjuXz8*es6"},
//                {"leonel.skiles","x3uvY0f8hw1T"}
//        };
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