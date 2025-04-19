package comparacion;

import java.util.ArrayList;
import java.util.List;

public class A implements Comparable<A> {
	
//	Comparable es un interfaz que es generico
	
//	Por defecto, el orden no está establecido
	
	public String s;

	public A(String s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return "A [s=" + s + "]";
	}

//	Método del interfaz Comparable
	
	@Override
	public int compareTo(A a) {
//		comparo el objeto actual con otro objeto
		
//		orden normal: de menor a mayor -> por ejemplo por orden alfabetico 
		return this.s.compareTo(a.s);
		
//		orden inverso: de mayor a menor
//		return a.s.compareTo(this.s);
		
//		orden por número de caracteres: de menor a mayor
//		return this.s.length() - a.s.length();
		
//		orden por número de caracteres: de mayor a menor
//		return a.s.length() - this.s.length();
//		o
//		return -this.s.length() + a.s.length();
		
	}
	
	public static void main(String[] args) {
		List<A> lista = new ArrayList<>();
		
		lista.add(new A("one"));
		lista.add(new A("two"));
		lista.add(new A("three"));
		lista.add(new A("four"));
		
		lista.stream()
		
//		.sorted() es un Comparator
//			no ordena porque no tiene ningún criterio, sino deja el orden tal cual que hemos establecido nosotros
//			.sorted((a1, a2) -> 0)
		
//			ahora si que ordena según le indicamos, a pesar que tenemos un metodo de interfaz Comparable<>
			.sorted((a1, a2) -> - a1.s.length() + a2.s.length())
			.forEach(System.out::println);
		;
		
		
		
	
	}
	
	
	

}
