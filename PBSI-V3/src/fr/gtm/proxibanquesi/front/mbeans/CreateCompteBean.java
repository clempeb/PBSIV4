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
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.exceptions.DaoException;
import fr.gtm.proxibanquesi.service.ICompteService;

/**
 * Bean associ� � la cr�ation d'un compte bancaire.
 * 
 * @author Alex
 *
 */
@ManagedBean(name = "createCompteBean")
public class CreateCompteBean implements Serializable {

	// Serial ID
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	// Compte to create
	/**
	 * L'objet Compte stockant les informations du compte � cr�er.
	 */
	private Compte createdCompte;
	/**
	 * Le type du compte (courant ou epargne) Par d�faut: courant.
	 */
	@ManagedProperty(value = "courant")
	private String type;

	// Client id
	/**
	 * L'identifiant du client pour qui le compte sera cr��.
	 */
	@ManagedProperty(value = "#{clientBean.selectedClient}")
	private Client client;

	// Service injection
	/**
	 * EJB charg� de cr�er le compte.
	 */
	@Inject
	ICompteService serv;

	// Constructor
	/**
	 * Constructeur initialisant la propri�t� createdCompte.
	 */
	public CreateCompteBean() {
		createdCompte = new CompteCourant();
	}

	// Bean lifecycle log
	// @PostConstruct
	// public void creationBean() {
	// System.out.println("Cr�ation CreateCompteBean, id client: " + idclient);
	//
	// }
	//
	// @PreDestroy
	// public void destructionBean() {
	// System.out.println("Destruction CreateCompteBean");
	// }

	// Creation du compte
	/**
	 * M�thode appel� lors de la soumission du formulaire de cr�ation de compte.
	 * Cr�� le compte en base de donn�e et charge un message indiquant le
	 * r�sultat.
	 */
	public void creerCompte() {
		try {
			createdCompte.setClient(client);
			if (type.equals("courant")) {
				serv.creerCompte((CompteCourant) createdCompte);
				FacesMessage message = new FacesMessage("Compte courant cr�� avec succ�s");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} else if (type.equals("epargne")) {
				CompteEpargne epargne = new CompteEpargne();
				epargne.setClient(client);
				epargne.setSolde(createdCompte.getSolde());
				serv.creerCompte(epargne);
				FacesMessage message = new FacesMessage("Compte �pargne cr�� avec succ�s");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		} catch (DaoException e) {
			FacesMessage message = new FacesMessage("Probl�me lors de la cr�ation");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	/**
	 * Getter de la propri�t� createdCompte.
	 * 
	 * @return La propri�t� createdCompte.
	 */
	public Compte getCreatedCompte() {
		return createdCompte;
	}

	/**
	 * Setter de la propri�t� created Compte
	 * 
	 * @param createdCompte
	 *            Le compte � affecter � la propri�t�.
	 */
	public void setCreatedCompte(Compte createdCompte) {
		this.createdCompte = createdCompte;
	}

	/**
	 * Getter de la propri�t� type.
	 * 
	 * @return La propri�t� type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Setter de la propri�t� type
	 * 
	 * @param type
	 *            La chaine de caract�re a associer � la propri�t�.
	 */
	public void setType(String type) {
		this.type = type;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}



}
