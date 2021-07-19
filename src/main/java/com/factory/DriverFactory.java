package com.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    WebDriver driver;
    public static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public WebDriver initWebDriver(String browser){
        if(browser.equals("chrome")){
            System.out.println("Chrome");
            WebDriverManager.chromedriver().setup();
            driverThreadLocal.set(new ChromeDriver());
        }
        else if (browser.equals("firefox")){
            System.out.println("firefox");
            WebDriverManager.firefoxdriver().setup();
            driverThreadLocal.set(new FirefoxDriver());
        }
        else{
            System.out.println("Web driver initialization failed");
        }

        getWebDriver().manage().deleteAllCookies();
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return getWebDriver();
    }

    public static synchronized WebDriver getWebDriver(){
        return driverThreadLocal.get();
    }
}
