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
			
			for (Doctor doc : docList) {
				docListFormat.add(doc.getID() + "_" + doc.getName());
			}
			
			String submitType = request.getParameter("submit");
			
			//Sending list of doctors to populate dropdown in UI
			if(submitType.equals("fetchDList"))
			{
				boolean showBookDiv = false;
				System.out.println("Sending list of doctors to populate dropdown in UI");
				request.setAttribute("names", docListFormat);
				request.setAttribute("firstLoad", "done");
				request.getRequestDispatcher("bookAppointment.jsp").include(request, response);
			}
			
			String date = "";
			int Doc_Id = -1;
			
			//send this list of avail slots to populate
			if(submitType.equals("slotList"))
			{
				//Receive Selected DocIdNameString and DateString
				String selDate = request.getParameter("selDate");
				String Day = selDate.split("-")[0];
				String Month = selDate.split("-")[1];
				String Year = selDate.split("-")[2];
				System.out.println("Sel Date: "+ selDate);
				//request.setAttribute("dt", Day);
				String[] SelectedDoc = request.getParameterValues("selDoc");
				System.out.println("Printing selected doctor below");
				System.out.print("Selected Doctor ID:");
				System.out.println(SelectedDoc[0].split("_")[0]);
				
				
				Doc_Id = Integer.valueOf((SelectedDoc[0].split("_")[0]));
				date = request.getParameter("selDate");
				
				//create doc object
				Doctor doc = doctorDao.getDoctor(Doc_Id);
				
				//create slot list
				SlotDao slotDao = new SlotDaoImpl();
				List<Slot> list_slot = slotDao.getSlotsForDoc(Doc_Id);
				
				//create appt list
				ApptDao apptDao = new ApptDaoImpl();
				List<Appt> list_appt = apptDao.getApptForDoc(Doc_Id, date);
				
				DocSched docSched = new DocSched(doc, list_slot, list_appt);
				
				List<String> list_format_slot = docSched.getAvailSlots();
				for(String x: list_format_slot) {
					System.out.println(x);
				}
				boolean showBookDiv = true;
				request.setAttribute("slots", list_format_slot);
				request.setAttribute("showBookDiv", showBookDiv);
				request.setAttribute("firstLoad", "done");
				request.setAttribute("names", docListFormat);
				request.getRequestDispatcher("bookAppointment.jsp").include(request, response);
			}
			
			
			if(submitType.equals("finishAppt"))
			{
				String dId = request.getParameter("dId");
				String saveDt = request.getParameter("saveDt");
				
				//recieve SlotId, PatId
				String Slot_IdStr = request.getParameter("selSlotId");
				int Slot_Id = Integer.valueOf(Slot_IdStr);
				System.out.println("Selected slot");
				System.out.println(Slot_Id);
				String Pat_IdStr = request.getParameter("selPatId");
				
				PatientDao patientDao = new PatientDaoImpl();
				Patient p = patientDao.getPatient(Pat_IdStr);
				int Pat_Id = p.getID();
				
				System.out.println("Pat id:");
				System.out.println(Pat_Id);
				
				ApptDao apptDao = new ApptDaoImpl();
				//create new appt object and save to db
				
				System.out.println(saveDt +"     " + Slot_Id + "   " + dId + "   " + Pat_Id);
				
				Appt new_Appt = new Appt(saveDt, Slot_Id, Pat_Id, Integer.parseInt(dId));
				
				apptDao.addAppt(new_Appt);
				request.setAttribute("confMSG", "success");
				//request.getRequestDispatcher("bookAppointment.jsp").include(request, response);
				request.setAttribute("name", p.getName());
				request.setAttribute("address", p.getAddress());
				request.setAttribute("birthdate", p.getBirthdate());
				request.setAttribute("city", p.getCity());
				request.setAttribute("Gender", p.getGender());
				request.setAttribute("medicalhistory",p.getMedicalHistory());
				request.setAttribute("message", "Hello "+p.getName());
				patientDao.updatePatient(p);				
				request.getRequestDispatcher("PatientHome.jsp").forward(request, response);
			}
			
			
			
			
		}
		catch(Exception e){
			//System.out.println(e);
			System.out.println("");
		}
		
	}
}
