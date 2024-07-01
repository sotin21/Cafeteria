package model.data.dao;

import model.Cafe;
import model.TamanioCafe;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.VARCHAR;
public class CafeDAO {
    public static void agregarCafe(DSLContext query, Cafe cafe){
        Table tablaCafe= table(name("Cafe"));
        Field[] columnas = tablaCafe.fields("cantidad_gramos_cafe","cantidad_mililitros_agua","tamanio_cafe");
        query.insertInto(tablaCafe, columnas[0], columnas[1],columnas[2])
                .values(cafe.getCantidadGramosCafe(),cafe.getCantidadMililitrosAgua(),cafe.getTamanioCafe().getTamanioCafe())
                .execute();
    }

    public static boolean validarExistenciaCafe(DSLContext query,String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Cafe")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        if(resultados.size()>=1){
            return true;
        }
        else{
            return false;
        }
    }

    // Obtener una lista de cafés de la cafetería de acuerdo a algún tamaño y mostrarlos.
    public static List obtenerListaCafes(Result resultados){
        List<Cafe> cafes= new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            String nombreCafe = (String) resultados.getValue(fila,"nombre_cafe");
            int cantidadGramosCafe = (int) resultados.getValue(fila,"cantidad_gramos_cafe");
            int cantidadMililitrosAgua = (int) resultados.getValue(fila,"cantidad_mililitros_agua");
            String tamanioCafe = (String) resultados.getValue(fila,"tamanio_cafe");
            cafes.add(new Cafe(nombreCafe,cantidadGramosCafe,cantidadMililitrosAgua, TamanioCafe.valueOf(tamanioCafe)));
        }
        return cafes;
    }

    // obtener cafes
    public static String[][] obtenerListaCafes(DSLContext query){
        Result resultados = query.select().from(DSL.table("Cafe")).fetch();
        return exportarDatos(resultados);
    }


    public static List obtenerCafe(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Cafe")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaCafes(resultados);
    }

    // Obtener una lista de cafés de la cafetería de acuerdo a algún tamaño y mostrarlos.
    public static String[][] obtenerCafesTamanio(DSLContext query, String tamanio){
        Table tablaCafe= table(name("Cafe"));
        Table tablaTamanio= table(name("TamanioCafe"));
        Result resultados = query.select().from(tablaCafe).join(tablaTamanio).on(DSL.field("tamanio_cafe").eq(DSL.field("tamanio_cafe")))
                .where(DSL.field("tamanio_cafe").eq(tamanio)).fetch();
        return exportarDatos(resultados);
    }

    // obtenerCafeNombre
    public static String[][] obtenerCafeNombre(DSLContext query, String nombre){
        Table tablaCafe= table(name("Cafe"));
        Table tablaNombre= table(name("nombre_cafe"));
        Result resultados = query.select().from(tablaCafe).join(tablaNombre).on(DSL.field("nombre_cafe").eq(DSL.field("nombre_cafe")))
                .where(DSL.field("nombre_cafe").eq(nombre)).fetch();
        return exportarDatos(resultados);
    }


    // Descontinuar un café de la cafetería.
    public void eliminarCafe(DSLContext query, String nombreCafe){
        Table tablaCafe= table(name("Cafe"));
        query.delete(DSL.table("Cafe")).where(DSL.field("nombre_cafe").eq(nombreCafe)).execute();
    }



    // exportar datos
    private static String[][] exportarDatos(Result resultados){
        String[][] datosResultado=new String[resultados.size()][3];
        for(int registro = 0; registro < resultados.size(); registro ++){
            datosResultado[registro][0] = (String) resultados.getValue(registro,"cantidad_gramos_cafe");
            datosResultado[registro][1] = (String) resultados.getValue(registro,"cantidad_mililitros_agua");
            datosResultado[registro][2] = (String) resultados.getValue(registro,"tamanio_cafe");
        }
        return datosResultado;
    }

}