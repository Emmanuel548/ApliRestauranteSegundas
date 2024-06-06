package Controlador;

import Modelo.ConsultasDetalleOrden;
import Modelo.detalleOrden;
import javax.swing.JOptionPane;

public class CtrlDetalleOrden {
    detalleOrden dOr = new detalleOrden();
    ConsultasDetalleOrden cdo = new ConsultasDetalleOrden();
    
    public void agregarDetalleOrden(int cant, double subt, int id_prod, int id_orden) {
        dOr.setCantidad(cant);
        dOr.setSubtotal(subt);
        dOr.setId_prod(id_prod);
        dOr.setId_orden(id_orden);
        
        if (cdo.agregarDetalleOrden(dOr))
            JOptionPane.showMessageDialog(null,"Datos guardados correctamente.");
        else 
            JOptionPane.showMessageDialog(null,"Error al guardar");
    }
    
    public double consultarTotal(int id) {
        dOr.setId_orden(id);
        return cdo.consultarTotal(dOr);
    }
    
    public boolean eliminar(int id){
        dOr.setId_orden(id);
        
        if(cdo.eliminar(dOr)){
            return true;
        } else {
            return false;
        }
    }
}
