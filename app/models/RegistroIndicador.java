package models;

import play.db.jpa.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RegistroIndicador extends Model {

    @Temporal(TemporalType.DATE)
    public Date data;

    @ManyToOne
    @JoinColumn(name = "indicador_id")
    public Indicador indicador;

    public double valor;
}
