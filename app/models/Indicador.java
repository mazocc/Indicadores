package models;

import formatadores.Formato;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Indicador extends Model {

  @Required
  public String descricao;

  @Required
  public String iniciativa;

  @Enumerated(EnumType.STRING)
  public Formato formato;

  @ManyToMany
  public List<Pessoa> responsaveis;

  @ManyToOne
  @JoinColumn(name = "forca_tarefa_id")
  public ForcaTarefa forcaTarefa;

  @ManyToOne
  @JoinColumn(name = "meta_id", nullable = false)
  public Meta meta;

  @Enumerated(EnumType.STRING)
  public Periodicidade periodicidade;

  @OneToMany(mappedBy = "indicador")
  public List<RegistroIndicador> registros;

  @ManyToOne
  @JoinColumn(name = "objetivo_id", nullable = false)
  public Objetivo objetivo;

  @Override
  public String toString() {
    return id + " - " + descricao;
  }
}
