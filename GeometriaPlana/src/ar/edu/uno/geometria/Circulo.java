package ar.edu.uno.geometria;
import static java.lang.Math.*;

public class Circulo extends Figura {
	
	private double radio;
	
	public Circulo(double radio, double a, double b, int numLinea) {
		
		super.setNumLinea(numLinea);
		
		this.radio = radio;
		
		if(radio > 0) {
			getPuntos().add(new Punto(a,b));
			this.radio = radio; 
		}
		else throw new InvalidRadioException("El radio no puede ser menor o igual a 0.");
		
	}

	public Circulo(double radio, double a, double b) {
		this.radio = radio;
		
		if(radio > 0) {
			getPuntos().add(new Punto(a,b));
			this.radio = radio; 
		}
		else throw new InvalidRadioException("El radio no puede ser menor o igual a 0.");
	}

	@Override
	public double calcularArea() {
		return PI*pow(radio,2);
	}

	@Override
	public String toString() {
		return "Circulo " + this.getNumLinea() + ": " + this.calcularArea();
	}

	public double getRadio() {
		return radio;
	}
}
