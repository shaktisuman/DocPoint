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
				System.out.println("Sending list of doctors to populate dropdown in UI");
				request.setAttribute("names", docListFormat);
				request.setAttribute("firstLoad", "done");
				//request.setAttribute("busyDays", returnedDates);
				request.getRequestDispatcher("bookAppointment.jsp").include(request, response);
			}
			
			//Receive Selected DocId and Date
			//Dummy DocId an Date
			int Doc_Id = 1;
			String date = "2018-11-27";
			
			//create doc object
			Doctor doc = doctorDao.getDoctor(Doc_Id);
			
			//create slot list
			SlotDao slotDao = new SlotDaoImpl();
			List<Slot> list_slot = slotDao.getSlotsForDoc(Doc_Id);
			
			//create appt list
			ApptDao apptDao = new ApptDaoImpl();
			List<Appt> list_appt = apptDao.getApptForDoc(Doc_Id);
			
			DocSched docSched = new DocSched(doc, list_slot, list_appt);
			
			List<String> list_format_slot = docSched.getAvailSlots();
			
			//send this list of avail slots to populate
			
			//recieve slotid, get patid
			int Slot_Id = 1;
			int Pat_Id = 1;
			
			//create new appt object and save to db
			Appt new_Appt = new Appt(date, Slot_Id, Doc_Id, Pat_Id);
			apptDao.addAppt(new_Appt);
			
			
		}
		catch(Exception e){
			//System.out.println(e);
			System.out.println("");
		}
		
	}
}

			