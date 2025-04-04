package repaso_simplificacion_lambdas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimplificacionLambdas {
	
	public static void main(String[] args) {
		
		/* 01 */ 
		//(int s) -> { return s + 1; }
		EntraIntSaleInt primero = s -> s + 1; 
		
		
		/* 02 */ 
		//(int x, int y) -> { return x + y; }
		EntranDosIntSaleInt segundo = (x, y) -> x + y; 
		
		//(String x, String y) -> x + y;
		// si lo hacemos + con los Strings sería una concatación
		
		
		/* 03 */ 
		//() -> { System.out.println("Hola Mundo"); }
		SinParametrosSaleString tercero = () -> System.out.println("Hola mundo");
		
		
		/* 04 */ 
		//(String s) -> { return s.isEmpty(); }
		EntraStringSaleBoolean cuarto = s -> s.isEmpty();
		
		
		/* 05 */ 
		//(double d) -> { return d * 2.0; }
		EntraDoubleSaleDouble quinto = d -> d * 2.0; 
		
		
		/* 06 */ 
		//(int a, int b) -> { System.out.println(a - b); }
		EntranDosIntSaleInt sexto = (a, b) -> a - b;
		
		
		/* 07 */ 
		//(String s1, String s2) -> { return s1.equals(s2); }
		EntraDosStringSaleBoolean septimo = (s1, s2) -> s1.equals(s2);
		
		
		/* 08 */ 
		//() -> 42
		SinParametrosSaleInt octavo = () -> 42;
		
		/* 09 */ 
		//(List<String> list) -> { return list.size(); }
		EntraListaDeStringSaleLista noveno = list -> list.size();
		List<String> lista = new ArrayList<String>();
		lista.add("hello");
		
		
		/* 10 */ 
		//(Map<String, Integer> map) -> { return map.isEmpty(); }
		EntraMapaDeStringYIntegerSaleBoolean decimo = map -> map.isEmpty();
		
		// DECLARACIÓN DE MAP
		// MAP.OF -> Si no necesitas modificar el Map después de crearlo, Map.of() es la opción más sencilla:
		Map<String, Integer> mapa = Map.of(
				"Migle", 1,
				"Lola", 2,
				"Carolina", 3,
				"Angie", 4);
		
		// MAP.OF ENTRIES()  -> Si quieres inicializar un Map con muchos valores de forma más ordenada
		Map<String, Integer> mapa2 = Map.ofEntries(
				Map.entry("Migle", 1),
				Map.entry("Lola", 2)
				);

		// HASH MAP   -> Si necesitas modificar el Map después de crearlo, usa HashMap
		Map<String, Integer> mapa3 = new HashMap<>();
		mapa3.put("Migle", 1);
		mapa3.put("Lola", 1);
		
		// STREAM.OF() -> Si prefieres un código más funcional
		Map<String, Integer> mapa4 = Stream.of(
			    new Object[][] { {"Lola", 25}, {"Migle", 30}, {"Ana", 28} }
			).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));
		
		
		
		/* 11 */ 
		//(char c) -> { return Character.isDigit(c); }
		EntraCharSaleBoolean decimoPrimero = c -> Character.isDigit(c);
				
				
		/* 12 */ 
		//(String str) -> str.toUpperCase()
		EntraStringSaleString decimoSegundo = str -> str.toUpperCase();
		
		
		/* 13 */ 
		//(String str) -> { return new StringBuilder(str).reverse().toString(); }
		EntraStringSaleStringBuilder decimoTercero = str -> new StringBuilder(str).reverse();
		
		// String Builder se usa para manipular cadenas de texto de manera más eficiente que String, especialmente cuando se hacen muchas modificaciones.
		StringBuilder texto = decimoTercero.opera("Hola");
		
		
		/* 14 */ 
		//(boolean b) -> { return !b; }
		EntraBooleanSaleBoolean decimoCuarto = b -> !b;
		
		
		// /* 15
		//(String s, int n) -> { return s.substring(0, n); }
		EntraStringYIntSaleString decimoQuinto = (s, n) -> s.substring(0, n); 
		
		
		// 16 
		// (int n, double d) -> { return Math.pow(n, d); }
		EntraIntYDoubleSaleDouble decimoSexto = (n, d) -> Math.pow(n, d); 
		
	
		System.out.println("1");
		System.out.println(primero.opera(3));
		System.out.println();
		
		System.out.println("2");
		System.out.println(segundo.opera(3, 5));
		System.out.println();
		
		System.out.println("3");
		tercero.opera();
		System.out.println();
		
		System.out.println("4");
		System.out.println(cuarto.opera(""));
		System.out.println();
		
		System.out.println("5");
		System.out.println(quinto.opera(3.4));
		System.out.println();
		
		System.out.println("6");
		System.out.println(sexto.opera(10, 2));
		System.out.println();
		
		System.out.println("7");
		System.out.println(septimo.opera("Migle", "migle"));
		System.out.println();
		
		System.out.println("8");
		System.out.println(octavo.opera());
		System.out.println();
		
		System.out.println("9");
		System.out.println(noveno.opera(lista));
		System.out.println();
		
		System.out.println("10");
		System.out.println(decimo.opera(mapa));
		System.out.println();
		
		System.out.println("11");
		System.out.println(decimoPrimero.opera('1'));
		System.out.println();
		
		System.out.println("12");
		System.out.println(decimoSegundo.opera("Hola"));
		System.out.println();
		
		System.out.println("13");
		System.out.println(texto);
		System.out.println();
		
		System.out.println("14");
		System.out.println(decimoCuarto.opera(false));
		System.out.println();
		
		System.out.println("15");
		System.out.println(decimoQuinto.opera("Hello", 2));
		System.out.println();
		
		System.out.println("16");
		System.out.println(decimoSexto.opera(2, 2.2));
		System.out.println();
		
	}
	

}
