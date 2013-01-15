package graficos.highchart;

import graficos.inter.Categoria;

public class HighChartCategoria implements Categoria {

  public String descricao;

  public HighChartCategoria(String descricao) {
    this.descricao = descricao;
  }

  @Override
  public String descricao() {
    return descricao;
  }
}
