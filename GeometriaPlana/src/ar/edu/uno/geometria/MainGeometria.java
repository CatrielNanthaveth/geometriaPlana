package ar.edu.uno.geometria;

import java.util.HashMap;
import java.util.LinkedList;

public class MainGeometria {

	public static void main(String[] args) {
		
		HashMap<String, LinkedList<Geometria>> geometrias = LectorFiguras.leerFiguras("arch/input.csv");
		
		ImprimirFiguras impresora = new ImprimirFiguras(geometrias);
		
		System.out.println(geometrias);
		
		
		impresora.imprimir();
		impresora.imprimirParalelos();
		impresora.imprimirGrandotes();
	}

}
