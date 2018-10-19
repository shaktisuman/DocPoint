package userDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DbManager;
import domain.login.Login;
import userDAO.Patient;

public class PatientDaoImpl implements PatientDao {
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	

	
	@Override
	public List<Patient> getAllPatients() {
		/**
		 * This method get all patients
		 * @return List of Patients
		 * @exception com.mysql.jdbc.exceptions
		 */
		List<Patient> patient_list = new ArrayList<Patient>();
		try
		{
			conn 	= db.getConnection();
			ps		= conn.prepareStatement("select * from PATIENT");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
							
				Patient p = new Patient(Integer.parseInt(rs.getString("Patient_Id")),
						rs.getString("Name"), rs.getString("Username"),
						rs.getString("Password"),  rs.getString("Secret_Q"),rs.getString("Secret_A"),
						rs.getString("Birthdate"),rs.getString("Address"),rs.getString("City"),
						rs.getString("State"),rs.getString("Medical_Hist"),rs.getString("Gender"));
				
				patient_list.add(p);
			}
			
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return patient_list;		
	}
	
	private Patient decodeRS(ResultSet rs)
	{
		Patient p = new Patient();
		try
		{
			p = new Patient(Integer.parseInt(rs.getString("Patient_Id")),
					rs.getString("Name"), rs.getString("Username"),
					rs.getString("Password"),  rs.getString("Secret_Q"),rs.getString("Secret_A"),
					rs.getString("Birthdate"),rs.getString("Address"),rs.getString("City"),
					rs.getString("State"),rs.getString("Medical_Hist"),rs.getString("Gender"));		
		}catch(Exception e)
		{
			System.out.println(e);
			return null;
		}

		return p;
	}
	
	@Override
	public Patient getPatient(String username) {
		/**
		 * This method query Patient by username (email)
		 * @param String username
		 * @return Patient
		 * @exception com.mysql.jdbc.exceptions
		 */
		
		// TODO Auto-generated method stub
		Patient p = new Patient();
		try
		{
			conn 	= db.getConnection();
			ps		= conn.prepareStatement("select * from PATIENT where Username=?");
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				p = decodeRS(rs);
//				p = new Patient(Integer.parseInt(rs.getString("ID")),
//						rs.getString("name"), rs.getString("username"),
//						rs.getString("password"), rs.getString("info"),
//						rs.getString("Secret_Q"),rs.getString("Secret_A"));
			}
			
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
		return p;
	}
	@Override
	public Patient getPatient(int ID) {
		/**
		 * This method query Patient by ID
		 * @param int ID
		 * @return Patient
		 * @exception com.mysql.jdbc.exceptions
		 */

		Patient p = new Patient();
		try
		{
			conn 	= db.getConnection();
			ps		= conn.prepareStatement("select * from PATIENT where Patient_Id=?");
			ps.setString(1, Integer.toString(ID));
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				p = new Patient(Integer.parseInt(rs.getString("Patient_Id")),
						rs.getString("Name"), rs.getString("Username"),
						rs.getString("Password"),  rs.getString("Secret_Q"),rs.getString("Secret_A"),
						rs.getString("Birthdate"),rs.getString("Address"),rs.getString("City"),
						rs.getString("State"),rs.getString("Medical_Hist"),rs.getString("Gender"));
			}
			
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return p;
	}
	@Override
	public int addPatient(Patient p) {
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

			ps =conn.prepareStatement("insert into PATIENT (Name,Username,Password,Secret_Q,Secret_A,Birthdate,Address,City,State,Medical_Hist,Gender) values(?,?,?,?,?,?,?,?,?,?,?)");
//			ps.setString(1, Integer.toString(p.getID()));
			ps.setString(1, p.getName());
			ps.setString(2, p.getUsername());
			ps.setString(3, p.getPassword());
			ps.setString(4, p.getSecret_Q());
			ps.setString(5, p.getSecret_A());
			ps.setString(6, p.getBirthdate());
			ps.setString(7, p.getAddress());
			ps.setString(8, p.getCity());
			ps.setString(9, p.getState());
			ps.setString(10, p.getMedicalHistory());
			ps.setString(11, p.getGender());
			
			status = ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return status;
		
	}
	@Override
	public void updatePatient(Patient p) {
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

			ps =conn.prepareStatement("update PATIENT set Name = ?,Username=?,Password=?, Secret_Q=?,"
					+ "Secret_A=?,Birthdate =? , Address = ?, City = ?, State = ?, Medical_Hist =?,  Gender =? where Patient_Id =?");
			ps.setString(1, p.getName());
			ps.setString(2, p.getUsername());
			ps.setString(3, p.getPassword());
			ps.setString(4, p.getSecret_Q());
			ps.setString(5, p.getSecret_A());
			ps.setString(6, p.getBirthdate());
			ps.setString(7, p.getAddress());
			ps.setString(8, p.getCity());
			ps.setString(9, p.getState());
			ps.setString(10, p.getMedicalHistory());
			ps.setString(11, p.getGender());
			ps.setString(12, Integer.toString(p.getID()));
			
			ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
	@Override
	public void deletePatient(Patient p) {
		/**
		 * This method delete Patient to table "Patients" and auto reset AUTO_INCREMENT
		 * @param Patient
		 * @return status
		 * @exception com.mysql.jdbc.exceptions
		 */				
		try{
			conn = db.getConnection();

			ps =conn.prepareStatement("delete from PATIENT where Username = ?;ALTER TABLE PATIENT AUTO_INCREMENT = 1;");
			ps.setString(1, p.getUsername());
			ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}		
	}

	@Override
	public void deleteAllPatients() {
		/**
		 * This method delete all patients from table "Patients" and auto reset AUTO_INCREMENT
		 * @param Patient
		 * @return status
		 * @exception com.mysql.jdbc.exceptions
		 */				
		try{
			conn = db.getConnection();

			ps =conn.prepareStatement("delete from PATIENT;ALTER TABLE PATIENT AUTO_INCREMENT = 1;");
			ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}		
	}
	
	@Override
	public Patient validatePatient(Login login) {
		/**
		 * This method validate Patients login
		 * @param Patient
		 * @return status
		 * @exception com.mysql.jdbc.exceptions
		 */	
		Patient p = new Patient();
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("select * from PATIENT where Username = ? and Password = ?");
			ps.setString(1, login.getUsername());
			ps.setString(2, login.getPassword());

			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				p = decodeRS(rs);
			}
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return p;
	}
	
}
