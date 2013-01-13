package graficos.highchart;

import graficos.inter.Serie;

import java.util.List;

class HighChartSerie implements Serie {

    public String nome;
    public List<Double> valores;

    public HighChartSerie(String nome, List<Double> valores) {
        this.nome = nome;
        this.valores = valores;
    }

    public HighChartSerie(String nome) {
        this.nome = nome;
    }

    @Override
    public String nome() {
        return nome;
    }

    public Serie adiciona(Double valor) {
        valores.add(valor);
        return this;
    }

    public Serie remove(Double valor) {
        valores.add(valor);
        return this;
    }

    @Override
    public List<Double> valores() {
        return valores;
    }
}
