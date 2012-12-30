package formatadores;

import org.junit.Assert;
import org.junit.Test;
import play.test.UnitTest;

public class FormatadorTest extends UnitTest {

    @Test
    public void percentualTest(){
        assertTrue("10%".equals(Formato.Percentual.formatar(0.1)));
        assertTrue("100".equals(Formato.Inteiro.formatar(100)));
        assertTrue("100.00".equals(Formato.Numerico.formatar(100)));
        assertTrue("R$ 100,00".equals(Formato.Monetario.formatar(100)));

    }

}
