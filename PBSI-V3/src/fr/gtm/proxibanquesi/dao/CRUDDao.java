package fr.gtm.proxibanquesi.dao;

import javax.persistence.EntityManager;
import fr.gtm.proxibanquesi.dao.util.BddConnector;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

public abstract class CRUDDao<O> implements ICRUDDao<O> {

	@Override
	public O create(O o) throws LigneExistanteException {
		EntityManager em = BddConnector.begin();
		o = em.merge(o);
		BddConnector.close();
		return o;
	}

	@Override
	public O read(O o, int id) throws LigneInexistanteException {	
		EntityManager em = BddConnector.begin();
		o = (O) em.find(o.getClass(), id);
		BddConnector.close();
		return o;
	}

	@Override
	public O update(O o) throws LigneInexistanteException {	
		EntityManager em = BddConnector.begin();
		o = em.merge(o);
		BddConnector.close();
		return o;
	}

	@Override
	public int delete(O o) throws LigneInexistanteException {
		int res = 0;
		EntityManager em = BddConnector.begin();
		em.remove(o);
		BddConnector.close();
		return res;
	}


}
