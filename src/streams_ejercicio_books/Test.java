package streams_ejercicio_books;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
	
	// ****
	// tener cuidado con el equals y distinct
	// diferentes instancias diferentes objetos
	
	public static void main(String[] args) {
		
		// lista de libros con autores
		
		Author miguelCervantes = new Author("Miguel", "de Cervantes", 56, Gender.MALE);
        Author gabrielGarciaMarquez = new Author("Gabriel", "García Márquez", 87, Gender.MALE);
        Author jorgeLuisBorges = new Author("Jorge", "Luis Borges", 86, Gender.MALE);
        Author marioVargasLlosa = new Author("Mario", "Vargas Llosa", 88, Gender.MALE);
        Author isabelAllende = new Author("Isabel", "Allende", 72, Gender.FEMALE);
        Author juliaNavarro = new Author("Julia", "Navarro", 60, Gender.FEMALE);
        Author carmenPosadas = new Author("Carmen", "Posadas", 67, Gender.FEMALE);
        Author lauraEsquivel = new Author("Laura", "Esquivel", 70, Gender.FEMALE);

        // Crear un ArrayList de libros
        List<Book> library = new ArrayList<>();

        // Agregar 20 libros al ArrayList con los autores
        library.add(new Book("Don Quijote de la Mancha", miguelCervantes));
        library.add(new Book("Cien años de soledad", gabrielGarciaMarquez));
        library.add(new Book("Ficciones", jorgeLuisBorges));
        library.add(new Book("La fiesta ajena", marioVargasLlosa));
        library.add(new Book("La casa de los espíritus", isabelAllende));
        
        library.add(new Book("El amante japonés", isabelAllende));
        library.add(new Book("La chica del tren", juliaNavarro));
        library.add(new Book("Las uvas de la ira", marioVargasLlosa));
        library.add(new Book("El código Da Vinci", gabrielGarciaMarquez));
        library.add(new Book("La sombra de los otros", juliaNavarro));
        
        library.add(new Book("El secreto", carmenPosadas));
        library.add(new Book("La lluvia en los zapatos", carmenPosadas));
        library.add(new Book("Esquivel", lauraEsquivel));
        library.add(new Book("El jardín de los finzi-Contini", jorgeLuisBorges));
        library.add(new Book("El alquimista", marioVargasLlosa));
        
        library.add(new Book("Como agua para chocolate", lauraEsquivel));
        library.add(new Book("Los pilares de la tierra", gabrielGarciaMarquez));
        library.add(new Book("Poesía completa", jorgeLuisBorges));
        library.add(new Book("El otoño del patriarca", gabrielGarciaMarquez));

        
        // declaro como mi intencion y se guarda sin hacer nada, y con última acción empezaría a funcionar stream
        
        Stream<Book> miStream = library.stream();
        
        // manera entera
        //miStream.map((Book b) -> {return b.getAuthor();});
        
        System.err.println("imprimir la lista de autores");
        miStream
        	.map(b -> b.getAuthor())
        	.distinct()
        	.forEach(System.out::println);
        
        System.out.println();
        
        System.err.println("\nimprimir la lista de autores únicos");
        library.stream()
        	.map(b -> b.getAuthor())
        	.distinct()
        	.forEach(System.out::println);      
        
        System.out.println();
        
        System.err.println("\ncontar autores únicos");
        System.out.println(library.stream()
            	.map(b -> b.getAuthor())
            	.distinct()
            	.count());
        
        System.out.println();
        
        
        // contar autores únicos menores de 60 años
        System.err.println("contar autores únicos menores de 60 años");
        System.out.println(library.stream()
            	.map(a -> a.getAuthor())
            	.filter(a -> a.getAge() < 60)
            	.count());

        System.out.println();
        
        // JAVI
        library.stream()
        	.map(Book::getAuthor)
        	.filter(a -> a.getAge() < 60)
        	.distinct()
        	.count();
        

        ////////////////////////////////////////////////////////////7777
        System.err.println("contar autoras únicas");
        System.out.println(library.stream()
        		.map(a -> a.getAuthor())
        		.filter(a -> a.getGender() == Gender.FEMALE)
        		.count());
        
        System.out.println();

        System.err.println("mostrar el nombre y la edad de autores cuyo nombre tenga menos de 6 caracteres");
        library.stream()
        	.map(Book::getAuthor)
        	.filter(a -> a.getName().length() < 6)
        	.distinct()
        	.forEach(a -> System.out.println(a.getName() + " → " +  a.getAge() ))
        ;        
        
        System.out.println();
        
        System.err.println("mostrar el nombre y el apellido de autoras cuyo nombre y apellidos conjuntamente tengan menos de 25 caracteres");
        library.stream()
        	.map(Book::getAuthor)
        	.distinct()
        	.filter(a -> a.getGender() == Gender.FEMALE )
        	.filter(a -> a.getName().length() + a.getSurname().length() < 25)
        	.forEach(a -> System.out.println(a.getName() + " " + a.getSurname()))
        ;
 
        
        
        // OTROS EJEMPLOS
        System.err.println("\nEJEMPLOS ADICIONALES");
        
        System.err.println("\nmostrar apellidos (en mayúscula) de los autores que <= 50 años - de los primeros 15 libros ");
        
        System.out.println(library.stream()
                .map(book -> book.getAuthor())
                .filter(age -> age.getAge() >= 50)
                .distinct()
                .limit(15)
                .map(Author::getSurname)
                .map(String::toUpperCase)    
                .collect(Collectors.toList()))
        ;

        

		
		
	}

}
