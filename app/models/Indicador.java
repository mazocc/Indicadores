package models;

import formatadores.Formatador;
import play.db.jpa.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Indicador extends Model {

    @NotNull
    public String descricao;

    @NotNull
    public String iniciativa;

    @Enumerated(EnumType.STRING)
    public Formato formato;
    //public List<Responsavel> responsaveis;
    //public ForcaTarefa forcaTarefa;

    @ManyToOne
    @JoinColumn(name = "meta_id", nullable = false)
    public Meta meta;

    //public Periodicidade periodicidade;
    //public List<RegistroIndicador> registros;

    @ManyToOne
    @JoinColumn(name = "objetivo_id", nullable = false)
    public Objetivo objetivo;

}
