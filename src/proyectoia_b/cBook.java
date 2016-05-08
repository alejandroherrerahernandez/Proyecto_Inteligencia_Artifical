/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoia_b;

/**
 *
 * @author Alejandro
 */
public class cBook {
    public String id;
    public String titulo;
    public String autor;
    public int edicion;
    public int year;
    public String resumen;
    
    public cBook(String id, String titulo, String autor, int edicion, int year, String resumen){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.edicion = edicion;
        this.year = year;
        this.resumen = resumen;
    }
}
