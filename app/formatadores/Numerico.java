package formatadores;

import java.math.BigDecimal;

class Numerico<T> implements Formatador<Number> {
  @Override
  public String formatar(Number value) {
    BigDecimal valor = BigDecimal.valueOf(value.doubleValue());
    valor = valor.setScale(2);
    return valor.toString();
  }
}
