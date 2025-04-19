package comparacion;

import java.util.ArrayList;
import java.util.List;

public class B {
	
//	Comparable es un interfaz que es generico
	
//	Por defecto, el orden no está establecido
	
	public String b;

	public B(String b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "B [b=" + b + "]";
	}
	
	public static void main(String[] args) {
		List<B> lista = new ArrayList<>();
		
		lista.add(new B("one"));
		lista.add(new B("two"));
		lista.add(new B("three"));
		lista.add(new B("four"));
		
		lista.stream()
		
//		.sorted() es un Comparator
//			no ordena porque no tiene ningún criterio, sino deja el orden tal cual que hemos establecido nosotros
//			.sorted((a1, a2) -> 0)
		
//			ahora si que ordena según le indicamos, a pesar que tenemos un metodo de interfaz Comparable<>
			.sorted((a1, a2) -> - a1.b.length() + a2.b.length())
			.forEach(System.out::println);
		;
		
		System.out.println();
		lista.stream()
			.sorted()
			.forEach(System.out::println);
		;
		
	}
	
	
	

}
