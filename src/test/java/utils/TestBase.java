package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;
    Properties prop;

    public WebDriver WebDriverManager() throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
        prop = new Properties();
        prop.load(fis);
        String url = prop.getProperty("QAUrl");
        String browser_propeties = prop.getProperty("browser");
        String browser_maven = System.getProperty("browser");// to run using maven command
        //result = testCondition? value1:value2
       String browser = browser_maven!=null ? browser_maven:browser_propeties;
        if (driver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("safari")) {
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(url);
            driver.manage().window().maximize();

        }
        return driver;
    }
}
