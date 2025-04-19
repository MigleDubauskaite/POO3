package ej_stream_personas;

import java.util.Objects;

public class Persona implements Comparable<Persona> {

	private String apellido1;
	private String apellido2;
	private String nombre;
	private int edad;
	private double altura;

	private ColorOjos colorOjos;
	private Continentes continente;

	public enum ColorOjos {
		marrones, verdes, azules, negros
	}

	public enum Continentes {
		EUROPA, ASIA, ÁFRICA, OCEANÍA, ANTÁRTIDA, AMÉRICA;
	}

	public int getEdad() {
		return edad;
	}

	public String getApellido1() {
		return apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public String getNombre() {
		return nombre;
	}

	public double getAltura() {
		return altura;
	}

	public ColorOjos getColorOjos() {
		return colorOjos;
	}

	public Continentes getContinente() {
		return continente;
	}

	public Persona(String apellido1, String apellido2, String nombre, int edad, double altura, ColorOjos colorOjos,
			Continentes continentes) {
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nombre = nombre;
		this.edad = edad;
		this.altura = altura;
		this.colorOjos = colorOjos;
		this.continente = continentes;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s (%d años) de %s mide %.2f cm con ojos %s %n", nombre, apellido1,
				apellido2, edad, continente.toString().toLowerCase(), altura, colorOjos);
	}

	
	@Override
	public int compareTo(Persona o) {
		
//		ORDENANDO SEGÚN

//		comparamos apellido (this -> el mio) con otro apellido
		
//		NOMBRE
		if (nombre.compareTo(o.nombre) != 0)
			return nombre.compareTo(o.nombre);
		
//		APELLIDO 1
		if (apellido1.compareTo(o.apellido1) != 0)
			return apellido1.compareTo(o.apellido1);

//		APELLIDO 2
		if (apellido2.compareTo(o.apellido2) != 0)
			return apellido2.compareTo(o.apellido2);


//		EDAD
		if (edad - o.edad != 0)
			return edad - o.edad;
		
//		ALTURA
		if(altura != o.altura)
			return altura - o.altura > 0 ? 1 : altura - o.altura < 0 ? -1 : 0;
			
			/*

//		COLOR OJO
		if(colorOjos.toString().compareTo(o.colorOjos.toString()) != 0)
			return colorOjos.toString().compareTo(o.colorOjos.toString());
			*/
			
		return 0;
	}
	

	

}
