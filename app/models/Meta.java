package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Meta extends Model {

    @NotNull
    public String descricao;

    @OneToMany(mappedBy = "meta")
    public List<Indicador> indicadores;

    //public Formato formato;
    //public List<ValorAnual> valoresAnuais;
}
