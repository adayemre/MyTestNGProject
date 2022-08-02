package techproed.tests.paralleltesting;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.utilities.ConfigurationReader;
import techproed.utilities.ExcelUtil;
import techproed.utilities.ReusableMethods;
import java.time.Duration;
public class DataProviderLogin {
    //   !!!!!!! To this parallel mode with data provider, we use parallel="true":
//    Note that this will NOT LIMIT THE NUMBER OF BROWSER
//    For example, when I run this class, i will see 9 thread
//    By default, data provider runs all available data in parallel
//    But we can give thread count
//    STEPS:
//    1. create an xml file  : parallel-testing-3.xml
//    2. use parallel and data-provider-thread-count to limit thread


    @DataProvider(name = "employeeInfo",parallel = true)
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
    @Test(dataProvider = "employeeInfo")
    public void employeeLogin(String userName, String password) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(ConfigurationReader.getProperty("gmi_login_url"));
        ReusableMethods.waitFor(1);
        driver.findElement(By.id("account-menu")).click();
        ReusableMethods.waitFor(1);;
        try{
            driver.findElement(By.xpath("//span[.='Sign out']")).click();
            ReusableMethods.waitFor(1);
            driver.findElement(By.id("account-menu")).click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
//            System.out.println("Sign out link is not exist");
        }
        driver.findElement(By.xpath("(//*[text()='Sign in'])[1]")).click();
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        ReusableMethods.waitFor(1);
        driver.quit();
    }
}