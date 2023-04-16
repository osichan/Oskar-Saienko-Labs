package ua.lviv.iot.algo.part1.Lab1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
public class Orchard extends Garden {
    private int numberOfPods;

    @Override
    public String getHeaders() {
        return super.getHeaders() + ", numberOfPods";
    }
    @Override
    public String toCSV() {
        return super.toCSV() + ", " + numberOfPods;
    }

    @Override
    public boolean hasOrchard() {
        return true;
    }

    @Override
    public boolean hasVegetableGarden() {
        return false;
    }

    public Orchard(double area, int numberOfFlowers, int numberOfPods) {
        super(area, numberOfFlowers);
        this.numberOfPods = numberOfPods;
    }
}
