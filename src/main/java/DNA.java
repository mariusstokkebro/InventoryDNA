import processing.core.PApplet;
import processing.data.Table;

import java.util.ArrayList;
import java.util.List;

public class DNA {
    PApplet p;
    ArrayList<Item> DNAString = new ArrayList<Item>();
    ArrayList<Backpack> backpack = new ArrayList<Backpack>();
    List<List<Item>> backpack2 = new ArrayList<List<Item>>();
    Table t;
    int itemInBackpack = 0;
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
            List<Item> list = new ArrayList<>();

            for(int s = 0; s<DNAString.size();s++){
             itemInBackpack = (int) p.random(0,2);
                if(itemInBackpack == 1) {
                    list.add(new Item(DNAString.get(s).name, DNAString.get(s).weight, DNAString.get(s).worth));
                }
                else{

                }
            }
            backpack2.add(list);
        }
       p.println(backpack2.get(2));
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