package controllers.administracao;

import controllers.CRUD;
import models.Indicador;
import play.db.jpa.Model;

@CRUD.For(Indicador.class)
public class IndicadorCrud extends CRUD {
    protected static ObjectType createObjectType(Class<? extends Model> type) {
        return new HideControlFields(type);
    }
}
