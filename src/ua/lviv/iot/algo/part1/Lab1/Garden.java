package ua.lviv.iot.algo.part1.Lab1;

import lombok.*;

@Setter
@NoArgsConstructor
public abstract class Garden  {
    protected double area;
    protected int numberOfFlowers;
    abstract public boolean  hasOrchard();
    abstract public boolean hasVegetableGarden();

    public double getArea() {
        return area;
    }

    public int getNumberOfFlowers() {
        return numberOfFlowers;
    }

    public Garden(double area, int numberOfFlowers) {
        this.area = area;
        this.numberOfFlowers = numberOfFlowers;
    }

}