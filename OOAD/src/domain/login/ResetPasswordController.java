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
@WebServlet("/ResetPasswordController")
public class ResetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ResetPasswordController() {}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			PatientDao patientDao = new PatientDaoImpl();
			Cookie ck[]=request.getCookies();
			String user = ck[0].getValue();
			Patient p = patientDao.getPatient(user);
		
			
			String submitType = request.getParameter("submit");
			
			if(submitType.equals("submit") && p!=null && p.getName()!=null){
				
				
				if(request.getParameter("secretanswer") != null &&  !request.getParameter("secretanswer").equals("") && request.getParameter("secretanswer").equals(p.getSecret_A())){
					
					p.setPassword(request.getParameter("password") );
				}
				request.setAttribute("secretanswer", p.getPassword());
				patientDao.updatePatient(p);
				System.out.println(p);
				
				request.getRequestDispatcher("login.jsp").forward(request, response);
				 
			}
			else{
				request.setAttribute("message", "Incorrect Answer!");
				request.getRequestDispatcher("resetpassword.jsp").include(request, response);
			}
			
		}
		catch(Exception e){
			System.out.println("Something went wrong");
			System.out.println(e);
		}
		
		
		/*String username = request.getParameter("username");
		String submitType = request.getParameter("submit");		
		
		PatientDao patientDao = new PatientDaoImpl();
		Patient a = patientDao.getPatient(username);
	
	
		if(submitType.equals("submit") && a!=null && a.getName()!= null  && !a.getName().equals("")){
			request.setAttribute("secretquestion", a.getSecret_Q());

			Cookie ck=new Cookie("username",username);
			response.addCookie(ck);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "Incorrect Secret Question!");
			request.getRequestDispatcher("resetpassword.jsp").include(request, response);
		}*/

	}

}
