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
public class cNodoCombinacion {
    public String origen;
    public String destino;
    public int ocurrencias;
    public boolean visto;
    public cNodoCombinacion(String id_origen, String id_destino){
        this.origen = id_origen;
        this.destino = id_destino;
        this.ocurrencias = 0;
        this.visto = false;
    }
    
    public void aumentar_ocurrencias(){
        this.ocurrencias ++;
    }

    public void set_visto(){
        this.visto = true;
    }
}
