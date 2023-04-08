package ua.lviv.iot.algo.part1.Lab1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GardenManagerTest {

    @Test
    void addGardensWithOneElement() {
        long startTime = System.currentTimeMillis();
        GardenManager testClass = new GardenManager();
        Garden botanicGarden = new BotanicGarden(1, 2, 3, 4);
        testClass.addGardens(botanicGarden);
        long endTime = System.currentTimeMillis();

        if(endTime-startTime>=70){
            throw new RuntimeException("too long runtime of method addGardensWithOneElement() - "+ (endTime-startTime) + "ms");
        }

        assertEquals(List.of(botanicGarden), testClass.getGardens());
    }

    @Test
    void addGardens() {
        long startTime = System.currentTimeMillis();
        GardenManager testClass = new GardenManager();
        Garden botanicGarden = new BotanicGarden(1, 2, 3, 4);
        Garden orchard = new Orchard(5, 6, 7);
        Garden farmstead = new Farmstead(8, 9, 10);
        Garden universityGarden = new UniversityGarden(11, 12, 13);
        testClass.addGardens(List.of(botanicGarden, orchard, farmstead, universityGarden));
        long endTime = System.currentTimeMillis();

        if(endTime-startTime>=70){
            throw new RuntimeException("too long runtime of method addGardens() - "+ (endTime-startTime) + "ms");
        }

        assertEquals(List.of(botanicGarden, orchard, farmstead, universityGarden), testClass.getGardens());
    }

    @Test
    void findGardenWithFlowersMoreThan() {
        long startTime = System.currentTimeMillis();
        GardenManager testClass = new GardenManager();
        Garden botanicGarden = new BotanicGarden(1, 2, 3, 4);
        Garden orchard = new Orchard(5, 6, 7);
        Garden farmstead = new Farmstead(8, 9, 10);
        Garden universityGarden = new UniversityGarden(11, 12, 13);
        testClass.addGardens(List.of(botanicGarden, orchard, farmstead, universityGarden));
        long endTime = System.currentTimeMillis();

        if(endTime-startTime>=70){
            throw new RuntimeException("too long runtime of method findGardenWithFlowersMoreThan() - "+ (endTime-startTime) + "ms");
        }

        assertEquals(List.of(farmstead, universityGarden), testClass.findGardenWithFlowersMoreThan(7));
    }

    @Test
    void findGardenWithAreaLessThan() {
        long startTime = System.currentTimeMillis();
        GardenManager testClass = new GardenManager();
        Garden botanicGarden = new BotanicGarden(1, 2, 3, 4);
        Garden orchard = new Orchard(5, 6, 7);
        Garden farmstead = new Farmstead(8, 9, 10);
        Garden universityGarden = new UniversityGarden(11, 12, 13);
        testClass.addGardens(List.of(botanicGarden, orchard, farmstead, universityGarden));
        long endTime = System.currentTimeMillis();

        if(endTime-startTime>=70){
            throw new RuntimeException("too long runtime of method findGardenWithAreaLessThan() - "+ (endTime-startTime) + "ms");
        }

        assertEquals(List.of(botanicGarden, orchard), testClass.findGardenWithAreaLessThan(7));
    }
}