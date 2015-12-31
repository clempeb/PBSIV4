package fr.gtm.proxibanquesi.service;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.gtm.proxibanquesi.dao.ICompteDao;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.DaoException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.exceptions.SoldeInsuffisantException;

/**
 * Classe de la couche Service du Compte
 * Elle impl�mente les m�thodes de CRUD d'un compte et la m�thode virement.
 * Cette classe est un EJB Stateless.
 * @author Alexandre De Bruyn et Clement Peberge
 *
 */
@Stateless
public class CompteService implements ICompteService {
	
	/** D�claration de l'interface Dao pour l'injection*/
	@Inject
	ICompteDao<Compte> dao;

	/**
	 * M�thode de cr�ation d'un compte.
	 * 
	 * @param comt : le compte
	 * @return Le compte cr��
	 * @throws DaoException 
	 */
	@Override
	public Compte creerCompte(Compte compte) throws DaoException {
		return dao.create(compte);
	}

	/**
	 * M�thode pour lire les informations d'un compte.
	 * 
	 * @param comt : le compte
	 * @return Le compte consult�
	 * @throws LigneInexistanteException
	 */
	@Override
	public Compte consulterCompte(Compte compte) throws LigneInexistanteException {
		compte = dao.read(compte, compte.getNumCompte());
		return compte;
	}

	/**
	 * M�thode de modification d'un compte.
	 * @param compte : compte
	 * @return Le compte mis � jour
	 * @throws LigneInexistanteException
	 */
	@Override
	public Compte modifierCompte(Compte compte) throws LigneInexistanteException {
		return dao.update(compte);
	}

	/**
	 * M�thode pour supprimer un compte.
	 * 
	 * @param comt : le compte
	 * @return res : un int repr�sentant le nombre de lignes supprim�e en base de donn�es
	 * @throws LigneInexistanteException
	 */
	@Override
	public int supprimerCompte(Compte compte) throws LigneInexistanteException {
		return dao.delete(compte);
	}

	/**
	 * M�thode de virement d'un compte vers un autre compte.
	 * @param compteDebiteur : compte � d�biter
	 * @param compteCrediteur : compte � cr�diter
	 * @param double montant : montant du virement
	 * @return
	 * @throws SoldeInsuffisantException
	 * @throws LigneInexistanteException
	 */
	@Override
	public int virement(Compte compteDebiteur, Compte compteCrediteur, double montant)
			throws SoldeInsuffisantException, LigneInexistanteException {
		if (compteDebiteur instanceof CompteCourant && (compteDebiteur.getSolde() + ((CompteCourant) compteDebiteur).getAutorisationDecouvert()) < montant) {
				throw new SoldeInsuffisantException();
		} else if (compteDebiteur instanceof CompteEpargne && compteDebiteur.getSolde() < montant) {
				throw new SoldeInsuffisantException();
		} else {
			compteDebiteur.setSolde(compteDebiteur.getSolde() - montant);
			compteCrediteur.setSolde(compteCrediteur.getSolde() + montant);
			dao.update(compteDebiteur);
			dao.update(compteCrediteur);
		}

		return 0;
	}
	
	/**
	 * M�thode qui r�cup�re la liste des comptes des clients d'un conseiller.
	 * 
	 * @param cons : Le conseiller en session
	 * @return La liste de tous les comptes des clients d'un conseiller
	 */
//	@Override
//	public ArrayList<Compte> getListeComptes(Conseiller cons) {
//		return dao.getListeComptes(cons);
//	}





}
