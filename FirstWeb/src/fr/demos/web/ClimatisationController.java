//http://localhost:8080/FirstWeb/ClimatisationController
package fr.demos.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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
import fr.demos.data.SQLClimatisationDAO;
import fr.demos.formation.Climatisation;

/**
 * Servlet implementation class ClimatisationController
 */
@WebServlet("/ClimatisationController")
public class ClimatisationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClimatisationController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("========================>(CC)Debut");
		String affiche = request.getParameter("cmdAffiche");
		String action = request.getParameter("cmdAction");
		System.out.println("========================>(CC)verification; affiche = " + affiche + "; action = " + action);
		boolean erreur = false;// liste des erreurs à remplir
		String pass = "/saisieClimatisation.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(pass);
		if (affiche != null && affiche.equals("Fin")) {
			//insertion depuiçs FC
			List<Climatisation> listClim = null;
			//ClimatisationDAO dao = new FileClimatisationDAO();
			
			try {
				ClimatisationDAO dao = new SQLClimatisationDAO();
				listClim = dao.rechercheTout();
				System.out.println("========================>(CC)listClim :" + "\n"+ listClim.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
			//insertion depuiçs FC
			pass = "/successClimatisation.jsp";
			rd = request.getRequestDispatcher(pass);
			rd.forward(request, response);
			System.out.println("========================>(CC)Fin affiche; forward: "+pass);
			//return;
		}
		else {
			if ((action != null && action.equals("enregistrer"))) {
				String appareilStr = request.getParameter("appareil");
				String temperatureStr = request.getParameter("temperature");
				String pressionStr = request.getParameter("pression");
				String humiditeStr = request.getParameter("humidite");
				System.out.println("========================>(CC)enregistre ;  "+ "\n" + "appareil: "+appareilStr +"; temperature: "+ temperatureStr + "; pression: "+pressionStr + "; humidite: "+ humiditeStr);
				// conversion et attribution
				float temperature = 0;
				float pression = 0;
				int humidite = 0;
	
				try {
					temperature = Float.parseFloat(temperatureStr);
				} catch (NumberFormatException ex) {
					erreur = true; // active l'erreur
				}
	
				try {
					pression = Float.parseFloat(pressionStr);
				} catch (NumberFormatException ex) {
					erreur = true; // active l'erreur
				}
				try {
					humidite = Integer.parseInt(humiditeStr);
				} catch (NumberFormatException ex) {
					erreur = true; // active l'erreur
				}
				System.out.println("========================>(CC) enregistre; erreur: "+ erreur);
				request.setAttribute("temperature", temperatureStr);
				request.setAttribute("pression", pressionStr);
				request.setAttribute("humidite", humiditeStr);
				request.setAttribute("appareil", appareilStr);
				if (!erreur) {
					Climatisation clim = new Climatisation(humidite, temperature, pression, appareilStr);


					try{
						//ClimatisationDAO dao = new FileClimatisationDAO(); changé en SQL
						ClimatisationDAO dao = new SQLClimatisationDAO();
						System.out.println("========================>(CC)Verification : try clim: " + "\n" + clim.toString());
						dao.sauve(clim);
						System.out.println("========================>(CC) sauve sans erreur; dao: " + "\n" + dao.toString());
						//rd=request.getRequestDispatcher("/successClimatisation.jsp");
					}
					catch (Exception e){
						e.printStackTrace();
						request.setAttribute("sauvegardeErreur", e.getMessage());
						System.out.println("========================>(CC)sauve avec erreur; forward: " + pass);
						rd = request.getRequestDispatcher(pass);
					}
					/*ArrayList<Climatisation> liste = new ArrayList<>();
					try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("climatisation")));) {
						liste = (ArrayList<Climatisation>) ois.readObject();
					} catch (IOException exc) {
						request.setAttribute("IOErreur", "IO Problem!");
					} catch (ClassNotFoundException exc) {
						request.setAttribute("ClassErreur", "Class Problem!");
					}
					liste.add(clim);
					try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Climatisation", true)));){ // création d'un file avec les infos de la clim
						oos.writeObject(liste);
						oos.flush(); // concorde avec le buffered, donne le coup d'arrêt et d'envoi des informations bufferisées
						System.out.println("fin if !erreur");*/
				}
			}
		}
		rd.forward(request, response);
		System.out.println("========================>(CC)finfin; forward " +pass);
	}

}
