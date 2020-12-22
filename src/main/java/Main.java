import processing.core.PApplet;
import processing.data.Table;

import java.util.ArrayList;

public class Main extends PApplet{
    public static void main(String[] args) {
        PApplet.main("Main");
    }
    PApplet p;
    Table table;
    DNA[] population = new DNA[10];

    @Override
    public void settings() {

    }

    @Override
    public void setup() {
        table = loadTable("backpack.csv");
        for (int i = 0; i < population.length; i++) {
            population[i] = new DNA(this,table);
        }


    }

    @Override
    public void draw() {
        for (int i = 0; i < population.length; i++) {
            population[i].assignValue();
            population[i].backpack();
            population[i].fitness();

        }

        ArrayList<DNA> matingPool = new ArrayList<>();

        for (int i = 0; i < population.length; i++) {
            int n = (int) population[i].totalFitnessPercentage.get(0);
            for (int j = 0; j < n; j++) {
                matingPool.add(population[i]);
            }

        }
            for (int i = 0; i < population.length; i++) {
                int a = (int)(random(matingPool.size()));
                int b = (int)(random(matingPool.size()));
                DNA partnerA = matingPool.get(a);
                DNA partnerB = matingPool.get(b);

                DNA child = partnerA.crossover(partnerB);

                child.mutate();

                population[i] = child;

        }
    }
}
