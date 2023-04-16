package ua.lviv.iot.algo.part1.Lab1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
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
}
