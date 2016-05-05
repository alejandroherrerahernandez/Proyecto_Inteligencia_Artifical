/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoia_b;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

/**
 *
 * @author Alejandro
 */
public class cAdminBDD {
    static Connection cnn;
    static Statement st;
    static ResultSet rs;
  
    int cantidadColumnas;
    int cantidadFilas;
    public void conectar(){
        try{
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            cnn = DriverManager.getConnection(url,"admin_ia", "hola123");
            st = cnn.createStatement();
            JOptionPane.showConfirmDialog(null, "Usuario ingresado exitosamente");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en conexion " + e);
        }
    }
    
    public void ingresar_usuario(int id, String name, String password){
        try{
            conectar();
            st.executeQuery("insert into usuario (id, nombre, password) values (" + Integer.toString(id) + ",'" + name + "','" + password + "')");
            cnn.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en base de datos al ingresar usuario");
        }
    }

    public void cold_start(JComboBox cb, String sql){
        String actual = "";
        try{
            conectar();
            rs = st.executeQuery(sql);
            while(rs.next()){
                actual = rs.getObject(1).toString();
                actual = actual + " ;" + rs.getObject(2).toString();
                cb.addItem(actual);
            }
            cnn.close();
            rs.close();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    /*  select titulo, ID from book where id in (select book_id from rating where rating BETWEEN 5 and 3);  MOSTRAR LIBROS CON MEJOR RATING
        select b.titulo, b.id from BOOK b join c_vistas v on (b.id = v.book_id) order by v.counter desc;    MOSTRAR LIBROS CON MAS VISTAS
        select titulo, ID from book where id in  (SELECT LB.BOOK_ID FROM LISTA_CATEGORIA_BOOKS LB JOIN LISTA_CATEGORIA_USER LU ON(LB.CATEGORIA_CATEGORIA = LU.CATEGORIA_CATEGORIA) AND LU.USUARIO_ID = 1); MOSTRAR LIBROS QUE SEAN ESTEN EN LA CATEGORIA DE INTERES DEL USUARIO
        select titulo, id from (select titulo, id from book order by  SYS.DBMS_RANDOM.VALUE) where rownum <=10; MOSTRAR LIBROS RANDOM
    */
}
