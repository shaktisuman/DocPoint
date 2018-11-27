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

import org.eclipse.jetty.websocket.api.Session;

import domain.login.Login;
import userDAO.*;
import bookDAO.*;

@WebServlet("/BookController")
public class BookControllerOld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookControllerOld() {}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			System.out.println("in DoPost");
			
			//Get all doctors from DB
			DoctorDao doctorDao = new DoctorDaoImpl();
			
			List<Doctor> docList = doctorDao.getAllDoctors();
			List<String> docListFormat = new ArrayList<String>();
			
			for (Doctor doc : docList) {
				docListFormat.add(doc.getID() + "_" + doc.getName());
			}
			
			//Print out doctor format
			for (String docString : docListFormat) {
				//System.out.println(docString);
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
			String dt = "";
			
			String submitType = request.getParameter("submit");
			
			//Sending list of doctors to populate dropdown in UI
			int counter = 0;
			if(submitType.equals("fetchDList"))
			{
				int count = 1;
				System.out.println("Sending list of doctors to populate dropdown in UI");
				request.setAttribute("names", docListFormat);
				request.setAttribute("firstLoad", "done");
				//request.setAttribute("busyDays", returnedDates);
				request.getRequestDispatcher("bookAppointment.jsp").include(request, response);
			}

			
			//Receiving selected Doctor from dropdown and send back the dates for which the doctor is busy
			if(submitType.equals("dlist"))
			{
				String[] SelectedDoc = request.getParameterValues("docList");
				System.out.println("Printing selected doctor below");
				System.out.print("Selected Doctor ID:");
				System.out.println(SelectedDoc[0].split("_")[0]);
				request.setAttribute("busyDays", returnedDates);
				System.out.println("Returning back busy days");
				request.getRequestDispatcher("bookAppointment.jsp").include(request, response);
			}
			
			
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
				System.out.print("Printing Slots:");
				System.out.println(slotString);
			}
			
			if(submitType.equals("slotList"))
			{
				String selDate = request.getParameter("selDate");
				System.out.println("Sel Date: "+ selDate);
				request.setAttribute("dt", selDate);
				request.setAttribute("slots", slotListFormat);
				request.getRequestDispatcher("bookAppointment.jsp").include(request, response);
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
			//System.out.println(e);
			System.out.println("");
		}
		
	}
}
