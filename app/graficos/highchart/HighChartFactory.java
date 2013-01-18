package graficos.highchart;

import graficos.inter.Categoria;
import graficos.inter.Eixo;
import graficos.inter.Grafico;
import graficos.inter.Serie;
import models.Indicador;
import models.RegistroIndicador;

import java.util.ArrayList;
import java.util.List;

import static graficos.inter.TipoGrafico.line;
import static play.i18n.Messages.get;

public class HighChartFactory {

  public Indicador indicador;

  public HighChartFactory(Indicador indicador) {
    this.indicador = indicador;
  }

  public Grafico valoresIndicador() {
    Eixo eixoX = new HighChartEixo(criaCategorias());
    Eixo eixoY = new HighChartEixo(new HighChartTitulo(get("valores")));

    return new HighChartGrafico(line, new HighChartTitulo(indicador.descricao), eixoX, eixoY, series());
  }

  private List<Serie> series() {
    List<Serie> series = new ArrayList<Serie>();
    for (Integer i : indicador.anosComRegistro())
      series.add(new HighChartSerie(i.toString()));

    for (RegistroIndicador r : indicador.registrosOrdenados()) {
      for (Serie s : series) {
        if (String.valueOf(r.ano()).equals(s.nome())) s.adiciona(r.valor);
      }
    }

    return series;
  }

  private List<Categoria> criaCategorias() {
    List<Categoria> categorias = new ArrayList<Categoria>(12);
    switch (indicador.periodicidade) {
      case Anual:
        break;
      case Mensal:
        categorias.add(new HighChartCategoria(get("janeiro")));
        categorias.add(new HighChartCategoria(get("fevereiro")));
        categorias.add(new HighChartCategoria(get("marco")));
        categorias.add(new HighChartCategoria(get("abril")));
        categorias.add(new HighChartCategoria(get("maio")));
        categorias.add(new HighChartCategoria(get("junho")));
        categorias.add(new HighChartCategoria(get("julho")));
        categorias.add(new HighChartCategoria(get("agosto")));
        categorias.add(new HighChartCategoria(get("setembro")));
        categorias.add(new HighChartCategoria(get("outubro")));
        categorias.add(new HighChartCategoria(get("novembro")));
        categorias.add(new HighChartCategoria(get("dezembro")));
        break;
    }


    return categorias;
  }

}

