
// CONTROLLER
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import packagedto.User;

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
			User user= loginService.getUserDetails(userId);
//			request.getSession().setAttribute("user", user);
			// now we have set attributes to session scope and now when it will be redirected to success page then it will have that user object, now we just have to get details in success page
			
////			response.sendRedirect("success.jsp");
//			// in case the above parameter is servlet then we have to give the path... not file name
//			// here we have used response.sendRedirect, now we can't use response.PrintWriter in between
//			// use only one thing either redirect or write HTML text
			
			
			// this is one way in which we can take the flow of control from once jsp/sevlet to another servlet/jsp	
						// instead passing instruction to browser to redirect, we have to actually redirect directly server side, browser will not know that redirecting is actually happening to another url/servlet/jsp
						// for that we will use requestDispatcher object.
			
			
			request.setAttribute("user", user);
			RequestDispatcher dispatcher=request.getRequestDispatcher("success.jsp");
			// now we transmit the control to success.jsp with the help of dispatcher
			// dispatcher takes req and res and dispatches
			dispatcher.forward(request, response);
			// now our browser doesn't know that it is another request.
			// and for this we don't need session object in success page, we can simply set attributes to request only...
			return;
		}
		else {
			response.sendRedirect("login.jsp");
			return;
		}
	}

}
