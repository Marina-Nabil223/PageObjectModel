package tests;

import framework.engine.JsonFileManager;
import framework.engine.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.homePage;
import pages.newUserSignUpPage;
import pages.userInformationPage;
import framework.engine.DriverFactory;

public class newUserSignUpTest {
    private WebDriver driver;
    private homePage HomePage;

    private newUserSignUpPage newUserSignUpObject;

    private userInformationPage userInformationObject;

    JsonFileManager testData;


    @Test
    public void userSignUp() {
        HomePage.assertOnVisibilityOfHomePage("FEATURES ITEMS");
        HomePage.SignUp();
        newUserSignUpObject.assertOnSignUpPage("New User Signup!");//
        newUserSignUpObject.newUserSignUpPage(testData.getTestData("testDataUserName"),testData.getTestData("testDataUserMail")+System.currentTimeMillis()+"@gizasystems.com");
        userInformationObject.assertOnAccountInfoPage("ENTER ACCOUNT INFORMATION");
        userInformationObject.enterAccountInformation(testData.getTestData("testDataUserPassword"),testData.getTestData("testDataUserFirstName"),
                testData.getTestData("testDataUserLastName"), testData.getTestData("testDataUserBirthDay"),
                testData.getTestData("testDataUserBirthMonth"), testData.getTestData("testDataUserBirthYear"));
        userInformationObject.enterAddressInformation(testData.getTestData("testDataUserAddress1"),testData.getTestData("testDataUserAddress2"),
                testData.getTestData("testDataUserCountry") ,testData.getTestData("testDataUserState"),
                testData.getTestData("testDataUserCity"),testData.getTestData("testDataUserZipCode"),testData.getTestData("testDataUserMobile"));
        userInformationObject.assertOnAccountCreated("ACCOUNT CREATED!");//

    }

    //////////////////////// Configurations \\\\\\\\\\\\\\\\\\\\\\\\\\\

    @BeforeClass
    public void beforeClass() {
        PropertiesReader.loadProperties();
        testData = new JsonFileManager("src/test/resources/Test Data/TestData.json");
    }



    @BeforeMethod
    public void beforeMethod() {
        driver = DriverFactory.initDriver();
        HomePage = new homePage(driver);
        HomePage.navigateToHomePage();
        newUserSignUpObject = new newUserSignUpPage(driver);
        userInformationObject = new userInformationPage(driver);


    }

    @AfterMethod
    public void closeDriver() {

        driver.quit();
    }

}
