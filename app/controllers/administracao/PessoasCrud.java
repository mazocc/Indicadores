package controllers.administracao;

import controllers.CRUD;
import models.Pessoa;
import play.db.jpa.Model;

@CRUD.For(Pessoa.class)
public class PessoasCrud extends CRUD {
  protected static ObjectType createObjectType(Class<? extends Model> type) {
    return new HideControlFields(type);
  }
}
