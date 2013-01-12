package models;

import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Meta extends Model {

    @Required
    @MinSize(4)
    public String descricao;

    @OneToMany(mappedBy = "meta")
    public List<Indicador> indicadores;

    @OneToMany(mappedBy = "meta")
    public List<ValorAnual> valoresAnuais;

    @Override
    public String toString() {
        return id + " - " + descricao;
    }
}
