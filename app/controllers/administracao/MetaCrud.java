package controllers.administracao;

import controllers.CRUD;
import models.Meta;
import play.db.jpa.Model;

@CRUD.For(Meta.class)
public class MetaCrud extends CRUD {
    protected static ObjectType createObjectType(Class<? extends Model> type) {
        return new HideControlFields(type);
    }
}
