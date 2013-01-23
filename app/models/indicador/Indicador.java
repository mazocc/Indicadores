package models.indicador;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import formatadores.Formato;
import models.ForcaTarefa;
import models.Iniciativa;
import models.Objetivo;
import models.Pessoa;
import models.enumeracoes.Ordem;
import models.enumeracoes.Periodicidade;
import models.meta.Meta;
import org.joda.time.LocalDate;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

  @OneToMany(mappedBy = "indicador")
  public List<ReferencialComparativo> referenciaisComparativos;

  @OneToMany(mappedBy = "indicador")
  public List<TotalRealizado> totaisRealizados;

  @ManyToOne
  @JoinColumn(name = "objetivo_id", nullable = false)
  public Objetivo objetivo;

  @Override
  public String toString() {
    return descricao;
  }

  public List<Integer> anosComRegistro() {
    Collection<Integer> set = Sets.newLinkedHashSet();
    for (RegistroIndicador r : registros) {
      set.add(LocalDate.fromDateFields(r.data).getYear());
    }
    List<Integer> list = Lists.newArrayList(set);
    Collections.sort(list);
    return list;
  }

  public List<RegistroIndicador> registrosOrdenados() {
    Collections.sort(registros);
    return registros;
  }

  public RegistroIndicador pegaOuCriaRegistro(int ano, int mes) throws ParseException {
    for (RegistroIndicador r : registros) {
      if (r.ano() == ano && r.mes() == mes) return r;
    }

    RegistroIndicador r = new RegistroIndicador();
    r.data = new SimpleDateFormat("yyyy-MM-dd").parse(String.format("%s-%s-%s", ano, mes, "01"));
    r.indicador = this;
    registros.add(r);
    r.valor = 0;
    r.save();
    return r;
  }

  public TotalRealizado pegaOuCriaTotalRealizado(int ano) {
    for (TotalRealizado r : totaisRealizados) {
      if (r.ano == ano) return r;
    }

    TotalRealizado r = new TotalRealizado();
    r.ano = ano;
    r.indicador = this;
    totaisRealizados.add(r);
    r.valor = 0;
    r.save();
    return r;
  }

  public ReferencialComparativo pegaOuCriaReferencialComparativo(int ano) {
    for (ReferencialComparativo r : referenciaisComparativos) {
      if (r.ano == ano) return r;
    }

    ReferencialComparativo r = new ReferencialComparativo();
    r.ano = ano;
    r.indicador = this;
    referenciaisComparativos.add(r);
    r.valor = 0;
    r.save();
    return r;
  }
}
