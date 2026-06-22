public class WhippedCreamDecorator extends CoffeeDecorator{
    public WhippedCreamDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getDescription(){
        return coffee.getDescription() + ", Whipped Cream";
    }

    @Override
    public int getCost(){
        return coffee.getCost() + 20;
    }
}

