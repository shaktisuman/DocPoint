package domain.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userDAO.Patient;
import userDAO.PatientDao;
import userDAO.PatientDaoImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginController() {}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		String submitType = request.getParameter("submit");
		Login login = new Login(username, pass);
		
		
		PatientDao patientDao = new PatientDaoImpl();
		Patient a = patientDao.validatePatient(login);
	
	
		if(submitType.equals("login") && a!=null && a.getName()!= null  && !a.getName().equals("")){
			
			request.setAttribute("message", "Hello "+a.getName());
			
			request.setAttribute("name", a.getName());
			request.setAttribute("address", a.getAddress());
			request.setAttribute("birthdate", a.getBirthdate());
			request.setAttribute("city", a.getCity());
			request.setAttribute("Gender", a.getGender());
			request.setAttribute("medicalhistory",a.getMedicalHistory());
			/*request.setAttribute("birthdate", "01/01/2000");
			request.setAttribute("address", "123 Main St.");
			request.setAttribute("city", "Richardson");
			request.setAttribute("Gender", "F"); */
			//Added Cookie
			Cookie ck=new Cookie("username",username);
			request.setAttribute("LoggedIn", "T");
			response.addCookie(ck);
			request.getRequestDispatcher("PatientHome.jsp").forward(request, response);
		}else if(submitType.equals("register")){
			a.setName(request.getParameter("name"));
			a.setUsername(request.getParameter("username"));
			a.setPassword(request.getParameter("password"));
			a.setBirthdate(request.getParameter("birthdate"));
			a.setAddress(request.getParameter("address"));
			a.setCity(request.getParameter("city"));
			a.setState(request.getParameter("state"));
			a.setGender(request.getParameter("gender"));
			a.setMedicalHistory(request.getParameter("sickness"));
			a.setSecret_Q(request.getParameter("secretQ"));
			a.setSecret_A(request.getParameter("secretanswer"));
			patientDao.addPatient(a);
			request.setAttribute("successMessage", "Registration done, please login!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if(submitType.equals("logout")){
			request.setAttribute("LoggedIn", "F");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "Incorrect Username and/or Password!");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}

	}

}
