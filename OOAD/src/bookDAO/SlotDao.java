package bookDAO;

import java.util.List;

import bookDAO.Slot;

public interface SlotDao {
	
	public Slot getSlot(int Slot_Id);
	
	public int addSlot(Slot s);
	public void updateSlot(Slot s);
	public void deleteSlot(Slot s);
	
	public void deleteAllSlotsForDoc(int Doc_Id);
	
	public List<Slot> getSlotsForDoc(int Doc_Id);
	public int getTotalNumSlotsForDoc(int Doc_Id);
	
	public List<Slot> getAvailSlotsForDocOnDate(int Doc_Id, String Date);
	public int getNumAvailSlotsForDocOnDate(int Doc_Id, String Date);
	
}
