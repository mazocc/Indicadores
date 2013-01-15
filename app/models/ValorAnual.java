package models;

import play.data.validation.Min;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Calendar;

@Entity
public class ValorAnual extends Model {

  @ManyToOne
  @JoinColumn(name = "meta_id", nullable = false)
  @Required
  public Meta meta;

  @Required
  @Min(2000)
  public int ano = Calendar.getInstance().get(Calendar.YEAR);
  @Required
  public double valor;

  @Override
  public String toString() {
    return ano + " - " + valor;
  }

}
