package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class ForcaTarefa extends Model {
    public List<Pessoa> pessoas;
}
