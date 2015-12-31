package fr.gtm.proxibanquesi.service;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.gtm.proxibanquesi.dao.IClientDao;
import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Classe de la couche Service du Client.
 * Elle impl�mente les m�thodes de CRUD d'un client, et une m�thode pour lister les comptes d'un client.
 * Cette classe est un EJB Stateless.
 * @author Alexandre De Bruyn et Clement Peberge
 *
 */
@Stateless
public class ClientService implements IClientService {
	
	/** D�claration de l'interface Dao pour l'injection*/
	@Inject
	IClientDao<Client> dao;
	/**
	 * M�thode de cr�ation de client.
	 * 
	 * @param cli : le client
	 * @return le client cr��
	 * @throws LigneExistanteException
	 */
	@Override
	public Client createClient(Client cli) throws LigneExistanteException {
		return dao.create(cli);
	}
	/**
	 * M�thode de lecture des informations du client.
	 * 
	 * @param cli : le client
	 * @return le client consult�
	 * @throws LigneInexistanteException
	 */
	@Override
	public Client consulterClient(Client cli) throws LigneInexistanteException {
		cli = dao.read(cli, cli.getId());
		return cli;
	}
	/**
	 * M�thode pour modifier les informations du client.
	 * 
	 * @param cli : le client
	 * @return le client mis � jour
	 * @throws LigneInexistanteException
	 */
	@Override
	public Client modifierClient(Client cli) throws LigneInexistanteException {
		return dao.update(cli);
	}
	/**
	 * M�thode pour effacer un client.
	 * 
	 * @param cli : le client
	 * @return res : un int repr�sentant le nombre de lignes supprim�e en base de donn�es
	 * @throws LigneInexistanteException
	 */
	@Override
	public int supprimerClient(Client cli) throws LigneInexistanteException {
		return dao.delete(cli);
	}
	/**
	 * M�thode qui r�cup�re la liste des comptes d'un client.
	 * 
	 * @param client : Le client
	 * @return La liste de comptes d'un client
	 */
	@Override
	public ArrayList<Compte> getListeComptesClient(Client client) {
		return dao.getListeComptes(client);
	}
	
	

}
