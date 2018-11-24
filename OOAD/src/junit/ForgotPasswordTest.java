package junit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import userDAO.Patient;
import userDAO.PatientDao;
import userDAO.PatientDaoImpl;

public class ForgotPasswordTest {
	WebDriver driver;
	@Before
	public void openForgotPasswordPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\domin\\git\\DrBook\\OOAD\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8887/OOAD/forgotpassword.jsp");
		Assert.assertEquals("Forgot Password", driver.getTitle());
	}
	
	@Test
	public void testForgotPassword() throws InterruptedException{
		
		System.out.println("*************** Forgot Password ***************");
		System.out.println("========= Test Successful Cases ==========");	
			PatientDao patientDao = new PatientDaoImpl();
			Patient p = patientDao.getPatient("NancyPatient");	
		
			WebElement username_box = driver.findElement(By.id("username"));
			WebElement submit_btn = driver.findElement(By.name("submit"));
			
			username_box.sendKeys(p.getUsername());
			
			submit_btn.click();
			Thread.sleep(2000);
			Assert.assertEquals("Reset Password", driver.getTitle());
			
			String oldpw = p.getPassword();
			String newpw = "NancyPatient14";
			
			driver.findElement(By.name("secretanswer")).sendKeys(p.getSecret_A());
			driver.findElement(By.name("password")).sendKeys(newpw);
			driver.findElement(By.name("retry-password")).sendKeys(newpw);
			submit_btn = driver.findElement(By.name("submit"));
			
			submit_btn.click();
			Thread.sleep(2000);
			Assert.assertEquals("Patient Login", driver.getTitle());
			
			System.out.println("----- Check Database -----");
			PatientDao pDao = new PatientDaoImpl();
			Patient p_check = pDao.getPatient(p.getUsername());

			Assert.assertEquals(newpw, p_check.getPassword());
			
			System.out.println("Password was changed from " + oldpw + " to " + p.getPassword());
			Thread.sleep(2000);
			
			
			System.out.println("----- Patient Login -----");
			username_box = driver.findElement(By.id("username"));
			WebElement password_box = driver.findElement(By.id("password"));
			submit_btn = driver.findElement(By.name("submit"));
			
			username_box.sendKeys(p.getUsername());
			password_box.sendKeys(p.getPassword());
			
			submit_btn.click();
			Thread.sleep(2000);
			Assert.assertEquals("PatientHome", driver.getTitle());
			
			WebElement h2 = driver.findElement(By.tagName("h2"));
			String name = h2.getText().trim();
			name = name.substring(6);
			System.out.println(name + " successfully logged in with new pw " + p.getPassword());
			Assert.assertEquals(p.getName(), name); 

			
			
		driver.get("http://localhost:8887/OOAD/forgotpassword.jsp");
		Thread.sleep(2000);
		
		System.out.println("========== Test failure Cases ==========");
		System.out.println("===== Wrong Username ======");
			username_box = driver.findElement(By.id("username"));
			submit_btn = driver.findElement(By.name("submit"));
			
			String wronguser = "WrongUserName01";
			username_box.sendKeys(wronguser);
			
			submit_btn.click();
			Thread.sleep(2000);
			Assert.assertEquals("Forgot Password", driver.getTitle());
			System.out.println("Username " + wronguser + " does not exist");
			
			System.out.println("===== Wrong Secret Answer =====");
			username_box = driver.findElement(By.id("username"));
			submit_btn = driver.findElement(By.name("submit"));
			
			username_box.sendKeys(p.getUsername());
			
			submit_btn.click();
			Thread.sleep(2000);
			Assert.assertEquals("Reset Password", driver.getTitle());
			
			String wronganswer = "WrongSecretAnswer01";
			newpw = "NancyPatient15";

			driver.findElement(By.name("secretanswer")).sendKeys(wronganswer);
			driver.findElement(By.name("password")).sendKeys(newpw);
			driver.findElement(By.name("retry-password")).sendKeys(newpw);
			submit_btn = driver.findElement(By.name("submit"));
			Thread.sleep(2000);
			
			submit_btn.click();
			Thread.sleep(2000);
			Assert.assertEquals("Reset Password", driver.getTitle());
			System.out.println(wronganswer + " does not match secret answer: " + p.getSecret_A());
			
			System.out.println("----- Check Database -----");
			pDao = new PatientDaoImpl();
			p_check = pDao.getPatient(p.getUsername());
			Assert.assertEquals(p.getPassword(), p_check.getPassword());
			
			System.out.println("Password does NOT change to " + newpw + " but stays as " + p.getPassword());
			Thread.sleep(2000);	
		
	}
	
	@After
	public void closePage(){
		driver.quit();
	}
	

}
