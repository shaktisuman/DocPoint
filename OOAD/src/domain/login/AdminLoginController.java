package domain.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userDAO.Admin;
import userDAO.AdminDao;
import userDAO.AdminDaoImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AdminLoginController() {}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		String submitType = request.getParameter("submit");
		
		Login login = new Login(username, pass);
		
		
		AdminDao adminDao = new AdminDaoImpl();
		Admin a = adminDao.validateAdmin(login);
	
	
		if(submitType.equals("login") && a!=null && a.getName()!= null  && !a.getName().equals("")){
			
			
			request.setAttribute("message", "Hello "+a.getName());
			request.setAttribute("name", a.getName());
			request.setAttribute("info", a.getInfo());
			Cookie ck=new Cookie("username",username);
			
			response.addCookie(ck);
			
			request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
		}/*else if(submitType.equals("register")){
			a.setName(request.getParameter("name"));
			a.setUsername(request.getParameter("username"));
			a.setPassword(request.getParameter("password"));
			a.setInfo(request.getParameter("Info"));
			adminDao.addAdmin(a);
			request.setAttribute("successMessage", "Registration done, please login!");
			request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
		}*/
		else{
			request.setAttribute("message", "Incorrect Username and/or Password!");
			request.getRequestDispatcher("adminlogin.jsp").include(request, response);
		}

	}

}
