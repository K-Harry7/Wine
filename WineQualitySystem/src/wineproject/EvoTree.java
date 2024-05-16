package wineproject;

public class EvoTree extends TreeNode implements Cloneable, Comparable<EvoTree> {
    private double fitness;

    public EvoTree(Wine data) {
        super(data);
        this.fitness = evaluateFitness();
    }

    @Override
    public EvoTree clone() {
        try {
            EvoTree clone = (EvoTree) super.clone();
            clone.fitness = clone.evaluateFitness();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public int compareTo(EvoTree other) {
        return Double.compare(this.fitness, other.fitness);
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double evaluateFitness() {
        return getData().getRating();
    }
}
