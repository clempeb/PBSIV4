package fr.gtm.proxibanquesi.dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.gtm.proxibanquesi.dao.util.BddConnector;
import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Conseiller;

/** Cette classe implémentent les méthodes de CRUD pour la table 
 * CONSEILLER de la base de données.
 * 
 * @author Alexandre De Bruyn et Clement Peberge
 *
 */
public class ConseillerDao extends CRUDDao implements IConseillerDao {

	@Override
	public Conseiller checkUser(Conseiller cons) {
		
		EntityManager em = BddConnector.begin();
		
		Query q = em.createNamedQuery("readCons");
		q.setParameter("login", cons.getLogin());
		q.setParameter("mdp", cons.getMdp());
		cons = (Conseiller) q.getSingleResult();
		
		BddConnector.close();
		return cons;
	}
	
	@Override
	public ArrayList<Client> getListeClients(Conseiller cons) {
		
		EntityManager em = BddConnector.begin();
		
		Query q = em.createNamedQuery("readAllClient");
		q.setParameter("idcons", cons.getIdcons());
		ArrayList<Client> listeClients = (ArrayList<Client>) q.getResultList();
		
		BddConnector.close();
		
		return listeClients;
	}

}
