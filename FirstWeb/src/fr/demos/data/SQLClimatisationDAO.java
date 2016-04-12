package fr.demos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.resource.cci.ResultSet;
import javax.sql.DataSource;

import fr.demos.formation.Climatisation;

public class SQLClimatisationDAO implements ClimatisationDAO{
	private DataSource ds = null;
	public SQLClimatisationDAO() throws Exception {
		System.out.println("========================>(SQLC)debut SQLClimatisationDAO");
		//recherche dans l'annuaire du pool de connection
		Context context = new InitialContext();
		ds = (DataSource)context.lookup("jdbc/appliclim");
		System.out.println("========================>(SQLC)fin SQLClimatisationDAO " + "\n"+ ds.toString());
	}
	@Override
	public void sauve(Climatisation cl) throws Exception {
		System.out.println("========================>(SQLC)debut sauve");
		//on demande une connection au pool
		Connection cx = ds.getConnection();
		//on va pouvoir préparer notre requète SQL
		PreparedStatement psmt = cx.prepareStatement("insert into climatisation values (?,?,?,?,?)");
		System.out.println("========================>(SQLC)Verification psmt ");
		// ici, on a découpé le stateemnt au lieu de le concaténer. Ceci afin d'empécher qu'un utilisateur malveillant ne puisse y concaténer des instructions perturbatrices
		psmt.setString(1, cl.getNom());
		psmt.setFloat(2, cl.getPression());
		psmt.setFloat(3, cl.getTemperature());
		psmt.setInt(4, cl.getHumidite());
		psmt.setLong(5, cl.getDatation());
		System.out.println("========================>(SQLC)fin SQLClimatisationDAO " + "\n"+ psmt.toString());
		psmt.executeUpdate();
		//on rend la connection au pool
		cx.close();
		
	}

	@Override
	public List<Climatisation> rechercheTout() throws Exception {
		System.out.println("========================>(SQLC)debut recherchetout");
		Connection cx = ds.getConnection();
		//on va pouvoir préparer notre requète SQL
		PreparedStatement psmt = cx.prepareStatement("select * from Climatisation");
		java.sql.ResultSet rs = psmt.executeQuery();
		ArrayList<Climatisation> liste = new ArrayList<>();
		while(rs.next()){
			String nomAppareil = rs.getString(1);
			float pression = rs.getFloat(2);
			float temperature = rs.getFloat(3);
			int humidite = rs.getInt(4);
			long datation = rs.getLong(5);
			Climatisation cl = new Climatisation(humidite, pression, temperature, nomAppareil);
			liste.add(cl);
			System.out.println("========================>(SQLC)fin recherchetout; liste = " + liste.toString());
		}
		return liste;
	}

	@Override
	public List<Climatisation> recherche(String critere) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nombre(String critere) {
		int nb = 0;
		try{
			List<Climatisation> liste = this.rechercheTout();
			nb = liste.size();
		}
		catch(Exception e){}
		
		return nb;
	}

}
