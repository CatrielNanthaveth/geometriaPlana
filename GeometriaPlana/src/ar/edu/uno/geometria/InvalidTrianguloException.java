package ar.edu.uno.geometria;

	/***
	 * InvalidTrianguloException se lanza cuando un Triangulo tiene algun v�rtice igual
	 * a otro v�rtice, degenerando la figura y por lo tanto no se puede
	 * representar correctamente en el plano.
	 * 
	 */
	
@SuppressWarnings("serial")
public class InvalidTrianguloException extends RuntimeException {

	public InvalidTrianguloException(String s) {
		super(s);
	}	
}

