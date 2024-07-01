package controller;

import model.Cafe;
import model.TamanioCafe;
import model.TamañoCafe;
import model.data.dao.CafeDAO;
import model.data.DBConnector;
import model.data.DBGenerator;
import org.jooq.DSLContext;

public class CafeController {

    private static String nombreDataBase = "cafeteria";

    // agregarCafe
    public static boolean agregarCafe(String nombreCafe, int cantidadGramosCafe, int cantidadMililitrosAgua, TamañoCafe tamanioCafe) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD(nombreDataBase);
        if(!CafeDAO.validarExistenciaCafe(query,"nombre_cafe",nombreCafe)){
            Cafe cafe = new Cafe(nombreCafe,cantidadGramosCafe,cantidadMililitrosAgua, tamanioCafe);
            CafeDAO.agregarCafe(query,cafe);
            DBConnector.closeConnection();
            return true;
        }
        else{
            DBConnector.closeConnection();
            return false;
        }
    }

    // mostrarCafesPorTamanio
    public static String[][] mostrarCafesPorTamanio(String tamanio) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD(nombreDataBase);
        String[][] datosCafes = CafeDAO.obtenerCafesTamanio(query,tamanio);
        DBConnector.closeConnection();
        return datosCafes;
    }

    // mostrarCafesPorNombre
    public static String[][] mostrarCafesPorNombre(String nombre) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD(nombreDataBase);
        String[][] datosCafes = CafeDAO.obtenerCafeNombre(query,nombre);
        DBConnector.closeConnection();
        return datosCafes;
    }

    // mostrarlistaCafes
    public static String[][] obtenerListaCafes() throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD(nombreDataBase);
        String[][] datosCafes = CafeDAO.obtenerListaCafes(query);
        DBConnector.closeConnection();
        return datosCafes;
    }