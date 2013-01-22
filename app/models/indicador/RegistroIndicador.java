package models.indicador;

import org.joda.time.LocalDate;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RegistroIndicador extends Model implements Comparable<RegistroIndicador> {

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

  public int ano() {
    return LocalDate.fromDateFields(data).getYear();
  }

  @Override
  public int compareTo(RegistroIndicador o) {
    if (data.after(o.data)) return 1;
    else if (data.before(o.data)) return -1;
    else return 0;
  }
}
