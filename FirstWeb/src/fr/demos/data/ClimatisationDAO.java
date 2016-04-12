package fr.demos.data;

import java.util.List;

import fr.demos.formation.Climatisation;

//dao = data access object
public interface ClimatisationDAO {
	void sauve(Climatisation cl) throws Exception;
	List<Climatisation> rechercheTout ()throws Exception;
	List<Climatisation> recherche (String critere)throws Exception;
	int nombre(String critere);
}
