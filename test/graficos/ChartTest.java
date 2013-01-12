package graficos;

import graficos.highchart.HighChart;
import graficos.highchart.HighChartTitle;
import graficos.inter.Axis;
import graficos.inter.Chart;
import graficos.inter.ChartType;
import graficos.inter.Title;
import org.junit.Test;
import play.test.UnitTest;

public class ChartTest extends UnitTest {

    @Test
    public void testChartCreation() {
        Axis xAxis = null, yAxis = null;
        Title title = new HighChartTitle("Titulo");
        Series series = null;

        Chart chart = new HighChart(
                ChartType.bar
                , title
                , xAxis
                , yAxis
                , series);
    }

}
