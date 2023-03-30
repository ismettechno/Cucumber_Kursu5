package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {

    //her 1 threde özel lokal static driver oluşturdum
    private static ThreadLocal<WebDriver> threadDriver=new ThreadLocal<>(); //webDriver 1 , webDriver 2..
    private static ThreadLocal<String> threadBrowserName=new ThreadLocal<>(); // chrome, firefox

    // threadDriver.get()  --> bulunduğum thread deki driverı ver
    // threadDriver.set(driver) --> bulunduğum thread e driver set ediliyor
    public static WebDriver getDriver()
    {
        // extend report türkçe bilg çalışmaması sebebiyle kondu
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        Logger logger= Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

        //diğer senaryolar için default chrome
        if (threadBrowserName.get() == null)
            threadBrowserName.set("chrome");

        if (threadDriver.get() == null) { // bu thread de driver var mı

            switch (threadBrowserName.get())
            {
                case "firefox":
                    threadDriver.set(new FirefoxDriver());
                    break;

                case "safari":
                    threadDriver.set(new SafariDriver());
                    break;

                case "edge":
                    threadDriver.set(new EdgeDriver());
                    break;

                default:
                    //chrome
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    threadDriver.set(new ChromeDriver(options));   // yoksa buraya bir tane set et
                    break;
            }
        }

        threadDriver.get().manage().window().maximize();
        return threadDriver.get();
    }

    public static void quitDriver(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (threadDriver.get() != null) { // dolu ise, boş değilse
            threadDriver.get().quit();
            WebDriver driver = threadDriver.get(); driver=null;
            threadDriver.set(driver);
        }
    }

    public static void threadBrowserSet(String browser){
        threadBrowserName.set(browser);
    }

}
