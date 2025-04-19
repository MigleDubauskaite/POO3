package ej_stream_personas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ej_stream_personas.Persona.ColorOjos;
import ej_stream_personas.Persona.Continentes;

public class Test {

	public static void main(String[] args) {

		List<Persona> personas = new ArrayList<>();

		personas.add(new Persona("Gómez", "Pérez", "Ana", 25, 1.68, ColorOjos.marrones, Continentes.EUROPA));
		personas.add(new Persona("López", "García", "Carlos", 30, 1.75, ColorOjos.verdes, Continentes.AMÉRICA));
		personas.add(new Persona("Martínez", "Ruiz", "Lucía", 22, 1.60, ColorOjos.azules, Continentes.EUROPA));
		personas.add(new Persona("Fernández", "Sánchez", "Miguel", 45, 1.80, ColorOjos.negros, Continentes.ASIA));
		personas.add(new Persona("Navarro", "Torres", "Elena", 33, 1.70, ColorOjos.marrones, Continentes.ÁFRICA));
		personas.add(new Persona("Díaz", "Moreno", "Javier", 28, 1.82, ColorOjos.verdes, Continentes.EUROPA));
		personas.add(new Persona("Ramos", "Jiménez", "Sofía", 19, 1.55, ColorOjos.azules, Continentes.OCEANÍA));
		personas.add(new Persona("Romero", "Vega", "Daniel", 38, 1.77, ColorOjos.negros, Continentes.AMÉRICA));
		personas.add(new Persona("Cruz", "Ortega", "Paula", 29, 1.65, ColorOjos.marrones, Continentes.ANTÁRTIDA));
		personas.add(new Persona("Reyes", "Cano", "Laura", 26, 1.73, ColorOjos.verdes, Continentes.EUROPA));
		personas.add(new Persona("Reyes", "Cano", "Laura", 27, 1.73, ColorOjos.verdes, Continentes.EUROPA));

		System.out.println("ORDEN NATURAL\n--------------------------------------\n");
		personas.stream().sorted().forEach(System.out::println);

		System.out.println("\nORDEN NO NATURAL POR EDAD\n--------------------------------------\n");
		personas.stream().sorted((p1, p2) -> p1.getEdad() - p2.getEdad()).forEach(System.out::println);

		System.out.println("\nORDEN NO NATURAL POR EDAD INVERSO\n--------------------------------------\n");
		personas.stream().sorted((p1, p2) -> p2.getEdad() - p1.getEdad()).forEach(System.out::println);

		System.out.println("\nORDEN NO NATURAL POR ESTATURA\n--------------------------------------\n");

		Comparator<Persona> comparatorPorEstatura = (p1, p2) -> p1.getAltura() - p2.getAltura() > 0 ? 1
				: p1.getAltura() - p2.getAltura() < 0 ? -1 : 0;

		personas.stream().sorted(comparatorPorEstatura).forEach(System.out::println);

//    	sorted necesita un int, entonces al tener una propiedad de tipo double da error

//      .sorted((p1, p2) -> p1.getAltura() - p2.getAltura() > 0 ? 1 : p1.getAltura() - p2.getAltura() < 0 ? -1 : 0)

//      .sorted((p1, p2) -> Double.compare(p1.getAltura(), p2.getAltura()))

		System.out.println("\nORDEN NATURAL \n--------------------------------------\n");
		personas.stream()
				// .sorted(Comparator.reverseOrder())
				.forEach(System.out::println);

		System.out.println("\nORDEN POR EDAD INVERSO \n--------------------------------------\n");
//		personas.stream().sorted().forEach(System.out::println);

		System.out.println("\nORDEN ALFABÉTICO INVERSO DE COLOR DE OJOS  \n--------------------------------------\n");

		Comparator<Persona> comparatorPorColorOjos = (p1, p2) -> p1.getColorOjos().toString()
				.compareTo(p2.getColorOjos().toString());
		personas.stream().sorted(comparatorPorColorOjos.reversed()).forEach(System.out::println);

		/*
		 * personas.stream() .sorted((p1, p2) ->
		 * p2.getColorOjos().toString().compareTo(p1.getColorOjos().toString()))
		 * .forEach(System.out::println); ;
		 */

//        no va a ordenar por color de ojos porque el segundo sorted(9 sobreescribe el primero y orden apor el orden natural tirando de compareTo()
		System.out.println();
		personas.stream().sorted((p1, p2) -> p1.getColorOjos().toString().compareTo(p2.getColorOjos().toString()))
//				.sorted(Comparator.reverseOrder()).forEach(System.out::println);
		;

		/////////////////////////////////////////////////////
		System.out.println("\n/////////////////////////////////////////////////////////////////////////");

		System.out.println("MÉTODOS DE STREAM: PRUEBAS");

		System.err.println("\n1.filter()\n  Filtra elementos según una condición predicada.");

		System.out.println("FILTRA PERSONAS MENORES QUE 25 AÑOS");
		personas.stream().filter(t -> t.getEdad() > 25).forEachOrdered(System.out::println);
//		forEach(System.out::println);
		;

		System.out.println("FILTRA PERSONAS QUE TIENEN OJOS MARRONES");
		System.out.println();
		personas.stream().filter(t -> t.getColorOjos().toString() == "marrones").forEach(System.out::println);
//		forEachOrdered(System.out::println);
		;

		System.err.println("\nmap() \nTransforma los elementos usando una función.");

		personas.stream().map(t -> t.getColorOjos().toString()).sorted(Comparator.reverseOrder())
				.forEach(System.out::println);
		;

		System.out.println();

		personas.stream().map(t -> t.getColorOjos()).sorted().forEach(System.out::println);
		;

		System.out.println();
		personas.stream().map(t -> t.getColorOjos()).sorted(Comparator.comparing(Enum::name)) // o .toString()
				.forEach(System.out::println);
		;

		System.out.println();
		personas.stream().map(t -> t.getColorOjos().toString()).sorted() // o .toString()
				.forEach(System.out::println);
		;

		System.err.println("\npeek() \nRealiza una acción en los elementos del Stream sin alterar el Stream.");

		List<String> palabras = List.of("manzana", "naranja", "plátano");

		palabras.stream()
				// Imprime la palabra antes de la transformación
				.peek(p -> System.out.println("Antes de convertir: " + p))
				// Convierte cada palabra a mayúsculas
				.map(String::toUpperCase)
				// Imprime las palabras después de la transformación
				.forEach(System.out::println);

		System.out.println();

		List<Integer> numeros = List.of(1, 2, 3, 4, 5);

		int suma = numeros.stream().peek(n -> System.out.println("Inspectando: " + n)) // Se imprime cada número
				.mapToInt(Integer::intValue).sum();

		System.out.println("Suma total: " + suma);

		System.out.println();

		System.out.println("Suma " + numeros.stream().peek(n -> System.out.println("Inspectando: " + n)) // Se imprime
																											// cada
																											// número
				.mapToInt(Integer::intValue).sum());

		System.out.println();
		System.out.println(personas.stream().mapToInt(b -> b.getEdad()).filter(c -> c > 20)
				.peek(d -> System.out.println("edades: " + d)).sum());

		System.out.println();

		System.err.println(".distinct: \nElimina elementos duplicados del Stream.");
		personas.stream().map(t -> t.getColorOjos().toString()).peek(t -> System.out.println("repetidos: " + t))
				.distinct().forEach(b -> System.out.println("Unicos: " + b + "\n"));
		;

		System.out.println();

		personas.stream().map(t -> t.getColorOjos().toString()).distinct().forEach(System.out::println);
		;

//		dos primeros nombres por orden alfabetico
		System.out.println();
		System.err.println("limit() \nLimita el número de elementos en el Stream.");

		personas.stream().map(n -> n.getNombre()).sorted().limit(2).forEach(System.out::println);
		;

		System.out.println();
		List<String> names = List.of("Ana", "Marta", "Luis", "Mario", "Carlos", "Mónica");

		names.stream().filter(name -> name.startsWith("M")) // Filtra los nombres que empiezan con "M"
				.sorted(Comparator.reverseOrder()).limit(2) // Limita a los primeros 3 elementos filtrados
				.forEach(System.out::println);

		System.out.println();
		System.err.println("flatmap() \n");

		List<String> palabras2 = Arrays.asList("hola", "mundo");

		palabras2.stream().flatMap(t -> Arrays.stream(t.split(""))).forEach(t -> System.out.print(t + "  "));

		System.out.println();
		System.out.println();

		palabras2.stream().map(t -> t.split("")).forEach(a -> System.out.println(Arrays.toString(a)));

		System.out.println();
		System.err.println("\nOPERACIONES TERMINALES \n");

		System.err.println("forEach() \nAplica una acción a cada elemento del Stream. \n");
		personas.stream().sorted().forEach(System.out::println);

		System.err.println(
				"forEachOrdered() \nRealiza una acción sobre los elementos en el orden original del Stream. \n");
		personas.stream().forEachOrdered(System.out::println);

		System.out.println();
		System.err.println("count() \nDevuelve el número de elementos en el Stream. \n");

		System.out.println("Personas totales: " + personas.stream().count());

		System.out.println("Apellidos totales: "
				+ personas.stream().flatMap(t -> Stream.of(t.getApellido1(), t.getApellido2())).count());

		System.out.println();

		System.err.println("reduce() \nAcumula los elementos en un solo valor. \n");

		System.out.printf("Conjunto de todos los primeros apellidos en un solo resultado%n");

		System.out.println(personas.stream().map(b -> b.getApellido1()).reduce(" ", (a, b) -> a + " " + b).trim());

		System.out.println();

		List<String> ingredientes = List.of("Queso", "Tomate", "Orégano", "Jamón");

		String resultado = ingredientes.stream().reduce("Ingredientes:", (a, b) -> a + " - " + b);

		System.out.println(resultado);

		System.out.println();
		System.err.println("findFirst() \nDevuelve el primer elemento del Stream, si está presente.\n");

		List<Integer> numeros2 = List.of(3, 7, 12, 18, 5);

		Optional<Integer> primero = numeros2.stream().filter(n -> n > 10).findFirst();

		primero.ifPresent(System.out::println);
		// Salida: 12

		List<String> nombres = List.of("Ana", "Carlos", "Julia", "Pedro");

		Optional<String> nombreJ = nombres.stream().filter(n -> n.startsWith("J")).findFirst();

		nombreJ.ifPresent(System.out::println);
		// Salida: Julia

		List<String> vacia = List.of();

		Optional<String> resultado2 = vacia.stream().findFirst();

		System.out.println(resultado2.isPresent());
		// Salida: false

		List<String> frutas = List.of("Manzana", "Pera", "Sandía");

		String fruta = frutas.stream().filter(f -> f.startsWith("K")).findFirst().orElse("No encontrada");

		System.out.println(fruta);
		// Salida: No encontrada

		System.out.println();
		System.err.println("findAny()");

		List<String> nombres2 = List.of("Ana", "Luis", "Sofía", "Carlos");

		Optional<String> alguno = nombres2.stream().findAny();

		alguno.ifPresent(System.out::println); // Imprime uno cualquiera

		System.out.println();

		Optional<Persona> personaConApellidoJ = personas.stream().filter(p -> p.getApellido1().startsWith("J")) // condición
																												// dentro
																												// del
																												// stream
				.findAny();

		personaConApellidoJ.ifPresent(System.out::println);

		personaConApellidoJ.ifPresentOrElse(System.out::println,
				() -> System.out.println("No hay ninguna persona con apellido J"));

		System.out.println();
		personas.stream().map(b -> b.getNombre()).filter(b -> b.contains("o")).findAny().ifPresent(System.out::println);

		System.out.println();
		System.err.println("anyMatch()");

		List<String> nombres3 = List.of("Ana", "Carlos", "Lucía", "Pedro");

		boolean hayConO = nombres3.stream().anyMatch(n -> n.contains("o"));

		System.out.println(hayConO); // 👉 true (porque "Carlos" y "Pedro" tienen "o")

		List<Integer> numeros3 = List.of(2, 4, 6, 8, 12, 10);

		boolean hayImpar = numeros3.stream().anyMatch(n -> n % 2 != 0); // Comprobamos si hay algún impar

		System.out.println(hayImpar); // Imprime: true (porque 9 es impar)

		List<String> archivos = List.of("documento1.txt", "informe2.doc", "proyecto3.pdf");

		boolean contieneInforme = archivos.stream().anyMatch(archivo -> archivo.contains("informe"));

		System.out.println(contieneInforme); // Imprime: true (porque "informe2.doc" contiene "informe")

		System.out.println();
		System.err.println("noneMatch()");

		boolean nadieConOjosAzules = personas.stream().noneMatch(p -> p.getColorOjos() == Persona.ColorOjos.azules);

		System.out.println(nadieConOjosAzules);

		List<Integer> numeros4 = List.of(2, 4, 6, 8, 10);

		boolean ningunImpar = numeros4.stream().noneMatch(n -> n % 2 != 0); // Comprobamos si no hay números impares

		System.out.println(ningunImpar); // Imprime: true (porque todos los números son pares)

		System.out.println();
		System.err.println("allMatch()");

		/////////////////////////////////////////////////
		///

		System.out.println();
		System.err.println("toList()");

		System.out.println();
		System.out.println("Con .forEach()");
		personas.stream().map(Persona::getNombre).forEach(System.out::println);
		;

		System.out.println();
		System.out.println("Con .toList()");

		System.out.println(personas.stream().map(Persona::getNombre).toList());

		System.out.println();

//		podemos guardar la lista de persona para utilizarla cuando nos hace falta

//		1. guardamos la lista de nombres de personas
		List<String> nombresPersonas = personas.stream().map(Persona::getNombre).toList();

//		2. La utilizamos después para mostrarla ordenana por ejemplo
		System.out.println("imprimimos la lista de nombres ");
		nombresPersonas.stream().sorted(Comparator.reverseOrder()).forEach(t -> System.out.print(t + " "));
		;

		System.out.println();
		System.out.println();

//		además, se podría realizar otras acciones con esta lista, por ejemplo buscar un nombre en concreto
		if (nombresPersonas.contains("Luis")) {
			System.out.println("Luis está en la lista!!");
		} else {
			System.out.println("Luis no está en la lista...");
		}

		System.out.println();
		System.out.println();

		System.out.println("Lista de personas mayores de 30:");
		List<Persona> mayoresDe30 = personas.stream().filter(p -> p.getEdad() > 30).toList();

		mayoresDe30.stream().forEach(System.out::println);

		System.err.println("toArray()");
		System.out.println();

		List<String> cars = new ArrayList<String>();
		cars.add("Volvo");
		cars.add("BMW");
		cars.add("Ford");
		cars.add("Mazda");

		// Convertir la lista a un array usando .toArray()
		String[] carsArray = cars.stream().toArray(String[]::new);

		// Imprimir el contenido del array de manera legible
		System.out.println(Arrays.toString(carsArray));

		System.out.println();
		System.err.println("collect(Collectors.toMap())");

		System.out.println();

		Map<String, Integer> mapa = personas.stream().collect(
				Collectors.toMap(Persona::getNombre, Persona::getEdad, (edad1, edad2) -> Math.max(edad1, edad2)));

		System.out.println(mapa);

		System.out.println();
		System.err.println("collect()");
		System.out.println();
		System.out.println();

		System.err.println("     toList()");
		List<String> listaDeNombres = personas.stream().map(Persona::getNombre) // Extraemos solo los nombres
				.collect(Collectors.toList()); // Los recolectamos en una lista

		System.out.println(listaDeNombres);

		System.out.println();
		System.err.println("     toSet()");

		Set<String> nombresUnicos = personas.stream().map(Persona::getNombre).collect(Collectors.toSet());

		System.out.println(nombresUnicos);

		System.out.println();
		System.err.println("     toMap()");

		Map<String, Integer> mapa2 = personas.stream()
				.collect(Collectors.toMap(Persona::getNombre, Persona::getEdad, (t, u) -> Math.max(t, u)));

		System.out.println(mapa2);

		System.out.println();
		System.err.println("     joining()");

		String nombresConcatenados = personas.stream().map(Persona::getNombre).collect(Collectors.joining(", "));
		System.out.println(nombresConcatenados);

		System.out.println();
		System.err.println("     groupingBy()");

		Map<Integer, List<Persona>> porEdad = personas.stream().collect(Collectors.groupingBy(Persona::getEdad));

		for (Map.Entry<Integer, List<Persona>> entry : porEdad.entrySet()) {
			System.out.print("Edad: " + entry.getKey());
			for (Persona p : entry.getValue()) {
				System.out.println(" - " + p); // asegúrate de tener toString() bien definido en Persona
			}
		}

		System.out.println();
		System.err.println("     summarizingInt()");

		IntSummaryStatistics stats = personas.stream().collect(Collectors.summarizingInt(Persona::getEdad));

		System.out.println(stats);

		System.out.println();
		System.err.println("mapToInt()");

		List<String> lista = List.of("10", "20", "30");

		int suma2 = lista.stream().mapToInt(s -> Integer.parseInt(s)) // con lambda
				.sum();

		System.out.println(suma2);

		System.out.println();
		System.out.println(personas.stream().mapToInt(Persona::getEdad).sum());

		System.out.println();

		Stream<String> stream = Stream.of("1", "2", "3");
		int suma3 = stream.mapToInt(Integer::parseInt).sum();
		System.out.println(suma3);

	}

}
