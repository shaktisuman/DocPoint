package userDAO;

public class Patient {
	
	private int ID;
	private String name;
	private String username;
	private String password;
	private String info;
	private String Secret_Q;
	private String Secret_A;
		
//	Empty Constructor
	Patient (){
		this.ID = 0;
		this.name = "";
		this.info = "";
		this.username = "";
		this.password = "";
		this.Secret_Q = "";
		this.Secret_A = "";
	}
	
//	Full Constructor
	Patient (int ID,
			String name,String username,
			String password, String info,
			String Secret_Q, String Secret_A)
	{
		this.name = name;
		this.ID = ID;
		this.info = info;
		this.username = username;
		this.password = password;
		this.Secret_Q = Secret_Q;
		this.Secret_A = Secret_A;
	}

//	Constructor without ID
	Patient (String name,String username,
			String password, String info,
			String Secret_Q, String Secret_A)
	{
		this.name = name;
		this.info = info;
		this.username = username;
		this.password = password;
		this.Secret_Q = Secret_Q;
		this.Secret_A = Secret_A;
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
	
	public String getInfo()
	{
		return info;
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
	
	
//	Set Method
	
	public void setName(String newname)
	{
		this.name = newname;
	}
	
	public void setID(int newID)
	{
		this.ID = newID;
	}
	
	public void setInfo(String newInfo)
	{
		this.info = newInfo;
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
	
	public String toString()
	{
		String s = String.format("ID: %1$s \nName: %2$s \nUsername: %3$s "
								+ "\nPassword: %4$s \nInfo: %5$s "
								+ "\nSecretQ: %6$s \nSecretA: %7$s"
								, ID, name, username, password,info,Secret_Q,Secret_A);
		return s;
	}

}
