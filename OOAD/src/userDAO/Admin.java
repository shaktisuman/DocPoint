package userDAO;

public class Admin {
	private int Admin_ID;
	private String name;
	private String username;
	private String password;

	public Admin(){
		this.Admin_ID = -1;
		this.name = "";
		this.username = "";
		this.password = "";
	}
	// Full Constructor
	public Admin(int Doc_ID,String name, String username, String password){
		setID(Doc_ID);
		setName(name);
		setUsername(username);
		setPassword(password);

		//		this.password = pass
	}
	
	// Constructor without ID
	public Admin(String name, String username, String password){
		setName(name);
		setUsername(username);
		setPassword(password);

		//		this.password = pass
	}
	// Set method
	public void setName(String newname)
	{
		this.name = newname;
	}
	
	public void setID(int newID)
	{
		this.Admin_ID = newID;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setPassword(String newPass)
	{
		this.password = newPass;
	}
	
	// Get Method

		public String getName()
		{
			return name;
		}
		
		public int getID()
		{
			return Admin_ID;
		}
		
		
		public String getUsername()
		{
			return username;
		}
		
		public String getPassword()
		{
			return password;
		}
}
