package models;

import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Objetivo extends Model {

  @Required
  @MinSize(4)
  public String descricao;

  @ManyToOne
  @JoinColumn(name = "perspectiva_id", nullable = false)
  @Required
  public Perspectiva perspectiva;

  @OneToMany(mappedBy = "objetivo")
  public List<Indicador> indicadores;

  @Override
  public String toString() {
    return id + " - " + descricao;
  }
}
