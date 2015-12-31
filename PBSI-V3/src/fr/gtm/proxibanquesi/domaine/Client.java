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

/** Classe représentant un client de la banque.
 * Toutes les informations personnelles sont de type String
 *  hormis les numéros d'identification du client et du conseiller ainsi
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
	/** Numéro de téléphone du client */
	private String telephone;
	/** Numéro d'identification du client */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
//	/** Numéro d'identification du conseiller gérant le client */
//	private int cons;
	@ManyToOne
	private Conseiller cons;
	
	/** Liste des comptes du client */
	@OneToMany(cascade=CascadeType.ALL, mappedBy="client")
	private ArrayList<Compte> listeComptes = new ArrayList<Compte>();
//	/** Liste des placements effectués pour ce client */
//	private ArrayList<Placement> patrimoine;

	// Constructeurs
	/**
	 * Constructeur par défaut du client
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
	 * Getter de la propriété nom
	 * 
	 * @return La propriété nom
	 */
	public String getNom() {
		return this.nom;
	}
	/**
	 * Setter de la propriété nom
	 * 
	 * @return void
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * Getter de la propriété prenom
	 * 
	 * @return La propriété prenom
	 */
	public String getPrenom() {
		return this.prenom;
	}
	/**
	 * Setter de la propriété prenom
	 * 
	 * @return void
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * Getter de la propriété adresse
	 * 
	 * @return La propriété adresse
	 */
	public String getAdresse() {
		return this.adresse;
	}
	/**
	 * Setter de la propriété adresse
	 * 
	 * @return void
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * Getter de la propriété codePostal
	 * 
	 * @return La propriété codePostal
	 */
	public String getCodePostal() {
		return this.codePostal;
	}
	/**
	 * Setter de la propriété codePostal
	 * 
	 * @return void
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	/**
	 * Getter de la propriété ville
	 * 
	 * @return La propriété ville
	 */
	public String getVille() {
		return this.ville;
	}
	/**
	 * Setter de la propriété ville
	 * 
	 * @return void
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	 * Getter de la propriété telephone
	 * 
	 * @return La propriété telephone
	 */
	public String getTelephone() {
		return this.telephone;
	}
	/**
	 * Setter de la propriété telephone
	 * 
	 * @return void
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * Getter de la propriété id
	 * 
	 * @return La propriété id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Setter de la propriété id
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
//	 * Getter de la propriété cons
//	 * 
//	 * @return La propriété cons
//	 */
//	public int getCons() {
//		return cons;
//	}
//	/**
//	 * Setter de la propriété cons
//	 * 
//	 * @return void
//	 */
//	public void setCons(int cons) {
//		this.cons = cons;
//	}

	/**
	 * Getter de la propriété listeComptes
	 * 
	 * @return La propriété listeComptes
	 */
	public ArrayList<Compte> getListeComptes() {
		return listeComptes;
	}
	/**
	 * Setter de la propriété listeComptes
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
	 * Méthode permettant de retourner un String avec les propriétés de l'objet Client
	 * 
	 * @return String décrivant le client
	 */
	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", telephone=" + telephone + ", id=" + id + ", cons=" + cons.getNom() + "]";
	}




}