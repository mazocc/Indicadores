package models;

import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Perspectiva extends Model {

    @Required
    @MinSize(4)
    public String descricao;

    @OneToMany(mappedBy = "perspectiva")
    public List<Objetivo> objetivos;

}
