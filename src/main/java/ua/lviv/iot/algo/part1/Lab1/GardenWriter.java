package ua.lviv.iot.algo.part1.Lab1;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

public class GardenWriter {
    public void writeNonSorted(List<Garden> gardens) {
        if (gardens == null || gardens.isEmpty()) {
            return;
        }
        try (FileWriter writer = new FileWriter("nonSortedResult.csv")) {
            for (Garden garden : gardens) {
                writer.write(garden.getHeaders());
                writer.write(System.getProperty("line.separator"));
                writer.write(garden.toCSV());
                writer.write(System.getProperty("line.separator"));
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
            List<Field> allFieldsNormal = new LinkedList<>();
            List<Field[]> allFields = new LinkedList<>();
            allFields.add(Garden.class.getDeclaredFields());

            for (Garden garden : gardens) {
                allFields.add(garden.getClass().getDeclaredFields());
            }

            for (Field[] field : allFields) {
                for (Field field_1 : field) {
                    if (field != allFields.get(allFields.size() - 1) || field_1 != field[field.length - 1]) {
                        writer.write(field_1.getName() + ",");
                    } else {
                        writer.write(field_1.getName());
                    }
                    allFieldsNormal.add(field_1);
                }
            }

            for (Garden garden : gardens) {
                Field[] classFields = garden.getClass().getDeclaredFields();
                Field[] parentClassFields = garden.getClass().getSuperclass().getDeclaredFields();
                writer.write(System.getProperty("line.separator"));

                for (int j = 0; j < allFieldsNormal.size(); j++) {
                    boolean isThisFieldNull = true;
                    for (Field parentClassField : parentClassFields) {
                        if (parentClassField.getName().equals(allFieldsNormal.get(j).getName())) {
                            parentClassField.setAccessible(true);
                            writer.write(String.valueOf(parentClassField.get(garden)));
                            isThisFieldNull = false;
                            break;
                        }
                    }
                    for (Field classField : classFields) {
                        if (classField.getName().equals(allFieldsNormal.get(j).getName())) {
                            classField.setAccessible(true);
                            writer.write(String.valueOf(classField.get(garden)));
                            isThisFieldNull = false;
                            break;
                        }
                    }
                    if (isThisFieldNull) {
                        writer.write("-");
                    }
                    if (j != allFieldsNormal.size() - 1) {
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
