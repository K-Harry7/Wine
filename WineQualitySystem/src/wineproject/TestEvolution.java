package wineproject;

import java.util.ArrayList;
import java.util.List;

public class TestEvolution {
    public static void main(String[] args) {
        // Create initial population
        List<EvoTree> population = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            population.add(new EvoTree(new Wine("Wine" + i, "Flavor" + i, (i % 5) + 1, "Red")));
        }

        // Evolve population
        for (int generation = 0; generation < 10; generation++) {
            population = Evolution.evolve(population);
        }

        // Print new generation
        for (EvoTree tree : population) {
            System.out.println(tree.getData() + " Fitness: " + tree.getFitness());
        }

        // Example of using LinearModel
        LinearModel model = new LinearModel(0.01);
        model.train(population.stream().map(EvoTree::getData).toList());
        double prediction = model.predict(new Wine("TestWine", "TestFlavor", 3, "Red"));
        System.out.println("Prediction: " + prediction);

        // Save and load model
        model.saveModel("linear_model.txt");
        LinearModel loadedModel = LinearModel.loadModel("linear_model.txt");
        double loadedPrediction = loadedModel.predict(new Wine("TestWine", "TestFlavor", 3, "Red"));
        System.out.println("Loaded Model Prediction: " + loadedPrediction);
    }
}
