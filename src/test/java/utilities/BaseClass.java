package utilities;
//Importing packages
import java.io.File;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {
    //ConfigClass config=new ConfigClass();
    private String frameworkDir = System.getProperty("user.dir");
    private String webDriverPath = frameworkDir + File.separator + "resources" + File.separator + "chromedriver.exe";


    // create instance for webdriver
    public static WebDriver driver;

    // to launch chrome browser
    public void launchBrowser(String url) {
        // declaration and instantiation of objects/variables

        //System.setProperty("webdriver.chrome.driver",
          //      Objects.requireNonNull(getClass().getClassLoader().getResource(webDriverPath)).getFile());
        // Objects.requireNonNull(getClass().getClassLoader().getResource("drivers/chromedriver.exe")).getFile()
        System.out.println("Framework Directory : " + frameworkDir);
        System.out.println("WebDriver Path : " + webDriverPath);
        System.out.println("Entered Base Class : " + url);
        for(;;)
        {
            System.setProperty("webdriver.chrome.driver", webDriverPath);
            driver = new ChromeDriver();
            System.out.println("Driver : " + driver);
            if(driver != null)
                break;
        }
        //WebDriverManager.chromedriver().setup();

        // create the new instance of Chrome drive

        // comment the above 2 lines and uncomment below 2 lines to use firefox
        // System.setProperty("webdriver.firefox.marionette","D:\\Centrallibrary\\Drivers\\geckodriver.exe");
        // driver=new FirefoxDriver();
        // maximize the window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // launch chrome and direct it to the Base URL
        driver.get(url);
    }



    // Explicit wait method for element clickable
    public WebElement waitForExpectedElement(WebDriver driver, final By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
