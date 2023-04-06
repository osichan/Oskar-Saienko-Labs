package ua.lviv.iot.algo.part1.Lab1;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class Orchard extends Garden {
    private int numberOFPods;
    @Override
    public boolean hasOrchard() {
        return true;
    }

    @Override
    public boolean hasVegetableGarden() {
        return false;
    }

    public Orchard(double area, int numberOfFlowers, int numberOFPods) {
        super(area, numberOfFlowers);
        this.numberOFPods = numberOFPods;
    }

    @Override
    public String toString() {
        return "Orchard{" +
                "numberOFPods=" + numberOFPods +
                ", area=" + area +
                ", numberOfFlowers=" + numberOfFlowers +
                '}';
    }
}
