package techproed.tests.paralleltesting;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import techproed.utilities.ConfigurationReader;
import java.time.Duration;
public class CreateCustomer {
    @Test
    public void createCustomer(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(ConfigurationReader.getProperty("gmi_login_url"));
        driver.findElement(By.id("account-menu")).click();
        driver.findElement(By.xpath("(//*[text()='Sign in'])[1]")).click();
        driver.findElement(By.id("username")).sendKeys(ConfigurationReader.getProperty("employee_username"));
        driver.findElement(By.id("password")).sendKeys(ConfigurationReader.getProperty("employee_password"));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.id("entity-menu")).click();
        driver.findElement(By.xpath("//span[.='Manage Customers']")).click();
        driver.findElement(By.id("jh-create-entity")).click();
        driver.findElement(By.name("firstName")).sendKeys("FakeN");
        driver.findElement(By.name("lastName")).sendKeys("FakeL");
        driver.findElement(By.name("middleInitial")).sendKeys("N");
        driver.findElement(By.name("email")).sendKeys("fsdgsgf@gmail.com");
        driver.findElement(By.name("mobilePhoneNumber")).sendKeys("111-111-1111");
        driver.findElement(By.name("phoneNumber")).sendKeys("111-111-1111");
        driver.findElement(By.name("zipCode")).sendKeys("12345");
        driver.findElement(By.name("address")).sendKeys("2134123 way");
        driver.findElement(By.name("city")).sendKeys("Test");
        driver.findElement(By.id("tp-customer-ssn")).sendKeys("555-55-5555");
//        driver.findElement(By.id("tp-customer-country")).sendKeys("FakeN");
        driver.findElement(By.id("tp-customer-state")).sendKeys("FakeN");
//        driver.findElement(By.id("tp-customer-user")).sendKeys("FakeN");
//        driver.findElement(By.id("accountDropdown")).sendKeys("accountDropdown");
        driver.findElement(By.id("save-entity")).click();
        driver.quit();
    }
}