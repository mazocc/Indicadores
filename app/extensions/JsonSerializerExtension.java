package extensions;

import flexjson.JSONSerializer;
import play.templates.JavaExtensions;

import java.util.Collection;

public class JsonSerializerExtension extends JavaExtensions {

  /**
   * Serialize a model to JSON with a given serializer.
   */
  public static String serializeWith(Object model, String serializer) throws IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException {
    JSONSerializer js = (JSONSerializer) JSONSerializer.class.getField(serializer).get(null);
    return js.serialize(model);
  }

  /**
   * Serialize a list of models to JSON with a given serializer.
   */
  public static String serializeWith(Collection<Object> models, String serializer) throws IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException {
    JSONSerializer js = (JSONSerializer) JSONSerializer.class.getField(serializer).get(null);
    return js.serialize(models);
  }


}
