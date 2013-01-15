package formatadores;

import java.text.NumberFormat;
import java.util.Locale;

class Monetario<T> implements Formatador<Number> {
  @Override
  public String formatar(Number value) {
    return NumberFormat.getCurrencyInstance(Locale.getDefault()).format(value);
  }
}
