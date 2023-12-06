package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class homePage {
    private WebDriver driver;

    String homePageUrl = "https://automationexercise.com/";

    // Element Locators
    private final By homePageTitle = By.xpath("//h2[@class='title text-center']");
    private final By selectSignUpIcon  = By.xpath("(//a//i)[4]");

    public homePage(WebDriver driver){

        this.driver = driver;

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

}
