import processing.core.PApplet;
import processing.data.Table;

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

    }

    @Override
    public void setup() {
        table = loadTable("backpack.csv");
        dna = new DNA(this, table );
        dna2 = new DNA(this, table);
        dna.assignValue();
        dna.backpack();
        dna.fitness();
        dna2.assignValue();
        dna2.backpack();
        dna2.fitness();
    }

    @Override
    public void draw() {

    }
}
