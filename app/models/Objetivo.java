package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Objetivo extends Model {

    @NotNull
    public String descricao;

    @ManyToOne
    @JoinColumn(name = "perspectiva_id", nullable = false)
    public Perspectiva perspectiva;

    @OneToMany(mappedBy = "objetivo")
    public List<Indicador> indicadores;

}
