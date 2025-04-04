package optional;

import java.util.Optional;
import java.util.Random;

public class TestOptional {

	// EJERCICIO
	// EJEMPLO ILUSTRATIVO DE OPTIONAL
	// GENERAR LA MEDIA

	/*
	 * - Si no hay datos: no tengo valor de media y devuelve Optional vacío - Si
	 * tengo datos: si tengo valor de media y devuelve Optional con la media dentro
	 */

	private static Optional<Double> media(Integer[] numeros) {
		
		// si no hay datos o es nulo
		// el orden está mal hecho: numeros.length == 0 || numeros == null ----- es incorrecto
		if (numeros == null || numeros.length == 0) {
			// primero se mira si es nulo: .....
			// y luego si es igual a 0: .......
			return Optional.empty();
		}
		
		// Calculamos la suma
		
		Integer suma = 0;
		int contador = 0;
		
		for (Integer numero : numeros) {
			if (numero != null) {
				contador++;
				suma += numero;
			}
		}

		// Retornamos la media
		// multiplicamos por 1. para que nos devuelva un double
		// dividimos entre el contador para que divida solo de los numeros no nulos
		return contador == 0 ? Optional.empty() : Optional.of(1. * suma / contador);
	}

	public static void main(String[] args) {

		// construyendo un optional y asignando null

		// no se puede así, porque salta error
		// Optional<Integer> opt1 = Optional.of(null);

		// habría que utilziar ofNullable
		Optional<Integer> opt1 = Optional.ofNullable(null);

		// construyendo un optional y asignando un 4
		Optional<Integer> opt1_1 = Optional.of(4);

		// generar uno vacío
		Optional<Integer> opt2 = Optional.empty();

		Optional<Integer> opt3 = Optional.ofNullable(null);

		// lo imprimimos
		// con un get se puede extraer el contenido

		System.out.println(opt1);

		System.out.println();
		System.out.println(opt1_1);
		System.out.println(opt1_1.get());

		// findFirst()
		System.out.println(opt1.stream().findFirst());

		System.out.println();
		System.out.println(opt2.isEmpty());
		System.out.println(opt2.isPresent());

		System.out.println();
		System.out.println(opt3.isEmpty() ? "presente" : "vacío");
		System.out.println(opt3.isPresent() ? "presente" : "vacío");
		System.out.println();

		// imprimirlo con IF - Consumer
		// lo imprime si la instancia no está vacía
		opt1_1.ifPresent(System.out::println);

		// si es un null no podemos utilizar get()
		// System.out.println(opt2.get());

		// sino que utilizamos orElse()
		// en caso que dentro es un null me devuelves un 0
		System.out.println(opt2.orElse(0));

		// si no es null me va a imprimir el número
		System.out.println(opt1_1.orElse(0));

		// una vez creado el Optional es un inmutable

		// orElseGet()
		System.out.println();
		// me da el generador Random - oviamente podemos hacer cualquier método que
		// genere datos
		System.out.println(opt2.orElseGet(() -> {
			Random r = new Random();
			return r.nextInt();
		}));

		// Comprobamos el método con los siguientes datos
		// {1, 3, 5}
		// {null, null, null}
		// {1, null, 3, 5}
		// {}
		// null
		
		// {1, 3, 5}
		System.out.print(":");
		media(new Integer[] {1, 3, 5}).ifPresent(System.out::println);
		
		// {null, null, null}
		System.out.println(":");
		media(new Integer[] {null, null, null}).ifPresent(System.out::println);
		
		// {1, null, 3, 5}
		System.out.print(":");
		media(new Integer[] {1, null, 3, 5}).ifPresent(System.out::println);
		
		// {}
		System.out.println(":");
		media(new Integer[] {}).ifPresent(System.out::println);
		
		// null
		System.out.println(":");
		media(null).ifPresent(System.out::println);
		
		

	}

}
