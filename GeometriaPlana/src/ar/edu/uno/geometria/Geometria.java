package ar.edu.uno.geometria;

import java.util.ArrayList;

public abstract class Geometria {
	// arrayList donde guardo todos los puntos de referencia de las figuras
		private ArrayList<Punto> puntos = new ArrayList<Punto>();
		private int numlinea;

		// recorro el arrayList de puntos para moverlos
		public void desplazar(double enX, double enY) {
			for (Punto punto : getPuntos()) {
				punto.desplazar(enX, enY);
			}
		}

		// informar mi posicion
		public String informarPos() {
			String miPos = "";
			for (Punto punto : getPuntos()) {
				miPos += punto.toString();
			}
			return miPos;
		}
		
		public ArrayList<Punto> getPuntos() {
			return puntos;
		}

		public int getNumLinea() {
			return numlinea;
		}

		public void setNumLinea(int linea) {
			this.numlinea = linea;
		}
		
}
