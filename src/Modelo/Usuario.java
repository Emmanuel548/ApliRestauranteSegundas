package Modelo;

public class Usuario {
    private int id_usuario;
    private String nombre;
    private String telefono;
    private String contraseña;
    private int id_tipoU;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getId_tipoU() {
        return id_tipoU;
    }

    public void setId_tipoU(int id_tipoU) {
        this.id_tipoU = id_tipoU;
    }
}
