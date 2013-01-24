package controllers;

import models.meta.ValorAnual;
import play.mvc.Controller;

public class Metas extends Controller {

  public static void salvaValorAnual(ValorAnual valorAnual) {
    valorAnual.save();
  }

}
