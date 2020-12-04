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
        for(int i = 0; i<t.getRowCount();i++){
            DNAString.add(t.getRow(i).getInt(0),t.getRow(i).getInt(1),t.getRow(i).getInt(2));
        }
    }
}