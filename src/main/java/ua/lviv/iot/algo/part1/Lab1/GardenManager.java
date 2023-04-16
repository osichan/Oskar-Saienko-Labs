package ua.lviv.iot.algo.part1.Lab1;


import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
public class GardenManager {
    private final List<Garden> gardens = new LinkedList<>();

    List<Garden> getGardens() {
        return gardens;
    }

    public void addGardens(Garden garden) {
        gardens.add(garden);
    }

    public void addGardens(List<Garden> garden) {
        gardens.addAll(garden);
    }

    public List<Garden> findGardenWithFlowersMoreThan(int numberOfFlowers) {
        return gardens.stream().
                filter(garden -> garden.getNumberOfFlowers() >= numberOfFlowers).
                collect(Collectors.toList());
    }

    public List<Garden> findGardenWithAreaLessThan(int area) {
        return gardens.stream().
                filter(garden -> garden.getArea() <= area).
                collect(Collectors.toList());
    }
}