package userDAO;

public class Doctor {

	private int Doc_ID;
	private String name;
	private String username;
	private String password;
	
	private String Specialty;
	private String Info;
	
	// Constructor
	
	// Empty Constructor
	Doctor(){
		this.Doc_ID = -1;
		this.name = "";
		this.username = "";
		this.password = "";
		this.Specialty = "";
		this.Info = "";
	}

	// Full Constructor
	Doctor(int Doc_ID,String name, String username, String password, String Specialty, String Info){
		setID(Doc_ID);
		setName(name);
		setUsername(username);
		setPassword(password);
		setSpecialty(Specialty);
		setInfo(Info);
		//		this.password = pass
	}
	
	// Constructor without ID
	Doctor(String name, String username, String password, String Specialty, String Info){
		setName(name);
		setUsername(username);
		setPassword(password);
		setSpecialty(Specialty);
		setInfo(Info);
		//		this.password = pass
	}
	
	// Set method
	public void setName(String newname)
	{
		this.name = newname;
	}
	
	public void setID(int newID)
	{
		this.Doc_ID = newID;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setPassword(String newPass)
	{
		this.password = newPass;
	}
	
	public void setSpecialty(String spec)
	{
		this.Specialty = spec;
	}
	
	public void setInfo(String info)
	{
		this.Info = info;
	}
	
	
	// Get Method

	public String getName()
	{
		return name;
	}
	
	public int getID()
	{
		return Doc_ID;
	}
	
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getSpecialty()
	{
		return Specialty;
	}
	
	public String getInfo()
	{
		return Info;
	}
	
	public String toString()
	{
		String s = String.format("DocID: %1$s \nName: %2$s \nUsername: %3$s "
								+ "\nPassword: %4$s "
								+ "\nSpecialty: %5$s \nInfo: %6$s" 
								, Doc_ID, name, username, password,Specialty,Info);
		return s;
	}
	
	

}
