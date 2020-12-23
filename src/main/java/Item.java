public class Item {
    String name;
    int weight;
    int worth;
    boolean include;

    Item(String name, int weight, int worth){
        this.name = name;
        this.weight = weight;
        this.worth = worth;
    }

    public Item(Item item) {
        this.name = item.name;
        this.weight = item.weight;
        this.worth = item.worth;
        this.include = item.include;
    }
    void setInclude(boolean include) {
        this.include = include;
    }

    void test(){
        System.out.print(name);
        System.out.print(weight);
        System.out.print(worth);
    }
}
