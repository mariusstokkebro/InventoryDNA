import processing.core.PApplet;
import processing.data.Table;

public class Main extends PApplet{
    public static void main(String[] args) {
        PApplet.main("Main");
    }
    PApplet p;
    Table table;
    DNA dna;

    @Override
    public void settings() {

    }

    @Override
    public void setup() {
        table = loadTable("backpack.csv");
        dna = new DNA(this, table );
    }

    @Override
    public void draw() {

    }
}
