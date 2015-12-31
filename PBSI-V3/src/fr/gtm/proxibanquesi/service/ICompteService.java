package fr.gtm.proxibanquesi.service;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.DaoException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.exceptions.SoldeInsuffisantException;

/**
 * Interface de la couche Service du COmpte
 * Elle liste les m�thodes de CRUD d'un compte et la m�thode virement.
 * @author Alexandre De Bruyn et Clement Peberge
 *
 */
public interface ICompteService {
	
	/**
	 * M�thode de cr�ation d'un compte.
	 * 
	 * @param comt : le compte
	 * @return Le compte cr��
	 * @throws DaoException 
	 */
	public Compte creerCompte(Compte compte) throws DaoException;
	
	
	
	/**
	 * M�thode pour lire les informations d'un compte.
	 * 
	 * @param comt : le compte
	 * @return Le compte consult�
	 * @throws LigneInexistanteException
	 */
	public Compte consulterCompte(Compte compte) throws LigneInexistanteException;
	
	
	
	/**
	 * M�thode de modification d'un compte.
	 * @param compte : compte
	 * @return Le compte mis � jour
	 * @throws LigneInexistanteException
	 */
	public Compte modifierCompte(Compte compte) throws LigneInexistanteException;
	
	
	
	/**
	 * M�thode pour supprimer un compte.
	 * 
	 * @param comt : le compte
	 * @return res : un int repr�sentant le nombre de lignes supprim�e en base de donn�es
	 * @throws LigneInexistanteException
	 */
	public int supprimerCompte(Compte compte) throws LigneInexistanteException;
	
	/**
	 * M�thode de virement d'un compte vers un autre compte.
	 * @param compteDebiteur : compte � d�biter
	 * @param compteCrediteur : compte � cr�diter
	 * @param double montant : montant du virement
	 * @return
	 * @throws SoldeInsuffisantException
	 * @throws LigneInexistanteException
	 */
	public int virement(Compte compteDebiteur, Compte compteCrediteur, double montant)
			throws SoldeInsuffisantException, LigneInexistanteException;



	/**
	 * M�thode qui r�cup�re la liste des comptes des clients d'un conseiller.
	 * 
	 * @param cons : Le conseiller en session
	 * @return La liste de tous les comptes des clients d'un conseiller
	 */
//	public ArrayList<Compte> getListeComptes(Conseiller cons);



	



	

	
	
}
