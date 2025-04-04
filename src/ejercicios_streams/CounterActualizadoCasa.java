package ejercicios_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class CounterActualizadoCasa {
	
	private int value;
    private int maxValue = 120;
    private String model = "N-COUNTER";
    private static String CounterEnEsperanto = "ohmmmm";
    private static int contadoresCreados;
    private static int totalCounters = 0; //Ir contando la cantidad de Counters (instancias) que se vayan creando
    
    public CounterActualizadoCasa() {
        contadoresCreados++;
    }

    public CounterActualizadoCasa(int maxValue) {
        this.maxValue = maxValue < 10? 10: maxValue;
        contadoresCreados++;
    }
     
    public CounterActualizadoCasa(int maxValue, String model) {
        this.maxValue = maxValue < 10? 10: maxValue;
        this.model = model;
        contadoresCreados++;
    }
    
    public CounterActualizadoCasa (CounterActualizadoCasa c){
        this.maxValue = c.maxValue;
        this.model = c.model;
        contadoresCreados++;
    }
    
    public boolean increment (){
        return increment(1);
          
    }
    public boolean increment(int n ){
        if(value + n <= maxValue){
            value+= n;
            return true;
        }else{
            value= maxValue;
             return false;
        }
           
    }
     public boolean reset(){
        if(maxValue == value){
            value = 0;
            return true;
        } else {
            return false;
        }
    }   
    
    
    @Override
	public String toString() {
		return String.format("Contador (%d/%d) modelo %s. Posicion:%d.", value, maxValue, model, contadoresCreados);
	}

    public int getMaxValue (){
        return maxValue;
    }
   
    
    public static void main(String[] args) {

        CounterActualizadoCasa c1 = new CounterActualizadoCasa ();
        CounterActualizadoCasa c2 = new CounterActualizadoCasa (100);
        CounterActualizadoCasa c3 = new CounterActualizadoCasa (100, "Model-ONE");
        CounterActualizadoCasa c4 = new CounterActualizadoCasa(c3);
        CounterActualizadoCasa c5 = new CounterActualizadoCasa();
        
        // creamos instancias con Supplier
        Supplier<CounterActualizadoCasa> contadorSupplier = CounterActualizadoCasa::new;
        CounterActualizadoCasa p1 = contadorSupplier.get();
        CounterActualizadoCasa p2 = contadorSupplier.get();
        
        // mostramos en esperanto
        System.out.println("\nMOSTRAR EN ESPERANTO");
        Consumer<CounterActualizadoCasa> mostrarEnEsperanto = counter -> System.out.printf("%s (%d/%d) modelo %s%n", 
        		CounterActualizadoCasa.CounterEnEsperanto, counter.value, counter.getMaxValue(), counter.model);
        
        mostrarEnEsperanto.accept(p1);
        mostrarEnEsperanto.accept(p2);
        mostrarEnEsperanto.accept(c1);
        
        
        System.out.println("\nIMPRIMIMOS LOS COUNTERS CREADOS\n");
        
        List<CounterActualizadoCasa> counters = new ArrayList<CounterActualizadoCasa>(Arrays.asList(c1, c2, c3, c4, c5));
        counters.forEach(System.out::println);
      
        
        System.out.println("\n\nPROBANDO INCREMENTOS");
        
        // en C1
        counters.stream()
        .filter(c -> c == c1)
        .forEach(c -> {
        	c.increment();
        	System.out.println(c);
        });
        ;
        
        // en C2 y incrementar 10 veces
        System.out.println("\nAntes: " + c2);
        counters.stream()
        .filter(c -> c == c2)
        .forEach(c -> IntStream.range(0, 10).forEach(i -> c.increment()));
        ;
        System.out.println("Después: " + c2);
        
        
        System.out.println("\n \nPROBADNO INCREMENT N VECES");
        
        BiConsumer<CounterActualizadoCasa, Integer> incrementarNVeces = (counter, n) -> IntStream.range(0, n).forEach(i -> counter.increment());
        incrementarNVeces.accept(c5, 5);
        incrementarNVeces.accept(c4, 60);
        System.out.println(c5);
        System.out.println("\nAntes: " + c4);
        incrementarNVeces.accept(c4, 50);
        System.out.println("Después: " + c4);
        
        counters.stream()
        ;
        
        // verificamos si el contador está lleno
        System.out.println("\n\nVERIFICAMOS SI EL COUNTER ESTÁ LLENO");
        Predicate<CounterActualizadoCasa> counterEstaLleno = c -> c.value >= c.maxValue;
        System.out.println("¿Está lleno c5? " + counterEstaLleno.test(c5));
        System.out.println("¿Está lleno c4? " + counterEstaLleno.test(c4));
        
       
        /*
        System.out.println("Probando incrementos -n");
        System.out.println(c2);
        System.out.println(c2.increment(50));
        System.out.println(c2);
        System.out.println(c2.increment(40));
        System.out.println(c2);
        System.out.println(c2.increment(20));
        
        System.out.println();
        
        System.out.println("Probando un reset ()");
        System.out.println(c2);
        System.out.println(c2.reset());
        System.out.println(c2);
        System.out.println(c4);
        System.out.println(c2.reset());
        System.out.println(c4);
        
        System.out.println();
        System.out.println("Instancias que se van creando: (total counters)");
       
        //Idealmente preguntarle a la clase porque totalCounters es una propiedad de la clase
        System.out.println(Counter_Actualizado.totalCounters);
        //También se le puede preguntar a la instancia, pero no es lo ideal 
        System.out.println(c1.totalCounters);
        
        */
        
    }
    
    

}
