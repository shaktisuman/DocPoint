package userDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookDAO.Slot;
import bookDAO.SlotDao;
import bookDAO.SlotDaoImpl;

import javax.servlet.http.Cookie;

import domain.login.Login;



/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			Cookie ck[]=request.getCookies();
			String user = ck[0].getValue();
			
			AdminDao adminDao = new AdminDaoImpl();
			Admin admin = adminDao.getAdmin(user);
			//String username = request.getParameter("username");
			//String pass = request.getParameter("password");
			String submitType = request.getParameter("submit");
			
			//Login login = new Login(username, pass);
			
			DoctorDao doctorDao = new DoctorDaoImpl();
			Doctor a = new Doctor();
			
			if(submitType.equals("register")){
				a.setName(request.getParameter("name"));
				a.setUsername(request.getParameter("username"));
				a.setPassword(request.getParameter("password"));
				a.setSpecialty(request.getParameter("Specialty"));
				a.setInfo(request.getParameter("Info"));
				doctorDao.addDoctor(a);
				
				//SlotDao slotdao = new SlotDaoImpl();
				//slotdao.addSlot(new Slot(600,700,a.getID()));
				
				request.setAttribute("successMessage", "Registration done, please login!");
				request.setAttribute("name", admin.getName());
				request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
			}}
		catch(Exception e){System.out.println("Something went wrong");}
		
	}

}
