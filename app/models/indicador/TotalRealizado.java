package models.indicador;

import play.data.validation.Min;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Calendar;

@Entity
public class TotalRealizado extends Model {

  @ManyToOne
  @JoinColumn(name = "indicador_id", nullable = false)
  @Required
  public Indicador indicador;

  @Required
  @Min(1900)
  public int ano = Calendar.getInstance().get(Calendar.YEAR);

  @Required
  public double valor;

  @Override
  public String toString() {
    return ano + " - " + valor;
  }

}