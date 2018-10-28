package domain.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userDAO.Doctor;
import userDAO.DoctorDao;
import userDAO.DoctorDaoImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/DoctorLoginController")
public class DoctorLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DoctorLoginController() {}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		String submitType = request.getParameter("submit");
		Login login = new Login(username, pass);
		
		
		DoctorDao doctorDao = new DoctorDaoImpl();
		Doctor a = doctorDao.validateDoctor(login);
	
	
		if(submitType.equals("login") && a!=null && a.getName()!= null  && !a.getName().equals("")){
			
			request.setAttribute("message", "Hello "+a.getName());
			request.setAttribute("name", a.getName());
			Cookie ck=new Cookie("username",username);
			
			response.addCookie(ck);
			request.getRequestDispatcher("PatientHome.jsp").forward(request, response);
		}else if(submitType.equals("register")){
			a.setName(request.getParameter("name"));
			a.setUsername(request.getParameter("username"));
			a.setPassword(request.getParameter("password"));
			a.setSpecialty(request.getParameter("specialty"));
			a.setInfo(request.getParameter("info"));
			doctorDao.addDoctor(a);
			request.setAttribute("successMessage", "Registration done, please login!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "Incorrect Username and/or Password!");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}

	}

}
