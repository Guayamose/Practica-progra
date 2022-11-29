
package src.dominio;

public class Camiseta{

	private String nombre;
	private String equipo;
	private int numero; 

	// Constructor sin parámetros
	public Camiseta(){}

	// Constructor con un solo parámetro para usar en el borrado del Array List
	public Camiseta(String nombre){
	this.nombre = nombre;
	}

	 public Camiseta(String nombre, String equipo){
                this.nombre = nombre;
                this.equipo = equipo;
	}

	// Constructor con parámetros de los objetos de la clase camiseta
	public Camiseta(String nombre, String equipo, int numero) {
		this.nombre = nombre;
		this.equipo = equipo;
		this.numero = numero;
	}

	// Método que le dice al programa que todos aquellos objetos con el mismo atributo son el mismo objeto a la hora de compararlos
	public boolean equals(Object camiseta){
		Camiseta c = (Camiseta) camiseta;
		return this.nombre.equals(c.nombre);
	}

	// Crea una cadena de chars definida por el programador, para así que pueda salir impreso por pantalla esa cadena con los atributos y no la dirección  de memoria
	public String toString(){
		return  nombre + ", " + equipo + ", " + numero;
	}

	public String getNombre(){
		return nombre;
	}

	public String getEquipo(){
		return equipo;
	}

	public int getNumero(){
		return numero;
	}
}
