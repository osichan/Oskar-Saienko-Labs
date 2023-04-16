package ua.lviv.iot.algo.part1.Lab1;

import com.jparams.verifier.tostring.ToStringVerifier;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class OrchardTest {

    @Test
    void hasOrchard() {
        Orchard testClass = new Orchard(5,6,7);

        assertTrue(testClass.hasOrchard());
    }

    @Test
    void hasVegetableGarden() {
        Orchard testClass = new Orchard(5,6,7);

        assertFalse(testClass.hasVegetableGarden());
    }

    @Test
    void setNumberOFPods() {
        Orchard testClass = new Orchard(5,6,7);
        testClass.setNumberOfPods(10);

        assertEquals(10,testClass.getNumberOfPods());
    }
    @Test
    public void testToString()
    {
        ToStringVerifier.forClass(Orchard.class).verify();
    }
}