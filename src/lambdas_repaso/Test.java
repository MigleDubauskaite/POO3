package lambdas_repaso;

import java.util.Arrays;

public class Test {
	
	private static int[] opera2Arrays(int[]array1, int[] array2, EntranDosEnterosSaleEntero funcion) {
		
		// si ambos arrays son de mismo tamaño
		int[] arrayResultado = new int[array1.length];
		
		// recorrería el más grande, en caso que no son de mismo tamaño...
		
		for (int i = 0; i < arrayResultado.length; i++) {
			arrayResultado[i] = funcion.opera(array1[i], array2[i]);
		}
		
		return arrayResultado;
	}
	
	public static void main(String[] args) {
		
		// el nombre de la definición en IF no necesita ser iguales aquí al instanciarlos. 
		
		EntranDosEnterosSaleEntero suma = (int i1, int b) -> {return i1 + b;} ;
		
		// no es necesario definir el tipo de dato, porque lo tenemos definido en IF
		EntranDosEnterosSaleEntero resta = (a, b) -> a - b;
		
		System.out.println(suma.opera(2, 1));
		System.out.println(resta.opera(2, 1));
		
		// stack      heap
		// la suma      apunta al objeto 
		// la resta     apunta al otro objeto, que al dar valores resta 

		
		int[] resultado = opera2Arrays(
				new int[] {2, 3, 4}, 
				new int[] {2, 3, 4}, 
				suma
				//(a, b) -> a + b
				);
		 
		
		System.out.println(Arrays.toString(resultado));
		
		
		
	}

}
