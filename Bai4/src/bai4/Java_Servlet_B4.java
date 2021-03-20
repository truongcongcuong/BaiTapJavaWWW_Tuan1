package bai4;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registry")
public class Java_Servlet_B4 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Bai 4</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<form method='post'  name='registrationForm'>");
		writer.println("<h1> Registry </h1>");
		writer.println("");
		writer.println("<h3> Name </h3>");
		writer.println("<input type = 'text' name = 'name'>");
		writer.println("<h3> Username </h3>");
		writer.println("<input type = 'text' name = 'username'>");
		writer.println("<h3> Email </h3>");
		writer.println("<input type = 'text' name = 'email'>");
		writer.println("<h3> Password </h3>");
		writer.println("<input type = 'password' name = 'password'>");
		writer.println("<h3> Facebook </h3>");
		writer.println("<input type = 'text' name = 'facebook'>");
		writer.println("<h3> Short Bio </h3>");
		writer.println("<textarea rows='4' cols ='50' name = 'shortbio'></textarea>");
		writer.println("<br>");
		writer.println("<br>");
		writer.println("<br>");
		writer.println("<input type = 'submit' value = 'Submit'>");
		writer.println("</body>");
		writer.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String facebook = req.getParameter("facebook");
		String shortbio = req.getParameter("shortbio");
		String html = "<br>" + "<html>" + "<head>" + "<title>Result Page</title>" + "</head>" + "<body>"
				+ "First Name: " + name + "<br>" + "Email: " + email + "<br> Facebook URL: " + facebook + "<br>"
				+ "Short Bio: " + shortbio + "<br>" + "</body>" + "</html>";
		writer.println(html);
	}

}
