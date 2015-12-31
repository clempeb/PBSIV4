package fr.gtm.proxibanquesi.dao;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Conseiller;

/**
 * Cette interface permet d'effectuer les fonctions de CRUD
 * pour la table CONSEILLER de la base de données.
 * @author Alexandre De Bruyn et Clement Peberge
 *
 */

public interface IConseillerDao<O extends Conseiller> extends ICRUDDao<O> {

	public Conseiller checkUser(Conseiller cons);
	
	public ArrayList<Client> getListeClients(Conseiller cons);




	
}
