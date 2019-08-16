package model.DomainException;

// Estendendo de Excepion somos obrigado a tratar a exceção.
// RuntimeException não obriga o tratamento mais o programa pode quebrar 
// public class DomainException extends Exception {
public class DomainException extends RuntimeException {

	/** A classe é sirializada por isso tem uma versão
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public  DomainException(String msg) {
		// Chama o construto da super Classe
		super(msg);
	}
}

