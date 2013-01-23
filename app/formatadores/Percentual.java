package formatadores;

import static java.lang.String.valueOf;

class Percentual<T> implements Formatador<Number> {
  @Override
  public String formatar(Number value) {
    long valor = (long) value.doubleValue();
    return valueOf(valor) + "%";
  }
}
