package BasePack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browserLaunch {
	public static WebDriver driver;
	public static Properties property= new Properties();
	public static FileInputStream fis;

	
	public static void setup() throws IOException {
		fis = new FileInputStream("./src/test/resources/configFiles/config.properties");
		property.load(fis);
	}
	
	public static void launchBrowser() throws IOException {
		
		if(property.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}else if(property.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}else {
			WebDriverManager.iedriver().setup();
			 driver = new InternetExplorerDriver();
		}

		driver.get(property.getProperty("url"));
	}
	
	public static void terminate() {
		driver.close();
	}
	
}
