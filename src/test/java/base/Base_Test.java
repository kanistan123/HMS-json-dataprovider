package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


public class Base_Test {

	WebDriver driver;

	@BeforeSuite
	@Parameters("brower")
	public void setup(String brower) {
		switch (brower.toLowerCase()) {
		case ("chrome"):
			driver = new ChromeDriver();
		case ("edge"):
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://teststaybreez.invictainnovations.com/");
	}
	
	@AfterSuite
	public void teardown() {
		driver.quit();
	}

}
