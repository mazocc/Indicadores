package formatadores;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Monetario<T> implements Formatador<Number> {
    @Override
    public String formatar(Number value) {
        DecimalFormat formato = new DecimalFormat();
        formato.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.getDefault()));
        return formato.format(value);
    }
}
