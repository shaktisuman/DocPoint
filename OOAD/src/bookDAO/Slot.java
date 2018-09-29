package bookDAO;

public class Slot {
	
	private int slot_Id;
	private int start_t;
	private int end_t;
	private int doc_Id;
		
//	Empty Constructor
	Slot (){
		this.slot_Id = -1;
		this.start_t = -1;
		this.end_t = -1;
		this.doc_Id = -1;
	}
	
//	Full Constructor
	Slot (int slot_ID, int start_t, int end_t, int doc_Id)
	{
		this.slot_Id = slot_ID;
		this.start_t = start_t;
		this.end_t = end_t;
		this.doc_Id = doc_Id;
	}

//	Constructor without slot_ID
	Slot (int start_t, int end_t, int doc_Id)
	{
		this.start_t = start_t;
		this.end_t = end_t;
		this.doc_Id = doc_Id;
	}	
	
	//Getters and Setters
	public int getSlot_Id() {
		return slot_Id;
	}

	public void setSlot_Id(int slot_ID) {
		this.slot_Id = slot_ID;
	}

	public int getStart_t() {
		return start_t;
	}

	public void setStart_t(int start_t) {
		this.start_t = start_t;
	}

	public int getEnd_t() {
		return end_t;
	}

	public void setEnd_t(int end_t) {
		this.end_t = end_t;
	}

	public int getDoc_Id() {
		return doc_Id;
	}

	public void setDoc_Id(int doc_Id) {
		this.doc_Id = doc_Id;
	}
	
	@Override
	public String toString() {
		return "Slot [slot_ID=" + slot_Id + ", start_t=" + start_t + ", end_t=" + end_t + ", doc_Id=" + doc_Id + "]";
	}

}
