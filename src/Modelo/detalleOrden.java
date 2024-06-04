package Modelo;

public class detalleOrden {
    private int id_detalleOrden, cantidad, id_prod, id_orden;
    private double subtotal;

    public int getId_detalleOrden() {
        return id_detalleOrden;
    }

    public void setId_detalleOrden(int id_detalleOrden) {
        this.id_detalleOrden = id_detalleOrden;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
