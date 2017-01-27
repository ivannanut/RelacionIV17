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
		int[] intercambio=Arrays.copyOf(a, (a.length+b.length));	// Nuevo array con el contenido basico, y la longitud de �ste m�s la del array de datos.
		int[] cambio=new int[b.length];		// Array vac�o auxiliar para guardar los datos intermedios.
		int aux;							// Variable auxiliar para el tr�fico de datos.
		
		int posicionCambio=entradaTeclado("\nIntroduzca la posicion: ")-1;	// Solicitar la posici�n donde empezar a introducir los d�gitos.
		boolean end=false;
		
		for(int i=0; i<intercambio.length&&!end; i++){	// 'for' N�1: Localizaci�n de la posici�n.
			if(i==posicionCambio){
				int g=0;
				for(int j=i; j<intercambio.length-b.length&&g<cambio.length; j++){	// 'for' N�2: Inserci�n de los nuevos d�gitos.
					cambio[g]=intercambio[j];
					intercambio[j]=b[g++];
				}
				g=0;
				for(int h=i+cambio.length; h<intercambio.length; h++){	// 'for' N�3: Mover el resto de d�gitos a la derecha.
					aux=intercambio[h];
					intercambio[h]=cambio[g];
					cambio[g++]=aux;
					if(g==cambio.length)
						g=0;
				}
				end=true;	// Finalizar bucle 'for' N�1 para ahorrar iteraciones innecesarias.
			}
		}	
		
		return intercambio;
	}
	
	public static int[] rellenarArray(){
		
		// RELLENAR EL ARRAY DE DATOS A INSERTAR
		int[] datosInsertados=new int[0];	// D�gitos a insertar.
		int contadorPosiciones=0;			// Posiciones del array.
		boolean finPosiciones=false;		// Finalizar entrada de datos.
		
		do{
			int aux=entradaTeclado("Introduzca un n�mero: ");	// Solicitar d�gito.
			if(aux<0) finPosiciones=true;
			/* Si en la funci�n de entrada, se fuerza a la salida, �sta devuelve -1, en cuyo
				caso termina la entrada de datos. Si no, se ejecuta todo el proceso. */
			else{
				contadorPosiciones+=1;	// En cada iteraci�n se amplia el num. de posiciones en 1.
				datosInsertados=redimensionarArray(datosInsertados, contadorPosiciones);	// Redimensionar el array.
				datosInsertados[contadorPosiciones-1]=aux;	// En la �ltima posici�n del array, se guarda el d�gito introducido.
			}			
		}while(!finPosiciones);
		
		return datosInsertados;	// Al terminar se devuelve el array completo.
	}
	
	public static int[] redimensionarArray(int[] a, int b){
		
		//	REDIMENSIONAR ARRAY, COPIAR EL QUE SE LE PASA A LA FUNCI�N Y AMPLIAR EL ARRAY
		int[] arrayGrande=Arrays.copyOf(a, b);
		return arrayGrande;
	}
	
	public static int entradaTeclado(String cadena){
		
		Scanner sc=new Scanner(System.in);
		
		String aux;				// Captura del d�gito.
		int dato=0;				// Almacenar el d�gito parseado.
		boolean error=false;	// Control de errores (Dato incorrecto)
		boolean salir=false;	// Control de salida (No m�s d�gitos)
		
		do{
			// Introducci�n de d�gito por teclado.
			System.out.println(cadena);
			aux=sc.nextLine();
			
			// Pregunta, si se desea salir. 'Q' � 'q' valida la opci�n.
			if(aux.equals("Q") || aux.equals("q")){
				salir=true;
				dato=-1;
			}
			/*
			 * En caso contrario, se comprueba el dato, y si es parseable a
			 * entero se convierte y la funci�n devuelve el d�gito.
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
		
		//	COMPROBACI�N DE ERRORES
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
