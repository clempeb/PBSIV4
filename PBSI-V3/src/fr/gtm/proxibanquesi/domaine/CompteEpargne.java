package fr.gtm.proxibanquesi.domaine;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe repr�sentant un compte �pargne, h�ritant de la classe abstraite Compte, avec un taux de r�muneration d�clar� � 3%.
 * @author Alexandre De Bruyn et Clement Peberge
 */
@Entity
@DiscriminatorValue("EPARGNE")
public class CompteEpargne extends Compte {

	// Propri�t�s
	/** Taux de r�mun�ration du compte �pargne */
	private double tauxRemuneration = 0.03;
	
	// Constructeurs
	/**
	 * Constructeur par d�faut du compte �pargne
	 * 
	 */
	public CompteEpargne() {
		super();
	}
	/**
	 * Constructeur permettant cr�er un compte �pargne avec un solde
	 * @param double solde : le solde du compte �pargne � cr�er
	 */
	public CompteEpargne(double solde) {
		super();
		setSolde(solde);
	}

	// Getters & Setters
	/**
	 * Getter de la propri�t� tauxRemuneration
	 * 
	 * @return La propri�t� tauxRemuneration
	 */
	public double getTauxRemuneration() {
		return tauxRemuneration;
	}
	/**
	 * Setter de la propri�t� tauxRemuneration
	 * 
	 * @return void
	 */
	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}
	
	// M�thodes
//	@Override
//	public void typeCompte(ICompteBancaire compte) {
//		CompteEpargne.class.getTypeName();
//	}
//	@Override
//	public void getProprietaire(Client client) {
//		// TODO Auto-generated method stub
//		
//	}

	// Affichage
	/**
	 * M�thode permettant de retourner un String avec les propri�t�s de l'objet CompteEpargne
	 * 
	 * @return String d�crivant le compte �pargne
	 */
	@Override
	public String toString() {
		return "Epargne";
	}

}