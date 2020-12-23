import processing.core.PApplet;
import processing.data.Table;

import java.util.ArrayList;

public class Main extends PApplet{
    public static void main(String[] args) {
        PApplet.main("Main");
    }
    PApplet p;
    Table table;
   DNA dna;
DNA dna2;
    @Override
    public void settings() {
        size(500,500);
    }

    @Override
    public void setup() {
        background(0);
        table = loadTable("backpack.csv");
        dna = new DNA(this,table);



            dna.assignValue();
            dna.backpack(100);
        dna.removeBigBackpacks();
            dna.fitness();
            for(int i= 0; i<5;i++){
                dna.babytime();

            }



    }

    @Override
    public void draw() {

    }
}
