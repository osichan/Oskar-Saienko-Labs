package ua.lviv.iot.algo.part1.Lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void testToString() {
        Orchard testClass = new Orchard(5,6,7);
        assertEquals(testClass.toString(),testClass.toString());
    }
}