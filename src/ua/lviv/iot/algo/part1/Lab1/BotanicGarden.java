package ua.lviv.iot.algo.part1.Lab1;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class BotanicGarden extends Garden {
    private int numberOfFruitTrees;
    private int numberOfGreenhouses;

    public boolean hasOrchard(){
        return false;
    }

    @Override
    public boolean hasVegetableGarden() {
        return true;
    }

    public BotanicGarden(double area, int numberOfFlowers, int numberOfFruitTrees, int numberOfGreenhouses) {
        super(area, numberOfFlowers);
        this.numberOfFruitTrees = numberOfFruitTrees;
        this.numberOfGreenhouses = numberOfGreenhouses;
    }

    @Override
    public String toString() {
        return "BotanicGarden{" +
                "numberOfFruitTrees=" + numberOfFruitTrees +
                ", numberOfGreenhouses=" + numberOfGreenhouses +
                ", area=" + area +
                ", numberOfFlowers=" + numberOfFlowers +
                '}';
    }
}
