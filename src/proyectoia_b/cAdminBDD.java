/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoia_b;
import java.sql.*;
import java.util.ArrayList;
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
  
    
    boolean ingresando;
    public void conectar(){
        try{
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            cnn = DriverManager.getConnection(url,"admin_ia", "hola123");
            st = cnn.createStatement();
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
                actual = rs.getObject(1).toString().trim() + ";" + rs.getString(2);
                cb.addItem(actual);
            }
            cb.setSelectedIndex(-1);
            cnn.close();
            rs.close();
            ingresando = false;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<cNodoCombinacion> listaCombinaciones(String sql){
        ArrayList<cNodoCombinacion> lista = new ArrayList();
        try{
            conectar();
            rs = st.executeQuery(sql);
            while(rs.next()){
                lista.add(new cNodoCombinacion(rs.getString(1), rs.getString(2)));
            }
            cnn.close();
            rs.close();
            return lista;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    public void delete(String sql){
        try{
            conectar();
            st.executeQuery(sql);
            cnn.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void insert(String sql){
        try{
            conectar();
            st.executeQuery(sql);
            cnn.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public int get_uniques_id_from_transaction(String sql1, String sql2){
        int n = -1;
        try{
            conectar();
            rs = st.executeQuery(sql1);
            if(rs.next()){
                n = rs.getInt(1);
            }
            else 
                return n;
            rs.close();
            rs = st.executeQuery(sql2);
            if(rs.next()){
                n += rs.getInt(1);
            }
            cnn.close();
            rs.close();
            return n;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return n;
    }
    
    public ArrayList<cNodoAprendizaje> listaAprendizaje (String sql){
        ArrayList<cNodoAprendizaje> lista = new ArrayList();
        try{
            conectar();
            rs = st.executeQuery(sql);
            while(rs.next()){
                lista.add(new cNodoAprendizaje(rs.getString(1), rs.getInt(2)));
            }
            cnn.close();
            rs.close();
            if(lista.isEmpty())
                return null;
            else
                return lista;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    public void ingresar_rating(String user_id, String book_id, int rating){
        try{
            conectar();
            st.executeQuery("insert into rating (usuario_id, book_id, rating_id) values ('" + user_id + "','" + book_id + "'," + Integer.toString(rating) + ")");
            cnn.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en base de datos al ingresar usuario");
        }
    }
    
    public void aumentar_vista(String book_id){
        int rating = 0;
         try{
            conectar();
            rs = st.executeQuery("select counter from c_vistas where book_id = '" + book_id +"'");
            if(rs.next())
                rating =rs.getInt(1);
            rs.close();
            if(rating == 0){
                st.executeQuery("insert into c_vistas (book_id, rating) values ('"+ book_id + "'," + 1 + ")");
            }
            else{
                rating++;
                st.executeQuery("update c_vistas set rating = " + Integer.toString(rating) + " where book_id = '" + book_id + "'");
            }
            cnn.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public cBook buscar_libro(String id_book){
        cBook libro;
        try{
            conectar();
            rs = st.executeQuery("select id, titulo, autor, edicion, year, resumen from book where id = '" + id_book + "'");
            if(rs.next()){
                libro = new cBook(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
                cnn.close();
                st.close();
                return libro;
            }
            cnn.close();
            st.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    public cAdminBDD(boolean ingreso)
    {
        ingresando = ingreso;
    }
    
    /*  select titulo, ID from book where id in (select book_id from rating where rating BETWEEN 5 and 3);  MOSTRAR LIBROS CON MEJOR RATING
        select b.titulo, b.id from BOOK b join c_vistas v on (b.id = v.book_id) order by v.counter desc;    MOSTRAR LIBROS CON MAS VISTAS
        select titulo, ID from book where id in  (SELECT LB.BOOK_ID FROM LISTA_CATEGORIA_BOOKS LB JOIN LISTA_CATEGORIA_USER LU ON(LB.CATEGORIA_CATEGORIA = LU.CATEGORIA_CATEGORIA) AND LU.USUARIO_ID = 1); MOSTRAR LIBROS QUE SEAN ESTEN EN LA CATEGORIA DE INTERES DEL USUARIO
        select titulo, id from (select titulo, id from book order by  SYS.DBMS_RANDOM.VALUE) where rownum <=10; MOSTRAR LIBROS RANDOM
    select titulo, id from book where id in (select bood_id_d from similares where book_id_o = "LIBRO" union select BOOK_ID_O from similares where BOOK_ID_D = "LIBRO")
    
        select count(distinct book_id_origen) from TRANSACTION;
        select count(distinct book_id_destino) from TRANSACTION where BOOK_ID_DESTINO not in (select distinct(book_id_origen) from transaction); 

        select distinct(book_id_origen) from transaction;
        select distinct(book_id_destino) from transaction where book_id_destino not in (select distinct(book_id_origen) from transaction);

        select book_id_origen, book_id_destino from transaction;
    */
}
