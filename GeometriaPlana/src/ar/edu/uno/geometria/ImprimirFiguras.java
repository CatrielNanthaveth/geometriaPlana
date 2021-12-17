package ar.edu.uno.geometria;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

public class ImprimirFiguras {

	HashMap<String, LinkedList<Geometria>> geometrias = new HashMap<>();

	public ImprimirFiguras(HashMap<String, LinkedList<Geometria>> geometrias2) {
		this.geometrias = geometrias2;
	}

	public void imprimir() {

		try {
			FileWriter archivo = new FileWriter("arch/figuras.out");
			PrintWriter salida = new PrintWriter(archivo);

			for (Entry<String, LinkedList<Geometria>> entry : geometrias.entrySet()) {
				salida.println(entry.getKey());

				LinkedList<Geometria> miLista = entry.getValue();
				miLista.sort(null);
				Collections.reverse(miLista);

				Iterator<Geometria> iterator = miLista.iterator();
				while (iterator.hasNext()) {
					salida.println(iterator.next());
				}
			}
			salida.close();
		} catch (IOException e) {
			System.err.print("No se pudo crear el archivo");
		}

	}

	public void imprimirGrandotes() {

		try {
			FileWriter archivo = new FileWriter("arch/gradotes.out");
			PrintWriter salida = new PrintWriter(archivo);

			for (Entry<String, LinkedList<Geometria>> entry : geometrias.entrySet()) {

				String tipo = entry.getKey();
				salida.println(tipo);

				LinkedList<Geometria> miLista = entry.getValue();
				miLista.sort(null);
				Collections.reverse(miLista);

				Iterator<Geometria> iterator = miLista.iterator();

				Boolean flag = true;
				double max = 0.0;

				if (tipo == "Segmentos") {

					while (iterator.hasNext()) {
						Segmento seg = (Segmento) iterator.next();
						if (flag) {
							max = seg.longitud();
							salida.println(seg);
							flag = false;
						} else if (max == seg.longitud()) {
							salida.println(seg);
						}

					}

				} else {
					while (iterator.hasNext()) {
						Figura fig = (Figura) iterator.next();
						if (flag) {
							max = fig.calcularArea();
							salida.println(fig);
							flag = false;
						} else if (max == fig.calcularArea()) {
							salida.println(fig);
						}

					}
				}
			}
			salida.close();
		} catch (IOException e) {
			System.err.print("No se pudo crear el archivo");
		}

	}

	public void imprimirParalelos() {

		try {
			FileWriter archivo2 = new FileWriter("arch/paralelos.out");
			PrintWriter salida2 = new PrintWriter(archivo2);

			salida2.println("Los segmentos paralelos a X o Y son:");

			for (Entry<String, LinkedList<Geometria>> entry : geometrias.entrySet()) {
				if (entry.getKey() == "Segmentos") {

					Iterator<Geometria> iterator = entry.getValue().iterator();
					while (iterator.hasNext()) {
						Segmento miSegmento = (Segmento) iterator.next();
						if (miSegmento.esParaleloX() || miSegmento.esParaleloY()) {
							salida2.println(miSegmento);
						}
					}
				}

			}

			salida2.println("Los Triangulos con segmentos paralelos a X o Y son:");

			for (Entry<String, LinkedList<Geometria>> entry : geometrias.entrySet()) {
				if (entry.getKey() == "Triangulos") {

					Iterator<Geometria> iterator = entry.getValue().iterator();
					while (iterator.hasNext()) {
						Triangulo miTriangulo = (Triangulo) iterator.next();
						int cont = 0;
						for (Segmento tr : miTriangulo.getSegmentos()) {
							if (tr.esParaleloX() || tr.esParaleloY()) {
								cont++;
							}
						}
						if (cont > 0) {
							salida2.println(miTriangulo + " Tiene: " + cont + " Segmentos paralelos a X o Y");
						}
					}
				}

			}

			salida2.close();

		} catch (IOException e) {
			System.err.print("No se pudo crear el archivo");
		}

	}

}
