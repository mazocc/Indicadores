package graficos;

import graficos.highchart.HighChart;
import graficos.highchart.HighChartTitle;
import graficos.inter.Axis;
import graficos.inter.Chart;
import graficos.inter.TipoGrafico;
import graficos.inter.Title;
import org.junit.Test;
import play.test.UnitTest;

public class ChartTest extends UnitTest {

  @Test
  public void testChartCreation() {
    Axis xEixo = null, yEixo = null;
    Title titulo = new HighChartTitle("Titulo");
    Series series = null;

    Chart grafico = new HighChart(
        TipoGrafico.bar
        , title
        , xAxis
        , yAxis
        , series);
  }

}
