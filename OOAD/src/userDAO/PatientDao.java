package userDAO;

import userDAO.Patient;
import domain.login.Login;
import java.util.List;

public interface PatientDao {

	public List<Patient> getAllPatients();
	
	public Patient getPatient(String email);
	public Patient getPatient(int ID);
	
	public int addPatient(Patient p);
	public void updatePatient(Patient p);
	public void deletePatient(Patient p);
	public void deleteAllPatients();
	
	public Patient validatePatient(Login login);
	
}
