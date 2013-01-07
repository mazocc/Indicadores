package models;

import play.data.validation.Email;
import play.data.validation.Password;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Pessoa extends Model {

  @Required
  public String nome;

  @Email
  @Required
  @Unique
  public String email;

  @Required
  @Password
  public String senha;

}
