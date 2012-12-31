package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class ForcaTarefa extends Model {

    @ManyToMany
    public List<Pessoa> pessoas;

    @OneToMany(mappedBy = "forcaTarefa")
    List<Indicador> indicadores;

}
