package formatadores;

public enum Formato {
    Percentual(new Percentual()),
    Inteiro(new Inteiro()),
    Numerico(new Numerico()),
    Monetario(new Monetario());

    private final Formatador<Number> formatador;

    private Formato(Formatador<Number> formatador){
        this.formatador = formatador;
    }

    public String formatar(Number number) {
        return formatador.formatar(number);
    }

    public Formatador<Number> getFormatador() {
        return formatador;
    }
}
