package fr.gtm.proxibanquesi.front.mbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.service.IClientService;

/**
 * Managed Bean li� au formulaire de cr�ation de client
 * 
 * @author Alex
 *
 */
@ManagedBean(name = "creationClient")
@ViewScoped
public class CreateClientBean implements Serializable {

	// Serial ID
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	// Client to create
	/**
	 * Objet client stockant les informations du client � cr�er dans la base de
	 * donn�es.
	 */
	private Client createdClient;

	// Conseiller id
	/**
	 * Identifiant du conseiller connect� qui fait la demande de cr�ation
	 * client.
	 */
	@ManagedProperty(value = "#{authBean.conseiller}")
	private Conseiller cons;

	// Service injection
	/**
	 * EJB utilis� pour cr�er le client en base de donn�e.
	 */
	@Inject
	IClientService serv;

	// Constructor with attributes initialization
	/**
	 * Constructeur initialisant la propri�t� createdClient du bean.
	 */
	public CreateClientBean() {
		createdClient = new Client();
	}

	// Bean lifecycle log
	// @PostConstruct
	// public void creationBean() {
	// System.out.println("Cr�ation CreateClientBean, id conseiller: " +
	// idcons);
	// }
	// @PreDestroy
	// public void destructionBean() {
	// System.out.println("Destruction CreateClientBean");
	// }

	// Creation client
	/**
	 * M�thode de cr�ation du client, appel� � la soumission du formulaire.
	 * Cr��e un message en fonction du r�sultat de la m�thode.
	 */
	public void creerClient() {
		System.out.println(createdClient);
		try {
			createdClient.setCons(cons);
			serv.createClient(createdClient);
			FacesMessage message = new FacesMessage("Client cr�� avec succ�s.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (LigneExistanteException e) {
			FacesMessage message = new FacesMessage("Ce client existe d�ja.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	// Getters & Setters
	/**
	 * Getter de la propri�t� createdClient.
	 * 
	 * @return La propri�t� createdClient.
	 */
	public Client getCreatedClient() {
		return createdClient;
	}

	/**
	 * Setter de la propri�t� createdClient
	 * 
	 * @param createdClient
	 *            L'objet client � affecter � la propri�t� createdClient.
	 * 
	 */
	public void setCreatedClient(Client createdClient) {
		this.createdClient = createdClient;
	}

	public Conseiller getCons() {
		return cons;
	}

	public void setCons(Conseiller cons) {
		this.cons = cons;
	}



}
