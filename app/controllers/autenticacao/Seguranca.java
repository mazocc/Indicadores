package controllers.autenticacao;

import controllers.Secure;
import models.Pessoa;

public class Seguranca extends Secure.Security {


  static boolean authenticate(String email, String password) {
    Pessoa pessoa = Pessoa.find("byEmail", email).first();
    return pessoa != null && pessoa.senha.equals(password);
  }

  static Pessoa getPessoa() {
    return Pessoa.find("byEmail", session.get("username")).first();
  }
}
