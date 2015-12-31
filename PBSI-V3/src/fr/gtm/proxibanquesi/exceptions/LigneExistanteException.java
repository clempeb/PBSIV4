package fr.gtm.proxibanquesi.exceptions;

/**
 * Classe personnalis�e d'exception, qui h�rite de la classe DaoException,
 *  provoqu�e si une cl� primaire de la base est viol�e
 */
public class LigneExistanteException extends DaoException {

	/** Cl� de s�rialisation */
	private static final long serialVersionUID = 1L;
	/** Message renvoy� par l'exception */
	private String message;
	
	/**
	 * Constructeur de l'exception
	 * 
	 * @param String message
	 * @return void
	 */
	public LigneExistanteException(String message) {
		super();
		this.message = super.getMessage() + ": " + message;
	}
	
	/**
	 * Getter de la propri�t� message
	 * 
	 * @return La propri�t� message
	 */
	@Override
	public String getMessage() {
		return this.message;
	}

}
