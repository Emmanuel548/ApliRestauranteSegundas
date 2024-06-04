package Modelo;

import Conexion.CConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class ConsultasDetalleOrden {
    
    public boolean agregarDetalleOrden(detalleOrden d) {
        CConexion con = new CConexion();
        Connection cn = con.conectar();
        
        try {
            PreparedStatement ps = cn.prepareStatement("insert into detalle_orden (cantidad, subtotal, id_prod, id_orden) values (?, ?, ?, ?);");
            ps.setInt(1, d.getCantidad());
            ps.setDouble(2, d.getSubtotal());
            ps.setInt(3, d.getId_prod());
            ps.setInt(4, d.getId_orden());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar los productos en la BD" + e.toString());
            return false;
        } 
    } 
    
    public double consultarTotal(detalleOrden dor) {
        CConexion con = new CConexion();
        Connection cn = con.conectar();
        double total = -0.1;
        try {
            String consulta = "select sum(subtotal) as total from Detalle_orden where id_orden = ?;";
            PreparedStatement ps = cn.prepareStatement(consulta);
            ps.setInt(1, dor.getId_orden());
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                total = rs.getDouble("total");
            return total;
        }catch(SQLException e){
            System.out.println("Error al calcular los datos de la BD");
            return total;
        }
    }
    
    public boolean eliminar(detalleOrden dto) {
        CConexion con = new CConexion();
        Connection cn = con.conectar();
        
        try{
            PreparedStatement ps = cn.prepareStatement("delete from detalle_orden where id_orden = ?");
            ps.setInt(1, dto.getId_orden());
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println("Error al eliminar el detalle de orden en la BD"+ e.toString());
            return false;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error","Advertencia",JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
}
