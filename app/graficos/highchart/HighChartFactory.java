package graficos.highchart;

import graficos.inter.Categoria;
import graficos.inter.Eixo;
import graficos.inter.Grafico;
import graficos.inter.Serie;
import models.Indicador;
import play.i18n.Messages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static graficos.inter.TipoGrafico.line;

public class HighChartFactory {
    public static Grafico valoresIndicador(Indicador indicador) {
        Eixo eixoX = new HighChartEixo(criarMeses());
        Eixo eixoY = new HighChartEixo(new HighChartTitulo(Messages.get("valores")));

        return new HighChartGrafico(line, new HighChartTitulo(indicador.descricao), eixoX, eixoY, series());
    }

    private static List<Serie> series() {
        List<Serie> series = new ArrayList<Serie>();
        series.add(new HighChartSerie("2010", Arrays.<Double>asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0)));
        series.add(new HighChartSerie("2011", Arrays.<Double>asList(10.0, 20.0, 30.0, 40.0, 50.0, 60.0, 70.0, 80.0, 90.0, 100.0, 110.0, 120.0)));
    }

    private static List<Categoria> criarMeses() {
        List<Categoria> categorias = new ArrayList<Categoria>(12);
        categorias.add(new HighChartCategoria(Messages.get("janeiro")));
        categorias.add(new HighChartCategoria(Messages.get("fevereiro")));
        categorias.add(new HighChartCategoria(Messages.get("marco")));
        categorias.add(new HighChartCategoria(Messages.get("abril")));
        categorias.add(new HighChartCategoria(Messages.get("maio")));
        categorias.add(new HighChartCategoria(Messages.get("junho")));
        categorias.add(new HighChartCategoria(Messages.get("julho")));
        categorias.add(new HighChartCategoria(Messages.get("agosto")));
        categorias.add(new HighChartCategoria(Messages.get("setembro")));
        categorias.add(new HighChartCategoria(Messages.get("outubro")));
        categorias.add(new HighChartCategoria(Messages.get("novembro")));
        categorias.add(new HighChartCategoria(Messages.get("dezembro")));

        return categorias;
    }
}
