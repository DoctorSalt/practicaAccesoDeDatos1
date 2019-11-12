package es.studium.practica;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class guardarCargar {
	public static void main(String[] args) {
		ArrayList <ArticuloAComprar> arrayGuardarArticulos = new ArrayList <ArticuloAComprar>();
		ArrayList <ArticuloAComprar> arrayCargarArticulos = null;
		ArrayList <ListaDeLaCompra> arrayGuardarLista = new ArrayList <ListaDeLaCompra>();
		ArrayList <ListaDeLaCompra> arrayCargarLista = null;
		System.out.println("Datos que vamos a escribir en el fichero:");
        guardar(arrayGuardarArticulos, arrayGuardarLista);
        meter(arrayGuardarArticulos, arrayGuardarLista);
        cargar(arrayCargarArticulos, arrayCargarLista);
       
	}

	private static void meter(ArrayList<ArticuloAComprar> arrayGuardarArticulos1, ArrayList<ListaDeLaCompra> arrayGuardarLista1) {
		 try {
	            System.out.print("Guardando ArrayList en el fichero objetos.dat.. ");

	            ObjectOutputStream escribiendoFicheroArticulos = new ObjectOutputStream( 
	            		new FileOutputStream("objetosArticulos.dat") );
	            escribiendoFicheroArticulos.writeObject(arrayGuardarArticulos1);
	            escribiendoFicheroArticulos.close();
	    
	            System.out.println("ok!");
	            System.out.print("Leyendo ArrayList del fichero objetosArticulos.dat.. ");
	            
	            ObjectOutputStream escribiendoFicheroLista = new ObjectOutputStream( new FileOutputStream("objetosListas.dat") );
	            escribiendoFicheroLista.writeObject(arrayGuardarLista1);
	            escribiendoFicheroLista.close();
		 }catch(Exception e){
			 System.out.println(e.getMessage());
		 }
	}

	@SuppressWarnings("unchecked")
	private static void cargar(ArrayList<ArticuloAComprar> arrayCargarArticulos, ArrayList<ListaDeLaCompra> arrayCargarLista) {
		try {
        ObjectInputStream leyendoFicheroArticulos = new ObjectInputStream(new FileInputStream("objetosArticulos.dat"));
        arrayCargarArticulos = ( ArrayList <ArticuloAComprar> )leyendoFicheroArticulos.readObject();
        leyendoFicheroArticulos.close();
        System.out.println("ok!");
        System.out.println("Datos leídos del fichero:");

        for(int i = 0; i < arrayCargarArticulos.size(); i++) {
            System.out.println( "El dato "+i+" es " + arrayCargarArticulos.get(i).getDescripcion() );
        }
        
        ObjectInputStream leyendoFicheroListas = new ObjectInputStream(new FileInputStream("objetosListas.dat"));
        arrayCargarLista = ( ArrayList <ListaDeLaCompra> )leyendoFicheroListas.readObject();
        leyendoFicheroListas.close();
        for(int i = 0; i < arrayCargarArticulos.size(); i++) {
            System.out.println( "El dato "+i+" es " + arrayCargarLista.get(i).getNombreLista() +" y contiene");
            int tamano =arrayCargarLista.get(i).getArticulos().size();
            ArrayList <ArticuloAComprar> resultante=arrayCargarLista.get(i).getArticulos();
            for(int a = 0; a<tamano;a++) {
            	String desc=resultante.get(a).getDescripcion();
            	System.out.println("El articulo "+desc);
            }
        }
        
    } catch (Exception e) {
        System.out.println( e.getMessage() );
    }

		
		
		
		// https://jnjsite.com/java-serializando-objetos-para-guardar-y-recuperar-en-ficheros
		
	}

	private static void guardar(ArrayList<ArticuloAComprar> arrayGuardarArtículos, ArrayList<ListaDeLaCompra> arrayGuardarLista) {
		ArticuloAComprar patata = new ArticuloAComprar("patata",1,"kg");
		ArticuloAComprar movil = new ArticuloAComprar("movil",1,"unidades");
		System.out.println("creado los articulos");
		arrayGuardarArtículos.add(patata);
		arrayGuardarArtículos.add(movil);
		
		//ListaDeLaCompra
		ListaDeLaCompra list1 = new ListaDeLaCompra();
		list1.setNombreLista("list1");
		list1.articulosList.add(patata);
		list1.agregarProductoAComprar(movil);
		arrayGuardarLista.add(list1);
	}
}
