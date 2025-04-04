package contenidos_3_evaluacion;

import java.util.ArrayList;
import java.util.List;

public class Ejemplo1 {
	
	public static void main(String[] args) {
		
		// tiene inconvenientes cargar los datos de lista así
		// es una lista inmutable entonces no se puede aplizar el removeIf
		List<Integer> lista0 = List.of(3, 4, 5, 1, 6, 9);
		
		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(3);
		lista.add(9);
		lista.add(7);
		lista.add(4);
		
		System.out.println("PROGRAMANDO FUNCIONALMENTE");
		
		// admite un Consumer que devuelve un void
		lista.forEach(x -> System.out.println ("antes -> " + x + " "));
		System.out.println();
		
		// una forma de expresar un Consumer. Meto dentro el parametro
		// en esta lista para cada uno utilzias función print
		lista.forEach(System.out::println);
		System.out.println();
		
		// removeIf
		// un Predicate
		lista.removeIf(x -> x > 3);
		lista.forEach(x -> System.out.println("después -> " + x + " "));
		lista.replaceAll(s -> s * 2);
		
		// quedarme con los pares al cuadrado
		lista.removeIf(s -> s % 2 == 1);
		lista.removeIf(s -> s == 0);
		lista.replaceAll(n -> n * n);
		
		
		System.out.println("\n\nPROGRAMANDO NO FUNCIONALMENTE");
		
		List<Integer> lista2 = new ArrayList<>();
		lista2.add(1);
		lista2.add(3);
		lista2.add(9);
		lista2.add(7);
		lista2.add(4);
		
		for (Integer i : lista2) {
			System.out.println("antes -> " + i);
		}
		System.out.println();
		
		
		for (Integer i : lista2) {
			System.out.println(i);
		}
		
		System.out.println();
		
		for (int i = lista.size() - 1; i >= 0 ; i--) {
			if (lista.get(i) > 3) {
				lista2.remove(i);
			}
		}
		System.out.println();
		
		for (Integer i : lista2) {
			System.out.println("después -> " + i);
		}
		System.out.println();
		
	}

}
