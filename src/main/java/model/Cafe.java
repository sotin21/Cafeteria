package model;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    // atributos
    private String nombreCafe;
    private int cantidadGramosCafe;
    private int getCantidadMililitrosAgua;
    private TamañoCafe tamañoCafe;
    private List<Ingredientes> ingredientes;

    // constructor
    public Cafe(String nombreCafe, int cantidadGramosCafe, int getCantidadMililitrosAgua, TamañoCafe tamañoCafe) {
        this.nombreCafe = nombreCafe;
        this.cantidadGramosCafe = cantidadGramosCafe;
        this.getCantidadMililitrosAgua = getCantidadMililitrosAgua;
        this.tamañoCafe = tamañoCafe;
        this.ingredientes = new ArrayList<Ingredientes>();
    }

    // getters
    public String getNombreCafe() {
        return nombreCafe;
    }
    public int getCantidadGramosCafe() {
        return cantidadGramosCafe;
    }
    public int getCantidadMililitrosAgua() {
        return getCantidadMililitrosAgua;
    }
    public TamañoCafe getTamañoCafe() {
        return tamañoCafe;
    }
    public List<Ingredientes> getIngredientes() {
        return ingredientes;
    }

    @Override
    public String toString() {
        return "Cafe [nombreCafe=" + nombreCafe + ", cantidadGramosCafe=" + cantidadGramosCafe + ", cantidadMililitrosAgua="
                + getCantidadMililitrosAgua + ", tamañoCafe=" + tamañoCafe + ", ingredientes=" + ingredientes + "]";
    }
}