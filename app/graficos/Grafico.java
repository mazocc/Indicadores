package graficos;

import models.enumeracoes.Ordem;

import java.util.List;

public interface Grafico {
  public TipoGrafico tipoGrafico();

  public Titulo titulo();

  public Titulo subtitulo();

  public Eixo eixoX();

  public Eixo eixoY();

  public List<Serie> series();

  public Ordem ordem();

}
