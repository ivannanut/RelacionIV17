package Ejercicio33;

import java.util.Arrays;
import java.util.Scanner;

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
		do{
			posicion=entradaTeclado("Introduzca la posicion: ");
			
		} while(posicion>array.length || posicion<=0);
		posicion-=1;
		
		arrayCambiado=insertarArray(array, introDato, posicion);
		mostrarArray(arrayCambiado);

	}
	
	public static int[] insertarArray(int[]a, int b, int c){
		
		int[] nuevoArray=resizeArray(a);
		int cambio;
		int aux;
		boolean end=false;
		
		for(int i=0; i<nuevoArray.length && !end; i++){
			if(c==i){
				for(int j=i; j<nuevoArray.length; j++){
					aux=nuevoArray[j];
					nuevoArray[j]=b;
					b=aux;
				}
				end=true;
			}
		}
		
		return nuevoArray;
	}
	
	public static int[] resizeArray(int[]a){
		
		int[] arrayAux=Arrays.copyOf(a, a.length+1);
		return arrayAux;
	}
	
	public static int entradaTeclado(String cadena){
		
		Scanner sc=new Scanner(System.in);
		
		String aux;
		int dato;
		boolean error=false;
		
		do{
			System.out.println(cadena);
			aux=sc.nextLine();
			
			error=comprobarDato(aux);
			
		}while(error);
		
		return dato=Integer.parseInt(aux);
		
	}
	
	public static boolean comprobarDato(String cadena){
		
		try{
			int dato=Integer.parseInt(cadena);
			return false;
		}catch(Exception e){
			System.out.println("\nError. Dato incorrecto.");
			return true;
		}
	}
	
	public static void mostrarArray(int[] a){
		
		System.out.print("[ ");
		for(int i=0; i<a.length; i++){
			System.out.print(a[i]);
			if(i<a.length-1)
				System.out.print(", ");
		}
		System.out.print(" ]\n\n");
	}

}
