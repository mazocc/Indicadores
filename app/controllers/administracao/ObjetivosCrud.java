package controllers.administracao;

import controllers.CRUD;
import models.Objetivo;
import play.db.jpa.Model;

@CRUD.For(Objetivo.class)
public class ObjetivosCrud extends CRUD {
    protected static ObjectType createObjectType(Class<? extends Model> type) {
        return new HideControlFields(type);
    }
}
