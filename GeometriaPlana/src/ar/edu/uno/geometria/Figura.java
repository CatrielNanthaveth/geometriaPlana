package ar.edu.uno.geometria;

public abstract class Figura extends Geometria implements Comparable<Figura> {

	// implementar segun corresponda
	abstract double calcularArea();

	@Override
	public int compareTo(Figura otra) {

		if (this.calcularArea() > otra.calcularArea())
			return 1;
		if (this.calcularArea() < otra.calcularArea())
			return -1;
		else
			return 0;
	}
}