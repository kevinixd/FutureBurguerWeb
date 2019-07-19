package dao;

import interfaces.EmpleadosInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Empleados;

public class DaoEmpleados implements EmpleadosInterface {
    
    Conexion cn = new Conexion();
    PreparedStatement ejecutar;
    ResultSet resultado;
    
    private String sql = null;
    
    @Override
    public Empleados confirmarUsuario(Empleados empleado) {
        Empleados emp = new Empleados();
        try {            
            cn.abrirConexion();
            sql = "select * from empleados where correo=? and contrasenia=MD5(?)";
            ejecutar = cn.getCon().prepareStatement(sql);
            ejecutar.setString(1, empleado.getCorreo());
            ejecutar.setString(2, empleado.getPassword());
            resultado = ejecutar.executeQuery();
            resultado.next();
            emp = new Empleados();
            emp.setCorreo(resultado.getString("correo"));
            emp.setNombre(resultado.getString("nombre"));
            emp.setPassword(resultado.getString("contrasenia"));
            emp.setTipo_empleado(resultado.getByte("tipoempleado_id"));
            resultado.close();
        } catch (Exception e) {
            System.out.println("Error al leer datos: " + e);
            emp.setCorreo(null);
        } finally {
            cn.cerrarConexion();
        }
        return emp;
    }
    
}
