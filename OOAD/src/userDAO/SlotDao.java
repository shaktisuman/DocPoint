package userDAO;

import userDAO.Slot;
import java.util.List;

public interface SlotDao {
	
	public Slot getSlot(int Slot_Id);
	
	public int addSlot(Slot s);
	public void updateSlot(Slot s);
	public void deleteSlot(Slot s);
	
	public void deleteAllSlotsForDoc(int Doc_Id);
	
	public List<Slot> getSlotsForDoc(int Doc_Id);
	public int getTotalNumSlotsForDoc(int Doc_Id);
	
	public List<Slot> getAvailSlotsForDocOnDate(int Doc_Id, String Date);
	
}
