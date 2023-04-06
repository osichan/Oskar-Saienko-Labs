package ua.lviv.iot.algo.part1.Lab1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
public class UniversityGarden extends Garden {

    private int numberOfSculptures;

    @Override
    public boolean hasOrchard() {
        return false;
    }

    @Override
    public boolean hasVegetableGarden() {
        return false;
    }

    public UniversityGarden(double area, int numberOfFlowers, int numberOfSculptures) {
        super(area, numberOfFlowers);
        this.numberOfSculptures = numberOfSculptures;
    }

}
