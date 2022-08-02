package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class CreateCustomerPage {
    public CreateCustomerPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id ="jh-create-entity")
    public WebElement createANewCustomer;
    @FindBy(id="search-ssn")
    public WebElement ssn1;
    @FindBy(xpath = "(//button[@type='button'])[4]")
    public WebElement searchButton;
    @FindBy(name="firstName")
    public WebElement firstname;
    @FindBy(name="lastName")
    public WebElement lastname;
    @FindBy(name="middleInitial")
    public WebElement middleInitial;
    @FindBy(name="email")
    public WebElement email;
    @FindBy(name="mobilePhoneNumber")
    public WebElement mobilePhoneNumber;
    @FindBy(name = "phoneNumber")
    public WebElement phoneNumber;
    @FindBy(name="zipCode")
    public WebElement zipCode;
    @FindBy(name="address")
    public WebElement address;
    @FindBy(name="city")
    public WebElement city ;
    @FindBy(id = "tp-customer-ssn")
    public WebElement ssn2;
    @FindBy(name="createDate")
    public WebElement createDate;
    @FindBy(id="tp-customer-country")
    public WebElement countryDropdown;
    @FindBy(id="tp-customer-state")
    public WebElement state;
    @FindBy (id="tp-customer-user")
    public  WebElement userDrop;
    @FindBy(id = "tp-customer-account")
    public WebElement accountDropdown;
    @FindBy(id = "tp-customer-zelleEnrolled")
    public WebElement zelleEnrolledCheckbox;
    @FindBy(id = "cancel-save")
    public WebElement backButton;
    @FindBy(id="save-entity")
    public WebElement saveButton;


}
