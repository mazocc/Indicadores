package graficos;

import java.util.List;

public interface Serie {
  public String nome();

  public List<Double> valores();

  public Serie adiciona(Double valor);

  public Serie remove(Double valor);

}
