package bookDAO;

public class Appt {

	private int Appt_Id;
	private String Appt_Date;
	private int Slot_Id;
	private int Patient_Id;
	private int Doc_Id;
	
//	Empty Constructor
	Appt (){
		this.Appt_Id = -1;
		this.Appt_Date = "null";
		this.Slot_Id = -1;
		this.Patient_Id = -1;
		this.Doc_Id = -1;
	}
	
//	Full Constructor
	Appt (int Appt_Id, String Appt_Date, int Slot_Id, int Patient_Id, int Doc_Id)
	{
		this.Appt_Id = Appt_Id;
		this.Appt_Date = Appt_Date;
		this.Slot_Id = Slot_Id;
		this.Patient_Id = Patient_Id;
		this.Doc_Id = Doc_Id;
	}

//	Constructor without Appt_Id
	Appt (String Appt_Date, int Slot_Id, int Patient_Id, int Doc_Id)
	{
		this.Appt_Date = Appt_Date;
		this.Slot_Id = Slot_Id;
		this.Patient_Id = Patient_Id;
		this.Doc_Id = Doc_Id;
	}
	
	public int getAppt_Id() {
		return Appt_Id;
	}

	public void setAppt_Id(int appt_Id) {
		Appt_Id = appt_Id;
	}

	public String getAppt_Date() {
		return Appt_Date;
	}

	public void setAppt_Date(String appt_Date) {
		Appt_Date = appt_Date;
	}

	public int getSlot_Id() {
		return Slot_Id;
	}

	public void setSlot_Id(int slot_Id) {
		Slot_Id = slot_Id;
	}

	public int getPatient_Id() {
		return Patient_Id;
	}

	public void setPatient_Id(int patient_Id) {
		Patient_Id = patient_Id;
	}

	public int getDoc_Id() {
		return Doc_Id;
	}

	public void setDoc_Id(int doc_Id) {
		Doc_Id = doc_Id;
	}
}
