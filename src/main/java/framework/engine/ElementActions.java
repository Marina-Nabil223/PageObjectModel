package framework.engine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementActions {

    public static void click(WebDriver driver, By elementLocator) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));

        // Scroll to element
        String elementName = driver.findElement(elementLocator).getAccessibleName();
        driver.findElement(elementLocator).click();

        System.out.println("Clicking on element " + elementLocator + " " + elementName);

    }
}
