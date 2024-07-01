package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.text.InternationalFormatter;

public class DescontinuarCafe extends Ventana{
    public static void main(String[] args) {
        DescontinuarCafe ventana = new DescontinuarCafe();
    }

    private JButton botonDescontinuarCafe, botonRegresar;
    private JLabel textoEncabezado, textoNombreCafe;
    private JTextField campoNombreCafe;

    public DescontinuarCafe() {
        super("Descontinuar Cafe", 500, 300);
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarEncabezado();
        generarCampoNombreCafe();
        generarBotonDescontinuarCafe();
        generarBotonRegresar();
    }

    private void generarEncabezado() {
        super.generarJLabelEncabezado(this.textoEncabezado, "Descontinuar Cafe", 20, 20, 200, 20);
    }

    private void generarCampoNombreCafe() {
        String textoNombreCafe = "Nombre Cafe:";
        super.generarJLabel(this.textoNombreCafe, textoNombreCafe, 20, 50, 150, 20);
        this.campoNombreCafe = super.generarJTextField(200, 50, 250, 20);
        this.add(this.campoNombreCafe);
    }

    private void generarBotonDescontinuarCafe() {
        this.botonDescontinuarCafe = super.generarBoton("Descontinuar Cafe", 20, 100, 150, 20);
        this.botonDescontinuarCafe.addActionListener(this);
        this.add(this.botonDescontinuarCafe);
    }

    private void generarBotonRegresar() {
        this.botonRegresar = super.generarBoton("Regresar", 200, 100, 150, 20);
        this.botonRegresar.addActionListener(this);
        this.add(this.botonRegresar);
    }

    // eliminarCafe
    private boolean eliminarCafe() throws ClassNotFoundException {
        return false;
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonDescontinuarCafe) {
            try {
                if (eliminarCafe()) {
                    JOptionPane.showMessageDialog(this, "Cafe eliminado correctamente");
                    VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Cafe no encontrado");
                }
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == this.botonRegresar) {
            VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
            this.dispose();
        }
    }

}