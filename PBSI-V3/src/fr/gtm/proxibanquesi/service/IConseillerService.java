package fr.gtm.proxibanquesi.service;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Interface de la couche Service du Conseiller.
 * Elle liste les m�thodes de CRUD d'un conseiller, et une m�thode pour lister les clients,
 *  et leurs comptes, d'un conseiller.
 * @author Alexandre De Bruyn et Clement Peberge
 *
 */
public interface IConseillerService {
	
	/**
	 * M�thode de cr�ation un conseiller.
	 * @param cons qui est le conseiller.
	 * @return Le conseiller cr��
	 * @throws LigneExistanteException
	 * @throws LigneInexistanteException
	 */
	public Conseiller createConseiller(Conseiller cons) throws LigneExistanteException, LigneInexistanteException;

	/**
	 * M�thode pour lire les informations d'un conseiller.
	 * @param cons qui est le conseiller (doit avoir un login et un mdp).
	 * @return Le conseiller consult�
	 * @throws LigneInexistanteException
	 */
	public Conseiller checkUser(Conseiller userTemp) throws LigneInexistanteException;
	
	/**
	 * M�thode pour modifier les informations d'un conseiller.
	 * @param cons qui est le conseiller.
	 * @return Le conseiller mis � jour
	 * @throws LigneInexistanteException
	 */
	public Conseiller updateConseiller(Conseiller userTemp) throws LigneInexistanteException;
	
	/**
	 * M�thode pour supprimer un conseiller.
	 * @param cons qui est le conseiller.
	 * @return res : un int repr�sentant le nombre de lignes supprim�e en base de donn�es
	 * @throws LigneInexistanteException
	 */
	public int delete(Conseiller cons) throws LigneInexistanteException;
	
	/**
	 * M�thode pour r�cup�rer la liste des clients et leurs comptes d'un conseiller.
	 * @param cons qui est le conseiller.
	 * @return La liste de clients et de comptes du conseiller
	 */
	public ArrayList<Client> getListeClients(Conseiller cons);

}
