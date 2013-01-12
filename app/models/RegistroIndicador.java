package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RegistroIndicador extends Model {

    @Temporal(TemporalType.DATE)
    @Required
    public Date data;

    @ManyToOne
    @JoinColumn(name = "indicador_id", nullable = false)
    @Required
    public Indicador indicador;

    @Required
    public double valor;

    @Override
    public String toString() {
        return data + " - " + valor;
    }
}
