public class Item {
    String name;
    int weight;
    int worth;

    Item(String name, int weight, int worth){
        this.name = name;
        this.weight = weight;
        this.worth = worth;
    }

    void test(){
        System.out.print(name);
        System.out.print(weight);
        System.out.print(worth);
    }
}
