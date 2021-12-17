package ar.edu.uno.junit.test;

import static org.junit.Assert.*;
import org.junit.Test;

import ar.edu.uno.geometria.Circulo;
import ar.edu.uno.geometria.Cuadrado;
import ar.edu.uno.geometria.Elipse;
import ar.edu.uno.geometria.InvalidCuadradoException;
import ar.edu.uno.geometria.InvalidFiguraException;
import ar.edu.uno.geometria.InvalidRadioException;
import ar.edu.uno.geometria.InvalidTrianguloException;
import ar.edu.uno.geometria.Punto;
import ar.edu.uno.geometria.Rectangulo;
import ar.edu.uno.geometria.Segmento;
import ar.edu.uno.geometria.Triangulo;

public class testGeometria {

	@Test
	public void testLongitud() {
		Segmento segmentito = new Segmento(new Punto(0,3), new Punto(0,4), -1);
		double esperado = 1.0;
		double obtenido = segmentito.longitud();
		assertEquals(esperado, obtenido, 0.01);
	} 
	
	@Test
	public void testEsParaleloX() {
		Segmento segmentito1 = new Segmento(new Punto(3,4), new Punto(4,4), -1);
		assertTrue(segmentito1.esParaleloX());
	}
	
	@Test
	public void testEsParaleloY() {
		Segmento segmentito1 = new Segmento(new Punto(5,1), new Punto(5,4), -1);
		assertTrue(segmentito1.esParaleloY());
	}
	
	@Test
	public void testEsParaleloA() {
		Segmento segmentito1 = new Segmento(new Punto(3,3), new Punto(4,4), -1);
		Segmento segmentito2 = new Segmento(new Punto(4,4), new Punto(5,5), -1);
		assertTrue(segmentito1.esParaleloA(segmentito2));
	}
	
	@Test
	public void testPendiente() {
		// Hacer test de la pendiente
		
	}
	
	
	//	Desde acá se testean los casos de la clase Cuadrado
	
	@Test
	public void testCreoCuadrado(){
		Cuadrado cuadradito = new Cuadrado(10, 1, 1);
		assertNotNull(cuadradito);
	}
	
	@Test (expected= InvalidCuadradoException.class)
	public void testCreoCuadradoNegativo() {
		//	creo un cuadrado con lado negativo, deformándolo
		Cuadrado cuadraditoNegativo = new Cuadrado(-5, 1, 1);
		assertNotNull(cuadraditoNegativo);
		
	}
	
	@Test (expected= InvalidFiguraException.class)
	public void testCreoCuadradoLadoNulo() {
		// 	creo un cuadrado que en realidad es un segmento
		Cuadrado cuadraditoLadoNulo = new Cuadrado(0, 1, 1);
		assertNotNull(cuadraditoLadoNulo);
		
	}
	
	@Test
	public void testCalculoAreaCuadrado() {
		Cuadrado cuadradito = new Cuadrado(10, 1, 1);
		// 	area = 10*10 = 100
		assertEquals(100, cuadradito.calcularArea(), 0);
	}
	
	// 	Desde acá se testean los casos de la clase Rectangulo
	
	@Test
	public void testCreoRectangulo() {
		Rectangulo rectangulito = new Rectangulo(10, 1, 4, 6);
		assertNotNull(rectangulito);
	}
	
	@Test (expected= InvalidFiguraException.class)
	public void testCreoRectanguloInvalido() {
		// 	creo un rectangulo que en realidad es un segmento porque tiene ejes iguales
		Rectangulo rectangulito = new Rectangulo(10, 1, 10, 6);
		assertNotNull(rectangulito);
	}
	
	@Test
	public void testCalcularAreaRectangulo() {
		Rectangulo rectangulito = new Rectangulo(1, 5, 6, 11);
		// 	area = 5*6 = 30
		assertEquals(30, rectangulito.calcularArea(), 0);
	}
	
	// 	Desde acá se testean los casos de la clase Circulo
	
	@Test
	public void testCreoCirculo() {
		Circulo circulito = new Circulo(10, 1, 4);
		assertNotNull(circulito);
	}
	
	@Test (expected= InvalidRadioException.class)
	public void testCreoCirculoInvalido() {
		Circulo circulito = new Circulo(0, 1, 4);
		assertNotNull(circulito);
		
		Circulo circulito2 = new Circulo(-5, 1, 4);
		assertNotNull(circulito2);
	}
	
	@Test
	public void testCalcularAreaCirculo() {
		Circulo circulito = new Circulo(5, 1, 4);
		assertEquals(78.53981, circulito.calcularArea(), 0.00001);
		
	}
	
	//	Desde acá se testean los casos de la clase Elipse
	
	@Test
	public void testCreoElipse() {
		Elipse circulito = new Elipse(10, 3, 4, 5);
		assertNotNull(circulito);
	}
	
	@Test (expected= InvalidRadioException.class)
	public void testCreoElipseInvalido() {
		Elipse elipsito = new Elipse(-5, 3, 4, 5);
		assertNotNull(elipsito);
		
		Elipse elipsito2 = new Elipse(0, 3, 4, 5);
		assertNotNull(elipsito2);
	}
	
	@Test
	public void testCalcularAreaElipse() {
		Elipse elipsito = new Elipse(5, 4, 4, 5);
		assertEquals(62.83185, elipsito.calcularArea(), 0.00001);
		
	}
	
	// 	Desde acá se testean los casos de la clase Punto
	
	@Test
	public void testCreoPunto() {
		Punto puntito = new Punto(2, 2);
		assertNotNull(puntito);
	}
	
	@Test
	public void testDesplazoPunto() {
		Punto puntito = new Punto(2, 2);
		assertEquals(2, puntito.getX(), 0.001);
		assertEquals(2, puntito.getY(), 0.001);
		
		puntito.desplazar(2, 1);
		assertEquals(4, puntito.getX(), 0.001);
		assertEquals(3, puntito.getY(), 0.001);
	}
	
	// 	Desde acá se testean los casos de la clase Triangulo
	
	
	@Test
	public void testCreoTriangulo() {
		Triangulo triangulito = new Triangulo(2, 3, 4, 5, 6, 7);
		assertNotNull(triangulito);
	}
	
	@Test (expected = InvalidTrianguloException.class)
	public void testCreoTrianguloInvalido() {
		Triangulo triangulito = new Triangulo(2, 3, 2, 3, 6, 7);
		assertNotNull(triangulito);
	}
}
