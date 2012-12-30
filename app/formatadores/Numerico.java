package formatadores;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.String.valueOf;

public class Numerico<T> implements Formatador<Number> {
    @Override
    public String formatar(Number value) {
        BigDecimal valor = BigDecimal.valueOf(value.doubleValue());
        valor.setScale(2, RoundingMode.HALF_UP);
        return valor.toPlainString();
    }
}
