package controllers;

import models.Perspectiva;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

import java.util.List;

@With(Secure.class)
public class Perspectivas extends Controller {

  public static void index() {
    List<Perspectiva> perspectivas = Perspectiva.findAll();
    render(perspectivas);
  }

  public static void cadastroPerspectiva() {
    render();
  }

  public static void visualizar(Long id) {
    Perspectiva perspectiva = Perspectiva.findById(id);
    render(perspectiva);
  }

  public static void editar(Long id) {
    Perspectiva perspectiva = Perspectiva.findById(id);
    render("@cadastroPerspectiva", perspectiva);
  }

  public static void apagar(Long id) {
    Perspectiva perspectiva = Perspectiva.findById(id);
    perspectiva.delete();
    Perspectivas.index();
  }

  public static void salvar(@Valid Perspectiva perspectiva) {
    if (validation.hasErrors()) {
      render("@cadastroPerspectiva", perspectiva);
    }
    perspectiva.save();
    Perspectivas.index();
  }
}
