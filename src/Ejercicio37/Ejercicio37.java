package Ejercicio37;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio37 {

	final static int[] arrayBasico = {4,5,6,5,7,2,5};	// Array principal.
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//	MOSTRAR ARRAY
		mostrarArray(arrayBasico);
		//	MOSTRAR ARRAY REDIMENSIONADO CON LOS NUEVOS DATOS
		mostrarArray(insertarDatos(arrayBasico, rellenarArray()));
	}
	
	public static int[] insertarDatos(int[] a, int[] b){
		
		//	SE INSERTAN LOS DATOS OBTENIDOS POR TECLADO EN EL ARRAY
		int[] intercambio=Arrays.copyOf(a, (a.length+b.length));	// Nuevo array con el contenido basico, y la longitud de éste más la del array de datos.
		int[] cambio=new int[b.length];		// Array vacío auxiliar para guardar los datos intermedios.
		int aux;							// Variable auxiliar para el tráfico de datos.
		
		int posicionCambio=entradaTeclado("\nIntroduzca la posicion: ")-1;	// Solicitar la posición donde empezar a introducir los dígitos.
		boolean end=false;
		
		for(int i=0; i<intercambio.length&&!end; i++){	// 'for' Nº1: Localización de la posición.
			if(i==posicionCambio){
				int g=0;
				for(int j=i; j<intercambio.length-b.length&&g<cambio.length; j++){	// 'for' Nº2: Inserción de los nuevos dígitos.
					cambio[g]=intercambio[j];
					intercambio[j]=b[g++];
				}
				g=0;
				for(int h=i+cambio.length; h<intercambio.length; h++){	// 'for' Nº3: Mover el resto de dígitos a la derecha.
					aux=intercambio[h];
					intercambio[h]=cambio[g];
					cambio[g++]=aux;
					if(g==cambio.length)
						g=0;
				}
				end=true;	// Finalizar bucle 'for' Nº1 para ahorrar iteraciones innecesarias.
			}
		}	
		
		return intercambio;
	}
	
	public static int[] rellenarArray(){
		
		// RELLENAR EL ARRAY DE DATOS A INSERTAR
		int[] datosInsertados=new int[0];	// Dígitos a insertar.
		int contadorPosiciones=0;			// Posiciones del array.
		boolean finPosiciones=false;		// Finalizar entrada de datos.
		
		do{
			int aux=entradaTeclado("Introduzca un número: ");	// Solicitar dígito.
			if(aux<0) finPosiciones=true;
			/* Si en la función de entrada, se fuerza a la salida, ésta devuelve -1, en cuyo
				caso termina la entrada de datos. Si no, se ejecuta todo el proceso. */
			else{
				contadorPosiciones+=1;	// En cada iteración se amplia el num. de posiciones en 1.
				datosInsertados=redimensionarArray(datosInsertados, contadorPosiciones);	// Redimensionar el array.
				datosInsertados[contadorPosiciones-1]=aux;	// En la última posición del array, se guarda el dígito introducido.
			}			
		}while(!finPosiciones);
		
		return datosInsertados;	// Al terminar se devuelve el array completo.
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
		boolean salir=false;	// Control de salida (No más dígitos)
		
		do{
			// Introducción de dígito por teclado.
			System.out.println(cadena);
			aux=sc.nextLine();
			
			// Pregunta, si se desea salir. 'Q' ó 'q' valida la opción.
			if(aux.equals("Q") || aux.equals("q")){
				salir=true;
				dato=-1;
			}
			/*
			 * En caso contrario, se comprueba el dato, y si es parseable a
			 * entero se convierte y la función devuelve el dígito.
			 */
			else{
				error=comprobarDato(aux);
				if(!error)
					dato=Integer.parseInt(aux);
			}
			
		}while(error && !salir);
		
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
