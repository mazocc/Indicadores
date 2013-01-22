package models;

import models.indicador.Indicador;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class ForcaTarefa extends Model {

  public String descricao;

  @ManyToMany
  public List<Pessoa> pessoas;

  @OneToMany(mappedBy = "forcaTarefa")
  List<Indicador> indicadores;

  @Override
  public String toString() {
    return descricao;
  }
}
