package Ejercicio34;

import java.util.Arrays;
import java.util.Scanner;//pene

public class Ejercicio34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//	DECLARACIÓN DE VARIABLE
		int[] array = {4,5,6,7,2};
		int[] arrayCambiado;
		int posicion=0;
		
		mostrarArray(array);
		
		do{
			posicion=entradaTeclado("\n¿Que posicion desea eliminar?: ");
			
		} while(posicion>array.length || posicion<=0);
		posicion-=1;
		
		arrayCambiado=resizeArray(eliminarDeArray(array, posicion));
		mostrarArray(arrayCambiado);

	}
	
	public static int[] eliminarDeArray(int[]a, int b){
		
		int[] nuevoArray=Arrays.copyOf(a, a.length);
		int cambio=0;
		boolean end=false;
		
		for(int i=0; i<nuevoArray.length && !end; i++){
			if(b==i){
				for(int j=i; j<nuevoArray.length-1; j++){
					nuevoArray[j]=nuevoArray[j+1];
					nuevoArray[j+1]=cambio;
				}
				end=true;
			}
		}
		
		return nuevoArray;
	}
	
	public static int[] resizeArray(int[]a){
		
		int[] arrayAux=Arrays.copyOf(a, a.length-1);
		return arrayAux;
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

