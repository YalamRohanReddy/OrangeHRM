package Orange_Dashboard;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BrowserLaunch {
    public WebDriver driver;
    @BeforeTest
    @Parameters("browser") // This allows you to pass the browser type from the testng.xml
    public void setup(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize(); // Maximize the browser window
        //driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        //driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

    }


    @AfterTest
            public void closeBrowser(){
        driver.close();
    }

}


