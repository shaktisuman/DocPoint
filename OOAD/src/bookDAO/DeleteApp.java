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

@WebServlet("/DeleteApp")
public class DeleteApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteApp() {}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			PatientDao patientDao = new PatientDaoImpl();
			/*Cookie ck[]=request.getCookies();
			String user = ck[0].getValue();*/
			String username = request.getParameter("uname");
			
			Patient p = patientDao.getPatient(username);
			
			System.out.println("in delete app");
			String submitType = request.getParameter("submit");
			System.out.println(submitType);
				if(submitType.equals("submit")){
				System.out.println("inside cancel appointment");
				ApptDao apptDao1 = new ApptDaoImpl();
				int selAppt = Integer.parseInt(request.getParameter("selAppt"));
				Appt a = apptDao1.getAppt(selAppt);
				apptDao1.deleteAppt(a);
				System.out.println("Delete Done");
				request.setAttribute("name", p.getName());
				request.setAttribute("address", p.getAddress());
				request.setAttribute("birthdate", p.getBirthdate());
				request.setAttribute("city", p.getCity());
				request.setAttribute("Gender", p.getGender());
				request.setAttribute("medicalhistory",p.getMedicalHistory());
				request.setAttribute("message", "Hello "+p.getName());
				request.getRequestDispatcher("PatientHome.jsp").forward(request, response);
			}
			
			
		}
		catch(Exception e){
			System.out.println(e);
			//System.out.println("null");
		}
		
	}
}
