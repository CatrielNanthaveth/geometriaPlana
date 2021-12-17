package ar.edu.uno.geometria;

public class Punto {
	
	private double x;
	private double y;
	
	public Punto(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public void desplazar(double x, double y) {
		this.x += x;
		this.y += y;
	}

	@Override
	public String toString() {
		return "[" + x + "," + y + "]";
	}
	
}
