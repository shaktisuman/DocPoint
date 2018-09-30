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
	
		
		
		
		
		
		
		System.out.println(submitType);
		System.out.println(a.getName());
		if(submitType.equals("login") && a!=null && a.getName()!= null  && !a.getName().equals("")){
			
			request.setAttribute("message", "Hello "+a.getName());
			request.setAttribute("name", a.getName());
			request.setAttribute("birthdate", "01/01/2000");
			request.setAttribute("address", "123 Main St.");
			request.setAttribute("city", "Richardson");
			request.setAttribute("Gender", "F");
			Cookie ck=new Cookie("username",username);
			response.addCookie(ck);
			request.getRequestDispatcher("PatientHome.jsp").forward(request, response);
		}else if(submitType.equals("register")){
			a.setName(request.getParameter("name"));
			a.setUsername(request.getParameter("username"));
			a.setPassword(request.getParameter("password"));
			patientDao.addPatient(a);
			request.setAttribute("successMessage", "Registration done, please login!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "Data Not Found! Please register!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}

	}

}
