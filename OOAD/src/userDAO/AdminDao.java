package userDAO;

import userDAO.Admin;
import domain.login.Login;
import java.util.List;

public interface AdminDao {

	public List<Admin> getAllAdmin();
	
	public Admin getAdmin(String email);
	//public Admin getAdmin(int ID);
	
	//public int addAdmin(Admin p);
	//public void updateAdmin(Admin p);
	//public void deleteAdmin(Admin p);
	//public void deleteAllAdmins();
	
	public Admin validateAdmin(Login login);
	
}
