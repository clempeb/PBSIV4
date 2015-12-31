import java.util.ArrayList;
import java.util.List;

import fr.gtm.proxibanquesi.dao.ClientDao;
import fr.gtm.proxibanquesi.dao.CompteDao;
import fr.gtm.proxibanquesi.dao.ConseillerDao;
import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.service.ClientService;

public class Lanceur {

	public static void main(String[] args) throws LigneExistanteException, LigneInexistanteException {
		// TODO Auto-generated method stub
		Conseiller cons = new Conseiller("CLEM", "CLEM", "clem", "clem");

		ConseillerDao consdao = new ConseillerDao();
		ClientDao dao = new ClientDao();
		CompteDao cdao = new CompteDao();
		
		Client c1 = new Client("NOVA", "Mamie", "12 rue des cafes", "72541", "Paris", "0123456789");
		c1.setCons(cons);
//		System.out.println(c1);
//		c1 = dao.create(c1);
//		Client c1 = new Client();
//		c1.setId(51);
//		c1 = dao.read(c1);
//		c1 = dao.update(c1);
//		
//		dao.delete(c1);
//
//		c1 = dao.read(c1);
//		System.out.println(c1);
		CompteCourant cc1 = new CompteCourant(563);
		CompteCourant cc2 = new CompteCourant(453);
		CompteEpargne ce1 = new CompteEpargne(7893);
		
		cc1.setClient(c1);
		cc2.setClient(c1);
		ce1.setClient(c1);
		cons=consdao.checkUser(cons);
		System.out.println(cons);
		
		for(Client c : cons.getListeClients()) {
			System.out.println(c);
			for(Compte co : c.getListeComptes()) {
				System.out.println("Compte n°" + co.getNumCompte() + ", solde : " + co.getSolde() + "€, type : " + co.getClass().getSimpleName());
			}
		}
//		
//		c1 = dao.update(c1);
		
//		List<Compte> alc = cdao.getListeComptes(cons);
//		
//		for(Compte c : alc) {
//			System.out.println("Compte n°" + c.getNumCompte() + ", solde : " + c.getSolde() + "€, propriétaire : " + c.getClient().getPrenom() + " " + c.getClient().getNom());
//		}
		
//		cc1.setNumCompte(151);
//		cc1 = (CompteCourant) cdao.readCompte(cc1);
//		System.out.println("Compte n°" + cc1.getNumCompte() + ", solde : " + cc1.getSolde() + "€, propriétaire : " + cc1.getClient().getPrenom() + " " + cc1.getClient().getNom());
		
		
	}

}
