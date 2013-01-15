package graficos.highchart;

import graficos.inter.Categoria;
import graficos.inter.Eixo;
import graficos.inter.Titulo;

import java.util.List;

public class HighChartEixo implements Eixo {

  public List<Categoria> categorias;
  public Titulo titulo;

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
