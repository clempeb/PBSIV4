package fr.gtm.proxibanquesi.dao;

import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

public interface ICRUDDao<O> {

	
	/**
	 * M�thode de cr�ation un conseiller.
	 * @param cons qui est le conseiller.
	 * @return Le conseiller cr��
	 * @throws LigneExistanteException
	 */
	public O create(O o) throws LigneExistanteException;
	
	/**
	 * M�thode de lecture un conseiller.
	 * @param cons qui est le conseiller.
	 * @return Le conseiller consult�
	 * @throws LigneExistanteException
	 */
	public O read(O o, int id) throws LigneInexistanteException;
	
	/**
	 * M�thode pour modifier les informations d'un conseiller.
	 * @param cons qui est le conseiller.
	 * @return Le conseiller mis � jour
	 * @throws LigneInexistanteException
	 */
	public O update(O o) throws LigneInexistanteException;
	
	/**
	 * M�thode pour supprimer un conseiller.
	 * @param cons qui est le conseiller.
	 * @return res : un int repr�sentant le nombre de lignes supprim�e en base de donn�es
	 * @throws LigneInexistanteException
	 */
	public int delete(O o) throws LigneInexistanteException;
	



}
