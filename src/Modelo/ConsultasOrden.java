package Modelo;

import Conexion.CConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultasOrden extends CConexion{
    
    CConexion con = new CConexion();
    Connection cn = con.conectar();
        
    public void mostrar (DefaultTableModel modelo) {
        String consulta = "select * from orden inner join usuarios on (orden.id_usuario = usuarios.id_usuario);";
        String data[]= new String[5];
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
    
    public boolean actualizar(Orden o) {
        try {
                PreparedStatement pss = cn.prepareStatement("update orden set total=? where id_orden=? ");
                pss.setDouble(1, o.getTotal());
                pss.setInt(2, o.getId_orden());
                pss.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println("Error al actualizar en la BD " + e);
                return false;
            }
    }
    
    public boolean eliminar(Orden o) {
        try{
            PreparedStatement ps = cn.prepareStatement("delete from orden where id_orden = ?");
            ps.setInt(1, o.getId_orden());
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println("Error al eliminar la orden en la BD"+ e.toString());
            return false;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error","Advertencia",JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    public String[] obtenerUltimoRegistro() {
        String consult = "SELECT id_orden, fecha, no_mesa FROM orden ORDER BY id_orden DESC LIMIT 1;";
        String datos[] = new String[3];
        Statement st;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(consult);
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
            }
            return datos;
        }catch(SQLException e){
            System.out.println("Error al iniciar sesión");
            return null;
        }
    }
    
    public Double mostrarDetalles(DefaultTableModel modelo, Orden o) {
        try {
            String consulta = "select * from detalle_orden inner join productos on (detalle_orden.id_prod = productos.id_prod) where detalle_orden.id_orden = ?;";
            PreparedStatement ps = cn.prepareStatement(consulta);
            ps.setInt(1, o.getId_orden());
            String data[]= new String[3];
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                data[0] = rs.getString(7);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                modelo.addRow(data);
            }
            
            //Consultar columna de subtotal y mostrar total
            try {
                String cons = "select sum(subtotal) as total from Detalle_orden where id_orden = ?;";
                PreparedStatement ppss = cn.prepareStatement(cons);
                ppss.setInt(1, o.getId_orden());
                ResultSet rrs = ppss.executeQuery();
                double sumaSubtotal = 0;
                if (rrs.next()) 
                    sumaSubtotal = rrs.getDouble("total");
                return sumaSubtotal;
            }catch(SQLException e){
                System.out.println("Error al calcular los datos de la BD");
                return null;
            }
            
        }catch(SQLException e){
            System.out.println("Error al mostrar los datos de la BD");
            return null;
        }
    }
}
