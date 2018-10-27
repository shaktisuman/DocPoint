package junit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import userDAO.Patient;
import userDAO.PatientDao;
import userDAO.PatientDaoImpl;

public class LoginTest {
	WebDriver driver;
	@Before
	public void openLoginPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/OOAD/login.jsp");
		Assert.assertEquals("Dr. Book Login", driver.getTitle());
	}
	
	@Test
	public void testLogin() throws InterruptedException{
		
		
		System.out.println("======== Test Successful Cases ========");	
		PatientDao patientDao = new PatientDaoImpl();
		for (Patient p : patientDao.getAllPatients()) {
//			System.out.println(p.toString());
			
			WebElement username_box = driver.findElement(By.id("username"));
			WebElement password_box = driver.findElement(By.id("password"));
			WebElement submit_btn = driver.findElement(By.name("submit"));
			
			username_box.sendKeys(p.getUsername());
			password_box.sendKeys(p.getPassword());
			
			submit_btn.click();
			Thread.sleep(2000);
			Assert.assertEquals("PatientHome", driver.getTitle());
			
			WebElement h2 = driver.findElement(By.tagName("h2"));
			String name = h2.getText().trim();
			name = name.substring(6);
			System.out.println(name);
			Assert.assertEquals(p.getName(), name);
			
			driver.get("http://localhost:8080/OOAD/login.jsp");
			Thread.sleep(2000);

		}
		
		System.out.println("======== Test failure Cases ========");
		for (Patient p : patientDao.getAllPatients()) {
//			System.out.println(p.toString());
			
			WebElement username_box = driver.findElement(By.id("username"));
			WebElement password_box = driver.findElement(By.id("password"));
			WebElement submit_btn = driver.findElement(By.name("submit"));
			
			username_box.sendKeys(p.getUsername());
			password_box.sendKeys("WrongPassWord01");
			
			submit_btn.click();
			Thread.sleep(2000);
			Assert.assertEquals("Register", driver.getTitle());

			driver.get("http://localhost:8080/OOAD/login.jsp");
			Thread.sleep(2000);

		}		
		
	}
	
//	@Test
//	public void testRegister() throws InterruptedException{
//		driver.get("http://localhost:8080/OOAD/register.jsp");
//		Thread.sleep(2000);	
//		
//		Patient p = new Patient();
//		p.setName(newname);
//		driver.findElement(By.name("name")).sendKeys("TestUser01");
//		driver.findElement(By.name("username")).sendKeys("TestUser01@gmail.com");
//		driver.findElement(By.name("password")).sendKeys("TestUser01");
//		driver.findElement(By.name("retry-password")).sendKeys("TestUser01");
//		
//		Select question = new Select(driver.findElement(By.tagName("select")));
//		question.selectByIndex(2);
//		
//		driver.findElement(By.name("retry-password")).sendKeys("TestUser01");
//	}
	
	@After
	public void closePage(){
		driver.quit();
	}
	

}
