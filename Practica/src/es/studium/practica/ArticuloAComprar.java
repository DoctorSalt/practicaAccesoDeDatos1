package es.studium.practica;

import java.io.Serializable;

public class ArticuloAComprar implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String descripcion;
private int cantidad;
private String unidad;

ArticuloAComprar(){
	descripcion = "";
	cantidad = 0;
	unidad = "";
}

ArticuloAComprar(String desc, int cant, String type){
	descripcion = desc;
	cantidad = cant;
	unidad = type;
}

public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public int getCantidad() {
	return cantidad;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
public String getUnidad() {
	return unidad;
}
public void setUnidad(String unidad) {
	this.unidad = unidad;
}

}
