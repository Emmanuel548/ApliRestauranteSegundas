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
            PreparedStatement ps = cn.prepareStatement("select * from detalle_orden where id_orden = ? and id_prod = ?;");
            ps.setInt(1, d.getId_orden());
            ps.setInt(2, d.getId_prod());
            String data[] = new String[5];
            try{
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    data[0] = rs.getString(1);
                    data[1] = rs.getString(2);
                    data[2] = rs.getString(3);
                    data[3] = rs.getString(4);
                    data[4] = rs.getString(5);
                }
                if (data[0] == null) {
                    try {
                        PreparedStatement pss = cn.prepareStatement("insert into detalle_orden (cantidad, subtotal, id_prod, id_orden) values (?, ?, ?, ?);");
                        pss.setInt(1, d.getCantidad());
                        pss.setDouble(2, d.getSubtotal());
                        pss.setInt(3, d.getId_prod());
                        pss.setInt(4, d.getId_orden());
                        pss.executeUpdate();
                        return true;
                    } catch (SQLException e) {
                        System.out.println("Error al insertar los productos en la BD" + e.toString());
                        return false;
                    }
                } else {
                    int cant = Integer.parseInt(data[1]);
                    double sub = Double.parseDouble(data[2]);
                    int id = Integer.parseInt(data[0]);
                    d.setId_detalleOrden(id);
                    d.setCantidad(cant + d.getCantidad());
                    d.setSubtotal(sub + d.getSubtotal());
                    return actualizar(d);
                }
            }catch(SQLException e){
                System.out.println("Error al traer los datos de la BD");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    } 
    public boolean actualizar(detalleOrden d) {
        CConexion con = new CConexion();
        Connection cn = con.conectar();
    
        try {
            int id = d.getId_detalleOrden();
            PreparedStatement ps = cn.prepareStatement("update detalle_orden set cantidad = ?, subtotal = ? where id_detalleOrden = ?;");
            ps.setInt(1, d.getCantidad());
            ps.setDouble(2, d.getSubtotal());
            ps.setInt(3, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el detalle de orden en la BD " + e);
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
