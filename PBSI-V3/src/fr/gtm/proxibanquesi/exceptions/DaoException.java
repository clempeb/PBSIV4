package fr.gtm.proxibanquesi.exceptions;

/**
 * Classe personnalis�e d'exception, qui h�rite de la classe Exception,
 *  provoqu�e par une erreur dans la couche Dao
 */
public class DaoException extends Exception {

	/** Cl� de s�rialisation */
	private static final long serialVersionUID = 1L;
	/** Message renvoy� par l'exception */
	private String message = "Database Exception";
	
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
