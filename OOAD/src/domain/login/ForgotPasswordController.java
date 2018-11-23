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
@WebServlet("/ForgotPasswordController")
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ForgotPasswordController() {}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String username = request.getParameter("username");
		String submitType = request.getParameter("submit");		
		
		PatientDao patientDao = new PatientDaoImpl();
		Patient a = patientDao.getPatient(username);
	
	
		if(submitType.equals("submit") && a!=null && a.getName()!= null  && !a.getName().equals("")){
			request.setAttribute("secretquestion", a.getSecret_Q());

			Cookie ck=new Cookie("username",username);
			response.addCookie(ck);
			request.getRequestDispatcher("resetpassword.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "Username does not exist!");
			request.getRequestDispatcher("forgotpassword.jsp").include(request, response);
		}

	}

}
