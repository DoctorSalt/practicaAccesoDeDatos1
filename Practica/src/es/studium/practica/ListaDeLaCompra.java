package es.studium.practica;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaDeLaCompra implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nombreL;
	ArrayList <ArticuloAComprar> articulosList;
	public ListaDeLaCompra(){
		nombreL="";
		articulosList=new ArrayList<ArticuloAComprar>();
	}
	public ListaDeLaCompra(String nom, ArrayList <ArticuloAComprar> ac) {
		nombreL=nom;
		articulosList=ac;
	}
	public ListaDeLaCompra(String nombreLista) {
		nombreLista = nombreL;
	}
	public String getNombreLista() {
		return nombreL;	
	}
	public void setNombreLista(String nombreLista) {
		nombreL = nombreLista;
	}
	public void agregarProductoAComprar(ArticuloAComprar articulo) {
		articulosList.add(articulo);
	}
	public void eliminarArticulo (String descripcionArticulo){
		articulosList.remove(descripcionArticulo);
	}
	public ArrayList<ArticuloAComprar>getArticulos(){
		return articulosList;
	}
	public void CrearListasXd() {
		
		
	}
	
}
