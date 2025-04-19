package ejercicios_streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Random;

public class RunCounter {

	public static void main(String[] args) {

		List<CiudadCounterViernesJavi> ciudades = new ArrayList<>();

		Random random = new Random();

		/*
		CiudadCounterViernesJavi ciudad1 = new CiudadCounterViernesJavi("Ciudad 1");

		for (int i = 0; i < 10_000; i++) {
			ciudad1.addCounter(new CounterViernesJavi(50_000));
		}
		*/

		/*
		 * Crea 10 ciudades, cada una de ellas con un número grande de contadores,
		 * concretamente 10_000 entre y 12_000 contadores cada una (cada una tendrá
		 * distinto número cada una). Puedes suponer que todos los contadores tienen un
		 * valor máximo de 50_000.
		 */

		String[] nombreCiudades = { "Madrid", "Barcelona", "Sevilla", "Vilnius", "Roma", "Granada", "Cádiz", "Kaunas",
				"Palanga", "París" };

		for (String nombreCiudad : nombreCiudades) {

			CiudadCounterViernesJavi ciudad = new CiudadCounterViernesJavi(nombreCiudad);

			for (int i = 0; i < random.nextInt(10_000, 12_001); i++) {
				ciudad.addCounter(new CounterViernesJavi(50_000));
			}
			ciudades.add(ciudad);
		}

		/*
		 * Dale 100 vueltas a los contadores de cada ciudad e incrementalos en un número
		 * aleatorio entre 250 y 1000 pulsos cada uno.
		 */

		for (CiudadCounterViernesJavi ciudad : ciudades) {
			for (int i = 0; i < 100; i++) {
				for (CounterViernesJavi counter : ciudad.getContadores()) {
					counter.increment(random.nextInt(250, 1001));
				}
			}
		}
		
		
		for (int i = 0; i < 10; i++) {
			System.out.println(ciudades.get(3).getContadores().get(i));
		}
		

		// maximo consumo total de contadores
		
		// mínimo para una ciudad
		
		CiudadCounterViernesJavi miCiudad = ciudades.get(0);
		
		Optional<Integer> minimoParaCiudad = miCiudad.getContadores().stream()
			.map(c -> c.getValue())
			// no have falta ponerlo, porque por el defecto sale el orden correcto: 7- 8
//			.sorted((v1, v2) -> v1 - v2)
			.sorted()
//			.sorted(Comparator.reverseOrder())
			.findFirst()
			;
		System.out.printf("Mínimo para la ciudad %s: ", ciudades.get(0).getNombre());
		minimoParaCiudad.ifPresent(System.out::println);

		
		// máximo para una ciudad
				
		Optional<Integer> maximoParaCiudad = miCiudad.getContadores().stream()
			.map(c -> c.getValue())
//			revierte el orden 
//			.sorted((v1, v2) -> - v1 + v2)
			.sorted(Comparator.reverseOrder())
			.findFirst()
			;
		System.out.printf("Máximo para la ciudad %s: ", ciudades.get(0).getNombre());
		maximoParaCiudad.ifPresent(System.out::println);
		
		
		// media para una ciudad
		OptionalDouble mediaParaCiudad = miCiudad.getContadores().stream()
				.mapToInt(c -> c.getValue())
				.average();
		
		System.out.println(miCiudad.getContadores().stream()
				.mapToInt(c -> c.getValue()).summaryStatistics());
		
		System.out.println();
		System.out.println(mediaParaCiudad);
		
		
		// máximo
		OptionalInt maximoParaCiudad2 = miCiudad.getContadores().stream()
			.mapToInt(c -> c.getValue())
			.max()
		;
		System.out.println();
		System.out.println(maximoParaCiudad2);
		
		// mínimo
		OptionalInt minimoParaCiudad2 = miCiudad.getContadores().stream()
				.mapToInt(c -> c.getValue())
				.min()
			;
		System.out.println();
		System.out.println(minimoParaCiudad2.getAsInt());
		
		
		// suma
		int suma = miCiudad.getContadores().stream()
				.mapToInt(c -> c.getValue())
				.sum()
				;
		
		
		// flatMap

	}

}
