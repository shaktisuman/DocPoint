package userDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DbManager;
import domain.login.Login;
import userDAO.Doctor;

public class DoctorDaoImpl implements DoctorDao{
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();

	@Override
	public List<Doctor> getAllDoctors() {
		/**
		 * This method get all doctors
		 * @return List of Doctors
		 * @exception com.mysql.jdbc.exceptions
		 */
		List<Doctor> doctor_list = new ArrayList<Doctor>();
		try
		{
			conn 	= db.getConnection();
			ps		= conn.prepareStatement("select * from DOC");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
							
				Doctor d = new Doctor(Integer.parseInt(rs.getString("Doc_Id")),
						rs.getString("Name"), rs.getString("Username"),
						rs.getString("Password"),  rs.getString("Specialty"),rs.getString("Info"));
				
				doctor_list.add(d);
			}
			
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return doctor_list;
	}

	private Doctor decodeRS(ResultSet rs)
	{
		Doctor d = new Doctor();
		try
		{
			d = new Doctor(Integer.parseInt(rs.getString("Doc_Id")),
					rs.getString("Name"), rs.getString("Username"),
					rs.getString("Password"),  rs.getString("Specialty"),rs.getString("Info"));
			
		}catch(Exception e)
		{
			System.out.println(e);
			return null;
		}

		return d;
	}


	@Override
	public Doctor getDoctor(String username) {
		/**
		 * This method query Doctor by username (email)
		 * @param String username
		 * @return Patient
		 * @exception com.mysql.jdbc.exceptions
		 */
		
		// TODO Auto-generated method stub
		Doctor d = new Doctor();
		try
		{
			conn 	= db.getConnection();
			ps		= conn.prepareStatement("select * from DOC where Username=?");
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				d = decodeRS(rs);
			}
			
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
		return d;
	}

	@Override
	public List<Doctor> getDoctorbySpecialty(String specialty) {
		/**
		 * This method query Doctor by username (email)
		 * @param String username
		 * @return Patient
		 * @exception com.mysql.jdbc.exceptions
		 */
		
		// TODO Auto-generated method stub
		List<Doctor> doctor_list = new ArrayList<Doctor>();
		try
		{
			conn 	= db.getConnection();
			ps		= conn.prepareStatement("select * from DOC where Specialty like ?");
			ps.setString(1, '%'+specialty+'%');
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
							
				Doctor d = new Doctor(Integer.parseInt(rs.getString("Doc_Id")),
						rs.getString("Name"), rs.getString("Username"),
						rs.getString("Password"),  rs.getString("Specialty"),rs.getString("Info"));
				
				doctor_list.add(d);
			}
			
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
		return doctor_list;
	}
	

	@Override
	public int addDoctor(Doctor d) {
		/**
		 * This method add new Patient to table "Patients"
		 * @param Patient
		 * @return status
		 * @exception com.mysql.jdbc.exceptions
		 */
		// TODO Auto-generated method stub
		int status = 0;
		try{
			conn = db.getConnection();

			ps =conn.prepareStatement("insert into DOC (Name,Username,Password,Specialty,Info) values(?,?,?,?,?)");
			ps.setString(1, d.getName());
			ps.setString(2, d.getUsername());
			ps.setString(3, d.getPassword());
			ps.setString(4, d.getSpecialty());
			ps.setString(5, d.getInfo());
			
			status = ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return status;
	}



	@Override
	public void updateDoctor(Doctor d) {
		/**
		 * This method update Patient to table "Patients"
		 * @param Patient
		 * @return status
		 * @exception com.mysql.jdbc.exceptions
		 */
		// TODO Auto-generated method stub
//		int status = 0;
		try{
			conn = db.getConnection();

			ps =conn.prepareStatement("update DOC set Name = ?,Username=?,Password=?,Specialty=?,Info =? where Doc_Id =?");
			ps.setString(1, d.getName());
			ps.setString(2, d.getUsername());
			ps.setString(3, d.getPassword());
			ps.setString(4, d.getSpecialty());
			ps.setString(5, d.getInfo());
			ps.setString(6, Integer.toString(d.getID()));
			
			ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		
	}



	@Override
	public void deleteDoctor(Doctor d) {
		/**
		 * This method delete Patient to table "Patients" and auto reset AUTO_INCREMENT
		 * @param Patient
		 * @return status
		 * @exception com.mysql.jdbc.exceptions
		 */				
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("delete from DOC where Username = ?;ALTER TABLE DOC AUTO_INCREMENT = 1;");
			ps.setString(1, d.getUsername());
			ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}		
	}



	@Override
	public void deleteAllDoctors() {
		/**
		 * This method delete all patients from table "Patients" and auto reset AUTO_INCREMENT
		 * @param Patient
		 * @return status
		 * @exception com.mysql.jdbc.exceptions
		 */				
		try{
			conn = db.getConnection();

			ps =conn.prepareStatement("delete from DOC;ALTER TABLE DOC AUTO_INCREMENT = 1;");
			ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}	
	}



	@Override
	public Doctor validateDoctor(Login login) {
		/**
		 * This method validate Patients login
		 * @param Patient
		 * @return status
		 * @exception com.mysql.jdbc.exceptions
		 */	
		Doctor d = new Doctor();
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("select * from DOC where Username = ? and Password = ?");
			ps.setString(1, login.getUsername());
			ps.setString(2, login.getPassword());

			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				d = decodeRS(rs);
			}
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return d;
	}

}
