package devops.ilp1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.firefox.FirefoxOptions;

import devops.ilp1.IntegrationTest;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.File;

import org.junit.experimental.categories.Category;
import io.github.bonigarcia.wdm.WebDriverManager;

@Category(IntegrationTest.class)
public class LoginFunctionalTest {

	static WebDriver driver;

	@BeforeClass
	public static void setup() {
		//driver = new ChromeDriver();
		// new FirefoxDriver();
		WebDriverManager.firefoxdriver().setup();
				FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        System.setProperty("webdriver.gecko.driver", "geckodriver");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        
        driver = new FirefoxDriver(firefoxOptions);
	//System.setProperty("webdriver.chrome.driver","/home/yetirajam/Desktop/work/jyoti/chromedriver"); 
		//ChromeOptions options = new ChromeOptions();
/*options.addArguments("start-maximized"); // open Browser in maximized mode
options.addArguments("disable-infobars"); // disabling infobars
options.addArguments("--disable-extensions"); // disabling extensions
options.addArguments("--disable-gpu"); // applicable to windows os only
options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
options.addArguments("--no-sandbox"); // Bypass OS security model
		options.addArguments("--headless"); */
		//options.setExperimentalOption("useAutomationExtension", false);
	//driver = new ChromeDriver(options);  
	}

	@AfterClass
	public static void cleanUp() {
		driver.quit();
	}

	@Test
	public void loginSuccess() {
        driver.get("http://localhost:6080/ILP_Bookstore");
	//driver.get("http://localhost:5050/ILP_Bookstore");
        WebElement email = driver.findElement(By.name("email"));
        WebElement pass = driver.findElement(By.name("password"));
        WebElement button = driver.findElement(By.xpath("/html/body/form/div/button"));         
        email.sendKeys("avinash.patel@wipro.com");
        pass.sendKeys("1234");
        button.click();
        assertTrue(driver.getPageSource().contains("SuccessPage"));
	}
	
	//@Test
	public void loginFail() {
        driver.get("http://localhost:6080/ILP_Bookstore");
	//driver.get("http://localhost:5050/ILP_Bookstore");
        WebElement email = driver.findElement(By.name("email"));
        WebElement pass = driver.findElement(By.name("password"));
        WebElement button = driver.findElement(By.xpath("/html/body/form/div/button"));         
        email.sendKeys("avinash.patel@wipro.com");
        pass.sendKeys("1234566666666");
        button.click();
        assertTrue(driver.getPageSource().contains("Invalid username or password, Please try again with valid"));
	}
	
	@Test
	public void registrationSuccess() {
        driver.get("http://localhost:6080/ILP_Bookstore/register.jsp");
	//driver.get("http://localhost:5050/ILP_Bookstore/register.jsp");
        WebElement firstname = driver.findElement(By.name("firstname"));
        WebElement lastname = driver.findElement(By.name("lastname"));
        WebElement confirmpass = driver.findElement(By.name("confirmpass"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement pass = driver.findElement(By.name("pass"));
        WebElement button = driver.findElement(By.xpath("/html/body/form/div/button"));      
        firstname.sendKeys("fname");
        lastname.sendKeys("lname");
        pass.sendKeys("1234");
        confirmpass.sendKeys("1234");
        email.sendKeys("aa@gmail.com");
        button.click();
        assertTrue(driver.getPageSource().contains("Book Store"));
	}
	
	@Test
	public void forgotPasswordSuccess() {
        driver.get("http://localhost:6080/ILP_Bookstore/forgotpassword.jsp");   
	//driver.get("http://localhost:5050/ILP_Bookstore/forgotpassword.jsp"); 
        WebElement confirmpass = driver.findElement(By.name("confirmpassword"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement pass = driver.findElement(By.name("newpassword"));
        WebElement button = driver.findElement(By.xpath("/html/body/form/div/button"));      
        pass.sendKeys("1234");
        confirmpass.sendKeys("1234");
        email.sendKeys("avinash.patel@wipro.com");
        button.click();
        assertTrue(driver.getPageSource().contains("Book Store"));
	}
}
