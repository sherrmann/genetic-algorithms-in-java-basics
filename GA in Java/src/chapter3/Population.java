package chapter3;

import java.util.Arrays;
import java.util.Random;

public class Population {
    private Individual population[];
    private double populationFitness = -1;

    public Population(int populationSize) {
        this.population = new Individual[populationSize];
    }

    public Population(int populationSize, int chromosomeLength) {
        this.population = new Individual[populationSize];

        for (int individualCount = 0; individualCount <= populationSize; individualCount++) {
            this.population[individualCount] = new Individual(chromosomeLength);
        }
    }

    public Individual[] getIndividuals() {
        return this.population;
    }

    public Individual getFittest(int offset) {
        Arrays.sort(this.population, (o1, o2) -> {
            if (o1.getFitness() > o2.getFitness()) return -1;
            else if (o1.getFitness() < o2.getFitness()) return 1;
            return 1;
        });
        return this.population[offset];
    }

    public void setPopulationFitness(double fitness) {
        this.populationFitness = fitness;
    }

    public double getPopulationFitness() {
        return this.populationFitness;
    }

    public int size() {
        return this.population.length;
    }

    public Individual setIndividual(int offset, Individual individual) {
        return population[offset] = individual;
    }

    public Individual getIndividual(int offset) {
        return population[offset];
    }

    public void shuffle() {
        Random rnd = new Random();
        // loop through array
        for (int i = population.length - 1; i > 0; i--) {
            // get random int in range 0 to i+1
            int index = rnd.nextInt(i + 1);
            // temp copy
            Individual a = population[index];
            // assign the i element to the random element
            population[index] = population[i];
            // assign temp copy to the i element
            population[i] = a;
        }
    }
}
