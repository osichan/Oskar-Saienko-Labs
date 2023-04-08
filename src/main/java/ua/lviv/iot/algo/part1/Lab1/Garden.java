package ua.lviv.iot.algo.part1.Lab1;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class Garden  {
    protected double area;
    protected int numberOfFlowers;

    abstract public boolean hasOrchard();

    abstract public boolean hasVegetableGarden();
    
    public Garden(double area, int numberOfFlowers) {
        this.area = area;
        this.numberOfFlowers = numberOfFlowers;
    }
}