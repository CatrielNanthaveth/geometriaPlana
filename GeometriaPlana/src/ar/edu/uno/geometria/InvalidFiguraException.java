package ar.edu.uno.geometria;

/***
 * InvalidFiguraException se lanza cuando una figura tiene algun eje igual
 * a otro, formando una línea y por lo tanto no sería un rectángulo.
 * 
 */

@SuppressWarnings("serial")
public class InvalidFiguraException extends RuntimeException{

	public InvalidFiguraException(String s) {
		super(s);
	}
}