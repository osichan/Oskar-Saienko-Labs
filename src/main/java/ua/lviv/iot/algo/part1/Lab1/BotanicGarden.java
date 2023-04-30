package ua.lviv.iot.algo.part1.Lab1;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString(callSuper = true)
public class BotanicGarden extends Garden {
    private int numberOfFruitTrees;
    private int numberOfGreenhouses;
    @Override
    public String getHeaders() {
        return super.getHeaders() + ", numberOfGreenhouses, " + "numberOfFruitTrees";
    }
    @Override
    public String toCSV() {
        return super.toCSV() + ", " + numberOfGreenhouses + ", " + numberOfFruitTrees;
    }

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
}
