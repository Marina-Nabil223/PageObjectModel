package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class newUserSignUpPage {

    private WebDriver driver;

    private final By signUpMsg = By.xpath("(//h2)[3]");
    private final By userName =By.name("name");
    private final By userMail =By.xpath("//input[@data-qa='signup-email']");
    private final By signUPBtn =   By.xpath("//button[@data-qa='signup-button']");

    public newUserSignUpPage(WebDriver driver){

        this.driver = driver;

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

}
