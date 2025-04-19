package contenidos_3_evaluacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PrincipiosDeStream {

	public static void main(String[] args) {

		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(3);
		lista.add(3);
		lista.add(7);
		lista.add(4);
		
		// .stream convierte a Stream
		Stream<Integer> miPrimerStream = lista.stream();
		
		// a un void no podemos poner metodos (.) y forEach devuelve un void
		// sin embargo limit devuelve un String entonces se puede concatenar los metodos
		// filter es un Predicate
		miPrimerStream
		.filter(s -> s > 2)    // operacion intermedia
		.distinct()				// se relaciona con equals()  &&   operacion intermedia
		.sorted()				// operacion intermedia
		.limit(2)				// operacion intermedia
		.peek(System.out::println)				// hace funcion Consumer pero los elementos se qeudan allí &&   operacion intermedia
		.map(n -> n * 100)  			// es una Function    &&   operacion intermedia
		.forEach(System.out::println);    // operación final
		
		
		System.out.println();
		System.out.println();
		List<Integer> lista2 = new ArrayList<>();
		lista2.add(1);
		lista2.add(3);
		lista2.add(3);
		lista2.add(7);
		lista2.add(4);
		
		lista2.stream()		
		.filter(s -> s > 2)    // operacion intermedia
		.sorted()				// operacion intermedia
		.distinct()	
		.limit(2)				// operacion intermedia
		.forEach(System.out::println);    // operación final
		
		
	}

}
