package graficos.highchart;

import graficos.inter.Categoria;
import graficos.inter.Eixo;
import graficos.inter.Grafico;
import graficos.inter.Serie;
import models.Indicador;

import java.util.ArrayList;
import java.util.Arrays;
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

    series.add(new HighChartSerie("2010", Arrays.<Double>asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0)));
    series.add(new HighChartSerie("2011", Arrays.<Double>asList(10.0, 20.0, 30.0, 40.0, 50.0, 60.0, 70.0, 80.0, 90.0, 100.0, 110.0, 120.0)));

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

