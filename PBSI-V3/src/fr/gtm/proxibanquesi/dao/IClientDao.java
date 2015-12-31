package fr.gtm.proxibanquesi.dao;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Compte;

/**
 * Cette interface permet d'effectuer les fonctions de CRUD pour la table CLIENT
 * de la base de données.
 * 
 * @author Alexandre De Bruyn et Clement Peberge
 *
 */
public interface IClientDao<O extends Client> extends ICRUDDao<O> {

	public ArrayList<Compte> getListeComptes(Client client);

}
