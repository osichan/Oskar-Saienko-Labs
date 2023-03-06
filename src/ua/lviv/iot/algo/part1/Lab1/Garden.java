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
    private static Garden instance;

    public void plantFlower(int count){
        this.numberOfFlowers+= count;
    }
    public void removeFlower(int count){
        if(count>numberOfFlowers){
            this.numberOfFlowers=0;
            System.out.println("There is no more flowers");
        }else {
            this.numberOfFlowers -= count;
        }
    }
    public void addVegetableRegion(double area){
        this.area+=area;
    }
    public static Garden getInstance() {
        if (instance == null) {
            instance = new Garden();
        }
        return instance;
    }
    public static void main(String[] args) {

        Garden[] garden = new Garden[4];
        garden[0] = new Garden();
        garden[1] = new Garden(20.0,true,false,4);
        garden[2] = Garden.getInstance();
        garden[3] = Garden.getInstance();


        garden[1].plantFlower(1);
        garden[1].removeFlower(2);
        garden[1].addVegetableRegion(20);
        garden[2].plantFlower(2);
        for(int i=0;i< garden.length;i++){
            System.out.println(garden[i].toString());
        }

    }
}
