package models;

import models.indicador.Indicador;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Iniciativa extends Model {

  @Required
  public String descricao;

  @OneToMany(mappedBy = "iniciativa")
  public List<Indicador> indicadores;

  @Override
  public String toString() {
    return descricao;
  }
}
