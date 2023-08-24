package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestAvion {

    @Test
    public void testAvionComercialVolar() {
        AvionComercial avion = new AvionComercial(1000, 10);
        int distancia = 100;
        int combustibleNecesario = avion.volar(distancia);
        assertEquals(1000, avion.getCapacidadCombustible());
        assertEquals(10, avion.getConsumoCombustible());
        assertEquals(1000, combustibleNecesario);
    }

    @Test
    public void testAvionPrivadoVolar() {
        AvionPrivado avion = new AvionPrivado(2000, 5);
        int distancia = 200;
        int combustibleNecesario = avion.volar(distancia);
        assertEquals(2000, avion.getCapacidadCombustible());
        assertEquals(5, avion.getConsumoCombustible());
        assertEquals(1000, combustibleNecesario);
    }
}
