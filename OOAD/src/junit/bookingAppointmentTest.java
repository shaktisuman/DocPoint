package junit;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import bookDAO.Appt;
import bookDAO.ApptDao;
import bookDAO.ApptDaoImpl;
import userDAO.PatientDao;
import userDAO.PatientDaoImpl;
import userDAO.Patient;

public class bookingAppointmentTest {
	WebDriver driver;
	Patient p;
	Appt myAppt = new Appt();
	@Before
	public void openLoginPage() throws InterruptedException{
		System.out.println("======== Patient Booking Appointment ========");
		System.setProperty("webdriver.gecko.driver","geckodriver");
		driver = new FirefoxDriver();
		
		driver.get("http://localhost:8080/OOAD/login.jsp");
		Assert.assertEquals("Patient Login", driver.getTitle());
		PatientDao patientDao = new PatientDaoImpl();
		p = patientDao.getAllPatients().get(0);
		System.out.println(p.toString());
		
		
		WebElement username_box = driver.findElement(By.id("username"));
		WebElement password_box = driver.findElement(By.id("password"));
		WebElement submit_btn = driver.findElement(By.name("submit"));
		
		username_box.sendKeys(p.getUsername());
		password_box.sendKeys(p.getPassword());
		
		submit_btn.click();
		Thread.sleep(2000);
		Assert.assertEquals("PatientHome", driver.getTitle());
		
//		Appt myAppt = new Appt();
		myAppt.setAppt_Date("2018-11-15");
		myAppt.setPatient_Id(p.getID());
	}
	
	@Test
	public void testBooking_success() throws InterruptedException{	
		
		
		
		System.out.println("======== Test Success Cases ========");
	
//		(int Appt_Id, String Appt_Date, int Slot_Id, int Patient_Id, int Doc_Id)
//		(String Appt_Date, int Slot_Id, int Patient_Id, int Doc_Id)
		
		WebElement booking_btn = driver.findElement(By.id("bookApp"));
		booking_btn.click();
		
		Thread.sleep(2000);
		
		Select doctorselect = new Select(driver.findElement(By.id("docList")));
		doctorselect.selectByIndex(1);
		myAppt.setDoc_Id(1);
		
		Thread.sleep(2000);
		
		WebElement date = driver.findElement(By.id("15"));
		date.click();	
		
		Thread.sleep(2000);	
		
		Select slotList = new Select(driver.findElement(By.id("slotList")));
		slotList.selectByIndex(1);
		myAppt.setSlot_Id(1);
		
		Thread.sleep(2000);	
		WebElement finish_btn = driver.findElement(By.id("bk"));
		finish_btn.click();
		
		Thread.sleep(2000);	
		Assert.assertEquals("PatientHome", driver.getTitle());
		
		System.out.println("======== Checking Database ========");
		
		ApptDao appDao = new ApptDaoImpl();
//		checkAppt = appDao.getApptForPatient(p.getID()).get(index);
		
//		System.out.println(myAppt.toString());
		
		List<Appt> checkAppt_list = appDao.getApptForPatient(p.getID(), myAppt.getAppt_Date());
		
		Appt checkAppt = checkAppt_list.get(checkAppt_list.size()-1);
		
//		System.out.println(checkAppt.toString());
		
		System.out.println("Check Date");
		Assert.assertEquals(myAppt.getAppt_Date(), checkAppt.getAppt_Date());
		
		System.out.println("Check SlotID");
		Assert.assertEquals(myAppt.getSlot_Id(), checkAppt.getSlot_Id());
		
		System.out.println("Check DocID");
		Assert.assertEquals(myAppt.getDoc_Id(), checkAppt.getDoc_Id());

		System.out.println("Check PatientID");
		Assert.assertEquals(myAppt.getPatient_Id(), checkAppt.getPatient_Id());	
		
//		appDao.deleteAppt(checkAppt);
		
	}
	
	@Test
	public void testCancel_success() throws InterruptedException{
		
		WebElement seeApp = driver.findElement(By.id("seeApp"));
		seeApp.click();
		
		Thread.sleep(2000);	

		Select appList = new Select(driver.findElement(By.id("appList")));
		appList.selectByIndex(0);
		
		Thread.sleep(2000);	
		
		ApptDao appDao = new ApptDaoImpl();
		List<Appt> checkAppt_list = appDao.getApptForPatient(p.getID(), myAppt.getAppt_Date());
		int size1 = checkAppt_list.size();

		WebElement cancel_btn = driver.findElement(By.id("delBTN"));
		cancel_btn.click();
		
		Thread.sleep(2000);	
		
		checkAppt_list = appDao.getApptForPatient(p.getID(), myAppt.getAppt_Date());
		int size2 = checkAppt_list.size();
		
		Assert.assertEquals(size1, size2 + 1);
		

				
	}
	
}