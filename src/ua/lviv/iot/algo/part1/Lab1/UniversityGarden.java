package ua.lviv.iot.algo.part1.Lab1;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
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

    @Override
    public String toString() {
        return "UniversityGarden{" +
                "numberOfSculptures=" + numberOfSculptures +
                ", area=" + area +
                ", numberOfFlowers=" + numberOfFlowers +
                '}';
    }
}
