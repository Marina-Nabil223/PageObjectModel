/*package tests;

import framework.engine.JsonFileManager;
import framework.engine.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class testProperties {

    static WebDriver driver;
    JsonFileManager testData;

    //////////////////////// Configurations \\\\\\\\\\\\\\\\\\\\\\\\\\\

    @BeforeClass
    public void beforeClass() {
        PropertiesReader.loadProperties();
        testData = new JsonFileManager("src/test/resources/Test Data/TestData.json");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = initDriver();
        navigateToHomePage();

    }

    @AfterMethod
    public void afterMethod() {

        driver.quit();
    }

    ///////////////////////////////////////// Steps

    String homePageUrl = "https://automationexercise.com/";

    private final By homePageTitle = By.xpath("//h2[@class='title text-center']");
    private final By selectSignUpIcon  = By.xpath("(//a//i)[4]");
    private final By signUpMsg = By.xpath("(//h2)[3]");
    private final By userName =By.name("name");
    private final By userMail =By.xpath("//input[@data-qa='signup-email']");
    private final By signUPBtn =   By.xpath("//button[@data-qa='signup-button']");
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
    private final By createAccountBtn =  By.xpath("//button[@data-qa='create-account']");
    private final By createAccountMsg = By.xpath("//h2[@data-qa='account-created']//b");






    @Test
    public void userSignUp() {

        assertOnVisibilityOfHomePage("FEATURES ITEMS");
        SignUp();
        assertOnSignUpPage("New User Signup!");//
        newUserSignUpPage(testData.getTestData("testDataUserName"),testData.getTestData("testDataUserMail"));
        assertOnAccountInfoPage("ENTER ACCOUNT INFORMATION");
        enterAccountInformation(testData.getTestData("testDataUserPassword"),testData.getTestData("testDataUserFirstName"),
                testData.getTestData("testDataUserLastName"), testData.getTestData("testDataUserBirthDay"),
                testData.getTestData("testDataUserBirthMonth"), testData.getTestData("testDataUserBirthYear"));
        enterAddressInformation(testData.getTestData("testDataUserAddress1"),testData.getTestData("testDataUserAddress2"),
                testData.getTestData("testDataUserCountry") ,testData.getTestData("testDataUserState"),
                testData.getTestData("testDataUserCity"),testData.getTestData("testDataUserZipCode"),testData.getTestData("testDataUserMobile"));
        assertOnAccountCreated("ACCOUNT CREATED!");//


    }

    public void navigateToHomePage() {

        driver.navigate().to(homePageUrl);
    }

    public void assertOnVisibilityOfHomePage(String expectedResult) {
        String homePageTxt= driver.findElement(homePageTitle).getText();
        Assert.assertEquals(homePageTxt, expectedResult);

    }

    public void SignUp () {

        driver.findElement(selectSignUpIcon).click();
    }

    public void assertOnSignUpPage(String expectedResult) {
        String signUptxt = driver.findElement(signUpMsg).getText();
        Assert.assertEquals(signUptxt, expectedResult);
    }

    public void newUserSignUpPage(String name,String email)
    {
        driver.findElement(userName).sendKeys(name);
        driver.findElement(userMail).sendKeys(email);
        driver.findElement(signUPBtn).click();
    }

   public void assertOnAccountInfoPage(String expectedResult)
    {
        String accountInfoText = driver.findElement(accountInfoTxt).getText();
        Assert.assertEquals(accountInfoText, expectedResult);
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


    ///////////////// Core
    private static WebDriver initDriver(String browserType, int implicitWait, Boolean maximize, Boolean headless) {
        if (browserType.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = null;
            if (headless) {
                chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                driver = new ChromeDriver(chromeOptions);
            } else {
                driver = new ChromeDriver();
            }
        } else if (browserType.equalsIgnoreCase("firefox")) {
            FirefoxOptions ffOptions = null;
            if (headless){
                ffOptions = new FirefoxOptions();
                ffOptions.addArguments("--headless");
                driver = new FirefoxDriver(ffOptions);
            } else {
                driver = new FirefoxDriver();
            }
        } else if (browserType == "edge") {
            driver = new EdgeDriver();
        } else {
            driver = new SafariDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        if (Boolean.TRUE.equals(maximize)) {
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriver initDriver(String browserType) {

        return initDriver(browserType, 20, true, false);
    }

    public static WebDriver initDriver() {
        return initDriver(
                System.getProperty("browserType"),
                Integer.parseInt(System.getProperty("waits")),
                Boolean.valueOf(System.getProperty("maximizeWindow")),
                Boolean.valueOf(System.getProperty("headlessExecution"))
        );
    }

}
*/