
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BuscaFreteTeste {

    @Test // Falaram (o gerente foi num evento de agil) que eu tinha que testar...dai to testando
    public void calcMaisBaratoDeMoto() {

        double calculado = BuscaFrete.calcMaisBarato(100, 150, 32, true, false, false);
        double esperado = 20;
        assertEquals(esperado, calculado);

    }

}
