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

    public Population initPopulation(int chromosomeLength){
        Population population = new Population(this.populationSize, chromosomeLength);
        return population;
    }

    public double calcFitness(Individual individual){
        int correctGenes = 0;
        for(int geneIndex = 0; geneIndex < individual.getChromosomeLength(); geneIndex++){
            if(individual.getGene(geneIndex) == 1){
                correctGenes += 1;
            }
        }
        double fitness = (double) correctGenes / individual.getChromosomeLength();
        individual.setFitness(fitness);
        return  fitness;
    }

    public void evalPopulation(Population population){
        double populationFitness = 0;
        for(Individual individual : population.getIndividuals()){
            populationFitness += calcFitness(individual);
        }
        population.setPopulationFitness(populationFitness);
    }

    public boolean isTerminationConditionMet(Population population){
        for(Individual individual: population.getIndividuals()){
            if(individual.getFitness() == 1){
                return true;
            }
        }
        return false;
    }
    //TODO: find out why populationFitness is being used
    //TODO: modify selectParents so that spinWheel isn't the sum of fitness values
    public Individual selectParent(Population population){
        // Get individuals
        Individual[] individuals = population.getIndividuals();
        // Spin roulette wheel
        double populationFitness = population.getPopulationFitness();
        // A higher populationFitness leads to a higher random wheel position
        double rouletteWheelPosition = Math.random() * populationFitness;
        // Find parent
        double spinWheel = 0;
        // loop through population
        for(Individual individual: individuals){
            // add individual fitness to spinWheel
            spinWheel += individual.getFitness();
            // fitnessValues are added up until they're as large as rouletteWheelPosition
            if(spinWheel >= rouletteWheelPosition){
                return individual;
            }
        }
        // if none is found pass the last individual
        return individuals[population.size() - 1];
    }
    public Population crossoverPopulation(Population population){
        // Create new Population
        Population newPopulation = new Population(population.size());

        // Loop over current population by fitness
        for(int populationIndex = 0; populationIndex < population.size(); populationIndex++){
            Individual parent1 = population.getFittest(populationIndex);

            // Apply crossover to this individual?
            // TODO: does a higher crossoverRate lead to less crossover?
            if(this.crossoverRate > Math.random() && populationIndex > this.elitismCount){
                // Initialize offspring
                Individual offspring = new Individual(parent1.getChromosome());
                // Find second paretn
                Individual parent2 = selectParent(population);
                // Loop over genome
                for (int geneIndex = 0; geneIndex < parent1.getChromosomeLength(); geneIndex++){
                    // Use half of parent1's genes and half of parent2
                    if(0.5 > Math.random()){
                        offspring.setGene(geneIndex, parent1.getGene(geneIndex));
                    } else {
                        offspring.setGene(geneIndex, parent2.getGene(geneIndex));
                    }
                }
            }
        }
    }
}
