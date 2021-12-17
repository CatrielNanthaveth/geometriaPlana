package ar.edu.uno.geometria;

public class Rectangulo extends Figura {

	public Rectangulo(double a, double b, double c, double d, int numLinea) throws InvalidFiguraException {

		super.setNumLinea(numLinea);
		if (a == c || b == d) {
			throw new InvalidFiguraException("Uno de los ejes de ámbos puntos del rectangulo son iguales.");
		}
		getPuntos().add(new Punto(a, b));
		getPuntos().add(new Punto(c, d));

	}

	public Rectangulo(double a, double b, double c, double d) throws InvalidFiguraException {
		if (a == c || b == d) {
			throw new InvalidFiguraException("Uno de los ejes de ámbos puntos del rectangulo son iguales.");
		}
		getPuntos().add(new Punto(a, b));
		getPuntos().add(new Punto(c, d));
	}

	public double calcularArea() {

		Double lado1 = getPuntos().get(1).getX() - getPuntos().get(0).getX();
		Double lado2 = getPuntos().get(1).getY() - getPuntos().get(0).getY();

		lado1 = (lado1 < 0) ? lado1 * -1 : lado1;
		lado2 = (lado2 < 0) ? lado2 * -1 : lado2;

		return (lado1 * lado2);
	}

	@Override
	public String toString() {
		return "Rectangulo" + this.getNumLinea() + ": " + this.calcularArea();
	}

}