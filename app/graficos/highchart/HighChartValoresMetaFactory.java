package graficos.highchart;

import graficos.*;
import models.Indicador;
import models.RegistroIndicador;
import models.ValorAnual;

import java.util.ArrayList;
import java.util.List;

import static graficos.TipoGrafico.column;
import static java.lang.String.valueOf;
import static play.i18n.Messages.get;

public class HighChartValoresMetaFactory implements GraficoFactory {

  public Indicador indicador;

  public HighChartValoresMetaFactory(Indicador indicador) {
    this.indicador = indicador;
  }

  @Override
  public Grafico criaGrafico() {
    Eixo eixoX = new HighChartEixo(criaCategorias());
    HighChartEixo eixoY = new HighChartEixo(new HighChartTitulo(get("valores")));
    eixoY.formato = indicador.formato;

    return new HighChartGrafico(column, new HighChartTitulo(get("acompanhamento.anual")), eixoX, eixoY, series(), indicador.ordem);
  }

  private List<Serie> series() {
    List<Serie> series = new ArrayList<Serie>();

    series.add(new HighChartSerie(get("meta.anual")));
    series.add(new HighChartSerie(get("total.realizado")));
    series.add(new HighChartSerie(get("ref.comp")));

    for (ValorAnual v : indicador.meta.valoresAnuais) {
      series.get(0).adiciona(v.valor);
    }

    for (int ano : indicador.meta.anosComRegistro()) {
      double valorAcumuladoAno = 0;
      for (RegistroIndicador r : indicador.registros) {
        if (r.ano() == ano) valorAcumuladoAno += r.valor;
      }
      series.get(1).adiciona(valorAcumuladoAno);
    }

    return series;
  }

  private List<Categoria> criaCategorias() {
    List<Categoria> categorias = new ArrayList<Categoria>(10);
    for (ValorAnual v : indicador.meta.valoresAnuais)
      categorias.add(new HighChartCategoria(get("ano") + " " + valueOf(v.ano)));
    return categorias;
  }

}

