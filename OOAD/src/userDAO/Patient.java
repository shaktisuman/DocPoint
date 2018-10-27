package userDAO;

public class Patient {
	
	private int ID;
	private String name;
	private String username;
	private String password;
	private String Secret_Q;
	private String Secret_A;
	
	private String Birthdate;
	private String Address;
	private String City;
	private String State;
	private String MedicalHistory;
	private String gender;
		
//	Empty Constructor
	public Patient (){
		this.ID = 0;
		this.name = null;
		this.username = null;
		this.password = "";
		this.Secret_Q = "";
		this.Secret_A = "";
		this.Birthdate ="";
		this.Address = "";
		this.City = "";
		this.State = "";
		this.MedicalHistory = "";
		this.gender = "";
		
	}
	
//	Full Constructor
	public Patient (int ID,
			String name,String username,
			String password, 
			String Secret_Q, String Secret_A, 
			String Birthdate, String Address, String City,
			String State,String MedicalHistory, String gender)
	{
		this.name = name;
		this.ID = ID;
		//this.info = info;
		this.username = username;
		this.password = password;
		this.Secret_Q = Secret_Q;
		this.Secret_A = Secret_A;
		this.Birthdate =Birthdate;
		this.Address = Address;
		this.City = City;
		this.State = State;
		this.MedicalHistory =MedicalHistory;
		this.gender = gender;
	}

//	Constructor without ID
	public Patient (String name,String username,
			String password,String Secret_Q, String Secret_A, 
			String Birthdate, String Address, String City,
			String State,String MedicalHistory, String gender)
	{
		this.name = name;
		//this.info = info;
		this.username = username;
		this.password = password;
		this.Secret_Q = Secret_Q;
		this.Secret_A = Secret_A;
		this.Birthdate =Birthdate;
		this.Address = Address;
		this.City = City;
		this.State = State;
		this.MedicalHistory =MedicalHistory;
		this.gender = gender;
	}	
	
//	Get method
	public String getName()
	{
		return name;
	}
	
	public int getID()
	{
		return ID;
	}
	
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getSecret_Q()
	{
		return Secret_Q;
	}
	
	public String getSecret_A()
	{
		return Secret_A;
	}
	public String getBirthdate() {
		return Birthdate;
	}
	public String getAddress() {
		return Address;
	}
	public String getCity() {
		return City;
	}
	public String getState() {
		return State;
	}
	public String getMedicalHistory() {
		return MedicalHistory;
	}
	public void setGender(String Gender) {
		this.gender = Gender;
	}
//	Set Method
	
	public void setName(String newname)
	{
		this.name = newname;
	}
	
	public void setID(int newID)
	{
		this.ID = newID;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setPassword(String newPass)
	{
		this.password = newPass;
	}
	
	public void setSecret_Q(String newSecret_Q)
	{
		this.Secret_Q = newSecret_Q;
	}

	public void setSecret_A(String newSecret_A)
	{
		this.Secret_A = newSecret_A;
	}
	
	public void setBirthdate(String Birthdate) {
		this.Birthdate = Birthdate;
	}
	
	public void setAddress(String Address) {
		this.Address = Address;
	}
	
	public void setCity(String City) {
		this.City = City;
	}
	
	public void setState(String State) {
		this.State = State;
	}
	
	public void setMedicalHistory(String MedicalHistory) {
		this.MedicalHistory = MedicalHistory;
	}
	public String getGender() {
		return gender;
	}
	
	
	public String toString()
	{
		String s = String.format("ID: %1$s \nName: %2$s \nUsername: %3$s "
								+ "\nPassword: %4$s "
								+ "\nSecretQ: %5$s \nSecretA: %6$s" 
								+ " \nBirthdate: %7$s \nAddress: %8$s \nCity: %9$s \nState: %10$s " 
								+ "\nMedicalHistory: %11$s \nGender: %12$s "
								, ID, name, username, password,Secret_Q,Secret_A,Birthdate,Address,City,State,MedicalHistory,gender);
		return s;
	}

}
