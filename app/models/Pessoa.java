package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Pessoa extends Model {

    @NotNull
    public String nome;

}
