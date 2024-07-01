package model;

public enum Ingrediente {
    CREMA("Crema"), LECHE("Leche"), CHOCOLATE("Chocolate");

    private String ingrediente;

    private Ingrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public String getIngrediente() {
        return ingrediente;
    }
}