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
}
