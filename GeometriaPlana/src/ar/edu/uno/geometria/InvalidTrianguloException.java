package ar.edu.uno.geometria;

	/***
	 * InvalidTrianguloException se lanza cuando un Triangulo tiene algun vértice igual
	 * a otro vértice, degenerando la figura y por lo tanto no se puede
	 * representar correctamente en el plano.
	 * 
	 */
	
@SuppressWarnings("serial")
public class InvalidTrianguloException extends RuntimeException {

	public InvalidTrianguloException(String s) {
		super(s);
	}	
}

