package tests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;
//    String host = "localhost";

    @BeforeTest
    public void before() throws MalformedURLException {

        String host = "localhost";
        DesiredCapabilities dc;

        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            dc = DesiredCapabilities.firefox();
            dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

        } else {
            dc = DesiredCapabilities.chrome();
            dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        }

        if (System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }

        String completeUrl = "http://" + host + ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
        this.driver.manage().window().maximize();

        /*String host = "localhost";
        ChromeOptions dc = new ChromeOptions();


        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {

            dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

        } else {

            dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        }

        if (System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }

        String completeUrl = "http://" + host + ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
        this.driver.manage().window().maximize();*/

    }

//    @Parameters({"Port"})
//    @BeforeMethod()
//    public void setUp(String Port) throws MalformedURLException {
//        if (Port.equalsIgnoreCase("32784")) {
//            System.out.println("Chrome Browser Initiated");
//            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//            capabilities.setBrowserName("chrome");
//            String completeUrl = "http://" + host + ":4444/wd/hub";
//
//            driver = new RemoteWebDriver(new URL(completeUrl), capabilities);
//
//            driver.manage().window().maximize();
//
//        } else if
//            (Port.equalsIgnoreCase("32785"))
//        {
//
//            System.out.println("Firefox Browser Initiated");
//            DesiredCapabilities capabilities1 = DesiredCapabilities.firefox();
//            capabilities1.setBrowserName("firefox");
//            String completeUrl = "http://" + host + ":4444/wd/hub";
//
//            driver = new RemoteWebDriver(new URL(completeUrl), capabilities1);
//
//
//            driver.manage().window().maximize();
//        }
//    }


        @AfterTest
    public void quit(){
        driver.quit();
    }

}
