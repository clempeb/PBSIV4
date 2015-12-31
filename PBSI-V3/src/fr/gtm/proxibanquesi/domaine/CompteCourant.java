package fr.gtm.proxibanquesi.domaine;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe repr�sentant un compte courant, h�ritant de la classe abstraite Compte, avec autorisation de d�couvert d�clar�e de 1000 euro.
 * @author Alexandre De Bruyn et Clement Peberge
 */
@Entity
@DiscriminatorValue("COURANT")
public class CompteCourant extends Compte {

	// Propri�t�s
	/** Autorisation de d�couvert */
	private double autorisationDecouvert = 1000;
	
	// Constructeurs
	/**
	 * Constructeur par d�faut du compte courant
	 * 
	 */
	public CompteCourant() {
		super();
	}
	/**
	 * Constructeur permettant cr�er un compte courant avec un solde
	 * @param double solde : le solde du compte courant � cr�er
	 */
	public CompteCourant(double solde) {
		super();
		setSolde(solde);
	}
	

	// Getters & Setters
	/**
	 * Getter de la propri�t� autorisationDecouvert
	 * 
	 * @return La propri�t� autorisationDecouvert
	 */
	public double getAutorisationDecouvert() {
		return autorisationDecouvert;
	}
	/**
	 * Setter de la propri�t� autorisationDecouvert
	 * 
	 * @return void
	 */
	public void setAutorisationDecouvert(double d) {
		this.autorisationDecouvert = d;
	}

	// M�thodes
//	@Override
//	public void typeCompte(ICompteBancaire compte) {
//		CompteCourant.class.getTypeName();
//		
//	}
//	@Override
//	public void getProprietaire(Client client) {
//		// TODO Auto-generated method stub
//		
//	}
	
	// Affichage
	/**
	 * M�thode permettant de retourner un String avec les propri�t�s de l'objet CompteCourant
	 * 
	 * @return String d�crivant le compte courant
	 */
	@Override
	public String toString() {
		return "Courant";
	}

}