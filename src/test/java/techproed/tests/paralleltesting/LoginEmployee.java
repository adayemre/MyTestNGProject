package techproed.tests.paralleltesting;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import techproed.utilities.ConfigurationReader;
import java.time.Duration;
public class LoginEmployee {
    @Test
    public void login(){
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
        driver.quit();
    }
}
