package chapter3;

import chapter2.Population;

public class RobotController {

    public static int maxGenerations = 1000;

    public static void main(String[] args) {

        /**
         * 0 = Empty
         * 1 = Wall
         * 2 = Starting position
         * 3 = Route
         * 4 = Goal position
         */

        Maze maze = new Maze(new int[][] {
                { 0, 0, 0, 0, 1, 0, 1, 3, 2 },
                { 1, 0, 1, 1, 1, 0, 1, 3, 1 },
                { 1, 0, 0, 1, 3, 3, 3, 3, 1 },
                { 3, 3, 3, 1, 3, 1, 1, 0, 1 },
                { 3, 1, 3, 3, 3, 1, 1, 0, 0 },
                { 3, 3, 1, 1, 1, 1, 0, 1, 1 },
                { 1, 3, 0, 1, 3, 3, 3, 3, 3 },
                { 0, 3, 1, 1, 3, 1, 0, 1, 3 },
                { 1, 3, 3, 3, 3, 1, 1, 1, 4 }
        });

        // create genetic algorithm
        GeneticAlgorithm ga = new GeneticAlgorithm(200, 0.05, 0.9, 2, 10 );
        Population population = ga.initPopulation(128);

        // TODO: Evaluate population

        int generation = 1;

        // Start evolutino looop
        while (/* TODO */ true) {
            // TODO: Print fittest individual from population
            // TODO: Apply crossover
            // TODO: Apply mutation
            // TODO: Evaluate population
            // Increment the current generation
            generation++;
        }
        // TODO: Print results
    }
}
