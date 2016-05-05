/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoia_b;

/**
 *
 * @author Alejandro
 * 
 */
//Clase USUARIO donde se obtienen los datos del usuario actual para no tener que estar ingresando a la base de datos muchas veces
public class cUsuario {
    public String nombre;
    public String id_usuario;
    
    public cUsuario(String name, String id){
        this.nombre = name;
        this.id_usuario = id;
    }
    
}
