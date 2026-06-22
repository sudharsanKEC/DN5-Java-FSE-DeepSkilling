public class PlainCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Plain Coffee";
    }    

    @Override
    public int getCost() {
        return 50;
    }
}
