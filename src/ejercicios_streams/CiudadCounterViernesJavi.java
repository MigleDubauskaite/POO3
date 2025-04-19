package ejercicios_streams;

import java.util.ArrayList;
import java.util.List;

public class CiudadCounterViernesJavi {

	private List<CounterViernesJavi> contadores;
	private String nombre;

	public CiudadCounterViernesJavi(String nombre) {
		this.nombre = nombre;
		contadores = new ArrayList<>();
	}

	public void addCounter(CounterViernesJavi counter) {
		contadores.add(counter);
	}

	public List<CounterViernesJavi> getContadores() {
		return contadores;
	}

	public String getNombre() {
		return nombre;
	}
	
}
