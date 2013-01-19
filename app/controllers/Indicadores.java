package controllers;

import graficos.Grafico;
import graficos.highchart.HighChartValoresIndicadorFactory;
import graficos.highchart.HighChartValoresMetaFactory;
import models.Indicador;
import models.Meta;
import models.Perspectiva;
import play.mvc.Controller;

import java.util.List;

public class Indicadores extends Controller {

  public static void index() {
  }

  public static void listarIndicadores() {
    List<Perspectiva> perspectivas = Perspectiva.findAll();
    render(perspectivas);
  }

  public static void visualizar(Long id) {
    Indicador indicador = Indicador.findById(id);
    Meta meta = indicador.meta;
    Grafico grafico = null;
    render(indicador, meta, grafico);
  }

  public static void visualizarJsonGraficoLinha(Long id) {
    Indicador indicador = Indicador.findById(id);
    Grafico grafico = new HighChartValoresIndicadorFactory(indicador).criaGrafico();
    renderJSON(grafico);
  }

  public static void visualizarJsonGraficoColuna(Long id) {
    Indicador indicador = Indicador.findById(id);
    Grafico grafico = new HighChartValoresMetaFactory(indicador).criaGrafico();
    renderJSON(grafico);
  }

}
