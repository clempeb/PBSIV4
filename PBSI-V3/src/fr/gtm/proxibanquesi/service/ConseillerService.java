package fr.gtm.proxibanquesi.service;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.gtm.proxibanquesi.dao.IConseillerDao;
import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Classe de la couche Service du Conseiller.
 * Elle impl�mente les m�thodes de CRUD d'un conseiller, et une m�thode pour lister les clients,
 *  et leurs comptes, d'un conseiller.
 * Cette classe est un EJB Stateless.
 * @author Alexandre De Bruyn et Clement Peberge
 *
 */
@Stateless
public class ConseillerService implements IConseillerService {
	
	/** D�claration de l'interface Dao pour l'injection*/
	@Inject
	IConseillerDao<Conseiller> dao;
	
	/**
	 * M�thode de cr�ation un conseiller.
	 * @param cons qui est le conseiller.
	 * @return Le conseiller cr��
	 * @throws LigneExistanteException
	 * @throws LigneInexistanteException
	 */
	@Override
	public Conseiller createConseiller(Conseiller cons) throws LigneExistanteException, LigneInexistanteException {
		return dao.create(cons);
	}

	/**
	 * M�thode pour lire les informations d'un conseiller.
	 * @param cons qui est le conseiller (doit avoir un login et un mdp).
	 * @return Le conseiller consult�
	 * @throws LigneInexistanteException
	 */
	@Override
	public Conseiller checkUser(Conseiller userTemp) throws LigneInexistanteException {
		return dao.checkUser(userTemp);
	}

	/**
	 * M�thode pour r�cup�rer la liste des clients et leurs comptes d'un conseiller.
	 * @param cons qui est le conseiller.
	 * @return La liste de clients et de comptes du conseiller
	 */
	@Override
	public ArrayList<Client> getListeClients(Conseiller cons) {
		return dao.getListeClients(cons);
	}

	/**
	 * M�thode pour modifier les informations d'un conseiller.
	 * @param cons qui est le conseiller.
	 * @return Le conseiller mis � jour
	 * @throws LigneInexistanteException
	 */
	@Override
	public Conseiller updateConseiller(Conseiller userTemp) throws LigneInexistanteException {
		return dao.update(userTemp);
	}

	/**
	 * M�thode pour supprimer un conseiller.
	 * @param cons qui est le conseiller.
	 * @return res : un int repr�sentant le nombre de lignes supprim�e en base de donn�es
	 * @throws LigneInexistanteException
	 */
	@Override
	public int delete(Conseiller cons) throws LigneInexistanteException {
		return dao.delete(cons);
	}


}
