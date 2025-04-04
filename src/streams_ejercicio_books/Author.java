package streams_ejercicio_books;

public class Author {
	
	private String name;
	private String surname;
	private Gender gender;
	private int age;
	
	public Author(String name, String surname, int age, Gender gender) {
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public Gender getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", surname=" + surname + ", gender=" + gender + ", age=" + age + "]";
	}
	
	
	
		

}
