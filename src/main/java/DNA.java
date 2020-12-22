import processing.core.PApplet;
import processing.data.IntList;
import processing.data.Table;

import java.util.ArrayList;
import java.util.List;

import static javax.swing.UIManager.get;

public class DNA {
    PApplet p;
    ArrayList<Item> DNAString = new ArrayList<Item>();
    ArrayList<Backpack> backpack = new ArrayList<Backpack>();
    List<List<Item>> backpack2 = new ArrayList<List<Item>>();
    IntList totalWeight = new IntList();
    IntList totalWorth = new IntList();

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
            int weight=0;
            int worth=0;
            for(int s = 0; s<DNAString.size();s++){
             itemInBackpack = (int) p.random(0,2);

                if(itemInBackpack == 1) {
                    list.add(new Item(DNAString.get(s).name, DNAString.get(s).weight, DNAString.get(s).worth));
                    weight+=DNAString.get(s).weight;
                    worth+=DNAString.get(s).worth;
                }
                else{

                }
            }
            this.totalWeight.append(weight);
            this.totalWorth.append(worth);
            backpack2.add(list);

        }
       p.println(backpack2.get(2));
        p.println(totalWeight);
        p.println(totalWorth);
    }

    /*int getTotalWeight(ArrayList a){
        int totalWeight=0;
        for(int i = 0; i<a.size();i++){

        }
    }

    int getTotalWorth(ArrayList a){
        int totalWorth=0;
        for(int i = 0; i<a.size();i++){
            totalWorth += a.get(i);
        }
    }*/


}