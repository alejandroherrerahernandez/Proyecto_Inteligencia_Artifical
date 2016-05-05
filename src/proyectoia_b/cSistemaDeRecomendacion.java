/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoia_b;
import javax.swing.JComboBox;
import java.sql.*;

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
        this.BDD = new cAdminBDD();
        this.contador = 10;
        this.sql_rating = "select titulo, ID from book where id in (select book_id from rating where rating BETWEEN 5 and 3)";
        this.sql_vistas = "select b.titulo, b.id from BOOK b join c_vistas v on (b.id = v.book_id) order by v.counter desc";
        this.sql_interes = "select titulo, ID from book where id in  (SELECT LB.BOOK_ID FROM LISTA_CATEGORIA_BOOKS LB JOIN LISTA_CATEGORIA_USER LU ON(LB.CATEGORIA_CATEGORIA = LU.CATEGORIA_CATEGORIA) AND LU.USUARIO_ID = ";
        this.sql_random = "select titulo, id from (select titulo, id from book order by  SYS.DBMS_RANDOM.VALUE) where rownum <=10";
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
    public void recomendacion_similitud(){}
    public void recomendacion_colaborativa(){}
    void limpiarCB(JComboBox cb){
        cb.removeAllItems();
    }
}
