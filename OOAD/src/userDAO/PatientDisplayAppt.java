package userDAO;

public class PatientDisplayAppt {
	private String docName;
	private String date;
	private String start_t;
	private String end_t;

	public PatientDisplayAppt(String docName, String date, String start_t, String end_t){
		this.docName = docName;
		this.date = date;
		this.date = start_t;
		this.date = end_t;
	}
	
	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStart_t() {
		return start_t;
	}

	public void setStart_t(String start_t) {
		this.start_t = start_t;
	}

	public String getEnd_t() {
		return end_t;
	}

	public void setEnd_t(String end_t) {
		this.end_t = end_t;
	}
}
