package Ejercicio31;

import java.util.Arrays;

public class Ejercicio31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//	DECLARACIÓN DE VARIABLES
		int[] a = {1,2,3};
		int[] b = {4,5,6,7,2};
		int[] c;
		
		c=concatenarArrays(a, b);
		
		mostrarArray(c);

	}
	
	public static int[] concatenarArrays(int[]a, int[]b){
		
		int[] arrayCont=new int[a.length+b.length];
		
		System.arraycopy(a, 0, arrayCont, 0, a.length);
		System.arraycopy(b, 0, arrayCont, a.length, b.length);
		
		return arrayCont;
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
