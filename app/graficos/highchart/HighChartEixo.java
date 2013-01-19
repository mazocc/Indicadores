package graficos.highchart;

import formatadores.Formato;
import graficos.Categoria;
import graficos.Eixo;
import graficos.Titulo;

import java.util.List;

public class HighChartEixo implements Eixo {

  public List<Categoria> categorias;
  public Titulo titulo;
  public Formato formato;

  public HighChartEixo(List<Categoria> categorias) {
    this.categorias = categorias;
  }

  HighChartEixo(Titulo titulo) {
    this.categorias = categorias;
    this.titulo = titulo;
  }

  public HighChartEixo() {
  }

  public Eixo adicionar(Categoria categoria) {
    categorias.add(categoria);
    return this;
  }

  public Eixo remover(Categoria categoria) {
    categorias.remove(categoria);
    return this;
  }

  @Override
  public List<Categoria> categorias() {
    return categorias;
  }

  @Override
  public Titulo titulo() {
    return titulo;
  }
}
