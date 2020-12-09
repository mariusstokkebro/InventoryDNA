import processing.core.PApplet;
import processing.data.Table;

import java.util.ArrayList;

public class DNA {
    PApplet p;
    ArrayList<Item> DNAString = new ArrayList<Item>();
    Table t;

    DNA(PApplet p, Table t) {
        this.p = p;
        this.t=t;
    }

    void assignValue() {
        for(int i = 1; i<t.getRowCount();i++){
            DNAString.add(new Item(t.getRow(i).getString(0),t.getRow(i).getInt(1),t.getRow(i).getInt(2)));
        }
    }

    void backpack(){
        for(int i = 0; i<50;i++){
            for(int s = 0; s<DNAString.size();s++){

            }
        }
    }

  /* public int getData(String itemName, int weight) {
        int a = 0;
        for (int i = 0; i < DNAString.size(); i++) {
            Item item = DNAString.get(i);
            if (itemName.equalsIgnoreCase(Item.name) && weight == Item.weight) {
                a = DNAString.get(i).worth;
            }
        }
        return a;
    }*/
}