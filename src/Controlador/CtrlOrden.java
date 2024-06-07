package Controlador;

import Modelo.ConsultasDetalleOrden;
import Modelo.ConsultasOrden;
import Modelo.Orden;
import Modelo.detalleOrden;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CtrlOrden {
    private static ConsultasOrden co = new ConsultasOrden();
    private static Orden o = new Orden();
    private static ConsultasDetalleOrden con = new ConsultasDetalleOrden();
    private static detalleOrden or = new detalleOrden();
    
    public static void mostrar(DefaultTableModel modelo){
        co.mostrar(modelo);
    }
    
    public static void eliminar(int id) {
        o.setId_orden(id);
        
        CtrlDetalleOrden dto = new CtrlDetalleOrden();
        
        if(co.eliminar(o) && dto.eliminar(id)){
            JOptionPane.showMessageDialog(null,"Orden cancelada");
        } else {
            JOptionPane.showMessageDialog(null,"Error al cancelar");
        }
    }
    
    public static void actualizarOrden(int id_orden, double total) {
        o.setId_orden(id_orden);
        o.setTotal(total);
        
        if(co.actualizar(o))
            JOptionPane.showMessageDialog(null, "Pedido realizado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        else{
            JOptionPane.showMessageDialog(null, "Error al registrar pedido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static String[] mostrarUltimoRegistro() {
        return co.obtenerUltimoRegistro();
    }
    
    public static Double mostrarDetalles(DefaultTableModel modelo, int id) {
        o.setId_orden(id);
        return co.mostrarDetalles(modelo, o);
    }
    public static double mostrarTotal(int id){
        or.setId_orden(id);
        return con.consultarTotal(or);
    }
}