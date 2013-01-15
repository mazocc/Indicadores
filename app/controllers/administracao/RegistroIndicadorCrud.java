package controllers.administracao;

import controllers.CRUD;
import models.RegistroIndicador;
import play.db.jpa.Model;

@CRUD.For(RegistroIndicador.class)
public class RegistroIndicadorCrud extends CRUD {
  protected static ObjectType createObjectType(Class<? extends Model> type) {
    return new HideControlFields(type);
  }
}
