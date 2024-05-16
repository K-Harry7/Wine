package wineproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final WineDataSet wineDataSet;
    private final LinearModel linearModel;
    private static final Scanner scanner = new Scanner(System.in);

    public Main() {
        wineDataSet = new WineDataSet();
        linearModel = new LinearModel(0.01);
        initializePreRankedWines();
    }

    public static void main(String[] args) {
        Main system = new Main();
        system.run();
    }

    public void run() {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1 -> addWine();
                case 2 -> viewWines();
                case 3 -> loadWineData();
                case 4 -> saveWineData();
                case 5 -> trainModel();
                case 6 -> predictQuality();
                case 7 -> optimizeWineQuality();
                case 8 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\nWine Quality Prediction and Optimization System");
        System.out.println("1. Add Wine");
        System.out.println("2. View Wines");
        System.out.println("3. Load Wine Data");
        System.out.println("4. Save Wine Data");
        System.out.println("5. Train Model");
        System.out.println("6. Predict Wine Quality");
        System.out.println("7. Optimize Wine Quality");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addWine() {
        System.out.print("Enter wine name: ");
        String name = scanner.nextLine();
        System.out.print("Enter wine flavor profile: ");
        String flavorProfile = scanner.nextLine();
        System.out.print("Enter wine rating (1-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter wine type (Red/White): ");
        String type = scanner.nextLine();

        wineDataSet.getWines().add(new Wine(name, flavorProfile, rating, type));
        System.out.println("Wine added successfully.");
    }

    private void viewWines() {
        List<Wine> wines = wineDataSet.getWines();
        if (wines.isEmpty()) {
            System.out.println("No wines available.");
        } else {
            for (Wine wine : wines) {
                System.out.println(wine);
            }
        }
    }

    private void loadWineData() {
        System.out.print("Enter filename to load wine data: ");
        String filename = scanner.nextLine();
        wineDataSet.loadFromFile(filename);
        System.out.println("Wine data loaded successfully.");
    }

    private void saveWineData() {
        System.out.print("Enter filename to save wine data: ");
        String filename = scanner.nextLine();
        wineDataSet.saveToFile(filename);
        System.out.println("Wine data saved successfully.");
    }

    private void trainModel() {
        linearModel.train(wineDataSet.getWines());
        System.out.println("Model trained successfully.");
    }

    private void predictQuality() {
        System.out.print("Enter wine name: ");
        String name = scanner.nextLine();
        System.out.print("Enter wine flavor profile: ");
        String flavorProfile = scanner.nextLine();
        System.out.print("Enter wine rating (1-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter wine type (Red/White): ");
        String type = scanner.nextLine();

        Wine newWine = new Wine(name, flavorProfile, rating, type);
        double predictedQuality = linearModel.predict(newWine);
        System.out.println("Predicted Quality: " + predictedQuality);
    }

    private void optimizeWineQuality() {
        List<EvoTree> population = new ArrayList<>();
        for (Wine wine : wineDataSet.getWines()) {
            population.add(new EvoTree(wine));
        }

        for (int generation = 0; generation < 10; generation++) {
            population = Evolution.evolve(population);
        }

        System.out.println("Optimized wine quality:");
        for (EvoTree tree : population) {
            System.out.println(tree.getData() + " Fitness: " + tree.getFitness());
        }
    }

    private void initializePreRankedWines() {
        wineDataSet.getWines().add(new Wine("Merlot", "Smooth, soft, dark fruits", 4, "Red"));
        wineDataSet.getWines().add(new Wine("Syrah", "Spicy, bold, dark fruits", 5, "Red"));
        wineDataSet.getWines().add(new Wine("Chardonnay", "Buttery, oaky, citrus", 3, "White"));
        wineDataSet.getWines().add(new Wine("Cabernet Franc", "Herbaceous, medium body", 4, "Red"));
        wineDataSet.getWines().add(new Wine("Lemberger", "Berry, peppery, medium body", 4, "Red"));
        wineDataSet.getWines().add(new Wine("Niagara", "Sweet, fruity, light body", 2, "White"));
        wineDataSet.getWines().add(new Wine("Riesling", "Crisp, floral, sweet", 5, "White"));
        wineDataSet.getWines().add(new Wine("Cabernet Sauvignon", "Rich, full body, dark fruits", 5, "Red"));
    }
}
