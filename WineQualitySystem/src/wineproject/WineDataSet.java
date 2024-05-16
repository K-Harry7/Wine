package wineproject;

import java.io.*;
import java.util.*;

public class WineDataSet {
    private final List<Wine> wines;

    public WineDataSet() {
        this.wines = new ArrayList<>();
    }

    public void loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) { // Updated to 4 parts
                    String name = parts[0];
                    String flavorProfile = parts[1];
                    int rating = Integer.parseInt(parts[2]);
                    String type = parts[3];
                    wines.add(new Wine(name, flavorProfile, rating, type));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Wine> getWines() {
        return wines;
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Wine wine : wines) {
                writer.write(wine.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
