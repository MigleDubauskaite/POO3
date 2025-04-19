package ej_stream_personas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMapExamples {
	public static void main(String[] args) {
		
		// Ejemplo 1: Aplanar una lista de listas
		
		List<List<Integer>> listOfLists = Arrays.asList(
				Arrays.asList(1, 2, 3), 
				Arrays.asList(4, 5, 6),
				Arrays.asList(7, 8, 9)
				);

		System.out.println("Ejemplo 1: Aplanar una lista de listas");
		// Sin flatMap (incorrecto - obtendríamos un Stream<List<Integer>>)
		
		listOfLists.stream()
			.map(list -> list)	
//			en este caso no haría falta poner .map(), lo ponemos para ver la diferencia con él flatMap()
			.forEach(list -> System.out.print(list + " "));
		
		System.out.println();

		// Con flatMap (correcto - obtenemos un Stream<Integer>)
		listOfLists.stream()
			.flatMap(list -> list.stream())
			.forEach(n -> System.out.print(n + " "));
		
		System.out.println("\n");

		
		// Ejemplo 2: Trabajar con arrays de cadenas de texto
		
		String[] arrayOfWords = { "Hola mundo", "Java Stream", "flatMap ejemplo" };

		System.out.println("Ejemplo 2: Dividir y aplanar palabras");
		
		Arrays.stream(arrayOfWords).map(str -> str.split(" ")) // Devuelve Stream<String[]>
				.flatMap(Arrays::stream) // Aplana a Stream<String>
				.forEach(word -> System.out.print(word + " "));
		System.out.println("\n");

		
		// Ejemplo 3: Obtener caracteres únicos de una lista de palabras
		
		List<String> words = Arrays.asList("Hola", "Java", "Stream");

		System.out.println("Ejemplo 3: Caracteres únicos de una lista de palabras");
		
		words.stream()
			.flatMap(word -> word.chars().mapToObj(c -> (char) c))
			.distinct()
			.sorted()
			.forEach(c -> System.out.print(c + " "));
		
		System.out.println("\n");

		
		// Ejemplo 4: Operaciones matemáticas - generar pares de números
		
		List<Integer> lista1 = Arrays.asList(1, 2, 3);
		List<Integer> lista2 = Arrays.asList(4, 5);

		System.out.println("Ejemplo 4: Generar todos los pares posibles de dos listas");
		
		lista1.stream()
			.flatMap(i -> lista2.stream()
			.map(j -> "(" + i + "," + j + ")"))
			.forEach(pair -> System.out.print(pair + " "));
		
		
		System.out.println("\n");

		// Ejemplo 5: Manejo de valores Optional con flatMap
		System.out.println("Ejemplo 5: Trabajar con Optional");
		Stream<String> streamWithNulls = Stream.of("a", null, "b", null, "c");

		streamWithNulls.flatMap(s -> s == null ? Stream.empty() : Stream.of(s)).forEach(s -> System.out.print(s + " "));
	}
}