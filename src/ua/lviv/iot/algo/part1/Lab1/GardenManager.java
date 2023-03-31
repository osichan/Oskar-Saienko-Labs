package ua.lviv.iot.algo.part1.Lab1;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GardenManager {
    private static final List<Garden> gardens = new LinkedList<>();
    public void addGardens(Garden garden){
        gardens.add(garden);
    }
    public void addGardens (List<Garden> garden){
        gardens.addAll(garden);
    }

    public List<Garden> findGardenWithFlowersMoreThan(int numberOfFlowers){
        return gardens.stream().
                filter(garden -> garden.getNumberOfFlowers() >= numberOfFlowers).
                collect(Collectors.toList());
    }

    public List<Garden> findGardenWithAreaLessThan(int area){
        return gardens.stream().
                filter(garden -> garden.getArea() <= area).
                collect(Collectors.toList());
    }

    public static void main (String [] args){
        GardenManager A = new GardenManager();
        A.addGardens(List.of(
                new BotanicGarden(1,2,3,4),
                new Orchard(5,6,7),
                new Farmstead(8,9,10),
                new UniversityGarden(11,12,13)));
        for(Garden value: gardens){
            System.out.println(value);
        }
        System.out.println("--------------------------------------------------By area----------------------------------------------------------");
        for(Garden value: A.findGardenWithAreaLessThan(4)){
            System.out.println(value);
        }
        System.out.println("--------------------------------------------------By flowers----------------------------------------------------------");
        for(Garden value: A.findGardenWithFlowersMoreThan(9)){
            System.out.println(value);
        }
    }
}
