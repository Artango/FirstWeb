package fr.demos.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AfficheEnTete
 Ce programme sert à générer une page où on puisse voir les informations (headers) d'une requète http*/
@WebServlet("/AfficheEnTete")
public class AfficheEnTete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficheEnTete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Enumeration<String> nomsEnTete = request.getHeaderNames();
		out.println("<body>");//créer la page html avec ce servlet
		out.println("<html>");
		// afficher le nom de chaque entete et sa valeur
		while(nomsEnTete.hasMoreElements()){ //boucle d'affichage
			String nom = nomsEnTete.nextElement();
			out.println(nom+ " : " + request.getHeader(nom));
			out.println("<br/>");
		}
		
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
