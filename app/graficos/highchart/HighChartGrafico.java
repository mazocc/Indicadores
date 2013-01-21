package graficos.highchart;

import graficos.*;
import models.Ordem;

import java.util.List;

public class HighChartGrafico implements Grafico {

  public TipoGrafico tipoGrafico;
  public Titulo titulo;
  public Eixo eixoX;
  public Eixo eixoY;
  public List<Serie> series;
  public Titulo subtitulo;
  public Ordem ordem;

  HighChartGrafico(TipoGrafico tipoGrafico, Titulo titulo, Eixo eixoX, Eixo eixoY, List<Serie> series, Ordem ordem) {
    this.tipoGrafico = tipoGrafico;
    this.titulo = titulo;
    this.eixoX = eixoX;
    this.eixoY = eixoY;
    this.series = series;
    this.ordem = ordem;
  }

  HighChartGrafico(TipoGrafico tipoGrafico, Titulo titulo, Eixo eixoX, Eixo eixoY, Ordem ordem) {
    this.tipoGrafico = tipoGrafico;
    this.titulo = titulo;
    this.eixoX = eixoX;
    this.eixoY = eixoY;
    this.ordem = ordem;
  }

  @Override
  public TipoGrafico tipoGrafico() {
    return tipoGrafico;
  }

  @Override
  public Titulo titulo() {
    return titulo;
  }

  @Override
  public Titulo subtitulo() {
    return subtitulo;
  }

  @Override
  public Eixo eixoX() {
    return eixoX;
  }

  @Override
  public Eixo eixoY() {
    return eixoY;
  }

  @Override
  public List<Serie> series() {
    return series;
  }

  @Override
  public Ordem ordem() {
    return ordem();
  }
}
