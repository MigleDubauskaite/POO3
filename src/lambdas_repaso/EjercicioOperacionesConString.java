package lambdas_repaso;

public class EjercicioOperacionesConString {

	public static void main(String[] args) {
		
		System.out.println("1. SI SON IGUALES");
		BooleanCompararDosString cadenasIguales = (s1, s2) -> s1.equals(s2);
		System.out.println(cadenasIguales.compara("migle", "Migle"));
		System.out.println(cadenasIguales.compara("Lola", "Lola"));
		System.out.println();
		
		System.out.println("2. SI LA INSTANCIA CONTIENE EL PARÁMETRO");
		BooleanCompararDosString contieneParametro = (s1, s2) -> s1.contains(s2);
		System.out.println(contieneParametro.compara("migle", "gle"));
		System.out.println(contieneParametro.compara("migle", "ml"));
		System.out.println();
		
		System.out.println("3. SI EL NÚMERO DE CARACTERES ES MENOR DE 3");
		EntraStringSaleBoolean menorDe3Caracteres = s -> s.length() < 3;
		System.out.println(menorDe3Caracteres.opera("ho"));
		System.out.println(menorDe3Caracteres.opera("hola"));
		System.out.println();
		
		System.out.println("3. SI EL NÚMERO DE CARACTERES ES MENOR DE N");
		EntraStringIntSaleBoolean menorNCaracteresV2 = (s, i) -> s.length() < i;
		System.out.println(menorNCaracteresV2.opera("ho", 5));
		System.out.println(menorNCaracteresV2.opera("ho", 1));
		System.out.println();
		
		System.out.println("4. SI EMPIEZA POR \"A\"");
		EntraStringSaleBoolean empiezaPorA = s -> s.startsWith("A");
		System.out.println(empiezaPorA.opera("Amanda"));
		System.out.println(empiezaPorA.opera("Carolina"));
		System.out.println();
		
		System.out.println("5. SI TERMINA POR \".\"");
		EntraStringSaleBoolean terminaPorPunto = s -> s.endsWith(".");
		System.out.println(terminaPorPunto.opera("."));
		System.out.println(terminaPorPunto.opera("-"));
		System.out.println();
		
		System.out.println("6. SI LA INSTANCIA EMPIEZA POR UN CARACTER DETERMINADO");
		Entra2StringSaleBoolean empiezaCaracterDeterminado = (s, c) -> s.startsWith(c);
		System.out.println(empiezaCaracterDeterminado.opera("hola", "h"));
		System.out.println(empiezaCaracterDeterminado.opera("hola", "m"));
		System.out.println();
		
	}
}
