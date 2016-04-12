package fr.demos.data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import fr.demos.formation.Climatisation;

public class FileClimatisationDAO implements ClimatisationDAO {

	@Override
	public void sauve(Climatisation cl) throws Exception {
		System.out.println("========================>(FC)sauve Debutdebut");
		List<Climatisation> liste = null;
		try{
			 System.out.println("========================>(FC)Verification tryin liste : " + "\n" + liste.toString());
			 liste = this.rechercheTout();//new ArrayList<>();
			 System.out.println("========================>(FC)Verification tryout liste : " + "\n" + liste.toString());
		}
		catch (Exception e){
			//si la recherche plante ce n'est pas un problème le fichier n'existe pas encore
			System.out.println(e.getMessage());
			liste = new ArrayList<>();
			System.out.println("========================>(FC)Verification catch liste 01 ");
		}
		System.out.println("========================>(FC)Verification juste_avant_addition, cl = "+ cl.getNom());
		liste.add(cl);
		System.out.println("========================>(FC)Verification juste_après_addition, liste = " + "\n"+ liste.toString());
		try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Climatisation", true)));){ // création d'un file avec les infos de la clim
			oos.writeObject(liste);
			oos.flush(); // concorde avec le buffered, donne le coup d'arrêt et d'envoi des informations bufferisées
			System.out.println("========================>(FC)fin sauve Liste : " + "\n" + liste.toString());
		}
	}

	@Override
	public List<Climatisation> rechercheTout() throws Exception {
		System.out.println("========================>(FC)rechercheTout Debutdebut");
		// TODO Auto-generated method stub
		List<Climatisation> listClim = new ArrayList<Climatisation>();
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Climatisation")));){
			listClim = (List<Climatisation>) ois.readObject();
		}
		catch(IOException exc){
			System.out.print(exc.getMessage());
		}
		catch(ClassNotFoundException exc){
			System.out.print(exc.getMessage());
		}
		System.out.println("========================>(FC)rechercheTout finfin, listClim = ");
			return listClim;
			
	}

	@Override
	public List<Climatisation> recherche(String critere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nombre(String critere){
		List<Climatisation> liste = null;
		int nb = 0;
		try{
			liste = this.rechercheTout();
			nb = liste.size();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return nb;
	}

}
