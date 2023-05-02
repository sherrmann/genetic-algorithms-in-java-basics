package chapter2;

public class AllOnesGA {
    public static void main(String[] args) {
        // Create GA object
        GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.01,0.95,0);
        Population population = ga.initPopulation(50);
        int generation = 0;
        ga.evalPopulation(population);

        while(!ga.isTerminationConditionMet(population)){
            System.out.println("Best solution: " + population.getFittest(0).toString());
            // TODO crossover
            //ga.crossover(population);
            // TODO mutate
            ga.evalPopulation(population);
            generation++;
        }


        System.out.println("Found solution in " + generation + " generations");
        System.out.println("Best solution: " + population.getFittest(0).toString());
    }
}
