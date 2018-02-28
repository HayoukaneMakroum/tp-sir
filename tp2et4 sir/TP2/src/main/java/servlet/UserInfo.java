
package servlet;

import dao.PersonDAO;
import domain.Person;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "userinfo", urlPatterns = { "/UserInfo" })

public class UserInfo extends HttpServlet {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					System.out.println("do get");

	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Person p = new Person();
		p.setName(request.getParameter("name"));
		p.setFirstName(request.getParameter("firstname"));
		p.setAge(Integer.parseInt(request.getParameter("age")));
		new PersonDAO().create(p);

		out.println("<HTML>\n<BODY>\n" + "<H1>Recapitulatif des informations de la personne ajoutee</H1>\n" + "<UL>\n" + " <LI>Nom: "
				+ request.getParameter("name") + "\n" + " <LI>Prenom: " + request.getParameter("firstname") + "\n"
				+ " <LI>Age: " + request.getParameter("age") + "\n" + "</UL>\n" +
				"<a href='/index.html'> Accueil </a>" +
				"</BODY></HTML>");


	}
}
