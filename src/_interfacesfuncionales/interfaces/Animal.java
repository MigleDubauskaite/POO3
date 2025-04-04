package _interfacesfuncionales.interfaces;

public abstract class Animal extends Object implements Desplazable {
	// no hace falta poner extends Object
	
	public void respirar() {
		System.out.println(this.getClass().getSimpleName() + " respirando");
	}


	
	

}
