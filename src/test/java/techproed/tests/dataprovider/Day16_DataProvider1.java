package techproed.tests.dataprovider;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Day16_DataProvider1 {
    /*DATA PROVIDER METHOD
     * 1. Create a 2D array method
     * 2. @DataProvider to provide data
     * 3. store test data in that method
     *
     * HOW DO YOU GET DATA IN TEST METHOD?
     * 4. @Test(dataProvider = "METHOD NAME")
     * NOTE: we can change the name using name parameter
     * @DataProvider(name = "employeeInfo") and pass employeeInfo
     * */
    @DataProvider(name = "employeeInfo")
    public Object[][] getData(){
        Object [][] employeeCredentials = {
                {"gino.wintheiser","%B6B*q1!TH"},
                {"dallas.batz","dOWjuXz8*es6"},
                {"leonel.skiles","x3uvY0f8hw1T"}
        };
        return employeeCredentials;
    }
    @Test(dataProvider = "employeeInfo")
    public void employeeLogin(String userName, String password){
        System.out.println(userName+" | "+password);
    }
}
