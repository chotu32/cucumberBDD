package pages;
//Importing packages
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.BaseClass;

public class SourceAndDestinationPage extends BaseClass {
    public WebDriver driver;

    public SourceAndDestinationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Storing required MakeMyTrip web elements
    public static final By FROM = By.id("fromCity");
    public static final By TO = By.id("toCity");
    public static final By TEXT_TO = By.xpath("(//input[@aria-autocomplete='list'])[position()=2]");



    public void sendSourcePlace(String sourcePlace, WebDriver driver) {
        try {
            waitForExpectedElement(driver, FROM);
            driver.findElement(FROM).click();
            driver.findElement(FROM).clear();
            driver.findElement(FROM).sendKeys(sourcePlace);
            // Wait for 2 Seconds
            Thread.sleep(2000);
            driver.findElement(FROM).sendKeys(Keys.ARROW_DOWN);
            // Wait for 2 Seconds
            Thread.sleep(2000);
            driver.findElement(FROM).sendKeys(Keys.ENTER);
        } catch (Exception e) {
            e.getMessage();
        }

    }

    public String getTextFromSource(WebDriver driver) {
        String source = null;
        try {
            waitForExpectedElement(driver, TO);
            WebElement textbox = driver.findElement(TO);
            source = textbox.getAttribute("value");
        } catch (Exception e) {
            e.getMessage();
        }
        return source;
    }

    public void sendDestinationPlace(String destinationPlace, WebDriver driver) {
        try {
            waitForExpectedElement(driver, TO);
            driver.findElement(TO).click();
            driver.findElement(TO).clear();
            driver.findElement(TO).sendKeys(destinationPlace);
            // Wait for 2 Seconds
            Thread.sleep(2000);
            driver.findElement(TO).sendKeys(Keys.ARROW_DOWN);
            // Wait for 2 Seconds
            Thread.sleep(2000);
            driver.findElement(TO).sendKeys(Keys.ENTER);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public String getTextFromDestination(WebDriver driver) {
        String source = null;
        try {
            waitForExpectedElement(driver, TO);
            WebElement textbox = driver.findElement(TO);
            source = textbox.getAttribute("value");
        } catch (Exception e) {
            e.getMessage();
        }
        return source;
    }
}
