import models.Perspectiva;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

@OnApplicationStart
public class Bootstrap extends Job {

  @Override
  public void doJob() throws Exception {
    if (Perspectiva.count() == 0)
      Fixtures.loadModels("data.yml");
  }
}
