package fr.gtm.proxibanquesi.dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.gtm.proxibanquesi.dao.util.BddConnector;
import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Compte;

/**
 *  
 * Cette classe est la classe DAO qui contient les méthodes create(Client), read(Client),
 *  update(Client), delete(Client) et getListeComptesClient(Client client).
 * @author Alexandre De Bruyn et Clement Peberge
 */
public class ClientDao extends CRUDDao implements IClientDao {
	
	/**
	 * Méthode qui récupère la liste des comptes d'un client.
	 * 
	 * @param client : Le client
	 * @return La liste de comptes d'un client
	 */
	@Override
	public ArrayList<Compte> getListeComptes(Client client) {
		
		EntityManager em = BddConnector.begin();
		Query q = em.createNamedQuery("readAllCompte");
		ArrayList<Compte> listeComptesClient = (ArrayList<Compte>) q.getResultList();
		q.setParameter("idclient", client.getId());
		BddConnector.close();

		return listeComptesClient;
	}

}
