package ar.edu.uno.geometria;

import static java.lang.Math.*;

public class Elipse extends Circulo {

	private double radio2;
	
	public Elipse(double radio1, double radio2, double x, double y, int numLinea) {
				
		super(radio1, x, y, numLinea);
		this.radio2 = radio2;
	}

	public Elipse(double radio1, double radio2, double x, double y) {
		super(radio1, x, y);
		this.radio2 = radio2;
	}

	@Override
	public double calcularArea() {
		return PI*super.getRadio()*radio2;
	}

	@Override
	public String toString() {
		return "Elipse " + this.getNumLinea() + ": " + this.calcularArea();
	}

}