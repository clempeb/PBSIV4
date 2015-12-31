package fr.gtm.proxibanquesi.service;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Interface de la couche Service du Client
 * Elle liste les m�thodes de CRUD d'un client, et une m�thode pour lister les comptes d'un client.
 * @author Alexandre De Bruyn et Clement Peberge
 *
 */
public interface IClientService {
	/**
	 * M�thode de cr�ation de client.
	 * 
	 * @param cli : le client
	 * @return le client cr��
	 * @throws LigneExistanteException
	 */
	public Client createClient(Client cli) throws LigneExistanteException;
	
	/**
	 * M�thode de lecture des informations du client.
	 * 
	 * @param cli : le client
	 * @return le client consult�
	 * @throws LigneInexistanteException
	 */
	public Client consulterClient(Client cli) throws LigneInexistanteException;
	
	/**
	 * M�thode pour modifier les informations du client.
	 * 
	 * @param cli : le client
	 * @return le client mis � jour
	 * @throws LigneInexistanteException
	 */
	public Client modifierClient(Client cli) throws LigneInexistanteException;
	
	/**
	 * M�thode pour effacer un client.
	 * 
	 * @param cli : le client
	 * @return res : un int repr�sentant le nombre de lignes supprim�e en base de donn�es
	 * @throws LigneInexistanteException
	 */
	public int supprimerClient(Client cli) throws LigneInexistanteException;
	
	/**
	 * M�thode qui r�cup�re la liste des comptes d'un client.
	 * 
	 * @param client : Le client
	 * @return La liste de comptes d'un client
	 */
	public ArrayList<Compte> getListeComptesClient(Client client);

}
