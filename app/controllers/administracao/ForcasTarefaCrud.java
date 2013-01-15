package controllers.administracao;

import controllers.CRUD;
import models.ForcaTarefa;
import play.db.jpa.Model;

@CRUD.For(ForcaTarefa.class)
public class ForcasTarefaCrud extends CRUD {
  protected static ObjectType createObjectType(Class<? extends Model> type) {
    return new HideControlFields(type);
  }
}
