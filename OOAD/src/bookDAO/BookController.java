package bookDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.login.Login;
import userDAO.*;
import bookDAO.*;

@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookController() {}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			System.out.println("in DoPost");
			
			//Get all doctors from DB
			DoctorDao doctorDao = new DoctorDaoImpl();
			
			List<Doctor> docList = doctorDao.getAllDoctors();
			List<String> docListFormat = new ArrayList<String>();
			List<String> docNames = new ArrayList<String>();
			
			for (Doctor doc : docList) {
				docListFormat.add(doc.getID() + "_" + doc.getName());
				docNames.add(doc.getName());
			}
			
			//Print out doctor format
			for (String docString : docListFormat) {
				//System.out.println(docString);
			}
			
			//Sending list of doctors to populate dropdown in UI
			String submitType = request.getParameter("submit");
			if(submitType.equals("fetchDList"))
			{
				System.out.println("Sending list of doctors to populate dropdown in UI");
				request.setAttribute("names", docNames);
				request.setAttribute("firstLoad", "done");
				request.getRequestDispatcher("bookAppointment.jsp").include(request, response);
			}

			if(submitType.equals("dlist"))
			{
				String[] SelectedDoc = request.getParameterValues("docList");
				System.out.println("Printing selected doctor below");
				System.out.println(SelectedDoc[0]);
				request.getRequestDispatcher("bookAppointment.jsp").include(request, response);
			}
			
			//After select a specific doc, display available dates for booking
			
			//first get a list of dates "yyyy-dd-MM", below is dummy data
			List<String> returnedDates = new ArrayList();
			returnedDates.add("2018-10-01");
			returnedDates.add("2018-10-02");
			returnedDates.add("2018-10-03");
			returnedDates.add("2018-09-21");
			
			//dummy docId
			int dummydocID = 1;
			
			//Get available num slots for each date for specific doctor
			SlotDao slotDao = new SlotDaoImpl();
			
			List<Integer> numSlots = new ArrayList();
			for(String date: returnedDates) {
				numSlots.add(slotDao.getNumAvailSlotsForDocOnDate(dummydocID, date));
			}
			
			//Print out numSlots
			for (Integer Nslot : numSlots) {
				//System.out.println(Nslot);
			}
			
			//Fill out date availability
			
			//After select a specific date, display available slots for booking
			String dummyDate = "2018-10-01";
			
			List<Slot> availSlots = slotDao.getAvailSlotsForDocOnDate(dummydocID, dummyDate);
			
			List<String> slotListFormat = new ArrayList();
			
			for (Slot slot : availSlots) {
				slotListFormat.add(slot.getSlot_Id() + "_" + slot.getStart_t() + "_" + slot.getEnd_t());
			}
			
			//Print out slot format
			for (String slotString : slotListFormat) {
				//System.out.println(slotString);
			}
			
			// They select a slot_id
			int dummySlot = 1;
			int dummyPatient = 1;
			
			// Create an appointment
			ApptDao apptDao = new ApptDaoImpl();
			
			//String Appt_Date, int Slot_Id, int Patient_Id, int Doc_Id
			Appt app = new Appt(dummyDate, dummySlot, dummyPatient, dummydocID);
			apptDao.addAppt(app);
			
		}
		catch(Exception e){
			System.out.println("DB Error!");
			System.out.println(e);
		}
		
	}
}
