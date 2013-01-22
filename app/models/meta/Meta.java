package models.meta;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import models.indicador.Indicador;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Entity
public class Meta extends Model {

  @Required
  @MinSize(4)
  public String descricao;

  @OneToMany(mappedBy = "meta")
  public List<Indicador> indicadores;

  @OneToMany(mappedBy = "meta")
  public List<ValorAnual> valoresAnuais;

  @Override
  public String toString() {
    return descricao;
  }

  public List<Integer> anosComRegistro() {
    Set<Integer> set = Sets.newHashSet();
    for (ValorAnual v : valoresAnuais) {
      set.add(v.ano);
    }
    List<Integer> list = Lists.newArrayList(set);
    Collections.sort(list);
    return list;
  }
}
