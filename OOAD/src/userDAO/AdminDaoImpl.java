package userDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DbManager;
import domain.login.Login;
import userDAO.Admin;

public class AdminDaoImpl implements AdminDao{
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	@Override
	public List<Admin> getAllAdmin() {
		/**
		 * This method get all doctors
		 * @return List of Admins
		 * @exception com.mysql.jdbc.exceptions
		 */
		List<Admin> admin_list = new ArrayList<Admin>();
		try
		{
			conn 	= db.getConnection();
			ps		= conn.prepareStatement("select * from DRBOOK_ADMIN");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
							
				Admin a = new Admin(Integer.parseInt(rs.getString("Admin_Id")),rs.getString("Name"), rs.getString("Username"),rs.getString("Password"));
				
				admin_list.add(a);
			}
			
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return admin_list;
	}
	private Admin decodeRS(ResultSet rs)
	{
		Admin a = new Admin();
		try
		{
			a = new Admin(Integer.parseInt(rs.getString("Admin_Id")),
					rs.getString("Name"), rs.getString("Username"),
					rs.getString("Password"));
			
		}catch(Exception e)
		{
			System.out.println(e);
			return null;
		}

		return a;
	}

	@Override
	public Admin getAdmin(String email) {
		/**
		 * This method query Admin by username (email)
		 * @param String username
		 * @return Patient
		 * @exception com.mysql.jdbc.exceptions
		 */
		
		// TODO Auto-generated method stub
		Admin a = new Admin();
		try
		{
			conn 	= db.getConnection();
			ps		= conn.prepareStatement("select * from DRBOOK_ADMIN where Username=?");
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				a = decodeRS(rs);
			}
			
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
		return a;
	}



	@Override
	public Admin validateAdmin(Login login) {
		/**
		 * This method validate Patients login
		 * @param Patient
		 * @return status
		 * @exception com.mysql.jdbc.exceptions
		 */	
		Admin a = new Admin();
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("select * from DRBOOK_ADMIN where Username = ? and Password = ?");
			ps.setString(1, login.getUsername());
			ps.setString(2, login.getPassword());

			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				a = decodeRS(rs);
			}
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return a;
	}
	

}
