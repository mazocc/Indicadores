package controllers;

import graficos.Grafico;
import graficos.highchart.HighChartValoresIndicadorFactory;
import graficos.highchart.HighChartValoresMetaFactory;
import models.Perspectiva;
import models.indicador.Indicador;
import models.indicador.ReferencialComparativo;
import models.indicador.RegistroIndicador;
import models.indicador.TotalRealizado;
import models.meta.Meta;
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

  public static void registrosIndicador(Long id) {
    Indicador indicador = Indicador.findById(id);
    render(indicador);
  }

  public static void salvarRegistroIndicador(RegistroIndicador registro) {
    registro.save();
  }

  public static void salvarTotalRealizado(TotalRealizado totalRealizado) {
    totalRealizado.save();
  }

  public static void salvarReferencialComparativo(ReferencialComparativo referencialComparativo) {
    referencialComparativo.save();
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
