package ua.lviv.iot.algo.part1.Lab1;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Farmstead extends Garden{
    private int houseArea;
    @Override
    public boolean hasOrchard() {
        return true;
    }

    @Override
    public boolean hasVegetableGarden() {
        return true;
    }

    public Farmstead(double area, int numberOfFlowers, int houseArea) {
        super(area, numberOfFlowers);
        this.houseArea = houseArea;
    }

    @Override
    public String toString() {
        return "Farmstead{" +
                "houseArea=" + houseArea +
                ", area=" + area +
                ", numberOfFlowers=" + numberOfFlowers +
                '}';
    }
}
