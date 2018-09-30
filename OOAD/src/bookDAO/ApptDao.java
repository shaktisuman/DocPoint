package bookDAO;

import java.util.List;

public interface ApptDao {
	
	public Appt getAppt(int Appt_Id);
	
	public int addAppt(Appt a);
	public void updateAppt(Appt a);
	public void deleteAppt(Appt a);
	
	public List<Appt> getApptForDoc(int Doc_Id);
	public List<Appt> getApptForDoc(int Doc_Id, String Date); //overloaded to get all appt for a specific date
	
	public List<Appt> getApptForPatient(int Patient_Id);
	
	public int getBookedApptForDocOnDate(int Doc_Id, String Date);
	
	
}
