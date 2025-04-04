package _interfacesfuncionales.interfaces;

public abstract class Vehiculo implements Desplazable{
	// no hace falta poner extends Object
	
	// implementamos el metodo de clase interfaz en la clase padre y así los hijos lo heredan, sin necesidad de implementarlo en cada uno de hijos
	@Override
	public String mover(int tiempoEnSegundos) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
