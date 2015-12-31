package fr.gtm.proxibanquesi.dao;

import fr.gtm.proxibanquesi.domaine.Compte;

/**
 * Cette interface permet d'effectuer les fonctions de CRUD pour la table Compte
 * de la base de données.
 * 
 * @author Alexandre De Bruyn et Clement Peberge
 *
 */
public interface ICompteDao<O extends Compte> extends ICRUDDao<O> {

	
}
