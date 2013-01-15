package graficos.inter;

import java.util.List;

public interface Eixo {
  public List<Categoria> categorias();

  public Titulo titulo();

  public Eixo adicionar(Categoria categoria);

  public Eixo remover(Categoria categoria);
}
