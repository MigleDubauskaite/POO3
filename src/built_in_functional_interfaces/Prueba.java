package built_in_functional_interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Prueba {

	public static void main(String[] args) {

		System.out.println("SUPPLIER\n===========\n");

		Supplier<LocalDate> s1 = LocalDate::now;
		System.out.println(s1.get());

		Supplier<StringBuilder> s2 = StringBuilder::new;
		StringBuilder sb = s2.get();
		sb.append("Hola");
		System.out.println(sb);

		Supplier<ArrayList<String>> s3 = ArrayList<String>::new;
		System.out.println(s3.get());

		ArrayList<String> array = s3.get();
		array.add("1");
		array.add("2");
		array.add("3");
		System.out.println(array);

		// otras maneras
		// ArrayList<String> array = new ArrayList<>(Arrays.asList("Elemento 1",
		// "Elemento 2", "Elemento 3"));

		// ArrayList<String> array = (ArrayList<String>) Stream.of("Elemento 1",
		// "Elemento 2", "Elemento 3").toList();

		//////////////////////
		///
		// CONSUMER
		System.out.println("\n\nCONSUMER\n===========\n");

		Consumer<String> c1 = System.out::println;
		c1.accept("Hi!");
		Consumer<String> c2 = c -> System.out.println(c);
		c2.accept("Hola!");

		//////////////////////
		///
		// BICONSUMER
		System.out.println("\n\nBICONSUMER\n===========\n");

		Map<String, Integer> map = new HashMap<>();

		BiConsumer<String, Integer> bc1 = map::put;
		bc1.accept("uno", 1);

		BiConsumer<String, Integer> bc2 = (k, v) -> map.put(k, v);
		bc2.accept("dos", 2);

		System.out.println(map);

		// Usar el BiConsumer para combinar y mostrar las cadenas
		BiConsumer<String, String> combinarYMostrar = (str1, str2) -> System.out.println(str1 + " " + str2);
		combinarYMostrar.accept("Hola", "Mundo");
		combinarYMostrar.accept("Java", "Programming");

		//////////////////////
		///
		// PREDICATE
		System.out.println("\n\nPREDICATE\n===========\n");

		Predicate<String> p1 = p -> p.isEmpty();
		System.out.println("¿es vacío? " + p1.test(""));
		System.out.println("¿es vacío? " + p1.test("Hi!"));

		Predicate<Integer> esMayorQue10 = num -> num > 10;
		System.out.println("¿es mayor que 10? " + esMayorQue10.test(5));
		System.out.println("¿es mayor que 10? " + esMayorQue10.test(12));

		//////////////////////
		///
		// BIPREDICATE
		System.out.println("\n\nBIPREDICATE\n===========\n");

		BiPredicate<String, String> bp1 = String::startsWith;
		System.out.println("¿empieza por...? " + bp1.test("Hola", "Ho"));

		BiPredicate<String, String> bp2 = (t, u) -> t.startsWith(u);
		System.out.println("¿empieza por...? " + bp2.test("Hola", "ol"));

		BiPredicate<String, Integer> longitudMayorQue = (str, num) -> str.length() > num;
        System.out.println(longitudMayorQue.test("Java", 3)); 
        System.out.println(longitudMayorQue.test("Java", 5)); 
        
        
		//////////////////////
		///
		// FUNCTION
		System.out.println("\n\nFUNCTION\n===========\n");
		
		Function<String, Integer> f1 = String::length;
		Function<String, Integer> f2 = s -> s.length();
		
		System.out.println(f1.apply(""));
		System.out.println(f2.apply("Hi!"));
        
		
		//////////////////////
		///
		// BIFUNCTION
		System.out.println("\n\nBIFUNCTION\n===========\n");
		
		BiFunction<String, String, String> bf1 = String::concat;
		System.out.println(bf1.apply("Ho", "la"));
		
		BiFunction<String, String, String> bf2 = (s, t) -> s.concat(t);
		System.out.println(bf2.apply("A", "dios"));
		
		BiFunction<String, String, Integer> bf3 = (s, t) -> s.concat(t).length();
		System.out.println(bf3.apply("A", "dios"));
		
		

		//////////////////////
		///
		// UNARY OPERATOR
		System.out.println("\n\nUNARY OPERATOR\n===========\n");
		
		UnaryOperator<String> uo1 = String::toUpperCase;
		UnaryOperator<String> uo2 = s -> s.toUpperCase();
		uo1.apply("Hola"); // "HOLA"
		uo2.apply("Hi!");   // "HI!"
		
		
		//////////////////////
		///
		// BIUNARY OPERATOR
		System.out.println("\n\nBINARY OPERATOR\n===========\n");
		
		BinaryOperator<String> bo1 = String::concat;
		
		BinaryOperator<String> bo2 = (s, t) -> s.concat(t);
		bo2.apply("Hi!", ""); 
		
		bo2 = (t, u) -> (t.toLowerCase() + " " + u.toLowerCase());
		System.out.println(bo2.apply("HELLO", " WORLD"));

	}

}
