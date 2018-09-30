package bookDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DbManager;

public class ApptDaoImpl implements ApptDao {
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	
	@Override
	public Appt getAppt(int Appt_Id) {
		// TODO Auto-generated method stub
		/**
		 * This method query Appt by Appt_Id
		 * @param int Appt_Id
		 * @return Appt
		 * @exception com.mysql.jdbc.exceptions
		 */

		Appt a = new Appt();
		try
		{
			conn 	= db.getConnection();
			ps		= conn.prepareStatement("SELECT * FROM APPT WHERE Appt_Id=?");
			ps.setString(1, Integer.toString(Appt_Id));
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				a = new Appt(Integer.parseInt(rs.getString("Appt_Id")), rs.getString("Appt_Date"), 
						Integer.parseInt(rs.getString("Slot_Id")), Integer.parseInt(rs.getString("Patient_Id")), 
						Integer.parseInt(rs.getString("Doc_Id")));
			}
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return a;
	}

	@Override
	public int addAppt(Appt a) {
		// TODO Auto-generated method stub
		/**
		 * This method add new Appt to table "APPT"
		 * @param Appt
		 * @return status
		 * @exception com.mysql.jdbc.exceptions
		 */
		
		int status = 0;
		try{
			conn = db.getConnection();

			ps =conn.prepareStatement("INSERT INTO APPT (Appt_Date,Slot_Id,Patient_Id,Doc_Id) values(?,?,?,?)");
			ps.setString(1, a.getAppt_Date());
			ps.setString(2, Integer.toString(a.getSlot_Id()));
			ps.setString(3, Integer.toString(a.getPatient_Id()));
			ps.setString(4, Integer.toString(a.getDoc_Id()));
			
			status = ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return status;
	}

	@Override
	public void updateAppt(Appt a) {
		// TODO Auto-generated method stub
		/**
		 * This method update Appt to table "APPT"
		 * @param Appt
		 * @return status
		 * @exception com.mysql.jdbc.exceptions
		 */
		
		try{
			conn = db.getConnection();

			ps =conn.prepareStatement("UPDATE APPT SET Appt_Date = ?, Slot_Id= ?, Patient_Id= ?, Doc_Id= ? WHERE Appt_Id= ?");
			ps.setString(1, a.getAppt_Date());
			ps.setString(2, Integer.toString(a.getSlot_Id()));
			ps.setString(3, Integer.toString(a.getPatient_Id()));
			ps.setString(4, Integer.toString(a.getDoc_Id()));
			ps.setString(5, Integer.toString(a.getAppt_Id()));
			
			ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		
	}

	@Override
	public void deleteAppt(Appt a) {
		// TODO Auto-generated method stub
		/**
		 * This method delete Appt to table "APPT"
		 * @param Appt
		 * @return status
		 * @exception com.mysql.jdbc.exceptions
		 */				
		try{
			conn = db.getConnection();

			ps =conn.prepareStatement("DELETE FROM APPT WHERE Appt_Id = ?;");
			ps.setString(1, Integer.toString(a.getAppt_Id()));
			
			ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}		
	}

	@Override
	public List<Appt> getApptForDoc(int Doc_Id) {
		// TODO Auto-generated method stub
		/**
		 * This method get all appt for doc_id
		 * @param Int Doc_Id
		 * @return Appt
		 * @exception com.mysql.jdbc.exceptions
		 */
		List<Appt> appt_list = new ArrayList<Appt>();
		try
		{
			conn 	= db.getConnection();
			ps		= conn.prepareStatement("SELECT * FROM APPT WHERE Doc_id = ?;");
			ps.setString(1, Integer.toString(Doc_Id));
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
							
				Appt a = new Appt(Integer.parseInt(rs.getString("Appt_Id")), rs.getString("Appt_Date"), 
						Integer.parseInt(rs.getString("Slot_Id")), Integer.parseInt(rs.getString("Patient_Id")), 
						Integer.parseInt(rs.getString("Doc_Id")));
								
				appt_list.add(a);
			}
			
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return appt_list;
	}

	@Override
	public List<Appt> getApptForDoc(int Doc_Id, String Date) {
		// TODO Auto-generated method stub
		/**
		 * This method get all appt for doc_id for specific date
		 * @param Int Doc_Id, String Date
		 * @return Appt
		 * @exception com.mysql.jdbc.exceptions
		 */
		List<Appt> appt_list = new ArrayList<Appt>();
		try
		{
			conn 	= db.getConnection();
			ps		= conn.prepareStatement("SELECT * FROM APPT WHERE Doc_id = ? AND Appt_Date = ?;");
			ps.setString(1, Integer.toString(Doc_Id));
			ps.setString(2, Date);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
							
				Appt a = new Appt(Integer.parseInt(rs.getString("Appt_Id")), rs.getString("Appt_Date"), 
						Integer.parseInt(rs.getString("Slot_Id")), Integer.parseInt(rs.getString("Patient_Id")), 
						Integer.parseInt(rs.getString("Doc_Id")));
								
				appt_list.add(a);
			}
			
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return appt_list;
	}

	@Override
	public List<Appt> getApptForPatient(int Patient_Id) {
		// TODO Auto-generated method stub
		/**
		 * This method get all appt for patient_Id
		 * @param Int Patient_Id
		 * @return Appt
		 * @exception com.mysql.jdbc.exceptions
		 */
		List<Appt> appt_list = new ArrayList<Appt>();
		try
		{
			conn 	= db.getConnection();
			ps		= conn.prepareStatement("SELECT * FROM APPT WHERE Patient_Id = ?;");
			ps.setString(1, Integer.toString(Patient_Id));
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
							
				Appt a = new Appt(Integer.parseInt(rs.getString("Appt_Id")), rs.getString("Appt_Date"), 
						Integer.parseInt(rs.getString("Slot_Id")), Integer.parseInt(rs.getString("Patient_Id")), 
						Integer.parseInt(rs.getString("Doc_Id")));
								
				appt_list.add(a);
			}
			
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return appt_list;
	}

	@Override
	public int getBookedApptForDocOnDate(int Doc_Id, String Date) {
		// TODO Auto-generated method stub
		/**
		 * This method get num booked appts for doc_id for specific date
		 * @param Int Doc_Id, String Date
		 * @return Int
		 * @exception com.mysql.jdbc.exceptions
		 */
		int numBooked = -1;
		
		try
		{
			conn 	= db.getConnection();
			ps		= conn.prepareStatement("SELECT COUNT(Appt_id) FROM APPT WHERE Doc_id = ? AND Appt_Date = ?;");
			ps.setString(1, Integer.toString(Doc_Id));
			ps.setString(2, Date);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				numBooked = Integer.parseInt(rs.getString("COUNT(Appt_id)"));
			}
			
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
				
		return numBooked;
	}
	
}
