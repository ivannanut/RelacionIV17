package Ejercicio38;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio38 {
	
	final static int[] arrayBasico = {4,5,6,5,7,2,5};	// Array principal.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//	Mostrar array principal.
		mostrarArray(arrayBasico);
		//	Mostrar subarray.
		mostrarArray(subArray2(arrayBasico));

	}
	public static int[] subArray2(int[] a){
		
		int indice1=entradaTeclado("Introduce el primer indice: ")-1;	// Indice inicial.
		int indice2=entradaTeclado("Introduce el indice final: ");		// Indice final.
		
		int[] subArray=Arrays.copyOfRange(a, indice1, indice2);
		return subArray;
	}
	
	public static int[] subArray(int[] a){
		
		int[] subarray=new int[0];
		int posiciones=0;
		int indice1=entradaTeclado("Introduce el primer indice: ")-1;	// Indice inicial.
		int indice2=entradaTeclado("Introduce el indice final: ")-1;	// Indice final.
		boolean end=false;
		
		for(int i=0; i<a.length&&!end;i++){		// Bucle 'for' nº1: Se localiza la primera posición.
			if(i==indice1){
				for(int j=i; j<=indice2; j++){	// Bucle 'for' nº2: Se procesan todos los datos hasta el indice final.
					subarray=redimensionarArray(subarray, ++posiciones);	// Se redimensiona el array.
					subarray[posiciones-1]=a[j];	// Se guarda el dígito de la posición indicada.
				}
				end=true;	// Finaliza el bucle.
			}
		}
		return subarray;
	}
	
	public static int[] redimensionarArray(int[] a, int b){
		
		//	REDIMENSIONAR ARRAY, COPIAR EL QUE SE LE PASA A LA FUNCIÓN Y AMPLIAR EL ARRAY
		int[] arrayGrande=Arrays.copyOf(a, b);
		return arrayGrande;
	}
	
	public static int entradaTeclado(String cadena){
		
		Scanner sc=new Scanner(System.in);
		
		String aux;				// Captura del dígito.
		int dato=0;				// Almacenar el dígito parseado.
		boolean error=false;	// Control de errores (Dato incorrecto)
		
		do{
			// Introducción de dígito por teclado.
			System.out.println(cadena);
			aux=sc.nextLine();
			
			// Se comprueba el dígito, si no hay error se parsea el dígito y se devuelve.
			error=comprobarDato(aux);
			if(!error)
				dato=Integer.parseInt(aux);
		}while(error);
		
		return dato;
	}
	
	public static boolean comprobarDato(String cadena){
		
		//	COMPROBACIÓN DE ERRORES
		try{
			int dato = Integer.parseInt(cadena);
			return false;
		}catch(Exception e){
			System.out.println("\nError. Dato incorreto.");
			return true;
		}
	}
	
	public static void mostrarArray(int[] a){
		
		//	SISTEMA PARA MOSTRAR ARRAYS
		System.out.print("[ ");
		for(int i=0; i<a.length; i++){
			System.out.print(a[i]);
			if(i<a.length-1)
				System.out.print(", ");
		}System.out.print(" ]\n\n");
	}

}
