package controllers;

import flexjson.JSONSerializer;
import flexjson.transformer.BasicDateTransformer;
import models.Indicador;
import play.mvc.Controller;

import java.util.Date;

public class Indicadores extends Controller {

  public static void index() {
  }

  public static void visualizar(Long id) {
    Indicador indicador = Indicador.findById(id);
    renderJSON(new JSONSerializer()
        .transform(new BasicDateTransformer(), Date.class)
        .include("registros").deepSerialize(indicador));
  }
}
