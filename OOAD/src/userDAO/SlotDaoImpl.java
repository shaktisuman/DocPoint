package userDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DbManager;
import domain.login.Login;
import userDAO.Slot;

public class SlotDaoImpl implements SlotDao {
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	
	@Override
	public Slot getSlot(int Slot_Id) {
		// TODO Auto-generated method stub
		/**
		 * This method query Slot by Slot_Id
		 * @param int Slot_Id
		 * @return Slot
		 * @exception com.mysql.jdbc.exceptions
		 */

		Slot s = new Slot();
		try
		{
			conn 	= db.getConnection();
			ps		= conn.prepareStatement("SELECT * FROM SLOT WHERE Slot_Id=?");
			ps.setString(1, Integer.toString(Slot_Id));
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				s = new Slot(Integer.parseInt(rs.getString("Slot_Id")), Integer.parseInt(rs.getString("Start_T")), 
						Integer.parseInt(rs.getString("End_T")), Integer.parseInt(rs.getString("Doc_Id")));
			}
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return s;
	}
	@Override
	public int addSlot(Slot s) {
		// TODO Auto-generated method stub
		/**
		 * This method add new Slot to table "SLOT"
		 * @param Slot
		 * @return status
		 * @exception com.mysql.jdbc.exceptions
		 */
		
		int status = 0;
		try{
			conn = db.getConnection();

			ps =conn.prepareStatement("INSERT INTO SLOT (Start_T,End_T,Doc_Id) values(?,?,?)");
			ps.setString(1, Integer.toString(s.getStart_t()));
			ps.setString(2, Integer.toString(s.getEnd_t()));
			ps.setString(3, Integer.toString(s.getDoc_Id()));
			
			status = ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return status;
	}
	@Override
	public void updateSlot(Slot s) {
		// TODO Auto-generated method stub
		/**
		 * This method update Slot to table "SLOT"
		 * @param Slot
		 * @return status
		 * @exception com.mysql.jdbc.exceptions
		 */
		
		try{
			conn = db.getConnection();

			ps =conn.prepareStatement("UPDATE SLOT SET Start_T = ?,End_T=?,Doc_Id=? where Slot_Id =?");
			ps.setString(1, Integer.toString(s.getStart_t()));
			ps.setString(2, Integer.toString(s.getEnd_t()));
			ps.setString(3, Integer.toString(s.getDoc_Id()));
			ps.setString(4, Integer.toString(s.getSlot_Id()));
			
			ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	@Override
	public void deleteSlot(Slot s) {
		// TODO Auto-generated method stub
		/**
		 * This method delete Slot to table "SLOT"
		 * @param SLOT
		 * @return status
		 * @exception com.mysql.jdbc.exceptions
		 */				
		try{
			conn = db.getConnection();

			ps =conn.prepareStatement("DELETE FROM SLOT WHERE Slot_Id = ?;");
			ps.setString(1, Integer.toString(s.getSlot_Id()));
			
			ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}		
	}
	@Override
	public void deleteAllSlotsForDoc(int Doc_Id) {
		// TODO Auto-generated method stub
		/**
		 * This method delete Slot to table "SLOT"
		 * @param SLOT
		 * @return status
		 * @exception com.mysql.jdbc.exceptions
		 */				
		try{
			conn = db.getConnection();

			ps =conn.prepareStatement("DELETE FROM SLOT WHERE Doc_Id = ?;");
			ps.setString(1, Integer.toString(Doc_Id));
			
			ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}		
		
	}
	@Override
	public List<Slot> getSlotsForDoc(int Doc_Id) {
		// TODO Auto-generated method stub
		/**
		 * This method get all slots for doc_id
		 * @param Int Doc_Id
		 * @return Slot
		 * @exception com.mysql.jdbc.exceptions
		 */
		List<Slot> slot_list = new ArrayList<Slot>();
		try
		{
			conn 	= db.getConnection();
			ps		= conn.prepareStatement("SELECT * FROM SLOT WHERE Doc_id = ?;");
			ps.setString(1, Integer.toString(Doc_Id));
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
							
				Slot s = new Slot(Integer.parseInt(rs.getString("Slot_Id")), Integer.parseInt(rs.getString("Start_T")), 
						Integer.parseInt(rs.getString("End_T")), Integer.parseInt(rs.getString("Doc_Id")));
				
				slot_list.add(s);
			}
			
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return slot_list;
	}
	@Override
	public int getTotalNumSlotsForDoc(int Doc_Id) {
		// TODO Auto-generated method stub
		/**
		 * This method get num slots for doc_id
		 * @param Int Doc_Id
		 * @return Int
		 * @exception com.mysql.jdbc.exceptions
		 */
		int numSlots = -1;
		
		try
		{
			conn 	= db.getConnection();
			ps		= conn.prepareStatement("SELECT COUNT(Slot_id) FROM SLOT WHERE Doc_id = ?;");
			ps.setString(1, Integer.toString(Doc_Id));
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				numSlots = Integer.parseInt(rs.getString("COUNT(Slot_id)"));
			}
			
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return numSlots;
	}
	@Override
	public List<Slot> getAvailSlotsForDocOnDate(int Doc_Id, String Date) {
		// TODO Auto-generated method stub
		/**
		 * This method get all slots for doc_id on date
		 * @param Int Doc_Id, String Date
		 * @return Slot
		 * @exception com.mysql.jdbc.exceptions
		 */
		List<Slot> slot_list = new ArrayList<Slot>();
		try
		{
			conn 	= db.getConnection();
			ps		= conn.prepareStatement("SELECT * FROM SLOT WHERE Doc_id = ? \r\n" + 
					"AND SLOT.Slot_Id \r\n" + 
					"	NOT IN \r\n" + 
					"(SELECT Slot_Id FROM APPT WHERE Appt_Date = ? AND Doc_id = ?); ");
			ps.setString(1, Integer.toString(Doc_Id));
			ps.setString(2, Date);
			ps.setString(3, Integer.toString(Doc_Id));
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
							
				Slot s = new Slot(Integer.parseInt(rs.getString("Slot_Id")), Integer.parseInt(rs.getString("Start_T")), 
						Integer.parseInt(rs.getString("End_T")), Integer.parseInt(rs.getString("Doc_Id")));
				
				slot_list.add(s);
			}
			
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return slot_list;
	}
}
