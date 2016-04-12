package fr.demos.web;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.data.ClimatisationDAO;
import fr.demos.data.FileClimatisationDAO;
import fr.demos.formation.Climatisation;


/**
 * Servlet implementation class ListClimatisationController
 */
@WebServlet("/ListClimatisationController")
public class ListClimatisationController extends HttpServlet {
	boolean erreur = false;
	private static final long serialVersionUID = 1L;
	//RequestDispatcher rd = request.getRequestDispatcher("/saisieClimatisation.jsp");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListClimatisationController() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Climatisation> listClim = null;
		RequestDispatcher rd = request.getRequestDispatcher("/saisieClimatisation.jsp");
		rd.forward(request, response);
		/*String affiche = request.getParameter("cmdAffiche");
		if (affiche != null && affiche.equals("Fin")) {
			System.out.println("affiche est passé");
			rd = request.getRequestDispatcher("/successClimatisation.jsp");
			rd.forward(request, response);
		}
		else{*///toute cette partie a été exportée vers ClimatisationController
			
			String action = request.getParameter("cmdAction");
			if  (action != null && action.equals("enregistrer")) {
				/*ClimatisationDAO dao = new FileClimatisationDAO();
				try {
					listClim = dao.rechercheTout();
					System.out.println("========================>(LCC)listClim :"+ listClim.toString() + "\n" + "========================>dao.rechercheTout :"+ dao.rechercheTout());
				} catch (Exception e) {
					e.printStackTrace();
				}*///exporté dans CC
			}
			/*try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Climatisation")));){
					listClim = (ArrayList<Climatisation>) ois.readObject();
			}
			catch(IOException exc){
				System.out.print(exc.getMessage());
			}
			catch(ClassNotFoundException exc){
				System.out.print(exc.getMessage());
			}*/
				//rd = request.getRequestDispatcher("/successClimatisation.jsp");
			
			request.setAttribute("listClim", listClim);
			rd.forward(request, response);
		//}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
