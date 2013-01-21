package models;

import com.google.common.collect.Sets;
import formatadores.Formato;
import org.joda.time.LocalDate;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Entity
public class Indicador extends Model {

  @Required
  public String descricao;

  @ManyToOne
  @JoinColumn(name = "iniciativa_id")
  public Iniciativa iniciativa;

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

  @Enumerated(EnumType.STRING)
  public Ordem ordem;

  @OneToMany(mappedBy = "indicador")
  public List<RegistroIndicador> registros;

  @ManyToOne
  @JoinColumn(name = "objetivo_id", nullable = false)
  public Objetivo objetivo;

  @Override
  public String toString() {
    return id + " - " + descricao;
  }

  public Set<Integer> anosComRegistro() {
    Set<Integer> set = Sets.newHashSet();
    for (RegistroIndicador r : registros) {
      set.add(LocalDate.fromDateFields(r.data).getYear());
    }
    return set;
  }

  public List<RegistroIndicador> registrosOrdenados() {
    Collections.sort(registros);
    return registros;
  }
}
