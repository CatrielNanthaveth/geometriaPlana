package ar.edu.uno.geometria;

/***
 * InvalidFiguraException se lanza cuando una figura tiene algun eje igual
 * a otro, formando una l�nea y por lo tanto no ser�a un rect�ngulo.
 * 
 */

@SuppressWarnings("serial")
public class InvalidFiguraException extends RuntimeException{

	public InvalidFiguraException(String s) {
		super(s);
	}
}