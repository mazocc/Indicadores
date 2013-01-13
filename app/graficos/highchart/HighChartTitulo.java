package graficos.highchart;

import graficos.inter.Titulo;

class HighChartTitulo implements Titulo {

    public String titulo;

    public HighChartTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String descricao() {
        return titulo;
    }
}
