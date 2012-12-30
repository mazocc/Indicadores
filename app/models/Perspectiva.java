package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Perspectiva extends Model {

    @NotNull
    public String descricao;

    @OneToMany(mappedBy = "perspectiva")
    public List<Objetivo> objetivos;

}
