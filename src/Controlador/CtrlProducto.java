package Controlador;

import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.Productos;
import Vista.formModificarProducto;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.data.category.DefaultCategoryDataset;

public class CtrlProducto{
    private  static Producto mod = new Producto();
    private static ConsultasProducto modC = new ConsultasProducto();
    private static Productos frm = new Productos();
    private static formModificarProducto frmMod = new formModificarProducto();
    
    public static void mostrarDatos(DefaultTableModel modelo) {
        modC.mostrar(modelo);
    }
    
    public static void mostrarAlgunos(DefaultTableModel modelo, int id) {
        mod.setId_categoria(id);
        modC.mostrarAlgunos(modelo, mod);
    }
    
    public static void registrarProducto(String n, String d, Double p, int c) {
        mod.setNombre(n);
            mod.setDescripcion(d);
            mod.setPrecio(p);
            mod.setId_categoria(c);
            
            if (modC.registrar(mod)){
                JOptionPane.showMessageDialog(null,"Registro guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null,"Error al guardar");
                limpiar();
            }
    }
    
    public static void modificarProducto(int id, String n, String d, Double p, int c) {
        mod.setId_prod(id);
        mod.setNombre(n);
        mod.setDescripcion(d);
        mod.setPrecio(p);
        mod.setId_categoria(c);

        if (modC.modificar(mod)) {
            JOptionPane.showMessageDialog(null, "Registro modificado");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar");
            limpiar();
        }
    }
    
    public static void eliminarProducto(int id) {
        mod.setId_prod(id);

        if (modC.eliminar(mod)) {
            JOptionPane.showMessageDialog(null, "Registro eliminado");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar");
            limpiar();
        }
    }
    
    public static DefaultCategoryDataset consultarProductos(DefaultCategoryDataset dataset, String F, String f) {
        return modC.consultaGrafica(dataset, F, f);
    }       
    
    public static void limpiar() {
        frm.txtNombre.setText("");
        frm.txtDesc.setText("");
        frm.txtPrecio.setText("");
        frm.cboCategoria.setSelectedIndex(0);
    }
}
