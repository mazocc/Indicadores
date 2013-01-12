package controllers.administracao;

import controllers.CRUD;
import models.Perspectiva;
import play.db.jpa.Model;

@CRUD.For(Perspectiva.class)
public class PerspectivasCrud extends CRUD {
    protected static ObjectType createObjectType(Class<? extends Model> type) {
        return new HideControlFields(type);
    }
}
