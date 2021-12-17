package ar.edu.uno.geometria;
import static java.lang.Math.*;

public class Segmento extends Geometria implements Comparable<Segmento>{

	
	public Segmento(Punto a, Punto b, int numLinea) throws InvalidSegmentoException {
		
		super.setNumLinea(numLinea);
		
		if(a.getX() == b.getX() && a.getY() == b.getY()) {
			throw new InvalidSegmentoException("Los extremos son iguales.");
		}
		else {
			getPuntos().add(a);
			getPuntos().add(b);
		}
		
	}
	
	public double longitud() {
		return sqrt(pow((getPuntos().get(1).getX() - getPuntos().get(0).getX()),2)+pow((getPuntos().get(1).getY() - getPuntos().get(0).getY()),2));
	}
	
	// Si los puntos tienen el mismo valor en Y el segmento es paralelo a X
	public boolean esParaleloX() {
		return getPuntos().get(0).getY() == getPuntos().get(1).getY();
	}
	
	// Si los puntos tienen el mismo valor en X el segmento es paralelo a Y
	public boolean esParaleloY() {
		return getPuntos().get(0).getX() == getPuntos().get(1).getX();
	}
	
	// Si los angulos son iguales son paralelos, cuando superan los 180 grados le resto 180 para poder comparar segmentos de direcciones opuestas.
	public boolean esParaleloA(Segmento otro) {
		double angulo1 = (tan(pendiente())>180)?tan(pendiente())-180:tan(pendiente());
		double angulo2 = (tan(otro.pendiente())>180)?tan(otro.pendiente())-180:tan(otro.pendiente());
		return (angulo1 == angulo2);
	}
	
	public double pendiente() {
		return (getPuntos().get(1).getY()-getPuntos().get(0).getY())/(getPuntos().get(1).getX()-getPuntos().get(0).getX());
	}

	
	@Override
	public String toString() {
		return "Segmento " + this.getNumLinea() + ": " + this.longitud();
	}
	
	@Override
	public int compareTo(Segmento otro) {
		int res;
		if (this.longitud() > otro.longitud())
			res = 1;
		else if (this.longitud() < otro.longitud())
			res = -1;
		else
			res = 0;
		return res;
	}
}