
// CONTROLLER
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// here we will capture the variables userId and password
		String userId, password;
		userId=request.getParameter("userId");
		password=request.getParameter("password");
		// userId and password captured inside strings
		// now we need to have a business service so that this do post method will pass this userId and password to that business service 
		// and then business service will authenticate whether password is correct or that userId or not
		// business service is nothing but a java class
		
		LoginService loginService=new LoginService();
		boolean result=loginService.authenticate(userId, password);
		
		if(result) {
			response.sendRedirect("success.jsp");
			// in case the above parameter is servlet then we have to give the path... not file name
			// here we have used response.sendRedirect, now we can't use response.PrintWriter in between
			// use only one thing either redirect or write HTML text
			return;
		}
		else {
			response.sendRedirect("login.jsp");
			return;
		}
	}

}
