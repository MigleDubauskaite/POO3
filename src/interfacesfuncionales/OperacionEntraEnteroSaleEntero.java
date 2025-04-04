package interfacesfuncionales;

@FunctionalInterface
//es como override 
public interface OperacionEntraEnteroSaleEntero {
	//delante vendría public abstract
	int dale(int i);
	//se puede llamar igual porque no tiene parámetros
	//se queja porque solo puede tener un método la interface funcional
	//int m();
	
	// INETRFACES FUNCIONALES SOLO PUEDE TENER UN METODO
}
