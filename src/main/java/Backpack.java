import processing.core.PApplet;

import java.util.ArrayList;

public class Backpack {
    ArrayList<Item> backPack = new ArrayList<Item>();
    PApplet p;
    int worth = 0;
    int weight = 0;

    Backpack(PApplet p) {
        this.p = p;
    }

    void addItemToBackPack(Item item) {
        backPack.add(item);

    }

    void mutate() {
        for(int j = 0; j < backPack.size(); ++j) {
            Item item = backPack.get(j);
            if(p.random(1) < 0.5){
                item.setInclude(!item.include);
            }
        }


    }
    int getWorth() {
        for (int i = 0; i< backPack.size(); ++i) {
            Item item = backPack.get(i);

                worth += item.worth;

        }
        return worth;
    }
    int getWeight() {
        for (int i = 0; i< backPack.size(); ++i) {
            Item item = backPack.get(i);

            weight += item.weight;

        }
        return weight;
    }
}