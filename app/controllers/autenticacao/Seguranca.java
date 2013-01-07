package controllers.autenticacao;

import controllers.Secure;
import models.Pessoa;

public class Seguranca extends Secure.Security {

  static boolean authenticate(String username, String password) {
    Pessoa pessoa = Pessoa.find("byEmail", username).first();
    return pessoa != null && pessoa.senha.equals(password);
  }
}
