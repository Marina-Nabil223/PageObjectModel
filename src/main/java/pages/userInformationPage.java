package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class userInformationPage {

    private WebDriver driver;
    private final By accountInfoTxt = By.xpath("(//h2[@class='title text-center']//b)[1]");
    private final By gender = By.id("id_gender2");
    private final By password =  By.id("password");
    private final By days =  By.id("days");
    private final By months =  By.id("months");
    private final By years =  By.id("years");
    private final By newsletter =  By.id("newsletter");
    private final By optin =  By.id("optin");
    private final By firstName =  By.id("first_name");
    private final By LastName =  By.id("last_name");
    private final By addressOne =  By.id("address1");
    private final By addressTwo =  By.id("address2");
    private final By country =  By.id("country");
    private final By state =  By.id("state");
    private final By city = By.id("city");
    private final By zipcode =  By.id("zipcode");
    private final By mobileNumber =  By.id("mobile_number");
    private final By createAccountBtn =  By.xpath("//button[@data-qa=\"create-account\"]");
    private final By createAccountMsg = By.xpath("//h2[@data-qa=\"account-created\"]//b");

    public userInformationPage(WebDriver driver){

        this.driver = driver;

    }

    public void assertOnAccountInfoPage(String expectedResult)
    {
        String accountInfotxt = driver.findElement(accountInfoTxt).getText();
        Assert.assertEquals(accountInfotxt, expectedResult);
    }

    public void enterAccountInformation(String pass,String userFirstName,String userLastName,String day,String month,String year) {
        driver.findElement(gender).click();
        driver.findElement(password).sendKeys(pass);

        driver.findElement(days).sendKeys(day);
        driver.findElement(months).sendKeys(month);
        driver.findElement(years).sendKeys(year);

        driver.findElement(newsletter).click();
        driver.findElement(optin).click();

        driver.findElement(firstName).sendKeys(userFirstName);
        driver.findElement(LastName).sendKeys(userLastName);
    }
    public void enterAddressInformation(String userAddressOne,String userAddressTwo,String Country,String State, String City , String zipCode, String userMobileNumber)
    {
        driver.findElement(addressOne).sendKeys(userAddressOne);
        driver.findElement(addressTwo).sendKeys(userAddressTwo);
        driver.findElement(country).sendKeys(Country);
        driver.findElement(state).sendKeys(State);
        driver.findElement(city).sendKeys(City);
        driver.findElement(zipcode).sendKeys(zipCode);
        driver.findElement(mobileNumber).sendKeys(userMobileNumber);
        driver.findElement(createAccountBtn).click();
    }

    public String assertOnAccountCreated(String expectedResult) {
        return driver.findElement(createAccountMsg).getText();
    }



}
