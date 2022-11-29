/* Copyright [2022] [Pablo de la Cruz Rodriguez y Rafael Pradillo Lopez-Ortum]
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.

You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. */

package src.dominio;
import java.io.*;
import java.util.*;

public class Catalogo{

	private ArrayList<Camiseta> catalogo = new ArrayList<>();	
	private String nombreFichero = "camisetas.txt";
	
	
	public Catalogo() {
		cargarCamisetas();
	}

	public void add(Camiseta c){
		catalogo.add(c);
	}
	
	public void annadir(Camiseta c){
		catalogo.add(c);
		volcarCamisetas();
 		System.out.println("La camiseta ha sido modificada o añadida con éxito.");
	}
	
	// Permite borrar objetos del ArrayList 
	public void borrar(Camiseta c){
		catalogo.remove(c);
		volcarCamisetas();
		System.out.println("La camiseta ha sido eliminada con éxito.");
	}
	
	// Lee el fichero en el que se guardaban los objetos y este convierte las líneas de chars en objetos que se guardarán en el array
	private void cargarCamisetas(){
			try{
				File fichero = new File(nombreFichero);
				fichero.createNewFile(); 
				Scanner sc = new Scanner(fichero);
				sc.useDelimiter(",|\n");
				while(sc.hasNext()){
					catalogo.add(new Camiseta (sc.next(), sc.next(), sc.nextInt()));
				}
		}catch(IOException ex){
			System.out.println("El catalogo está vacío en este momento.");
		}
	}
	
	// Nos permite escribir en un fichero .txt los objetos del array para así ppoder guardarse pese al cierre del programa
	private void volcarCamisetas(){
		try{
			FileWriter fw = new FileWriter(nombreFichero);
			for(Camiseta c : catalogo){
				fw.write(c.getNombre() + "\n");
				fw.write(c.getequipo() + "\n");
				fw.write(c.getNumero() + "\n");

			}
			
			fw.close();
		}catch(IOException ex){
			System.err.print(ex);
		}
	}
	
	// Nos genera una hoja de calculo que guarda las camisetas y sus atributos
	public void generarHojaCalculo(){
		try{
			FileWriter fw = new FileWriter(nombreFichero);
			fw.write("Nombre,Equipo,Numero\n");
			fw.write(toString().trim());
			fw.close();
                  }catch(IOException ex){
			  System.err.println(ex);
		  }
	}


	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(Camiseta c  : catalogo)
		sb.append(c + "\n");

	return sb.toString();
	}	
}

