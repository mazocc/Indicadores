package controllers;

import flexjson.JSONSerializer;
import flexjson.transformer.BasicDateTransformer;
import graficos.inter.Grafico;
import models.Indicador;
import models.Meta;
import models.Perspectiva;
import play.mvc.Controller;

import java.util.Date;
import java.util.List;

public class Indicadores extends Controller {

    public static void index() {
    }

    public static void listarIndicadores() {
        List<Perspectiva> perspectivas = Perspectiva.findAll();
        render(perspectivas);
    }

    public static void visualizar(Long id) {
        Indicador indicador = Indicador.findById(id);
        Meta meta = indicador.meta;
        Grafico grafico = null;
        render(indicador, meta, grafico);
        renderJSON(new JSONSerializer()
                .transform(new BasicDateTransformer(), Date.class)
                .include("registros").deepSerialize(indicador));
    }

    public static void visualizarJson(Long id) {

    }
}
