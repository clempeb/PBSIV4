package fr.gtm.proxibanquesi.dao;

import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

public interface ICRUDDao<O> {

	
	/**
	 * Méthode de création un conseiller.
	 * @param cons qui est le conseiller.
	 * @return Le conseiller créé
	 * @throws LigneExistanteException
	 */
	public O create(O o) throws LigneExistanteException;
	
	/**
	 * Méthode de lecture un conseiller.
	 * @param cons qui est le conseiller.
	 * @return Le conseiller consulté
	 * @throws LigneExistanteException
	 */
	public O read(O o, int id) throws LigneInexistanteException;
	
	/**
	 * Méthode pour modifier les informations d'un conseiller.
	 * @param cons qui est le conseiller.
	 * @return Le conseiller mis à jour
	 * @throws LigneInexistanteException
	 */
	public O update(O o) throws LigneInexistanteException;
	
	/**
	 * Méthode pour supprimer un conseiller.
	 * @param cons qui est le conseiller.
	 * @return res : un int représentant le nombre de lignes supprimée en base de données
	 * @throws LigneInexistanteException
	 */
	public int delete(O o) throws LigneInexistanteException;
	



}
