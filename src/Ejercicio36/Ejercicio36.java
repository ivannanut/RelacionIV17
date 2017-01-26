package Ejercicio36;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio36 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//	DECLARACIÓN DE VARIABLE
		int[] array = {4,5,6,5,7,2,5};
		int[] arrayCambiado;
		
		mostrarArray(array);
		int dato=entradaTeclado("Introduce el valor que deseas eliminar: ");
		
		arrayCambiado=eliminarDelArray(array, dato);
		mostrarArray(arrayCambiado);
		

	}
	
	public static int[] eliminarDelArray(int[]a, int b){
		
		int[] nuevoArray=Arrays.copyOf(a, a.length);
		int contador=0;
		
		for(int i=0; i<nuevoArray.length; i++){
			if(nuevoArray[i]==b){
				contador++;
				for(int j=i; j<nuevoArray.length-contador; j++){
					nuevoArray[j]=nuevoArray[j+1];
					nuevoArray[j+1]=0;
				}
			}
		}
		
		nuevoArray=resizeArray(nuevoArray, contador);
		
		return nuevoArray;
	}
	
	public static int[] resizeArray(int[]a, int b){
		
		return a=Arrays.copyOf(a, a.length-b);
	}
	
	public static int entradaTeclado(String cadena){
		
		Scanner sc=new Scanner(System.in);
		
		String aux;
		int dato=0;
		boolean error=false;
		
		do{
			System.out.print(cadena);
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
