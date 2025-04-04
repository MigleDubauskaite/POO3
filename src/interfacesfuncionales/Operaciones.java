package interfacesfuncionales;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Operaciones implements OperacionEntraEnteroSaleEntero {
	
	public int cuadrado(int x) {
		return x * x;
	}
	
	public int cubo(int x) {
		return x * x * x;
	}
	
	public int doble(int x) {
		return x * 2;
	}
	
	public int triple(int x) {
		return x * 3;
	}
	
	public int polinomio(int x) {
		return polinomioVariable(5, 7, 9, x);
	}
	
	public int polinomioVariable(int x, int a, int b, int c) {
		//a*x^3+b*x^2+c
		return (a * (x*x*x)) + (b * (x*x)) + c;
	}
	
	
	// A partir de un Array de enteros primitivos, calcular:
	/////////////////////////////////////////	
	public List<Integer> filtra (int[] numeros, FiltroEnteros f) {
		
		List<Integer> listaFiltrada = new ArrayList<>();
		
		for (int num : numeros) {
			if (f.filtrar(num)) {
				listaFiltrada.add(num);
			}
		}
		
		return listaFiltrada;
	}
	
	
	
	public static void main(String[] args) {
		
		Operaciones operaciones = new Operaciones();
		
		//esta x es una variable local y no choca con los parámetros anteriores
		int x = 3;
		
		System.out.println("operaciones.cuadrado " + operaciones.cuadrado(x));
		System.out.println(operaciones.cubo(x));
		System.out.println(operaciones.doble(x));
		System.out.println(operaciones.triple(x));
		System.out.println(operaciones.polinomio(x));
		System.out.println(operaciones.polinomioVariable(5, 7, 9, x));
		
		// 1º es la versión comprimida || 2º es la versión completa
		OperacionEntraEnteroSaleEntero cuadrado = s -> s * s;
		OperacionEntraEnteroSaleEntero cuadrado2 = (int s) -> {return s * s;};
		
		OperacionEntraEnteroSaleEntero cubo = s -> s * s * s;
		OperacionEntraEnteroSaleEntero doble = s -> s * 2;
		OperacionEntraEnteroSaleEntero triple = s -> s * 3;
		OperacionEntraEnteroSaleEntero polinomio = s -> (5 * x * x * x) + (7 * x * x) + 9;
		// son las instancias de un Object
		
		OperacionEntran4EnterosSaleEntero polinomioVariable = (a, b, c, d) -> (a * x * x * x) + (b * x * x) + c;
		
		System.out.println("\nCUADRADO " + cuadrado.dale(x));
		System.out.println("DOBLE " +doble.dale(x));
		System.out.println("TRIPLE " + triple.dale(x));
		System.out.println("CUBO " + cubo.dale(x));
		System.out.println("POLINOMIO (otra interfaz) " + polinomioVariable.dale(5, 7, 9, x));
		
		// Realizar el mismo problema con Functional Interface
		//////////////////////////////
		OperacionesInterfacesFuncionales mitad = s -> s / 2;
		OperacionesInterfacesFuncionales cuarta = s -> s / 4.; 
		OperacionesInterfacesFuncionales decima = s -> s / 10.; 
		OperacionesInterfacesFuncionalesN nsima = (s, n) -> s / n; 
		
		System.out.println("\nMitad: " + mitad.dale1(10));
		System.out.println("\nCuarta: " + cuarta.dale1(x));
		System.out.println("\nDécima: " + decima.dale1(x));
		System.out.println("\nNsima: " + nsima.daleN(10, 5));
		
		
		// A partir de un Array de enteros primitivos, calcular:
		/////////////////////////////////////////
		System.out.println(operaciones.filtra(new int[] {2, 3, -7, -5}, s -> s < 0));
		
		
		
	}
	@Override
	public int dale(int i) {
		//podría hacer cuadrado, cubo, etc.
		return 0;
	}
}
