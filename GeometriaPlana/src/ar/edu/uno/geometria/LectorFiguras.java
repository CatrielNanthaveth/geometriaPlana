package ar.edu.uno.geometria;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class LectorFiguras {

	public static HashMap<String, LinkedList<Geometria>> leerFiguras(String archivo) {

		HashMap<String, LinkedList<Geometria>> geometrias = new HashMap<>();

		LinkedList<Geometria> circulitos = new LinkedList<Geometria>();
		LinkedList<Geometria> elipsitas = new LinkedList<Geometria>();
		LinkedList<Geometria> cuadraditos = new LinkedList<Geometria>();
		LinkedList<Geometria> rectangulitos = new LinkedList<Geometria>();
		LinkedList<Geometria> triangulitos = new LinkedList<Geometria>();
		LinkedList<Geometria> segmentitos = new LinkedList<Geometria>();

		String[] arrFiguras;
		String nombreFigura;

		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivo));
			int numlinea = 1;
			while (sc.hasNext()) {
				arrFiguras = sc.nextLine().split(",");

				nombreFigura = arrFiguras[0];
			
				try {
					switch (nombreFigura) {
					case "CUADRADO":

						try {
							cuadraditos.add(new Cuadrado(Double.parseDouble(arrFiguras[1]),
									Double.parseDouble(arrFiguras[2]), Double.parseDouble(arrFiguras[3]), numlinea));
						} catch (InvalidCuadradoException exCua) {
							System.err.println(exCua.getMessage());
						}

						break;
					case "RECTANGULO":
						try {
							rectangulitos.add(new Rectangulo(Double.parseDouble(arrFiguras[1]),
									Double.parseDouble(arrFiguras[2]), Double.parseDouble(arrFiguras[3]),
									Double.parseDouble(arrFiguras[4]), numlinea));
						} catch (InvalidFiguraException exRec) {
							System.err.println(exRec.getMessage());
						}
						break;
					case "TRIANGULO":

						try {
							triangulitos.add(new Triangulo(Double.parseDouble(arrFiguras[1]),
									Double.parseDouble(arrFiguras[2]), Double.parseDouble(arrFiguras[3]),
									Double.parseDouble(arrFiguras[4]), Double.parseDouble(arrFiguras[5]),
									Double.parseDouble(arrFiguras[6]), numlinea));
						} catch (InvalidTrianguloException exTri) {
							System.err.println(exTri.getMessage());
						}	catch (InvalidFiguraException exRec) {
							System.err.println(exRec.getMessage());
						}

						break;
					case "CIRCULO":

						try {
							circulitos.add(new Circulo(Double.parseDouble(arrFiguras[1]),
									Double.parseDouble(arrFiguras[2]), Double.parseDouble(arrFiguras[3]), numlinea));
						} catch (InvalidRadioException exCir) {
							System.err.println(exCir.getMessage());
						}

						break;
					case "ELIPSE":
						elipsitas.add(new Elipse(Double.parseDouble(arrFiguras[1]), Double.parseDouble(arrFiguras[2]),
								Double.parseDouble(arrFiguras[3]), Double.parseDouble(arrFiguras[4]), numlinea));
						break;
					case "SEGMENTO":

						try {
							segmentitos.add(new Segmento(
									new Punto(Double.parseDouble(arrFiguras[1]), Double.parseDouble(arrFiguras[2])),
									new Punto(Double.parseDouble(arrFiguras[3]), Double.parseDouble(arrFiguras[4])),
									numlinea));
						} catch (InvalidSegmentoException exSeg) {
							System.err.println(exSeg.getMessage());
						}

						break;
					default:
						System.err.println("La opción no es aceptable.");
						break;
					}


				} catch (IndexOutOfBoundsException ex) {
					System.err.println(ex.getMessage());
				}
				numlinea++;
			}

			geometrias.put("Circulos", circulitos);
			geometrias.put("Elipses", elipsitas);
			geometrias.put("Cuadrados", cuadraditos);
			geometrias.put("Rectangulos", rectangulitos);
			geometrias.put("Triangulos", triangulitos);
			geometrias.put("Segmentos", segmentitos);

			/*
			 * } catch (ArrayIndexOutOfBoundsException e) {
			 * 
			 * System.err.println("Error: " + e.getMessage());
			 */} catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());
		} finally {
			sc.close();
		}
		return geometrias;
	}
}
