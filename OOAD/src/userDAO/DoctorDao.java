package userDAO;

import java.util.List;
import userDAO.Doctor;
import domain.login.Login;

public interface DoctorDao {

	public List<Doctor> getAllDoctors();
	
	public Doctor getDoctor(String username);
	public List<Doctor> getDoctorbySpecialty(String specialty);
	
	public int addDoctor(Doctor d);
	public void updateDoctor(Doctor d);
	public void deleteDoctor(Doctor d);
	public void deleteAllDoctors();
	public Doctor validateDoctor(Login login);
}
