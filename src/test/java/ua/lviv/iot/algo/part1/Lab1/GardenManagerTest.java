package ua.lviv.iot.algo.part1.Lab1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GardenManagerTest {
    GardenManager manager;

    @BeforeEach
    void setup() {
        manager = new GardenManager();
        manager.addGardens(List.of(
                new BotanicGarden(1, 2, 3, 4),
                new Orchard(5, 6, 7),
                new Farmstead(8, 9, 10),
                new UniversityGarden(11, 12, 13)));
    }

    @Test
    void addGardensWithOneElement() {
        long startTime = System.currentTimeMillis();
        manager.addGardens(new BotanicGarden(1, 2, 3, 4));
        long endTime = System.currentTimeMillis();

        if (endTime - startTime >= 70) {
            throw new RuntimeException("too long runtime of method addGardensWithOneElement() - " + (endTime - startTime) + "ms");
        }
        assertEquals(5, manager.getGardens().size());
    }

    @Test
    void addGardens() {
        long startTime = System.currentTimeMillis();
        manager.addGardens(List.of(new Farmstead(8, 9, 10),
                new UniversityGarden(11, 12, 13)));
        long endTime = System.currentTimeMillis();

        if (endTime - startTime >= 70) {
            throw new RuntimeException("too long runtime of method addGardens() - " + (endTime - startTime) + "ms");
        }

        assertEquals(6, manager.getGardens().size());
    }

    @Test
    void findGardenWithFlowersMoreThan() throws Exception {
        long startTime = System.currentTimeMillis();

        List<Garden> filteredByNUmberOfFlowersGardens = manager.findGardenWithFlowersMoreThan(7);
        long endTime = System.currentTimeMillis();

        if (endTime - startTime >= 70) {
            throw new RuntimeException("too long runtime of method findGardenWithFlowersMoreThan() - " + (endTime - startTime) + "ms");
        }

        assertEquals(2, filteredByNUmberOfFlowersGardens.size());

        for (Garden garden : filteredByNUmberOfFlowersGardens) {
            if (garden.getNumberOfFlowers() <= 7) {
                throw new Exception("in this garden flowers less than should filter - " + garden.getNumberOfFlowers() + " and should be more than 7");
            }
        }
    }

    @Test
    void findGardenWithAreaLessThan() throws Exception {
        long startTime = System.currentTimeMillis();
        List<Garden> filteredByNUmberOfFlowersGardens = manager.findGardenWithAreaLessThan(7);
        long endTime = System.currentTimeMillis();

        if (endTime - startTime >= 70) {
            throw new RuntimeException("too long runtime of method findGardenWithAreaLessThan() - " + (endTime - startTime) + "ms");
        }

        assertEquals(2,filteredByNUmberOfFlowersGardens.size());

        for(Garden garden:filteredByNUmberOfFlowersGardens){
            if(garden.getArea()>7){
                throw new Exception("in this garden area more than should filter - " + garden.getArea() + " and should be less than 7");
            }
        }
    }
}