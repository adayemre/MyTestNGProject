package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class EmployeeDefaultPage {
    public EmployeeDefaultPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
//      Find the object of Employee default Page

    @FindBy(id = "entity-menu")
    public WebElement myOperationDropdown;

    @FindBy(xpath = "//span[.='Manage Customers']")
    public WebElement manageCustomers;








}
