package wineproject;

import java.util.*;

public class Evolution {
    private static final Random random = new Random();

    public static List<EvoTree> evolve(List<EvoTree> population) {
        List<EvoTree> newGeneration = new ArrayList<>();
        Collections.sort(population);

        int halfSize = population.size() / 2;
        for (int i = 0; i < halfSize; i++) {
            EvoTree parent1 = population.get(i);
            EvoTree parent2 = population.get(random.nextInt(halfSize));
            EvoTree child = crossover(parent1, parent2);
            mutate(child);
            newGeneration.add(child);
        }

        while (newGeneration.size() < population.size()) {
            EvoTree parent = population.get(random.nextInt(halfSize));
            EvoTree clone = parent.clone();
            mutate(clone);
            newGeneration.add(clone);
        }

        return newGeneration;
    }

    private static EvoTree crossover(EvoTree parent1, EvoTree parent2) {
        Op rating1 = new Constant(parent1.getData().getRating());
        Op rating2 = new Constant(parent2.getData().getRating());

        Op childRating = new Add(rating1, rating2);
        int newRating = (int) Math.round(childRating.evaluate());

        String name = parent1.getData().getName() + "-" + parent2.getData().getName();
        String flavorProfile = parent1.getData().getFlavorProfile() + "|" + parent2.getData().getFlavorProfile();
        String type = parent1.getData().getType();

        return new EvoTree(new Wine(name, flavorProfile, newRating, type));
    }

    private static void mutate(EvoTree tree) {
        Wine wine = tree.getData();
        Op rating = new Constant(wine.getRating());
        Op mutation = new Add(rating, new Constant(random.nextInt(3) - 1));
        int newRating = Math.max(1, Math.min(5, (int) Math.round(mutation.evaluate())));
        wine.setRating(newRating);
        tree.setFitness(tree.evaluateFitness());
    }
}
