package gui;

import controller.CafeController;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.text.InternationalFormatter;

public class VentanaBienvenida extends Ventana{
    public static void main(String[] args) {
        VentanaBienvenida ventana = new VentanaBienvenida();
    }

    JLabel textoEncabezado;
    JButton botonAgregarCafe, botonDescontinuarCafe, botonVerCafes, botonSalir;

    public VentanaBienvenida() {
        super("Bienvenida", 500, 520);
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarEncabezado();
        generarBotonAgregarCafe();
        generarBotonDescontinuarCafe();
        generarBotonVerCafes();
        generarBotonSalir();

    }

    private void generarEncabezado() {
        super.generarJLabelEncabezado(this.textoEncabezado, "Bienvenido a la cafeteria", 130, 10, 300, 50);
    }

    private void generarBotonAgregarCafe() {
        this.botonAgregarCafe = super.generarBoton("Agregar Cafe", 150, 100, 200, 50);
        this.botonAgregarCafe.addActionListener(this);
        this.add(this.botonAgregarCafe);
    }

    private void generarBotonDescontinuarCafe() {
        this.botonDescontinuarCafe = super.generarBoton("Descontinuar Cafe", 150, 160, 200, 50);
        this.botonDescontinuarCafe.addActionListener(this);
        this.add(this.botonDescontinuarCafe);
    }

    private void generarBotonVerCafes() {
        this.botonVerCafes = super.generarBoton("Ver Cafes", 150, 220, 200, 50);
        this.botonVerCafes.addActionListener(this);
        this.add(this.botonVerCafes);
    }

    private void generarBotonSalir() {
        this.botonSalir = super.generarBoton("Salir", 150, 380, 200, 50);
        this.botonSalir.addActionListener(this);
        this.add(this.botonSalir);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonAgregarCafe) {
            VentanaAgregarCafe ventanaAgregarCafe = new VentanaAgregarCafe();
            this.dispose();
        }
        if (e.getSource() == this.botonDescontinuarCafe) {
            DescontinuarCafe ventanaDescontinuarCafe = new DescontinuarCafe();
            this.dispose();
        }
        if (e.getSource() == this.botonVerCafes) {
            CafeController cafeController = new CafeController();
            String[][] cafes = new String[0][];
            try {
                cafes = cafeController.obtenerListaCafes();
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            String[] columnas = {"Nombre", "Cantidad Gramos", "Cantidad Mililitros", "Tamanio"};
            VentanaTabla ventanaTabla = new VentanaTabla(cafes, columnas);
        }
        if (e.getSource() == this.botonSalir) {
            System.exit(0);
        }
    }


}