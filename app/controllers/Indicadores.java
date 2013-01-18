package controllers;

import graficos.highchart.HighChartFactory;
import graficos.inter.Grafico;
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

  public static void visualizarJson(Long id) {
    Indicador indicador = Indicador.findById(id);
    Grafico grafico = new HighChartFactory(indicador).valoresIndicador();
    renderJSON(grafico);
  }

}
