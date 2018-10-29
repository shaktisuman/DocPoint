package junit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import userDAO.Doctor;
import userDAO.DoctorDao;
import userDAO.DoctorDaoImpl;
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
		Assert.assertEquals("Patient Login", driver.getTitle());
	}
	
	@Test
	public void testPatientLogin() throws InterruptedException{
		
		System.out.println("======== Patient Login ========");
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
			Assert.assertEquals("Patient Login", driver.getTitle());

			driver.get("http://localhost:8080/OOAD/login.jsp");
			Thread.sleep(2000);

		}		
		
	}

	@Test
	public void testDoctorLogin() throws InterruptedException{
		driver.get("http://localhost:8080/OOAD/doctorlogin.jsp");
		Thread.sleep(2000);
		System.out.println("======== Doctor Login ========");
		System.out.println("======== Test Successful Cases ========");	
		DoctorDao dDao = new DoctorDaoImpl();
		for (Doctor p : dDao.getAllDoctors()) {
//			System.out.println(p.toString());
			
			WebElement username_box = driver.findElement(By.id("username"));
			WebElement password_box = driver.findElement(By.id("password"));
			WebElement submit_btn = driver.findElement(By.name("submit"));
			
			username_box.sendKeys(p.getUsername());
			password_box.sendKeys(p.getPassword());
			
			submit_btn.click();
			Thread.sleep(2000);
			Assert.assertEquals("DoctorHome", driver.getTitle());
			
			WebElement h2 = driver.findElement(By.tagName("h2"));
			String name = h2.getText().trim();
			name = name.substring(6);
			System.out.println(name);
			Assert.assertEquals(p.getName(), name);
			
			driver.get("http://localhost:8080/OOAD/doctorlogin.jsp");
			Thread.sleep(2000);

		}
		
		System.out.println("======== Test failure Cases ========");
		for (Doctor p : dDao.getAllDoctors()) {
//			System.out.println(p.toString());
			
			WebElement username_box = driver.findElement(By.id("username"));
			WebElement password_box = driver.findElement(By.id("password"));
			WebElement submit_btn = driver.findElement(By.name("submit"));
			
			username_box.sendKeys(p.getUsername());
			password_box.sendKeys("WrongPassWord01");
			
			submit_btn.click();
			Thread.sleep(2000);
			Assert.assertEquals("Doctor Login", driver.getTitle());

			driver.get("http://localhost:8080/OOAD/doctorlogin.jsp");
			Thread.sleep(2000);

		}		
		
	}
	
	@After
	public void closePage(){
		driver.quit();
	}
	

}
