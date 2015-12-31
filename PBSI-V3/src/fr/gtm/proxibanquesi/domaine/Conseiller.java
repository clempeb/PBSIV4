package fr.gtm.proxibanquesi.domaine;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/** Cette classe repr�sente un conseiller d'une agence ProxiBanque.
 * @author Alexandre De Bruyn et Clement Peberge
 *
 */
@Entity
@NamedQuery(name="readCons", query="SELECT cons FROM Conseiller cons WHERE cons.login = :login AND cons.mdp = :mdp")
public class Conseiller {
	// Prorpi�t�s
	/** Prenom du conseiller. */
	private String prenom;
	/** Nom du conseiller. */
	private String nom;
	/** Num�ro d'identification du conseiller. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idcons;
	/** Num�ro d'identification de l'agence. */
	private int idagence;
	/** True si le conseiller est �galement le g�rant de l'agence. */
	private boolean gerant = false;
	/** Login du conseiller pour s'authentifier � l'application */
	@NotNull(message="Veuillez saisir votre identifiant")
	private String login;
	/** Mot de passe du conseiller pour s'authentifier � l'application */
	@NotNull(message="Veuillez saisir votre mot de passe")
	private String mdp;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="cons")
	private ArrayList<Client> listeClients = new ArrayList<Client>();
	// Constructeurs
	/**
	 * Constructeur par d�faut du conseiller
	 */
	public Conseiller() {
	}
	/**
	 * Constructeur du conseiller avec les propri�t�s nom et prenom
	 * 
	 * @param String nom
	 * String prenom
	 * @return void
	 */
	public Conseiller(String nom, String prenom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.idagence = 1;
		this.gerant = false;
	}	
	/**
	 * Constructeur du conseiller avec les propri�t�s nom ,prenom, et g�rant
	 * 
	 * @param String nom
	 * String prenom
	 * boolean gerant
	 * @return void
	 */
	public Conseiller(String nom, String prenom, boolean gerant) {
		this(nom, prenom);
		this.gerant = true;		
	}
	/**
	 * Constructeur du conseiller avec les propri�t�s nom ,prenom, login et mdp
	 * 
	 * @param String nom
	 * String prenom
	 * String login
	 * String mdp
	 * @return void
	 */
	public Conseiller(String nom, String prenom, String login, String mdp) {
		this(nom, prenom);
		this.login = login;
		this.mdp = mdp;
	}
	/**
	 * Constructeur du conseiller avec les propri�t�s nom ,prenom, login, mdp et gerant
	 * 
	 * @param String nom
	 * String prenom
	 * String login
	 * String mdp
	 * boolean gerant
	 * @return void
	 */
	public Conseiller(String nom, String prenom, String login, String mdp, boolean gerant) {
		this(nom, prenom, gerant);
		this.login = login;
		this.mdp = mdp;
	}
	
	// Getters & Setters
	/**
	 * Getter de la propri�t� prenom
	 * 
	 * @return La propri�t� prenom
	 */
	public String getPrenom() {
		return this.prenom;
	}
	/**
	 * Setter de la propri�t� prenom
	 * 
	 * @return void
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * Getter de la propri�t� nom
	 * 
	 * @return La propri�t� nom
	 */
	public String getNom() {
		return this.nom;
	}
	/**
	 * Setter de la propri�t� nom
	 * 
	 * @return void
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * Getter de la propri�t� idcons
	 * 
	 * @return La propri�t� idcons
	 */
	public int getIdcons() {
		return idcons;
	}
	/**
	 * Setter de la propri�t� idcons
	 * 
	 * @return void
	 */
	public void setIdcons(int idcons) {
		this.idcons = idcons;
	}
	/**
	 * Getter de la propri�t� idagence
	 * 
	 * @return La propri�t� idagence
	 */
	public int getIdagence() {
		return idagence;
	}
	/**
	 * Setter de la propri�t� idagence
	 * 
	 * @return void
	 */
	public void setIdagence(int idagence) {
		this.idagence = idagence;
	}
	/**
	 * Getter de la propri�t� gerant
	 * 
	 * @return La propri�t� gerant
	 */
	public boolean isGerant() {
		return gerant;
	}
	/**
	 * Setter de la propri�t� gerant
	 * 
	 * @return void
	 */
	public void setGerant(boolean gerant) {
		this.gerant = gerant;
	}
	/**
	 * Getter de la propri�t� login
	 * 
	 * @return La propri�t� login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * Setter de la propri�t� login
	 * 
	 * @return void
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * Getter de la propri�t� mdp
	 * 
	 * @return La propri�t� mdp
	 */
	public String getMdp() {
		return mdp;
	}
	/**
	 * Setter de la propri�t� mdp
	 * 
	 * @return void
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public ArrayList<Client> getListeClients() {
		return listeClients;
	}
	public void setListeClients(ArrayList<Client> listeClients) {
		this.listeClients = listeClients;
	}
	/**
	 * M�thode permettant de retourner un String avec les propri�t�s de l'objet Conseiller
	 * 
	 * @return String d�crivant le conseiller
	 */
	@Override
	public String toString() {
		return "Conseiller [prenom=" + prenom + ", nom=" + nom + ", idcons=" + idcons + ", idagence=" + idagence
				+ ", gerant=" + gerant + ", login=" + login + ", mdp=" + mdp + "]";
	}




}
