package userDAO;

//import java.util.List;

import domain.login.Login;

public class DoctorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoctorDao doctorDao = new DoctorDaoImpl();
			
		System.out.println("======== Validate Doctor Login: Success ========");
		Login login = new Login("johnsmith@email.com","password");
		Doctor d_success = doctorDao.validateDoctor(login);
		System.out.println(d_success);	
		
		System.out.println("======== Validate Doctor Login: Fail ========");
		login = new Login("NotADoctor@email.com","password");
		Doctor d_fail = doctorDao.validateDoctor(login);
		System.out.println(d_fail);		
		
		System.out.println("======== Get all Doctors ========");			
		for (Doctor doc : doctorDao.getAllDoctors()) {
			System.out.println(doc.toString());
		}
		
		System.out.println("======== Get Patient by username :johnsmith@email.com  ========");	
		Doctor d1 = doctorDao.getDoctor("johnsmith@email.com");
		System.out.println(d1);
		
		System.out.println("======== Update Doctor Specialty: Pediatrics,Dermatology ========");
		d_success.setSpecialty("Pediatrics,Dermatology");
		doctorDao.updateDoctor(d_success);
		Doctor d_check = doctorDao.getDoctor(d_success.getUsername());
		System.out.println(d_check.toString());
		
		
		System.out.println("======== Add 2 new doctors ========");		
		Doctor NancyD = new Doctor("NancyD","nancyD@gmail.com","12345","Anesthesiology,Neurology,","This is a doctor");
		Doctor NancyX = new Doctor("NancyX","nancyX@gmail.com","12345","Neurology,Pediatrics,ENT","This is a doctor");		
		doctorDao.addDoctor(NancyD);
		doctorDao.addDoctor(NancyX);

		System.out.println("======== Get Doctor by Specialty: Neurology ========");	
		for (Doctor doc : doctorDao.getDoctorbySpecialty("Neurology")) {
			System.out.println(doc.toString());
		}
		
		System.out.println("======== Delete 2 new doctors ========");	
		doctorDao.deleteDoctor(NancyD);
		doctorDao.deleteDoctor(NancyX);
		
	}

}
