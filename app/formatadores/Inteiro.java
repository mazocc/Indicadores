package formatadores;

import static java.lang.String.valueOf;

class Inteiro<T> implements Formatador<Number> {
    @Override
    public String formatar(Number value) {
        return valueOf(value.longValue());
    }
}
