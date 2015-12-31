package fr.gtm.proxibanquesi.exceptions;

/**
 * Classe personnalis�e d'exception, qui h�rite de la classe DaoException,
 *  provoqu�e si aucune donn�e en base ne correspond � la requ�te
 */
public class LigneInexistanteException extends DaoException {

	/** Cl� de s�rialisation */
	private static final long serialVersionUID = 1L;
	/** Message renvoy� par l'exception */
	private String message;
	
	/**
	 * Constructeur par d�faut de l'exception
	 * 
	 * @return void
	 */
	public LigneInexistanteException() {
		super();
	}
	
	/**
	 * Constructeur de l'exception
	 * 
	 * @param String message
	 * @return void
	 */
	public LigneInexistanteException(String message) {
		this();
		this.message = super.getMessage() + ": donn�e manquante. " + message;
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
