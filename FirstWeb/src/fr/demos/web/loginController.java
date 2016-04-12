package fr.demos.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pass = null;
		String login = null;
		String erreurlogin = null;
		String successlogin = null;
		int i = 3;
		String[] session = new String[i];
		pass = "/login.jsp";
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		String action = request.getParameter("action");
		if (action != null && action.equals("enregistrer")) {
			login = request.getParameter("login");
			request.setAttribute("login", login);
			login.trim();//élaguer les espaces
			System.out.println("========================>(LC)Login brut: "+login.trim());
			if (login != null && !login.equals("")) {
				//successlogin = "Vous êtes maintenant enregistré";
				request.setAttribute("successlogin", successlogin);
				session[0] = login;
				pass = "/ClimatisationController";
				rd = request.getRequestDispatcher("/ClimatisationController");
				System.out.println("========================>(LC)Login enregistré "+ session[0]);
			}
			else{
				request.setAttribute("Pseudo non rempli", erreurlogin);
			}
		}
		rd.forward(request, response);
		System.out.println("========================>(LC)fin login Controller; envoi: "+ pass);
	}
}
