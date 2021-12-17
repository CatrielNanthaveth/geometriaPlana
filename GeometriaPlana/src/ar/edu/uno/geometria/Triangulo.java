package ar.edu.uno.geometria;

import java.util.ArrayList;

public class Triangulo extends Figura{
	
	private ArrayList<Segmento> segmentos = new ArrayList<Segmento>(3);
	
	public Triangulo(double a, double b, double c, double d, double e, double f, int numLinea) throws InvalidTrianguloException{
		
		super.setNumLinea(numLinea);
		
		if((a == c && b == d || a == e && b == f || c == e && d == f) || (a == c && a == e)) {
			throw new InvalidTrianguloException("Uno de los vértices es igual a otro.");
		}
		else {
			getPuntos().add(new Punto(a,b));
			getPuntos().add(new Punto(c,d));
			getPuntos().add(new Punto(e,f));
		}
		
		construirSegmentos();
	
	}

	public Triangulo(double a, double b, double c, double d, double e, double f) {
		if((a == c && b == d || a == e && b == f || c == e && d == f) || (a == c && a == e)) {
			throw new InvalidTrianguloException("Uno de los vértices es igual a otro.");
		}
		else {
			getPuntos().add(new Punto(a,b));
			getPuntos().add(new Punto(c,d));
			getPuntos().add(new Punto(e,f));
		}
		
		construirSegmentos();
	}

	public ArrayList<Segmento> getSegmentos() {
		return segmentos;
	}
	
	private void construirSegmentos() {
		segmentos.add(new Segmento(getPuntos().get(0), getPuntos().get(1), -1));
		segmentos.add(new Segmento(getPuntos().get(1), getPuntos().get(2), -1));
		segmentos.add(new Segmento(getPuntos().get(2), getPuntos().get(0), -1));
	}

	@Override
	public double calcularArea() {
		return segmentos.get(0).longitud()*segmentos.get(1).longitud()/2;
	}

	@Override
	public String toString() {
		return "Triangulo " + this.getNumLinea() + ": " + this.calcularArea();
	}
	
}
