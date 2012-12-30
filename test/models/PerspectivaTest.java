package models;

import org.junit.Test;
import play.test.UnitTest;

import java.util.List;

public class PerspectivaTest extends UnitTest {

    @Test
    public void salvaPerspetiva() {
        Perspectiva p = new Perspectiva();
        p.descricao = "Teste";
        p.save();
        assertEquals(1, Perspectiva.count());
    }

    @Test
    public void updatePerspetiva() {
        Perspectiva p = Perspectiva.find("descricao", "Teste").first();
        p.descricao = "Teste Alterado";
        p.save();
        assertEquals(1, Perspectiva.count("descricao", "Teste Alterado"));
    }

    @Test
    public void deletePerspetiva() {
        List<Perspectiva> list = Perspectiva.findAll();
        for (Perspectiva p : list) {
            p.delete();
        }
        assertEquals(0, Perspectiva.count());
    }

}
