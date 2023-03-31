package ua.lviv.iot.algo.part1.Lab1;

import lombok.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Garden {
    private double area;
    private boolean hasOrchard;
    private boolean hasVegetableGarden;
    private int numberOfFlowers;
    private static Garden instance = new Garden();

    public void plantFlower(int count) {
        this.numberOfFlowers += count;
    }

    public void removeFlower(int count) {
        if (count > numberOfFlowers) {
            this.numberOfFlowers = 0;
        } else {
            this.numberOfFlowers -= count;
        }
    }

    public void addVegetableRegion(double area) {
        this.area += area;
    }

    public static Garden getInstance() {
        return instance;
    }

    public static void main(String[] args) {

        Garden[] garden = {new Garden(),new Garden(20.0, true, false, 4),Garden.getInstance(),Garden.getInstance()};

        for (Garden value : garden) {
            System.out.println(value.toString());
        }
    }
}