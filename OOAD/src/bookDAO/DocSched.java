package bookDAO;

import userDAO.*;

import java.util.ArrayList;
import java.util.List;

public class DocSched {

	private Doctor doc;
	private List<Slot> list_slot;
	private List<Appt> list_appt;
	
//	Full Constructor
	DocSched (Doctor doc, List<Slot> list_slot, List<Appt> list_appt)
	{
		this.doc = doc;
		this.list_slot = list_slot;
		this.list_appt = list_appt;
	}
	
	public List<String> getAvailSlots() {
		List<String> availSlots =  new ArrayList<String>();
		
		for (Slot slot : list_slot) {
			boolean contained = false; 
			for(Appt appt: list_appt) {
				if(appt.getSlot_Id() == slot.getSlot_Id()){
					contained = true;
				}
			}
			if(contained == false) {
				availSlots.add(Integer.toString(slot.getSlot_Id()) + "_" + slot.getStart_t()/60 + ":" + slot.getStart_t()%60 + "-" +  + slot.getEnd_t()/60 + ":" + slot.getEnd_t()%60);
			 }
		}
		System.out.println("here");
		return availSlots;
	}
}
