package userDAO;
import userDAO.Patient;
import domain.login.Login;

public class PatientDemo {
	public static void main(String[] args) {
//		Please Create Table Patients as follows or import from 
		
//		DROP TABLE IF EXISTS `Patients`;
//		/*!40101 SET @saved_cs_client     = @@character_set_client */;
//		/*!40101 SET character_set_client = utf8 */;
//		CREATE TABLE `Patients` (
//		  `ID` int(11) NOT NULL AUTO_INCREMENT,
//		  `name` varchar(255) DEFAULT NULL,
//		  `username` varchar(255) NOT NULL,
//		  `password` varchar(255) DEFAULT NULL,
//		  `info` varchar(255) DEFAULT NULL,
//		  `Secret_Q` varchar(255) NOT NULL,
//		  `Secret_A` varchar(255) NOT NULL,
//		  PRIMARY KEY (`ID`),
//		  UNIQUE KEY `username` (`username`)
//		) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

		
		
		PatientDao patientDao = new PatientDaoImpl();
		
		System.out.println("======== Add 3 new patients ========");
		Patient linh = new Patient("Linh Truong","linhtruong@gmail.com","12345","This is a patient","How are you?","I'm Ok");
		Patient max = new Patient("Max Chen","maxchen@gmail.com","12345","This is a patient","How are you?","I'm Ok");
		Patient shakti = new Patient("Shakti","shakti@gmail.com","321","This is another patient","How are you?","I'm Ok");
		patientDao.addPatient(linh);
		patientDao.addPatient(max);
		patientDao.addPatient(shakti);
		
		System.out.println("======== Validate Patient Login ========");
		Login login = new Login("linhtruong@gmail.com","12345");
		Patient p4 = patientDao.validatePatient(login);
		System.out.println(p4);		
		
		System.out.println("======== Get all Patients ========");		
		for (Patient p : patientDao.getAllPatients()) {
			System.out.println(p.toString());
		}
		
		System.out.println("======== Get Patient by ID = 1 ========");	
		Patient p1 = patientDao.getPatient(1);
		System.out.println(p1);
		
		System.out.println("======== Get Patient by email: linhtruong@gmail.com ========");
		Patient p2 = patientDao.getPatient("linhtruong@gmail.com");
		System.out.println(p2);

		System.out.println("======== Update Patient Shakti ========");
		Patient p3_new = patientDao.getPatient("shakti@gmail.com");
		p3_new.setInfo("This is an extreme patient");
		patientDao.updatePatient(p3_new);
		Patient p3_update = patientDao.getPatient("shakti@gmail.com");
		System.out.println(p3_update);
		
		System.out.println("======== Delete Patient Shakti ========");
		patientDao.deletePatient(p3_new);
		Patient p3_delete = patientDao.getPatient("shakti@gmail.com");
		if (p3_delete.getID() == 0){
			System.out.println("Shakti has been no longer in database");
		}
		
		System.out.println("======== Delete Other Patients ========");
		patientDao.deleteAllPatients();
	
	}
}
