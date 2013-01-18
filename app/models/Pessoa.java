package models;

import play.data.validation.*;
import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Pessoa extends Model {

  @Required
  @MinSize(2)
  public String nome;

  @Email
  @Required
  @Unique
  public String email;

  @Required
  @Password
  public String senha;

  @Override
  public String toString() {
    return nome;
  }
}
