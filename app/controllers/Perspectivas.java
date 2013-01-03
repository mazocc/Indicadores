package controllers;

import models.Perspectiva;
import play.data.validation.Valid;
import play.mvc.Controller;

import java.util.List;

public class Perspectivas extends Controller {

  public static void index() {
    List<Perspectiva> perspectivas = Perspectiva.findAll();
    render(perspectivas);
  }

  public static void form(Long id) {
    if (id == null) {
      render();
    }
    Perspectiva perspectiva = Perspectiva.findById(id);
    render(perspectiva);
  }

  public static void save(@Valid Perspectiva perspectiva) {
  }
}
