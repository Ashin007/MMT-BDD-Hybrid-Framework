package apphooks;

import com.factory.DriverFactory;
import com.util.PropertiesReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ApplicationHooks {

    WebDriver driver;
    DriverFactory driverFactory;
    PropertiesReader propertiesReader;
    Properties properties;

    @Before(order = 0)
    public void intProperties(){
        propertiesReader = new PropertiesReader();
        properties = propertiesReader.initProperties();
    }

    @Before(order = 1)
    public void initDriver(){
        driverFactory = new DriverFactory();
        driver = driverFactory.initWebDriver(properties.getProperty("browser"));
        driver.get("https://www.makemytrip.com/");
    }

    @After(order=1)
    public void tearDown(Scenario scenario){

        String screenShotName = scenario.getName().replaceAll(" ","_");
        byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(sourcePath,"image/png",screenShotName);

    }


//    @After(order=0)
//    public void quitBrowser(){
//        driver.quit();
//    }


}
