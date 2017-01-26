package Ejercicio33;

public class Ejercicio33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//	DECLARACIÓN DE VARIABLE
		int[] array = {4,5,6,7,2};
		int[] arrayCambiado;
		int introDato=0;
		int posicion=0;
		
		mostrarArray(array);
		
		introDato=entradaTeclado("Introduzca un nuevo digito: ");
		posicion=entradaTeclado("Introduzca la posicion: ");
		
		arrayCambiado=insertarArray(array, introDato, posicion);

	}
	
	public static int entradaTeclado(String cadena){
		
		Scanner sc=new Scanner(System.in);
		
		
	}
	
	public static void mostrarArray(int[] a){
		
		System.out.print("[ ");
		for(int i=0; i<a.length; i++){
			System.out.print(a[i]);
			if(i<a.length-1)
				System.out.print(", ");
		}
		System.out.print(" ]");
	}

}
