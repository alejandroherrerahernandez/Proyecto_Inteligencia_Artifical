/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoia_b;
import javax.swing.JComboBox;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Alejandro Herrera
 */
public class cSistemaDeRecomendacion {
    cAdminBDD BDD;
    int contador;
    String sql_rating;
    String sql_vistas;
    String sql_interes;
    String sql_random;
    public cSistemaDeRecomendacion(){
        this.BDD = new cAdminBDD(false);
        this.contador = 10;
        this.sql_rating = "select titulo, ID from book where id in (select book_id from rating where rating BETWEEN 5 and 3)";
        this.sql_vistas = "select b.titulo, b.id from BOOK b join c_vistas v on (b.id = v.book_id) order by v.counter desc";
        this.sql_interes = "select titulo, ID from book where id in  (SELECT LB.BOOK_ID FROM LISTA_CATEGORIA_BOOKS LB JOIN LISTA_CATEGORIA_USER LU ON(LB.CATEGORIA_CATEGORIA = LU.CATEGORIA_CATEGORIA) AND LU.USUARIO_ID = ";
        this.sql_random = "select titulo, id from book where rownum <=10 order by Sys.DBMS_RANDOM.VALUE";
    }
    public void cold_start(String user_id, JComboBox cbRating, JComboBox cbViews, JComboBox cbInteres, JComboBox cbDescubre) throws SQLException{
        //Se limpian los JComboBox
        limpiarCB(cbRating);
        limpiarCB(cbViews);
        limpiarCB(cbInteres);
        //Se ejecutan los procedimientos para obtener información 
        BDD.cold_start(cbRating, sql_rating);
        BDD.cold_start(cbViews, sql_vistas);
        BDD.cold_start(cbInteres, sql_interes + user_id + ")");
        BDD.cold_start(cbDescubre, sql_random);
    }
    public void recomendacion_similitud(JComboBox cbSimilitud, String book_id_actual){
       limpiarCB(cbSimilitud);
       int z = BDD.get_uniques_id_from_transaction("select count(distinct book_id_origen) from TRANSACTION", "select count(distinct book_id_destino) from TRANSACTION where BOOK_ID_DESTINO not in (select distinct(book_id_origen) from transaction)");
       if(z > 0){
           ArrayList<cNodoCombinacion> lista = BDD.listaCombinaciones("select book_id_origen, book_id_destino from transaction");
           switch(lista.size()){
               case 1:
                   BDD.delete("delete from similares");
                   BDD.insert("insert into similares (book_id_o, book_id_d) values ('" + lista.get(0).origen + "','" + lista.get(0).destino + "')");
                   break;
               default:
                   for(int i = 0; i <lista.size(); i++){
                       if(!lista.get(i).visto){
                           lista.get(i).aumentar_ocurrencias();
                           lista.get(i).set_visto();
                           if(i != lista.size() -1){
                               for(int j = i +1; j <lista.size(); j++){
                                   if(!lista.get(j).visto && nodos_iguales(lista.get(i), lista.get(j))){
                                       lista.get(i).aumentar_ocurrencias();
                                       lista.get(j).set_visto();
                                    }
                                }
                            } 
                        }
                    }
                   BDD.delete("delete from similares");
                   ingresar_combinaciones_satisfactorias(z, lista);
                   break;
           }
       }
       BDD.cold_start(cbSimilitud, "select titulo, id from book where id in (select book_id_d from similares where book_id_o = '" + book_id_actual + "'" +" union select BOOK_ID_O from similares where BOOK_ID_D = '" + book_id_actual + "')");
    }
    void ingresar_combinaciones_satisfactorias(int z, ArrayList<cNodoCombinacion> lista){
       z = z / 2;
       for(int i = 0; i < lista.size(); i++){
           if(lista.get(i).ocurrencias >= z){
               BDD.insert("insert into similares (book_id_o, book_id_d) values ('" + lista.get(i).origen + "','" + lista.get(i).destino + "')");
           }
       }
    }
    boolean nodos_iguales(cNodoCombinacion a, cNodoCombinacion b){
        if(a.origen.equals(b.origen))
            return a.destino.equals(b.destino);
        else
            if(a.destino.equals(b.origen))
                return a.origen.equals(b.destino);
        return false;
    }
    public void recomendacion_aprendizaje(JComboBox cb, String user_id){
        ArrayList<cNodoAprendizaje> lista = BDD.listaAprendizaje("select autor, count(*) as contador from book where id in (select book_id from rating where usuario_id = "+ user_id + " and RATING BETWEEN 3 and 5) group by autor order by contador desc");
        for(int i = 0; i < lista.size() && cb.getItemCount() < 25; i++){
            BDD.cold_start(cb, "select titulo, id from book where autor = '" + lista.get(i).autor + "' and  rownum <= 5;");
        }
    }
    void limpiarCB(JComboBox cb){
        cb.removeAllItems();
    }
    
    public void show_book(String seleccion, JLabel titulo, JLabel autor, JLabel edicion, JLabel year, JTextArea taResumen ){
        cBook libro = BDD.buscar_libro(seleccion.split(";")[1]);
        if(libro != null){
            titulo.setText(libro.titulo);
            autor.setText(libro.autor);
            edicion.setText(Integer.toString(libro.edicion));
            year.setText(Integer.toString(libro.year));
            taResumen.setText(libro.resumen);
        }
    }
}
