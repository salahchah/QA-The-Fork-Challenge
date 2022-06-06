package TheFork;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class ElementsAndFunctions {

	private WebDriver driver;
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
	//Elements
	private By cookiesAcceptButton = By.xpath("//button[@id='_evidon-accept-button']");
	private By LogInButton = By.xpath("//button[@class='_35vz9']");
	private By emailAdress = By.xpath("//input[@id='identification_email']");
	private By submitEmailButton = By.xpath("//button[@data-testid='checkout-submit-email']");
	private By psswrd = By.xpath("//input[@id='password']");
	private By submitPasswordButton = By.xpath("//button[@data-testid='submit-password']");
	private By personalInformationButton = By.xpath("//button[@aria-controls='user-space-user-information']");
	private By firstname = By.xpath("//input[@name='firstName']");
	private By lastname = By.xpath("//input[@name='lastName']");
	private By phonenumber = By.xpath("//input[@name='phoneNumber.nationalNumber']");
	private By daybirth = By.xpath("//input[@name='birthDate.day']");
	private By monthbirth = By.xpath("//Select[@name='birthDate.month']");
	private By yearbirth = By.xpath("//input[@name='birthDate.year']");
	
	protected static final Logger log = LoggerFactory.getLogger(ElementsAndFunctions.class);

	//Methods
	public ElementsAndFunctions(WebDriver driver) throws Exception{
	try
	{
		this.driver = driver;
	}
 	catch (WebDriverException e) 
	{
 		e.printStackTrace();
	}
	}	
	//Click on recaptcha methood
	public void clickOnRecapchaCheckBox() throws InterruptedException
	{
		//We can not automate the capcha, please do it manually
	}
	//Click on accept cookies method
	public void clickOnAccept() throws Exception{
	{
	try
	{
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		log.info("Click on accept button");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(cookiesAcceptButton));
		driver.findElement(cookiesAcceptButton).click();
	}
	catch (WebDriverException e) 
	{
	 	e.printStackTrace();
	}
	}
	}
	//click on submit email button
	public void clickOnSubmitEmail() throws Exception{
		try
		{
			log.info("Click on submit email button");
			//wait.until(ExpectedConditions.presenceOfElementLocated(submitEmailButton));
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
			driver.findElement(submitEmailButton).click();
		}
		catch (WebDriverException e) 
		{
		 	e.printStackTrace();
		}
	}
	//click on submit password button
	public void clickOnSubmitPassword() throws Exception{
	try
	{
		log.info("Click on submit password button");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		//wait.until(ExpectedConditions.presenceOfElementLocated(submitPasswordButton));
		driver.findElement(submitPasswordButton).click();
	}
	catch (WebDriverException e) 
	{
	 	e.printStackTrace();
	}
	}
	//LogIn Method
	public void LogIn(String email, String password) throws Exception{
	try
	{
	    log.info("Log in with an existing account");
	    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	    //wait.until(ExpectedConditions.presenceOfElementLocated(LogInButton));
	    driver.findElement(LogInButton).click();
	    //wait.until(ExpectedConditions.presenceOfElementLocated(emailAdress));
	    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	    driver.findElement(emailAdress).sendKeys(email);
	    clickOnSubmitEmail();
	    //wait.until(ExpectedConditions.presenceOfElementLocated(psswrd));
	    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	    driver.findElement(psswrd).sendKeys(password);
	    clickOnSubmitPassword();    
	}
	 catch (WebDriverException e) 
	{
	 		e.printStackTrace();
	}
	}
	//click on submit password button
	public void clickOnMyPersonalInformation() throws Exception{
	try
	{
		log.info("Click on my personal information button");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		//wait.until(ExpectedConditions.presenceOfElementLocated(submitPasswordButton));
		driver.findElement(personalInformationButton).click();
	}
	 catch (WebDriverException e) 
	{
	 		e.printStackTrace();
	}
	}
	//verify the Personal informations
	public void verifyPersonalInformation(String firstnamee, String lastnamee, String phonenumberr ,String daybirthh, String monthbirthh, String yearbirthh) throws Exception
	{
		try
		{
		log.info("VerifyPresonalnformation");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		assertEquals(firstnamee, driver.findElement(firstname).getAttribute("value"));
		assertEquals(lastnamee, driver.findElement(lastname).getAttribute("value"));
		assertEquals(phonenumberr, driver.findElement(phonenumber).getAttribute("value"));
		assertEquals(daybirthh, driver.findElement(daybirth).getAttribute("value"));
		assertEquals(monthbirthh, driver.findElement(monthbirth).getAttribute("value"));
		assertEquals(yearbirthh, driver.findElement(yearbirth).getAttribute("value"));
		log.info("Success");
		}
	catch (WebDriverException e)
	{
		e.printStackTrace();
	}
	}
}
