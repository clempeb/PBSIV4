package fr.gtm.proxibanquesi.front.mbeans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.inject.Inject;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.service.IConseillerService;

/**
 * Managed Bean charg� de l'authentification du conseiller. Permet d'acc�der aux
 * clients du conseiller authentifi�. Ce bean poss�de un scope de type session.
 * 
 * @author Alex
 *
 */
@ManagedBean(name = "authBean")
@SessionScoped
public class AuthentificationBean implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	// Bean attributes
	/**
	 * Objet Conseiller correspondant au conseiller authentifi�. Permet
	 * d'acc�der aux informations concernant ce conseiller.
	 */
	private Conseiller conseiller;
//	/**
//	 * Liste des clients du conseill� authentifi�.
//	 */
//	private ArrayList<Client> listeClients;

	// Service injection
	/**
	 * EJB permettant de v�rifier l'authentification du conseiller.
	 */
	@Inject
	IConseillerService serv;

	/**
	 * Constructeur initialisant les propri�t�s du bean
	 */
	public AuthentificationBean() {
		conseiller = new Conseiller();
//		listeClients = new ArrayList<Client>();
	}

	// // Bean lifecycle log
	// @PostConstruct
	// public void creationBean() {
	// System.out.println("Cr�ation AuthentificationBean");
	// }
	// @PreDestroy
	// public void destructionBean() {
	// System.out.println("Destruction AuthentificationBean");
	// }

	// Phases log
	// public void afterPhase(PhaseEvent event) {
	// System.out.println(conseiller);
	// System.out.println(listeClients);
	// }

	// Authentification method (login-form)
	/**
	 * M�thode qui permet d'authentifier le conseiller � partir du login et mot
	 * de passe. Charge les infos du conseiller et sa liste de clients dans le
	 * bean. Charge un message indicatif dans le contexte de la vue en fonction
	 * du r�sultat.
	 * 
	 * @return Null en cas d'�chec de l'authentification, sinon le nom de la
	 *         page utilisateur.
	 */
	public String authentifier() {
		try {
			conseiller = serv.checkUser(conseiller);
//			listeClients = serv.getListeClients(conseiller);
			FacesMessage message = new FacesMessage("Authentification r�ussie.");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return "user-page";
		} catch (LigneInexistanteException e) {
			FacesMessage message = new FacesMessage("Authentification �chou�e. Veuillez r�essayer");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return null;
	}

	// Getters & Setters
	/**
	 * Getter de la propri�t� Conseiller
	 * 
	 * @return La propri�t� Conseiller
	 */
	public Conseiller getConseiller() {
		return conseiller;
	}

	 public void setConseiller(Conseiller conseiller) {
	 this.conseiller = conseiller;
	 }
//	/**
//	 * Getter de la propri�t� listeClients
//	 * 
//	 * @return La propri�t� listeClients
//	 */
//	public ArrayList<Client> getListeClients() {
//		listeClients = serv.getListeClients(conseiller);
//		return listeClients;
//	}
	// public void setListeClients(ArrayList<Client> listeClients) {
	// this.listeClients = listeClients;
	// }

}
