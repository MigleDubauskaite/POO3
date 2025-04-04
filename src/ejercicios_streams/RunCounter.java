package ejercicios_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RunCounter {

	public static void main(String[] args) {

		List<CiudadCounterViernesJavi> ciudades = new ArrayList<>();

		Random random = new Random();

		CiudadCounterViernesJavi ciudad1 = new CiudadCounterViernesJavi("Ciudad 1");

		for (int i = 0; i < 10_000; i++) {
			ciudad1.addCounter(new CounterViernesJavi(50_000));
		}

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
		
		// flatMap

	}

}
