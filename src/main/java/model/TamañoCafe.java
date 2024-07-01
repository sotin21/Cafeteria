package model;

public enum TamañoCafe {
    PEQUENO("Pequeño"), MEDIANO("Mediano"), GRANDE("Grande");

    private String tamañoCafe;

    private TamañoCafe(String tamañoCafe) {
        this.tamañoCafe = tamañoCafe;
    }

    public String getTamañoCafe() {
        return tamañoCafe;
    }
}