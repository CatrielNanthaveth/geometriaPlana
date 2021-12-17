package ar.edu.uno.geometria;

public class Cuadrado extends Rectangulo {

	private double lado = 0.0;
	
	public Cuadrado(double seg, double x, double y, int numLinea) throws InvalidCuadradoException{
		super(x,y,y+seg,x+seg, numLinea);
		this.lado = seg;
		
		if(lado > 0) {
			this.lado = seg;
		}
		else throw new InvalidCuadradoException("El lado del cuadrado es menor o igual a 0");
	}
	
	public Cuadrado(double seg, double x, double y) throws InvalidCuadradoException{
		super(x,y,y+seg,x+seg);
		this.lado = seg;
		
		if(lado > 0) {
			this.lado = seg;
		}
		else throw new InvalidCuadradoException("El lado del cuadrado es menor o igual a 0");
	}
	
	@Override
	public double calcularArea() {
		return (lado * lado);
	}

	@Override
	public String toString() {
		return "Cuadrado " + this.getNumLinea() + ": " + Double.toString(this.calcularArea());
		//return "Cuadrado [lado = " + lado + " ; punto A = " + super.getPuntos().get(0) + " ; punto B = " + super.getPuntos().get(1) + "]";
	}

}
