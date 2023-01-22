package chapter2;

public class GeneticAlgorithm {
    private int populationSize;
    private double mutationRate;
    private double crossoverRate;
    private int elitismCount;

    public GeneticAlgorithm(int populationSize, double mutationRate, double crossoverRate, int elitismCount) {
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.elitismCount = elitismCount;
    }

    public Population initPopulation(int chromosomeLength) {
        Population population = new Population(chromosomeLength);
        return population;
    }

    public double calcFitness(Individual individual) {
        int correctGenes = 0;
        for(int i = 0; i < individual.getChromosome().length; i++) {
            correctGenes += individual.getChromosome()[i];
        }
        individual.setFitness(correctGenes/individual.getChromosome().length);
        return individual.getFitness();
    }
}
