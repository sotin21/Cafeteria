package model.data.dao;

import model.*;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class CafeteriaDAO {
    // Modificar información de la cafetería para mantenerse actualizados. como nombreCafeteria y direccionCafeteria
    public void modificarCafeteria(DSLContext query, String nombreCafeteria, String direccionCafeteria){
        query.update(DSL.table("Cafeteria")).set(DSL.field("nombre_cafeteria"),nombreCafeteria)
                .set(DSL.field("direccion_cafeteria"),direccionCafeteria).execute();
    }

}