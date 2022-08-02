package techproed.tests.smoketest;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.RegistrationPage;
import techproed.utilities.ConfigurationReader;
import techproed.utilities.Driver;

public class Day15_RegistrationTest {

    RegistrationPage registrationPage;
    Faker faker = new Faker();

    @Test
    public void registrationTest(){
//        HOMEWORK : complete the test of the test case
//        Enter all fields and click register
//        Create page objects in the page class
//        Then use it in the test class
//        DO MANUAL TESTING FIRST

        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_registration_url"));
        registrationPage = new RegistrationPage();
        //Driver.getDriver().findElement(By.id("ssn")).sendKeys("1111");
        registrationPage.ssn.sendKeys("111111111");
        registrationPage.firstName.sendKeys(faker.name().firstName());
        registrationPage.lastName.sendKeys(faker.name().lastName());
        registrationPage.address.sendKeys(faker.address().fullAddress());
        registrationPage.mobilePhone.sendKeys(faker.phoneNumber().cellPhone());
        registrationPage.userName.sendKeys(faker.name().username());
        registrationPage.email.sendKeys(faker.internet().emailAddress());
        registrationPage.firstPassword.sendKeys("asdsfsa456.fd");
        registrationPage.secondPassword .sendKeys("asdsfsa456.fd");
        registrationPage.registerButton.click();




    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
