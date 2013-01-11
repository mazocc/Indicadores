package controllers;

import models.Objetivo;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

import java.util.List;

@With(Secure.class)
public class Objetivos extends Controller {

  public static void index() {
    List<Objetivo> objetivos = Objetivo.findAll();
    render(objetivos);
  }

  public static void cadastroObjetivo() {
    render();
  }

  public static void visualizar(Long id) {
    Objetivo objetivo = Objetivo.findById(id);
    render(objetivo);
  }

  public static void editar(Long id) {
    Objetivo objetivo = Objetivo.findById(id);
    render("@cadastroObjetivo", objetivo);
  }

  public static void apagar(Long id) {
    Objetivo objetivo = Objetivo.findById(id);
    objetivo.delete();
    Objetivos.index();
  }

  public static void salvar(@Valid Objetivo objetivo) {
    if (validation.hasErrors()) {
      render("@cadastroObjetivo", objetivo);
    }
    objetivo.save();
    Objetivos.index();
  }

}
