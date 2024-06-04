package Controlador;

import static Controlador.CtrlProducto.limpiar;
import Modelo.ConsultasUsuario;
import Modelo.Usuario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CtrlUsuario {
    Usuario u = new Usuario();
    ConsultasUsuario cu = new ConsultasUsuario();
    
    public void mostrar(DefaultTableModel modelo) {
        cu.mostrar(modelo);
    }
    
    public void modificar(int id, String n, String tel, int tipo) {
        u.setId_usuario(id);
        u.setNombre(n);
        u.setTelefono(tel);
        u.setId_tipoU(tipo);
        
        if (cu.modificar(u)) {
            JOptionPane.showMessageDialog(null, "Registro modificado");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar");
            limpiar();
        }
    }
    
    public void eliminar(int id) {
        u.setId_usuario(id);
        
        if (cu.eliminar(u)) {
            JOptionPane.showMessageDialog(null, "Registro eliminado");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar");
            limpiar();
        }
    }
    
    public void agregar(String n, String tel, String c) {
        u.setNombre(n);
        u.setTelefono(tel);
        u.setContraseña(c);
        
        if (cu.insertar(u)) {
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar");
            limpiar();
        }
    }
}
