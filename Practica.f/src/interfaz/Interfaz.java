/* License  
Copyright [2022] [Pablo de la Cruz Rodríguez y Rafal Pradillo López-Ortum] 
Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. 

You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.See the License for the specific language governing permissions andYou may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License. */



package src.interfaz;

import src.dominio.*;

public class Interfaz{
    private static String negrita = "\033[1m"; 
    private static String normal = "\033[0m"; 
    private static String subrayado = "\033[4m"; 

    private static String rojo = "\u001B[31m";
    private static String negro = "\u001B[30m";	 
    private static void mostrarAyuda(){
        System.out.println(negrita + "NOMBRE" + normal);
        System.out.println("\t" + subrayado + "Catálogo" + normal);
        System.out.println(negrita + "\nSYNOPSIS" + normal);
        System.out.println("\tjava -jar " + subrayado + "[annadir <nombre> <equipo> <numero> | mostrar | ayuda ]" + normal);
        System.out.println(negrita + "\nDESCRIPCIÓN" + normal);
        System.out.println("\tEste programa simula un catálogo de tienda virtual, en el cual podemos incluir una diversidad de camisetas, pudiendo incluir hasta 3 atributos de estos.");
        System.out.println(negrita + "\nEJEMPLOS" + normal);
        System.out.println("\tEjemplo 1. Inserción de una camiseta:\n");
        System.out.println(negrita + "\t\tjava -jar catalogo.jar annadir Illera Blanco 13\n" + normal);
	System.out.println("\tEjemplo 2. Borrado de un vino:\n");
        System.out.println(negrita + "\t\tjava -jar catalogo.jar borrar Illera Blanco 13\n" + normal);
	System.out.println("\tEjemplo 3. Edición de los atributos de una camiseta:\n");
        System.out.println(negrita + "\t\tjava -jar catalogo.jar editar Illera Blanco 13\n" + normal);
	System.out.println("\tEjemplo 4. Muestra de camisetas:\n");
        System.out.println(negrita + "\t\tjava -jar catalogo.jar mostrar" + normal);
        System.out.println("\t\nEjemplo 5. Muestra esta ayuda:\n");
        System.out.println(negrita + "\t\tjava -jar catalogo.jar ayuda\n" + normal);
    }

    public static void ejecutar(String[] instruccion){
        Catalogo catalogo = new Catalogo();
        if (instruccion.length == 0) mostrarAyuda();
        else if (instruccion[0].equalsIgnoreCase("annadir") && instruccion.length == 4){
            catalogo.annadir(new Camiseta(instruccion[1], instruccion[2], Integer.parseInt(instruccion[3])));
        }else if (instruccion[0].equalsIgnoreCase("borrar") && instruccion.length == 2){
            catalogo.borrar(new Camiseta(instruccion[1]));
         }else if (instruccion[0].equalsIgnoreCase("editar") && instruccion.length == 4){
	catalogo.borrar(new Camiseta(instruccion[1]));
	catalogo.annadir(new Camiseta(instruccion[1], instruccion[2], Integer.parseInt(instruccion[3])));
        }
	else if (instruccion[0].equalsIgnoreCase("mostrar") && instruccion.length == 1) System.out.println(catalogo);
        else if (instruccion[0].equalsIgnoreCase("ayuda") && instruccion.length == 1) mostrarAyuda();
        else{
            System.out.println(rojo + "Error en la instrucción" + normal); 
            mostrarAyuda();
        }
    }
}

