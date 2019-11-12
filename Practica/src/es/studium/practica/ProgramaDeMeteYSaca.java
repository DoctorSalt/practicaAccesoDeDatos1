package es.studium.practica;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ProgramaDeMeteYSaca {
	public static void main(String[] args) {
		ArrayList <ListaDeLaCompra> arrayGuardarListas = new ArrayList <ListaDeLaCompra>();
		Scanner lee = new Scanner(System.in);
		arrayGuardarListas=(programaDeMeteYSaca(lee));
		programaDeGuardado(arrayGuardarListas);
		imprimirRecibido();
	}
	private static void imprimirRecibido() {
		ArrayList<ListaDeLaCompra> recibido=programaDeCargado();
		 for(int b=0; b<recibido.size();b++) {
			 String nombreLista=recibido.get(b).getNombreLista();
			 System.out.println("La lista llamada "+nombreLista+" contiene los siguientes articulos");
			 ArrayList <ArticuloAComprar> articulosRecogidos =recibido.get(b).getArticulos();
			 for(int c=0;c<articulosRecogidos.size();c++) {
				 System.out.println("La descripcion del articulo nº"+(c+1)+" es "+articulosRecogidos.get(c).getDescripcion());
				 System.out.println("La unidad del articulo nº"+(c+1)+" es "+articulosRecogidos.get(c).getUnidad());
				 System.out.println("La cantidad del articulo nº"+(c+1)+" es "+articulosRecogidos.get(c).getCantidad());
			 }
		 }
	}
	private static  ArrayList<ListaDeLaCompra> programaDeCargado() {
		ArrayList <ListaDeLaCompra> arrayCargarListas = new ArrayList <ListaDeLaCompra>();
		try {
		  ObjectInputStream leyendoFicheroListas = new ObjectInputStream(new FileInputStream("listas.dat"));
		  arrayCargarListas = (ArrayList<ListaDeLaCompra>)leyendoFicheroListas.readObject();
		  System.out.println("Cargamos?");
	        leyendoFicheroListas.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return arrayCargarListas;
	}
	private static void programaDeGuardado(ArrayList<ListaDeLaCompra> arrayGuardarListas) {
		try {
		System.out.println("Guardando ArrayList en el fichero objetos.dat.. ");
		ObjectOutputStream escribiendoFicheroArticulos = new ObjectOutputStream(new FileOutputStream("listas.dat") );
		escribiendoFicheroArticulos.writeObject(arrayGuardarListas);
		escribiendoFicheroArticulos.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	private static ArrayList<ListaDeLaCompra> programaDeMeteYSaca(Scanner lee) {
		Boolean confirmacion;
		int a;
		int i;
		confirmacion=false;
		Boolean confirmacion2=false;
		a=1;
		ArrayList<ListaDeLaCompra> listillas = new ArrayList<ListaDeLaCompra>();
		while(confirmacion2==false) {
			System.out.println("Escriba el nombre de la lista nº"+a);
			String listaNombre=lee.nextLine();
			ArrayList<ArticuloAComprar> articulos =new ArrayList <ArticuloAComprar>(); 
			i=1;
			confirmacion=false;
			while(confirmacion==false) 
			{
				System.out.println("Vamos a escribir el articulo nº"+i);
				System.out.println("Escriba el nombre del articulo nº"+i);
				String articuloNombre=lee.next();
				System.out.println("Escriba el tipo de unidad del articulo nº"+i);
				String articuloUnidad=lee.next();
				System.out.println("Escriba la cantidad del articulo nº"+i);
				int articuloCantidad=lee.nextInt();
				articulos.add(new ArticuloAComprar(articuloNombre, articuloCantidad, articuloUnidad));				
				i++;
				Boolean salidaCorrecta=false;
				
				while(salidaCorrecta==false) {
					System.out.println("¿Quiere continuar creando articulos? S/N");
					char respuesta=lee.next().charAt(0);	
					switch(respuesta) {
					case 'S':
						System.out.println("Continuamos entonces");
						salidaCorrecta=true;
						break;
					case 'N':
						System.out.println("Terminamos de meter Articulos entonces");
						salidaCorrecta=true;
						confirmacion=true;
						break;
					default:
						System.out.println("Escriba S o N, por favor");
						break;
					}
				}
			}
			listillas.add(new ListaDeLaCompra(listaNombre, articulos));
			a++;
			Boolean salidaCorrecta2=false;
			while(salidaCorrecta2==false) {
				System.out.println("¿Quiere continuar con la creacion de listas? S/N");
				char respuesta=lee.next().charAt(0);	
				switch(respuesta) {
				case 'S':
					System.out.println("Continuamos entonces con la siguente lista");
					salidaCorrecta2=true;
					break;
				case 'N':
					System.out.println("Terminamos de hacer listas entonces");
					salidaCorrecta2=true;
					confirmacion2=true;
					break;
				default:
					System.out.println("Escriba S o N, por favor");
					break;
				}
			}
		}
		return listillas;
	}


}
