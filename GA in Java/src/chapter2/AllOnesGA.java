package chapter2;

public class AllOnesGA {
    public static void main(String[] args) {
        // Create GA object
        GeneticAlgorithm GA = new GeneticAlgorithm(100, 0.01,0.95,0);
        Population population = GA.initPopulation(50);
    }
}
