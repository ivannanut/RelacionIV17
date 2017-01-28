package Ejercicio40;

import java.util.Arrays;

public class Ejercicio40 {
	
	final static int[] arrayBasico = {4,5,6,5,7,2,5};	// Array principal.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//	Mostrar array principal.
		mostrarArray(arrayBasico);
		//	Mostrar subarray.
		mostrarArray(ordenaSeleccion(arrayBasico));

	}
	
	public static int[] ordenaSeleccion(int[] a){
		
		int[]arrayOrdenado=new int[0];	// Nuevo array ordenado.
		int posiciones=0;				// Nº de posiciones que irá aumentando.
		
		do{
			int indice=posicionMinArray(a);		// Captura del índice con el valor más pequeño.
			arrayOrdenado=insertarAlFinalArray(arrayOrdenado, 
					++posiciones, a[indice]);	// Redimensionar array, e insertar el valor.
			a[indice]=-1;
		}while(arrayOrdenado.length<a.length);	// Condicion: Mientras el bucle ordenado sea más pequeño que el inicial.
		
		return arrayOrdenado;
	}
	
	public static int posicionMinArray(int[]a){
		
		int digito=Integer.MAX_VALUE;	// Valor entero máximo disponible.
		int indice=0;
		
		/* Para evitar encontrar 2 veces el mismo indice, igualamos el campo a -1, 
		 * y si llega a este campo salta de iteración. */
		for(int i=0; i<a.length; i++){
			if(a[i]<digito&&a[i]>0){
				digito=a[i];
				indice=i;
			}
		}
		
		return indice;
	}
	
	public static int[] insertarAlFinalArray(int[]a, int b, int c){
		
		// Copia del array, se incrementa en 1 la longitud, y se inserta en el campo final el dígito pasado.
		int[] nuevoArray=Arrays.copyOf(a, b);
		nuevoArray[b-1]=c;
		
		return nuevoArray;
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
