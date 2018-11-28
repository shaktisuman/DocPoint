package userDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookDAO.*;
import domain.login.Customer;
import domain.login.CustomerDao;
import domain.login.CustomerDaoImpl;
import domain.login.Login;
import sun.security.util.Password;
import userDAO.*;

//Please copy this into DB

//DROP TABLE IF EXISTS `Patients`;
///*!40101 SET @saved_cs_client     = @@character_set_client */;
///*!40101 SET character_set_client = utf8 */;
//CREATE TABLE `Patients` (
//`ID` int(11) NOT NULL AUTO_INCREMENT,
//`name` varchar(255) DEFAULT NULL,
//`username` varchar(255) NOT NULL,
//`password` varchar(255) DEFAULT NULL,
//`Secret_Q` varchar(255) NOT NULL,
//`Secret_A` varchar(255) NOT NULL,
//`Birthdate` varchar(10) NOT NULL,
//`Address` varchar(255) DEFAULT NULL,
//`City` varchar(255) DEFAULT NULL,
//`State` varchar(255) DEFAULT NULL,
//`MedicalHistory` varchar(255) DEFAULT NULL,
//`Gender` varchar(2) DEFAULT NULL,
//PRIMARY KEY (`ID`),
//UNIQUE KEY `username` (`username`)
//) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

/**
 * Servlet implementation class PatientContorller
 */
@WebServlet("/DoctorController")
public class DoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			DoctorDao doctorDao = new DoctorDaoImpl();
			Cookie ck[]=request.getCookies();
			String user = ck[0].getValue();
			Doctor d = doctorDao.getDoctor(user);
			
			String submitType = request.getParameter("submit");
			
			if(submitType.equals("seeAppt")){
				
				ApptDao apptDao = new ApptDaoImpl();
				List<Appt> allAppt = apptDao.getApptForDoc(d.getID());
				SlotDao slotDao = new SlotDaoImpl();
				List<Slot> allSlot = new ArrayList<Slot>();
				
				PatientDao patientDao = new PatientDaoImpl();
				
				List<String> allApptStr = new ArrayList<String>();
				
				for(Appt ap: allAppt) {
					Slot slot_temp = slotDao.getSlot(ap.getSlot_Id());
					
					Patient pat_temp = patientDao.getPatient(ap.getPatient_Id());
					
					String patName = pat_temp.getName();
					String date = ap.getAppt_Date();
					String start_T = Integer.toString(slot_temp.getStart_t()/60) + ":" + Integer.toString(slot_temp.getStart_t()%60);
					String end_T = Integer.toString(slot_temp.getEnd_t()/60) + ":" + Integer.toString(slot_temp.getEnd_t()%60);
					
					allApptStr.add(ap.getAppt_Id() + "_" + "Patient Name: " + patName + "Date: " + date + "Start Time: " + start_T + "End Time: " + end_T);
				}
				
				request.setAttribute("allApptStr", allApptStr);
			}
			
		}
		catch(Exception e){
			System.out.println("Something went wrong");
			System.out.println(e);
		}
		

	}

}

