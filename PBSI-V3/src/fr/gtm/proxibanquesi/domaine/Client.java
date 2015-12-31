package fr.gtm.proxibanquesi.domaine;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/** Classe repr�sentant un client de la banque.
 * Toutes les informations personnelles sont de type String
 *  hormis les num�ros d'identification du client et du conseiller ainsi
 *   que la liste de comptes.
 * @author Alexandre De Bruyn et Clement Peberge
 */
@Entity
@NamedQueries({
		@NamedQuery(name="readClient", query="SELECT c FROM Client c WHERE c.id = :id"),
		@NamedQuery(name="readAllClient", query="SELECT c FROM Client c")})
public class Client {
	
	/** Nom du client */
	private String nom;
	/** Prenom du client */
	private String prenom;
	/** Adresse du client */
	private String adresse;
	/** Code postal du client */
	private String codePostal;
	/**Ville du client */
	private String ville;
	/** Num�ro de t�l�phone du client */
	private String telephone;
	/** Num�ro d'identification du client */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
//	/** Num�ro d'identification du conseiller g�rant le client */
//	private int cons;
	@ManyToOne
	private Conseiller cons;
	
	/** Liste des comptes du client */
	@OneToMany(cascade=CascadeType.ALL, mappedBy="client")
	private ArrayList<Compte> listeComptes = new ArrayList<Compte>();
//	/** Liste des placements effectu�s pour ce client */
//	private ArrayList<Placement> patrimoine;

	// Constructeurs
	/**
	 * Constructeur par d�faut du client
	 */
	public Client() {
		super();
//		listeComptes = new HashMap<Integer, CompteBancaire>();
//		patrimoine = new ArrayList<Placement>();
		}
	
	/**
	 * Constructeur du client
	 * 
	 * @param String nom
	 * String prenom
	 * String adresse
	 * String codePostal,
	 * String ville
	 * String telephone
	 * int idcons
	 * @return void
	 */
	public Client(String nom, String prenom, String adresse, String codePostal,
			String ville, String telephone) {
		this();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
	}

	// Getters & Setters
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
	 * Getter de la propri�t� adresse
	 * 
	 * @return La propri�t� adresse
	 */
	public String getAdresse() {
		return this.adresse;
	}
	/**
	 * Setter de la propri�t� adresse
	 * 
	 * @return void
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * Getter de la propri�t� codePostal
	 * 
	 * @return La propri�t� codePostal
	 */
	public String getCodePostal() {
		return this.codePostal;
	}
	/**
	 * Setter de la propri�t� codePostal
	 * 
	 * @return void
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	/**
	 * Getter de la propri�t� ville
	 * 
	 * @return La propri�t� ville
	 */
	public String getVille() {
		return this.ville;
	}
	/**
	 * Setter de la propri�t� ville
	 * 
	 * @return void
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	 * Getter de la propri�t� telephone
	 * 
	 * @return La propri�t� telephone
	 */
	public String getTelephone() {
		return this.telephone;
	}
	/**
	 * Setter de la propri�t� telephone
	 * 
	 * @return void
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * Getter de la propri�t� id
	 * 
	 * @return La propri�t� id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Setter de la propri�t� id
	 * 
	 * @return void
	 */
	public void setId(int id) {
		this.id = id;
	}
//	public HashMap<Integer, CompteBancaire> getListeComptes() {
//		return listeComptes;
//	}
//	public void setListeComptes(HashMap<Integer, CompteBancaire> listeComptes) {
//		this.listeComptes = listeComptes;
//	}
//	public ArrayList<Placement> getPatrimoine() {
//		return patrimoine;
//	}
//	public void setPatrimoine(ArrayList<Placement> patrimoine) {
//		this.patrimoine = patrimoine;
//	}

//	/**
//	 * Getter de la propri�t� cons
//	 * 
//	 * @return La propri�t� cons
//	 */
//	public int getCons() {
//		return cons;
//	}
//	/**
//	 * Setter de la propri�t� cons
//	 * 
//	 * @return void
//	 */
//	public void setCons(int cons) {
//		this.cons = cons;
//	}

	/**
	 * Getter de la propri�t� listeComptes
	 * 
	 * @return La propri�t� listeComptes
	 */
	public ArrayList<Compte> getListeComptes() {
		return listeComptes;
	}
	/**
	 * Setter de la propri�t� listeComptes
	 * 
	 * @return void
	 */
	public void setListeComptes(ArrayList<Compte> listeComptes) {
		this.listeComptes = listeComptes;
	}

	public Conseiller getCons() {
		return cons;
	}

	public void setCons(Conseiller cons) {
		cons.getListeClients().add(this);
		this.cons = cons;
	}

	// Affichage
	/**
	 * M�thode permettant de retourner un String avec les propri�t�s de l'objet Client
	 * 
	 * @return String d�crivant le client
	 */
	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", telephone=" + telephone + ", id=" + id + ", cons=" + cons.getNom() + "]";
	}




}