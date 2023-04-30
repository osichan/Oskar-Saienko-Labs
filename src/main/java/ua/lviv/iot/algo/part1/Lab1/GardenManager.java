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
    public static void main(String... args){
        List<Garden> gardens = new LinkedList<>(List.of(
                new Farmstead(1,2,3),
                new Orchard(4,5,6),
                new UniversityGarden(7,8,9),
                new BotanicGarden(10,11,12,13),
                new Farmstead(14,15,16),
                new Orchard(17,18,19),
                new UniversityGarden(20,20,20),
                new BotanicGarden(21,22,23,24)
        ));

        GardenWriter writer = new GardenWriter();
        writer.writeNonSorted(gardens);
        writer.writeSorted(gardens);
    }
}