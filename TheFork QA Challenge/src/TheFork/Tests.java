package TheFork;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Tests {
public WebDriver driver;
JSONParser jsonparser = new JSONParser();

 @BeforeTest
 public void beforeTest() throws Exception{

	try{
	//Setting system properties of ChromeDriver
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\SALAH\\eclipse-workspace\\TheFork QA Challenge\\driver\\chromedriver.exe");

	//Open browser and launching the specified URL
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://www.thefork.fr/");
 	}
 	catch (WebDriverException e) 
	{
 		e.printStackTrace();
	}
 }

 @AfterTest
  public void afterTest() throws Exception{
	 try
	 {
	 driver.quit();
	 }
	 catch (WebDriverException e) 
	 {
		 e.printStackTrace();
	 }
 }

 @Test
  public void login() throws Exception{
	 try
	 {
		JSONObject jsonobject = (JSONObject) jsonparser.parse(new FileReader("json\\data.json"));
		String email = (String) jsonobject.get("email");
		String password = (String) jsonobject.get("password");
		String firstname = (String) jsonobject.get("firstname");
		String lastname = (String) jsonobject.get("lastname");
		String phonenumber = (String) jsonobject.get("phonenumber");
		String daybirth = (String) jsonobject.get("daybirth");
		String monthbirth = (String) jsonobject.get("monthbirth");
		String yearbirth = (String) jsonobject.get("yearbirth");
		ElementsAndFunctions elementsAndFunctions = new ElementsAndFunctions(driver);
		//elementsAndFunctions.clickOnRecapchaCheckBox();
		Thread.sleep(5000);
		elementsAndFunctions.clickOnAccept();
		elementsAndFunctions.LogIn(email, password);
		elementsAndFunctions.clickOnMyPersonalInformation();
		elementsAndFunctions.verifyPersonalInformation(firstname, lastname, phonenumber, daybirth, monthbirth, yearbirth);
		
	 }
	 catch(WebDriverException e)
	 {
		 e.printStackTrace();
	 }
 }
}
