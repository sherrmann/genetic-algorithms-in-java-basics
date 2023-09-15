package chapter3;

public class Individual {

    private int[] chromosome;
    private double fitness = -1;

    public Individual(int[] chromosome) {
        this.chromosome = chromosome;
    }

    public Individual(int chromosomeLength){
        this.chromosome = new int[chromosomeLength];
        for(int gene = 0; gene < chromosomeLength; gene++){
            if(0.5 < Math.random()) this.setGene(gene, 1);
            else this.setGene(gene, 0);
        }
    }

    public int[] getChromosome() {
        return this.chromosome;
    }

    public void setChromosome(int[] chromosome) {
        this.chromosome = chromosome;
    }

    public int getGene(int offset){
        return this.chromosome[offset];
    }

    public void setGene(int offset, int gene){
        this.chromosome[offset] = gene;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int gene = 0; gene < this.chromosome.length; gene++){
            output.append(this.chromosome[gene]);
        }
        return output.toString();
    }
}
