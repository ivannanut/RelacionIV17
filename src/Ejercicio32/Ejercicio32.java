package Ejercicio32;

import java.util.Arrays;

public class Ejercicio32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//	DECLARACIÓN DE VARIABLES
		int[] a = {1,2,3};
		int[] b;

		b=copiarArray(a);
		
		mostrarArray(b);

	}
	
	public static int[] copiarArray(int[]a){
		
		return Arrays.copyOf(a, a.length);
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
