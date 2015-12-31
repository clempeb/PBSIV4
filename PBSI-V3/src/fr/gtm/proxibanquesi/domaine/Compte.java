package fr.gtm.proxibanquesi.domaine;

import java.sql.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Classe abstraite repr�sentant un compte en banque g�n�rique.
 * @author Alexandre De Bruyn et Clement Peberge
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE")
@DiscriminatorValue("NULL")
@NamedQueries({
	@NamedQuery(name="readCompte", query="SELECT co FROM Compte co WHERE co.numCompte = :numCompte"),
	@NamedQuery(name="readAllCompte", query="SELECT co FROM Compte co WHERE co.client.id = :idclient")})
public abstract class Compte {

	// Propri�t�s
	/** Num�ro du compte */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int numCompte;
	/** Solde du compte */
	private double solde;
	/** Date d'ouverture du compte */
	private Date dateOuverture;
//	/** Num�ro d'identification du client auquel le compte appartient */
//	private int idcli;
	
	@ManyToOne
	private Client client;
	
	// Getters & Setters
	/**
	 * Getter de la propri�t� numCompte
	 * 
	 * @return La propri�t� numCompte
	 */
	public int getNumCompte() {
		return numCompte;
	}
	/**
	 * Setter de la propri�t� numCompte
	 * 
	 * @return void
	 */
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	/**
	 * Getter de la propri�t� solde
	 * 
	 * @return La propri�t� solde
	 */
	public double getSolde() {
		return solde;
	}
	/**
	 * Setter de la propri�t� solde
	 * 
	 * @return void
	 */
	public void setSolde(double d) {
		this.solde = d;
	}
	/**
	 * Getter de la propri�t� dateOuverture
	 * 
	 * @return La propri�t� dateOuverture
	 */
	public Date getDateOuverture() {
		return dateOuverture;
	}
	/**
	 * Setter de la propri�t� dateOuverture
	 * 
	 * @return void
	 */
	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		client.getListeComptes().add(this);
		this.client = client;
	}
	//	/**
//	 * Getter de la propri�t� idcli
//	 * 
//	 * @return La propri�t� idcli
//	 */
//	public int getIdcli() {
//		return idcli;
//	}
//	/**
//	 * Setter de la propri�t� idcli
//	 * 
//	 * @return void
//	 */
//	public void setIdcli(int idcli) {
//		this.idcli = idcli;
//	}
	// Affichage
	/**
	 * M�thode permettant de retourner un String avec les propri�t�s de l'objet Compte
	 * 
	 * @return String d�crivant le compte
	 */
	@Override
	public String toString() {
		return "CompteBancaire [numCompte=" + numCompte + ", solde=" + solde
				+ "]";
	}

}