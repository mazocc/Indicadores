package graficos.highchart;

import graficos.Categoria;
import graficos.Grafico;
import graficos.GraficoFactory;
import graficos.Serie;
import models.indicador.Indicador;
import models.indicador.RegistroIndicador;

import java.util.ArrayList;
import java.util.List;

import static graficos.TipoGrafico.line;
import static play.i18n.Messages.get;

public class HighChartValoresIndicadorFactory implements GraficoFactory {

  public Indicador indicador;

  public HighChartValoresIndicadorFactory(Indicador indicador) {
    this.indicador = indicador;
  }

  @Override
  public Grafico criaGrafico() {
    HighChartEixo eixoX = new HighChartEixo(criaCategorias());
    HighChartEixo eixoY = new HighChartEixo(new HighChartTitulo(get("valores")));
    eixoY.formato = indicador.formato;

    return new HighChartGrafico(line, new HighChartTitulo(get("acompanhamento.mensal")), eixoX, eixoY, series(), indicador.ordem);
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

