package ua.lviv.iot.algo.part1.Lab1;


import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GardenWriter {
    public void writeNonSorted(List<Garden> gardens) {
        if (gardens == null || gardens.isEmpty()) {
            return;
        }
        try (FileWriter writer = new FileWriter("nonSortedResult.csv")) {
            List<String> usedClasses = new ArrayList<>();
            for(Garden gardenToWrite:gardens){
                if(!usedClasses.contains(gardenToWrite.getClass().getName())) {
                    writer.write(gardenToWrite.getHeaders());
                    writer.write(System.getProperty("line.separator"));
                    writer.write(gardenToWrite.toCSV());
                    writer.write(System.getProperty("line.separator"));
                    usedClasses.add(gardenToWrite.getClass().getName());
                    for(Garden gardenToCheckForSameNames :gardens){
                        if(gardenToWrite.getClass().getName().equals(gardenToCheckForSameNames.getClass().getName()) && gardenToWrite!=gardenToCheckForSameNames){
                            writer.write(gardenToCheckForSameNames.toCSV());
                            writer.write(System.getProperty("line.separator"));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeSorted(List<Garden> gardens) {
        if (gardens == null || gardens.isEmpty()) {
            return;
        }
        try (FileWriter writer = new FileWriter("sortedResult.csv")) {
            List<Field> allFields = new LinkedList<>(List.of(Garden.class.getDeclaredFields()));
            List<String> allNamesOfClasses = new ArrayList<>();
            allNamesOfClasses.add(Garden.class.getName());
            for (Garden garden : gardens) {
                if(!allNamesOfClasses.contains(garden.getClass().getName())) {
                    allFields.addAll(List.of(garden.getClass().getDeclaredFields()));
                    allNamesOfClasses.add(garden.getClass().getName());
                }
            }

            for (Field field : allFields) {
                if (field != allFields.get(allFields.size() - 1) ) {
                    writer.write(field.getName() + ",");
                } else {
                    writer.write(field.getName());
                }
            }

            for (Garden garden : gardens) {
                Field[] classFields = garden.getClass().getDeclaredFields();
                Field[] parentClassFields = garden.getClass().getSuperclass().getDeclaredFields();
                writer.write(System.getProperty("line.separator"));

                for (Field field : allFields) {
                    boolean isThisFieldNull = true;
                    for (Field parentClassField : parentClassFields) {
                        if (parentClassField.getName().equals(field.getName())) {
                            parentClassField.setAccessible(true);
                            writer.write(String.valueOf(parentClassField.get(garden)));
                            isThisFieldNull = false;
                            break;
                        }
                    }
                    if (isThisFieldNull) {
                        for (Field classField : classFields) {
                            if (classField.getName().equals(field.getName())) {
                                classField.setAccessible(true);
                                writer.write(String.valueOf(classField.get(garden)));
                                isThisFieldNull = false;
                                break;
                            }
                        }
                    }
                    if (isThisFieldNull) {
                        writer.write("-");
                    }
                    if (!field.equals(allFields.get(allFields.size() - 1))) {
                        writer.write(",");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
