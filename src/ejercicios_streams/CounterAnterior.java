package ejercicios_streams;

public class CounterAnterior {
	
	private int value;
    private int maxValue = 120;
    private String model = "N-COUNTER";
    private static String CounterEnEsperanto = "ohmmmm";
    private static int contadoresCreados;
    private static int totalCounters = 0; //Ir contando la cantidad de Counters (instancias) que se vayan creando
    
    public CounterAnterior() {
        contadoresCreados++;
    }

    public CounterAnterior(int maxValue) {
        this.maxValue = maxValue < 10? 10: maxValue;
        contadoresCreados++;
    }
     
    public CounterAnterior(int maxValue, String model) {
        this.maxValue = maxValue < 10? 10: maxValue;
        this.model = model;
        contadoresCreados++;
    }
    
    public CounterAnterior (CounterAnterior c){
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
		return String.format("Contador (%d/%d) modelo %s. Posicion:%d.%n", value, maxValue, model, contadoresCreados);
	}

	//Getter y setter
    public int getMaxValue (){
        return maxValue;
    }
    
    public void showEnEsperanto (){
         System.out.printf("%s (%d/%d) modelo %s%n", 
                 CounterAnterior.CounterEnEsperanto, this.value, this.maxValue, this.model);
         //ponemos Counter.CounterEnEspanto para hacer referencia a que es una propiedad static de Counter
         //podríamos poner this porque al final forma parte del objeto/instancia pero es más correcto poner Counter
    }
    
    public String comoSeDiceShowEnEsperanto (){
        //ponemos estatico porque le tenemos que preguntar a la propiedad de la clase static
       // Los objetos saben por la información static de la clase por eso podemos quitar el static aqui
        return CounterEnEsperanto;
        
    }
    
    
    
    public static void main(String[] args) {
	       
        //Probando constructores
        CounterAnterior c1 = new CounterAnterior ();
        CounterAnterior c2 = new CounterAnterior (100);
        CounterAnterior c3 = new CounterAnterior (100, "Model-ONE");
        CounterAnterior c4 = new CounterAnterior(c3);
        CounterAnterior c5 = new CounterAnterior();
        
       
        
        //Array de counters diversos
        CounterAnterior [] counters = {c1, c2, c3, c4};
        
        //Mostrar counters
        for (CounterAnterior counter : counters) {
            System.out.println(counter);
        }
        
        /*c1.show();
        c2.show();
        c3.show();
        c4.show();*/
        
        
        //Probando increment()
        System.out.println();
        System.out.println("Probando incrementos c1");
        
        System.out.println(c1); //Aquí es como inicia
        
        for (int i = 0; i < 10; i++) {
            System.out.println(c1.increment());
        }
        
        System.out.println(c1.increment()); //Con esto se verifica si devuelve true
        System.out.println(c1);
        
        System.out.println();
        System.out.println("Probando incrementos c2");
        
        System.out.println(c2);
        
        System.out.println(c2.increment());
        
        System.out.println(c2);
        
        System.out.println();

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
        System.out.println(CounterAnterior.totalCounters);
        //También se le puede preguntar a la instancia, pero no es lo ideal 
        System.out.println(c1.totalCounters);
    }
    

}
