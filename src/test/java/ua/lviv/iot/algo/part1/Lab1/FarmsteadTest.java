package ua.lviv.iot.algo.part1.Lab1;

import com.jparams.verifier.tostring.ToStringVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FarmsteadTest {

    @Test
    void hasOrchard() {
        Farmstead testClass = new Farmstead(8,9,10);

        assertTrue(testClass.hasOrchard());
    }

    @Test
    void hasVegetableGarden() {
        Farmstead testClass = new Farmstead(8,9,10);

        assertTrue(testClass.hasVegetableGarden());
    }
    @Test
    void setHouseArea() {
        Farmstead testClass = new Farmstead(8,9,10);

        testClass.setHouseArea(2);
        assertEquals(2,testClass.getHouseArea());
    }

    @Test
    public void testToString()
    {
        ToStringVerifier.forClass(Farmstead.class).verify();
    }
}