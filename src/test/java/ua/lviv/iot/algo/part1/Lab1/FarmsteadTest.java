package ua.lviv.iot.algo.part1.Lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void testToString() {
        Farmstead testClass = new Farmstead(8,9,10);
        assertEquals(testClass.toString(),testClass.toString());
    }
}