package controllers.administracao;

import controllers.CRUD;
import models.ValorAnual;
import play.db.jpa.Model;

@CRUD.For(ValorAnual.class)
public class ValorAnualCrud extends CRUD {
    protected static ObjectType createObjectType(Class<? extends Model> type) {
        return new HideControlFields(type);
    }
}
