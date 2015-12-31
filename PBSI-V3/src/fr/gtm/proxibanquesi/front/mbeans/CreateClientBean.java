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
 * Managed Bean lié au formulaire de création de client
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
	 * Objet client stockant les informations du client à créer dans la base de
	 * données.
	 */
	private Client createdClient;

	// Conseiller id
	/**
	 * Identifiant du conseiller connecté qui fait la demande de création
	 * client.
	 */
	@ManagedProperty(value = "#{authBean.conseiller}")
	private Conseiller cons;

	// Service injection
	/**
	 * EJB utilisé pour créer le client en base de donnée.
	 */
	@Inject
	IClientService serv;

	// Constructor with attributes initialization
	/**
	 * Constructeur initialisant la propriété createdClient du bean.
	 */
	public CreateClientBean() {
		createdClient = new Client();
	}

	// Bean lifecycle log
	// @PostConstruct
	// public void creationBean() {
	// System.out.println("Création CreateClientBean, id conseiller: " +
	// idcons);
	// }
	// @PreDestroy
	// public void destructionBean() {
	// System.out.println("Destruction CreateClientBean");
	// }

	// Creation client
	/**
	 * Méthode de création du client, appelé à la soumission du formulaire.
	 * Créée un message en fonction du résultat de la méthode.
	 */
	public void creerClient() {
		System.out.println(createdClient);
		try {
			createdClient.setCons(cons);
			serv.createClient(createdClient);
			FacesMessage message = new FacesMessage("Client créé avec succès.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (LigneExistanteException e) {
			FacesMessage message = new FacesMessage("Ce client existe déja.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	// Getters & Setters
	/**
	 * Getter de la propriété createdClient.
	 * 
	 * @return La propriété createdClient.
	 */
	public Client getCreatedClient() {
		return createdClient;
	}

	/**
	 * Setter de la propriété createdClient
	 * 
	 * @param createdClient
	 *            L'objet client à affecter à la propriété createdClient.
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
