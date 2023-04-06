package ua.lviv.iot.algo.part1.Lab1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GardenManagerTest {

    @Test
    void testAddGardensWithOneElement() {
        GardenManager A = new GardenManager();
        A.addGardens(new BotanicGarden(1,2,3,4));
        assertEquals(1,A.getGardens().size());
    }

    @Test
    void testAddGardens() {
        GardenManager A = new GardenManager();
        A.addGardens(List.of(
                new BotanicGarden(1,2,3,4),
                new Orchard(5,6,7),
                new Farmstead(8,9,10),
                new UniversityGarden(11,12,13)));
        assertEquals(4,A.getGardens().size());
    }

    @Test
    void findGardenWithFlowersMoreThan() {
        GardenManager A = new GardenManager();
        A.addGardens(List.of(
                new BotanicGarden(1,2,3,4),
                new Orchard(5,6,7),
                new Farmstead(8,9,10),
                new UniversityGarden(11,12,13)));
        assertEquals(2,(A.findGardenWithFlowersMoreThan(7)).size());
    }

    @Test
    void findGardenWithAreaLessThan() {
        GardenManager A = new GardenManager();
        A.addGardens(List.of(
                new BotanicGarden(1,2,3,4),
                new Orchard(5,6,7),
                new Farmstead(8,9,10),
                new UniversityGarden(11,12,13)));
        assertEquals(2,(A.findGardenWithAreaLessThan(7)).size());
    }
}