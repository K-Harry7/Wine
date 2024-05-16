package wineproject;

import java.io.*;
import java.util.*;

abstract class Model {
    public abstract void train(List<Wine> data);
    public abstract double predict(Wine wine);
}

public class LinearModel extends Model {
    private final double[] weights;
    private final double learningRate;

    public LinearModel(double learningRate) {
        this.weights = new double[4]; // Assuming 4 features for simplicity
        this.learningRate = learningRate;
    }

    @Override
    public void train(List<Wine> data) {
        int iterations = 1000;
        for (int i = 0; i < iterations; i++) {
            gradientDescentStep(data);
        }
    }

    private void gradientDescentStep(List<Wine> data) {
        double[] gradients = new double[weights.length];

        for (Wine wine : data) {
            double prediction = predict(wine);
            double error = prediction - wine.getRating();
            gradients[0] += error;
            gradients[1] += error * wine.getRating();
            gradients[2] += error * wine.getFlavorProfile().length();
            gradients[3] += error * (wine.getType().equals("Red") ? 1 : 0);
        }

        for (int i = 0; i < weights.length; i++) {
            weights[i] -= learningRate * gradients[i] / data.size();
        }
    }

    @Override
    public double predict(Wine wine) {
        return weights[0] + weights[1] * wine.getRating() + weights[2] * wine.getFlavorProfile().length() + weights[3] * (wine.getType().equals("Red") ? 1 : 0);
    }

    public void saveModel(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (double weight : weights) {
                writer.write(weight + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LinearModel loadModel(String filename) {
        LinearModel model = new LinearModel(0.01);
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            for (int i = 0; i < model.weights.length; i++) {
                model.weights[i] = Double.parseDouble(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return model;
    }
}
