package Modelo;

import Conexion.CConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import org.jfree.data.category.DefaultCategoryDataset;

public class ConsultasProducto extends CConexion{
    
    public boolean registrar(Producto pro) {
        CConexion con = new CConexion();
        Connection cn = con.conectar();
    
        try {
            PreparedStatement ps = cn.prepareStatement("insert into productos (nombre, descripcion, precio, id_categoria) values (?,?,?,?)");
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getDescripcion());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getId_categoria());
            ps.executeUpdate();
            return true;
        }catch (SQLException e) {
            System.out.println("Error al registrar el producto en la BD " + e);
            return false;
        }
    }
    
    public boolean modificar(Producto pro) {
        CConexion con = new CConexion();
        Connection cn = con.conectar();
    
        try {
            int id = pro.getId_prod();
            PreparedStatement ps = cn.prepareStatement("update productos set nombre=?, descripcion=?, precio=?, id_categoria=? where id_prod=? ");
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getDescripcion());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getId_categoria());
            ps.setInt(5, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto en la BD " + e);
            return false;
        }
    }
    
    public static boolean eliminar(Producto pro) {
        CConexion con = new CConexion();
        Connection cn = con.conectar();

        try {
            PreparedStatement ps = cn.prepareStatement("DELETE FROM productos WHERE id_prod = ? ");
            ps.setInt(1, pro.getId_prod());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto en la BD " + e);
            return false;
        }
    }
    
    public static void mostrar(DefaultTableModel modelo) {
        CConexion con = new CConexion();
        Connection cn = con.conectar();
        
        String consulta = "select * from productos inner join categoria on (productos.id_categoria = categoria.id_categoria)";
        String data[]= new String[7];
        Statement st;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while(rs.next()){
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = rs.getString(4);
                data[4] = rs.getString(7);
                modelo.addRow(data);
            }
        }catch(SQLException e){
            System.out.println("Error al mostrar los datos de la BD");
        }
    }
    
    public static void mostrarAlgunos(DefaultTableModel modelo, Producto p) {
        CConexion con = new CConexion();
        Connection cn = con.conectar();
        
        try {
            PreparedStatement ps = cn.prepareStatement("select * from productos p inner join categoria c on (p.id_categoria = c.id_categoria) where p.id_categoria = ?;");
            ps.setInt(1, p.getId_categoria());
            String data[]= new String[7];
            try{
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    data[0] = rs.getString(2);
                    data[1] = rs.getString(3);
                    data[2] = rs.getString(4);
                    data[3] = rs.getString(7);
                    modelo.addRow(data);
                }
            }catch(SQLException e){
                System.out.println("Error al mostrar los datos de la BD");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static DefaultCategoryDataset consultaGrafica(DefaultCategoryDataset dataset, String Fi, String FF) {
        CConexion con = new CConexion();
        Connection cn = con.conectar();
        
        try {
            String sql = """
                         SELECT p.nombre, 
                                COALESCE(SUM(do.cantidad), 0) AS total
                         FROM productos p
                         JOIN detalle_orden do ON p.id_prod = do.id_prod
                         JOIN orden o ON do.id_orden = o.id_orden
                         WHERE o.fecha BETWEEN ? AND ?
                         GROUP BY p.nombre;""";
            
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, Fi);
            pst.setString(2, FF);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int total = rs.getInt("total");
                dataset.setValue(total, "Cantidad", nombre);
            }
            return dataset;
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
