/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DaoEmpleados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Empleados;
import vista.JfrmLogin;
import vista.JfrmPrincipal;

/**
 *
 * @author javam2019
 */
public class EmpleadoControlador implements ActionListener {

    JfrmLogin fromLogin;
    DaoEmpleados dao = new DaoEmpleados();
    Empleados emp = new Empleados();

    private int comprobarCampos = 0;
    private boolean verificar = false;

    public EmpleadoControlador(JfrmLogin fromLogin) {
        this.fromLogin = fromLogin;
        fromLogin.jBtnEntrar.addActionListener(this);
        fromLogin.jLblError.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fromLogin.jBtnEntrar) {
            validarCampos();
            verificarUsuario();
            System.out.println(comprobarCampos);
        }
    }

    public void datos() {
        emp.setCorreo(String.valueOf(fromLogin.jTxtUser.getText()));
        emp.setPassword(String.valueOf(fromLogin.jTxtPass.getText()));
    }

    /* public void verificarDatos(){
        Empleados empleados = new Empleados();
        datos();
        empleados = dao.confirmarUsuario(emp);
        
        if (empleados.getCorreo() != null) {
            JOptionPane.showMessageDialog(null,"Bienvenido");
        } else {
            JOptionPane.showMessageDialog(null, "Datos incorrectos");
        }
    }*/
    public void verificarUsuario() {
        if (verificar == false) {
            Empleados p = new Empleados();
            datos();
            p = dao.confirmarUsuario(emp);

            //Se verifican si los datos son correctos
            if ((p.getNombre() != null) && (p.getTipo_empleado() == 1)) {
                JfrmPrincipal vista = new JfrmPrincipal();
                vista.setVisible(true);
                
                vista.jLblUsuario.setText(p.getNombre());
                vista.setLocationRelativeTo(null);
                fromLogin.hide();
            } else if ((p.getNombre() != null) && (p.getTipo_empleado() == 2)) {
                JOptionPane.showMessageDialog(fromLogin, "No tiene accesso al sistema");
            } else {
                JOptionPane.showMessageDialog(fromLogin, "Datos Incorrectos");
            }
        }

    }

    public void validarCampos() {
        comprobarCampos = 0;
        if (fromLogin.jTxtUser.getText().isEmpty() && fromLogin.jTxtPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(fromLogin, "Campo contraseña y usuario requerido");
            comprobarCampos++;

        } else if (fromLogin.jTxtPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(fromLogin, "Campo Contraseña requerido");
            comprobarCampos++;

        } else if (fromLogin.jTxtUser.getText().isEmpty()) {
            JOptionPane.showMessageDialog(fromLogin, "Campos usuario requerido");
            comprobarCampos++;
        } else if (!fromLogin.jTxtUser.getText().contains("@") || !fromLogin.jTxtUser.getText().contains(".")) {
            fromLogin.jLblError.setText("Correo Invalido");
            comprobarCampos++;
        }else{
            fromLogin.jLblError.setText(" ");
        }

        if (comprobarCampos != 0) {
            verificar = true;
        } else {
            verificar = false;
        }
    }

}
