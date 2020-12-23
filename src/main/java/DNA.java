import processing.core.PApplet;
import processing.data.FloatList;
import processing.data.IntList;
import processing.data.Table;

import java.util.ArrayList;
import java.util.List;

import static javax.swing.UIManager.get;
import static org.apache.commons.lang.RandomStringUtils.random;

public class DNA {
    PApplet p;
    ArrayList<Item> DNAString = new ArrayList<Item>();
    ArrayList<Backpack> backpacks = new ArrayList<Backpack>();

    Table t;
    int itemInBackpack = 0;


    DNA(PApplet p, Table t) {
        this.p = p;
        this.t = t;
    }


    void assignValue() {
        for (int i = 1; i < t.getRowCount(); i++) {
            DNAString.add(new Item(t.getRow(i).getString(0), t.getRow(i).getInt(1), t.getRow(i).getInt(2)));
        }
    }

    public void backpack(int amountBp) {
        for (int i = 0; i <amountBp ; i++) {

            Backpack backpack = new Backpack(p);
            backpacks.add(backpack);
            for (int s = 0; s < DNAString.size(); s++) {
                itemInBackpack = (int) p.random(0, 2);

                if (itemInBackpack == 1) {
                    backpack.addItemToBackPack(new Item(DNAString.get(s).name, DNAString.get(s).weight, DNAString.get(s).worth));

                } else {

                }
            }


        }


    }

    void removeBigBackpacks() {
        ArrayList<Backpack> bestJeans = new ArrayList<Backpack>();

        for (int i = 0; i < backpacks.size(); i++) {
            Backpack b = backpacks.get(i);
            if (b.getWeight() <= 5000) {
                bestJeans.add(backpacks.get(i));
            }
        }

        backpacks = bestJeans;
    }

    Backpack fitness() {
        int maxWorth = 0;
        int maxIdx = -1;


        for (int i = 0; i < backpacks.size(); ++i) {
            Backpack backpack = backpacks.get(i);

            if (backpack.getWorth() > maxWorth) {
                maxIdx = i;
                maxWorth = backpack.getWorth();
            }
        }

        if (maxIdx >= 0) {
            Backpack superJeans = backpacks.get(maxIdx);
            backpacks.remove(maxIdx);
            p.println(backpacks.size());
            return superJeans;
        }
        return null;

    }




        Backpack crossover2ElectricBoogaloo (Backpack parent1, Backpack parent2){
        int midpoint = (int) (p.random(0, 2));
        Backpack child = new Backpack(p);
            for(int i = 0; i<parent1.backPack.size(); ++i) {

                if(Math.random() > .5){
                    Item item = new Item(parent1.backPack.get(i));
                    child.addItemToBackPack(item);
                } else {
                    Item item = new Item(parent2.backPack.get(i));
                    child.addItemToBackPack(item);
                }

            }

            return child;
        }
        void babytime(){
            ArrayList<Backpack> newGeneration = new ArrayList<Backpack>();
            for (int i=0; i<500; ++i) {
                if (backpacks.size() < 2)
                    break;

                Backpack parent1 = fitness();
                Backpack parent2 = fitness();

                Backpack bpChild = crossover2ElectricBoogaloo(parent1, parent2);
                bpChild.mutate();

                newGeneration.add(parent1);
                newGeneration.add(parent2);
                newGeneration.add(bpChild);
            }

            backpacks = newGeneration;
            removeBigBackpacks();
        }





}