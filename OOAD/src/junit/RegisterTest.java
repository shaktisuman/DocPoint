package junit;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import userDAO.Doctor;
import userDAO.DoctorDao;
import userDAO.DoctorDaoImpl;
import userDAO.Patient;
import userDAO.PatientDao;
import userDAO.PatientDaoImpl;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class RegisterTest {
	WebDriver driver;
	@Before
	public void openLoginPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver");
		driver = new ChromeDriver();
//		driver.get("http://localhost:8080/OOAD/login.jsp");
//		Assert.assertEquals("Patient Login", driver.getTitle());
	}
	
	@Test
	public void testPatientRegister() throws InterruptedException{
		driver.get("http://localhost:8080/OOAD/register.jsp");
		Thread.sleep(2000);
		
		
		String[] p = {"TestUser1","10/18/2018","Male","Heart","test address",
				"test city","test state","TestUser1@gmail.com","Password01","What is your mother's maiden name?","Test Answer"};
		Patient p1 = new Patient();
		p1.setName(p[0]);
		p1.setBirthdate(p[1]);
		p1.setGender(p[2]);
		p1.setMedicalHistory(p[3]);
		p1.setAddress(p[4]);
		p1.setCity(p[5]);
		p1.setState(p[6]);
		p1.setUsername(p[7]);
		p1.setPassword(p[8]);
		p1.setSecret_Q(p[9]);
		p1.setSecret_A(p[10]);
		
		
		System.out.println("======== Patient Registration ========");
//		System.out.println("======== Test Successful Cases ========");	
		
		driver.findElement(By.name("name")).sendKeys(p1.getName());
		
		WebElement dateField = driver.findElement(By.name("birthdate"));
		dateField.sendKeys(p1.getBirthdate());
//        //This are the columns of the from date picker table
//        List<WebElement> columns = dateField.findElements(By.tagName("td"));
//
//        //DatePicker is a table. Thus we can navigate to each cell
//        //and if a cell matches with the current date then we will click it.
//        for (WebElement cell: columns) {
//            /*
//            //If you want to click 18th Date
//            if (cell.getText().equals("18")) {
//            */
//            //Select Today's Date
//            if (cell.getText().equals("18")) {
//                cell.click();
//                break;
//            }
//        }
		
		Select gender = new Select(driver.findElement(By.name("gender")));
		gender.selectByIndex(0);
	
		List<WebElement> sickness = driver.findElements(By.name("sickness"));
		sickness.get(7).click();

		driver.findElement(By.id("street")).sendKeys(p1.getAddress());
		driver.findElement(By.name("city")).sendKeys(p1.getCity());
		driver.findElement(By.name("state")).sendKeys(p1.getState());

		driver.findElement(By.name("username")).sendKeys(p1.getUsername());
		driver.findElement(By.name("password")).sendKeys(p1.getPassword());
		driver.findElement(By.name("retry-password")).sendKeys(p1.getPassword());
		
		Select question = new Select(driver.findElement(By.name("secretquestion")));
		question.selectByIndex(1);
		
		driver.findElement(By.name("secretanswer")).sendKeys(p1.getSecret_A());
		
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
//		
		System.out.println("======== Check Database ========");
		PatientDao pDao = new PatientDaoImpl();
		Patient p1_check = pDao.getPatient(p1.getUsername());
		Assert.assertEquals(p1.getUsername(), p1_check.getUsername());
		Assert.assertEquals(p1.getBirthdate(), p1_check.getBirthdate());
		Assert.assertEquals(p1.getPassword(), p1_check.getPassword());
		Assert.assertEquals(p1.getUsername(), p1_check.getUsername());
		
//		Assert.assertEquals(p1, p1_check);
//		pDao.deletePatient(p1_check);
		Thread.sleep(2000);
		
		
		System.out.println("======== Patient Login ========");
//		driver.get("http://localhost:8080/OOAD/register.jsp");
//		Thread.sleep(2000);
				
		WebElement username_box = driver.findElement(By.id("username"));
		WebElement password_box = driver.findElement(By.id("password"));
		WebElement submit_btn = driver.findElement(By.name("submit"));
		
		username_box.sendKeys(p1.getUsername());
		password_box.sendKeys(p1.getPassword());
		
		submit_btn.click();
		Thread.sleep(2000);
		Assert.assertEquals("PatientHome", driver.getTitle());
		
		WebElement h2 = driver.findElement(By.tagName("h2"));
		String name = h2.getText().trim();
		name = name.substring(6);
		System.out.println(name);
		Assert.assertEquals(p1.getName(), name);
		
//		Delete Patient
		pDao.deletePatient(p1_check);

	}
	
	@After
	public void closePage(){
		driver.quit();
	}
}
