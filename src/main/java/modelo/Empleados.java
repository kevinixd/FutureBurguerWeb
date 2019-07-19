/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author javam2019
 */
public class Empleados {

    private String nombre;
    private String correo;
    private String password;
    private byte tipo_empleado;

    public Empleados(String nombre, String correo, String password, byte tipo_empleado) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.tipo_empleado = tipo_empleado;
    }

    

    public Empleados() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getTipo_empleado() {
        return tipo_empleado;
    }

    public void setTipo_empleado(byte tipo_empleado) {
        this.tipo_empleado = tipo_empleado;
    }
    
    
}
