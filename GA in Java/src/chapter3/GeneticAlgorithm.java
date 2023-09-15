package chapter3;

import chapter2.Individual;
import chapter2.Population;

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

    public chapter2.Population initPopulation(int chromosomeLength) {
        chapter2.Population population = new chapter2.Population(chromosomeLength);
        return population;
    }
}
